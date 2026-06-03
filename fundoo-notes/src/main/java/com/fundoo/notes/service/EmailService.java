package com.fundoo.notes.service;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class EmailService {

    @Value("${SENDGRID_API_KEY}")
    private String sendGridApiKey;

    @Value("${MAIL_USERNAME}")
    private String fromEmail;

    private void sendEmail(String toEmail, String subject, String body) {
        Email from = new Email(fromEmail);
        Email to = new Email(toEmail);
        Content content = new Content("text/plain", body);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sg.api(request);
        } catch (IOException e) {
            throw new RuntimeException("Failed to send email: " + e.getMessage());
        }
    }

    public void sendPasswordResetEmail(String toEmail, String resetToken) {
        String subject = "Fundoo Notes Password Reset";
        String message = "Hello,\n\n"
                + "You requested to reset your Fundoo Notes password.\n\n"
                + "Use the below reset token:\n\n"
                + resetToken + "\n\n"
                + "This token is valid for 10 minutes.\n\n"
                + "If you did not request this, please ignore this email.\n\n"
                + "Regards,\nFundoo Notes Team";
        sendEmail(toEmail, subject, message);
    }

    public void sendReminderEmail(String toEmail, String noteTitle, String noteDescription) {
        String subject = "Fundoo Notes Reminder: " + noteTitle;
        String message = "Hello,\n\n"
                + "This is a reminder for your note.\n\n"
                + "Title: " + noteTitle + "\n"
                + "Description: " + noteDescription + "\n\n"
                + "Please check your Fundoo Notes app.\n\n"
                + "Regards,\nFundoo Notes Team";
        sendEmail(toEmail, subject, message);
    }
}
