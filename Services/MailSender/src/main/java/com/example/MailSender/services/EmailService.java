package com.example.MailSender.services;

import com.example.MailSender.details.EmailDetails;

public interface EmailService {

    // Method
    // To send a simple email
    String sendSimpleMail(String email);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}