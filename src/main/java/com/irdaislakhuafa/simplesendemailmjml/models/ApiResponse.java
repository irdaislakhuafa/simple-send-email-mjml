package com.irdaislakhuafa.simplesendemailmjml.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ApiResponse {
    private boolean isSended;
    private Object errors;
}
