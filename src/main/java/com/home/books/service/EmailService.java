package com.home.books.service;

public interface EmailService {
    void sendSimpleMessage(
            String to, String subject, String text);
}
