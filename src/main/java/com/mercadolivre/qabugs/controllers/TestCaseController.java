package com.mercadolivre.qabugs.controllers;

import com.mercadolivre.qabugs.dtos.CreateTestCaseDTO;
import com.mercadolivre.qabugs.entities.TestCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class TestCaseController {

    @PostMapping("/test-cases")
    public ResponseEntity<Void> createTestCase(
            @Valid @RequestBody CreateTestCaseDTO createTestCaseDTO,
            UriComponentsBuilder uriBuilder
    ) {
        TestCase testCase = createTestCaseDTO.mountTestCase();

        URI uri = uriBuilder
                .path("/api/v1/test-cases/{id}")
                .buildAndExpand(testCase.getId_case())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/ping")
    public ResponseEntity<String> checkAppIsAlive() {
        return ResponseEntity.ok().body("pong");
    }

}
