package com.fundoo.notes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendPasswordResetEmail(String toEmail, String resetToken) {

        String subject = "Fundoo Notes Password Reset";

        String message = "Hello,\n\n"
                + "You requested to reset your Fundoo Notes password.\n\n"
                + "Use the below reset token:\n\n"
                + resetToken + "\n\n"
                + "This token is valid for 10 minutes.\n\n"
                + "If you did not request this, please ignore this email.\n\n"
                + "Regards,\n"
                + "Fundoo Notes Team";

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(fromEmail);
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        javaMailSender.send(mailMessage);
    }
    public void sendReminderEmail(String toEmail, String noteTitle, String noteDescription) {

        String subject = "Fundoo Notes Reminder: " + noteTitle;

        String message = "Hello,\n\n"
                + "This is a reminder for your note.\n\n"
                + "Title: " + noteTitle + "\n"
                + "Description: " + noteDescription + "\n\n"
                + "Please check your Fundoo Notes app.\n\n"
                + "Regards,\n"
                + "Fundoo Notes Team";

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(fromEmail);
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        javaMailSender.send(mailMessage);
    }
}