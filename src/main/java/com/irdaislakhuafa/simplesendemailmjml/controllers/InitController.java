package com.irdaislakhuafa.simplesendemailmjml.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = { "/init" })
@RequiredArgsConstructor
public class InitController {

    @GetMapping
    public ResponseEntity<?> init() {
        try {
            return null;
        } catch (Exception e) {
            return ResponseEntity.ok().body("failed: " + e.getMessage());
        }
    }
}