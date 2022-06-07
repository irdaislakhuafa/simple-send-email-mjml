package com.irdaislakhuafa.simplesendemailmjml.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.irdaislakhuafa.simplesendemailmjml.models.ApiResponse;
import com.irdaislakhuafa.simplesendemailmjml.models.MailRequest;
import com.irdaislakhuafa.simplesendemailmjml.services.MailService;
import com.irdaislakhuafa.simplesendemailmjml.utils.ApiValidation;

import dev.ditsche.mailo.MailAddress;
import dev.ditsche.mailo.factory.MailBuilder;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = { "/send" })
@RequiredArgsConstructor
public class InitController {
    private final MailService mailService;

    @PostMapping
    public ResponseEntity<?> send(@RequestBody @Valid final MailRequest request, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.builder()
                            .errors(ApiValidation.getErrorMessage(errors))
                            .isSended(false)
                            .build());
        }

        try {
            var mail = MailBuilder.mjml()
                    .subject("To You Dear")
                    .from(new MailAddress(request.getFrom()))
                    .to(new MailAddress(request.getTo()))
                    .param("text", request.getText())
                    .loadTemplate("mjml/index.mjml")
                    .build();

            var success = mailService.send(mail);
            if (success) {
                return ResponseEntity.ok()
                        .body(ApiResponse.builder()
                                .errors(null)
                                .isSended(true)
                                .build());
            } else {
                return ResponseEntity.badRequest()
                        .body(ApiResponse.builder()
                                .errors("something wrong or email not allowed")
                                .isSended(false)
                                .build());
            }

        } catch (Exception e) {
            return ResponseEntity.ok()
                    .body(ApiResponse.builder()
                            .errors(e.getMessage())
                            .isSended(false)
                            .build());
        }
    }
}