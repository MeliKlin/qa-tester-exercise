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
        TestCase mockTestCase = new TestCase();
            mockTestCase.setId_case(1L);
            mockTestCase.setDescription("some_description");
            mockTestCase.setTested(true);
            mockTestCase.setPassed(false);
            mockTestCase.setNumber_of_tries(1);
            mockTestCase.setLast_update(new Date());

        return ResponseEntity.ok(mockTestCase);
    }

    @GetMapping("/alive")
    public ResponseEntity<Void> checkAppIsAlive() {
        return ResponseEntity.ok().build();
    }

}
