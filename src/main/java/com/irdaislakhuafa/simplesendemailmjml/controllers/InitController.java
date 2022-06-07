package com.irdaislakhuafa.simplesendemailmjml.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.ditsche.mailo.MailAddress;
import dev.ditsche.mailo.factory.MailBuilder;
import dev.ditsche.mailo.provider.MailProvider;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = { "/init" })
@RequiredArgsConstructor
public class InitController {

    // @Value(value = "mjml.io.app.id")
    // private String APP_ID;

    // @Value(value = "mjml.io.app.secret")
    // private String APP_SECRET;

    private final MailProvider mailProvider;

    @GetMapping
    public ResponseEntity<?> init() {
        try {
            var mail = MailBuilder.mjml()
                    .subject("Hi this is beatufile")
                    .from(new MailAddress("irdhaislakhuafa@gmail.com"))
                    .to(new MailAddress("irdaislakhuafa.test@gmail.com"))
                    .param("name", "irda islakhu afa hahahahah")
                    .loadTemplate("mjml/index.mjml")
                    .build();
            mailProvider.send(mail);
            return ResponseEntity.ok("ok");

        } catch (Exception e) {
            return ResponseEntity.ok().body("failed: " + e.getMessage());
        }
    }
}