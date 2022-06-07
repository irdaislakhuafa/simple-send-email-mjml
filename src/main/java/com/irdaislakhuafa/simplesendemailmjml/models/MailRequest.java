package com.irdaislakhuafa.simplesendemailmjml.models;

import javax.validation.constraints.*;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MailRequest {
    @NotNull(message = "cannot be null")
    @NotBlank(message = "cannot be blank")
    @NotEmpty(message = "cannot be empty")
    @Email(message = "invalid email format")
    private String from;

    @NotNull(message = "cannot be null")
    @NotBlank(message = "cannot be blank")
    @NotEmpty(message = "cannot be empty")
    @Email(message = "invalid email format")
    private String to;

    @NotNull(message = "cannot be null")
    @NotBlank(message = "cannot be blank")
    @NotEmpty(message = "cannot be empty")
    private String text;
}
