package com.app.mission.config;

import java.io.IOException;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonNodeType implements UserType {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.JAVA_OBJECT};
    }

    @Override
    public Class<JsonNode> returnedClass() {
        return JsonNode.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == y) {
            return true;
        }
        if (x == null || y == null) {
            return false;
        }
        return x.equals(y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return (x != null) ? x.hashCode() : 0;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
            throws HibernateException, SQLException {
        String json = rs.getString(names[0]);
        if (json == null) {
            return null;
        }
        try {
            return objectMapper.readTree(json);
        } catch (IOException e) {
            throw new HibernateException("Failed to convert JSON string to JsonNode", e);
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, Types.OTHER);
            return;
        }
        try {
            String json = objectMapper.writeValueAsString(value);
            st.setObject(index, json, Types.OTHER);
        } catch (JsonProcessingException e) {
            throw new HibernateException("Failed to convert JsonNode to JSON string", e);
        }
    }

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

    // Other methods (deepCopy, isMutable, assemble, disassemble) can be left empty or with default implementations.
}
