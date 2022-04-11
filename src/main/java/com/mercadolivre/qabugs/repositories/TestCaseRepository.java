package com.mercadolivre.qabugs.repositories;

import com.mercadolivre.qabugs.entities.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {

}
