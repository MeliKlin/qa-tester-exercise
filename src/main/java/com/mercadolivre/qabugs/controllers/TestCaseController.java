package com.mercadolivre.qabugs.controllers;

import com.mercadolivre.qabugs.entities.TestCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestCaseController {

    @GetMapping("/test-cases")
    public ResponseEntity<TestCase> findTestCaseById() {
        TestCase mockTestCase = TestCase.builder()
                .id_case(1L)
                .description("some_description")
                .tested(true)
                .passed(false)
                .number_of_tries(1)
                .last_update(new Date())
                .build();

        return ResponseEntity.ok(mockTestCase);
    }

    @GetMapping("/alive")
    public ResponseEntity<Void> checkAppIsAlive() {
        return ResponseEntity.ok().build();
    }

}
