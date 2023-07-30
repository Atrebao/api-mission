package com.app.mission.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mission.model.EmailRequest;

@RestController
@RequestMapping("/api")
public class EmailController {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailController(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            String toEmail = emailRequest.getToEmail();
            String subject = emailRequest.getSubject();
            String body = emailRequest.getBody();

            // Vérifier que les champs requis sont présents
            if (toEmail == null || toEmail.isEmpty() || subject == null || subject.isEmpty() || body == null || body.isEmpty()) {
                return "Erreur: Veuillez fournir les informations nécessaires pour envoyer l'email.";
            }

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toEmail);
            message.setSubject(subject);
            message.setText(body);
            javaMailSender.send(message);

            return "Email envoyé avec succès.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erreur lors de l'envoi de l'email.";
        }
    }

}
