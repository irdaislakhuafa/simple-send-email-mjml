package com.irdaislakhuafa.simplesendemailmjml.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MailRequest {
    private String from;
    private String to;
    private String text;
}
