package com.irdaislakhuafa.simplesendemailmjml.services;

import org.springframework.stereotype.Service;

import dev.ditsche.mailo.Mail;
import dev.ditsche.mailo.provider.MailProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class MailService {
    private final MailProvider mailProvider;

    public boolean send(Mail mail) {
        var isSuccess = this.mailProvider.send(mail);
        if (isSuccess) {
            log.info("Success sending email");
        } else {
            log.error("Failed while send email");
        }
        return isSuccess;
    }
}
