package ru.gb.thymeleafapp.service.message;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.gb.thymeleafapp.config.JmsConfig;
import ru.gb.thymeleafapp.modelMessage.ChangePricedMessage;

import javax.jms.JMSException;
import javax.jms.Message;

/**
 * @author Artem Kropotov
 * created at 08.06.2022
 **/

@Component
@RequiredArgsConstructor
@Slf4j
public class JmsListenerService {
//    private final MailService mailService;

    @JmsListener(destination = JmsConfig.CHANGE_PRICE_PRODUCT_QUEUE)
    public void listen(@Payload ChangePricedMessage changePricedMessage, @Headers MessageHeaders messageHeaders) {
        log.info("Message {} have been gotten", changePricedMessage);
        System.out.println(changePricedMessage);
//        mailService.sendSimpleMessage(
//                "malugn-evg-nsk@yandex.ru",
//                "Change priced",
//                changePricedMessage.toString());
    }
}
