//package ru.gb.thymeleafapp.service.message;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.criteria.From;
//
///**
// * @author Artem Kropotov
// * created at 08.06.2022
// **/
//@Component
//@RequiredArgsConstructor
//public class MailService {
//    private final JavaMailSender javaMailSender;
//
//    private final String FROM = "shuffle2149@gmail.com";
//
//    public void sendSimpleMessage(
//            String to, String subject, String text
//    ) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(FROM);
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//        javaMailSender.send(message);
//    }
//}
