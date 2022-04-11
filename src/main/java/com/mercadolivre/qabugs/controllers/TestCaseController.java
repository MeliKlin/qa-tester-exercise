package com.mercadolivre.qabugs.controllers;

import com.mercadolivre.qabugs.dtos.CreateTestCaseDTO;
import com.mercadolivre.qabugs.entities.TestCase;
import com.mercadolivre.qabugs.repositories.TestCaseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/test-cases")
public class TestCaseController {

    private final TestCaseRepository testCaseRepository;

    public TestCaseController(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @PostMapping
    public ResponseEntity<Void> createTestCase(
            @Valid @RequestBody CreateTestCaseDTO createTestCaseDTO,
            UriComponentsBuilder uriBuilder
    ) {
        TestCase testCase = createTestCaseDTO.mountTestCase();

        testCaseRepository.save(testCase);
        URI uri = uriBuilder
                .path("/api/v1/test-cases/{id}")
                .buildAndExpand(testCase.getId_case())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TestCase>> findTestCase(
            @PathVariable Long id
    ) {
        Optional<TestCase> testCase = testCaseRepository.findById(id);

        return ResponseEntity.ok(testCase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestCase(
            @PathVariable Long id
    ) {
        testCaseRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ping")
    public ResponseEntity<String> checkAppIsAlive() {
        return ResponseEntity.ok().body("pong");
    }

}
