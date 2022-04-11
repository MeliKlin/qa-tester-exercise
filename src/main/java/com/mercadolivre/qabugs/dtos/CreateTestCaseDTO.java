package com.mercadolivre.qabugs.dtos;

import com.mercadolivre.qabugs.entities.TestCase;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
public class CreateTestCaseDTO {

    @NotEmpty(message = "Descrição do teste é obrigatório")
    private String description;
    private boolean tested = false;
    private boolean passed = false;
    private int numberOfTries = 0;

    public TestCase mountTestCase() {
        TestCase testCase = new TestCase();
        testCase.setDescription(description);
        testCase.setNumber_of_tries(numberOfTries);
        testCase.setLast_update(new Date());

        if (!tested) {
            testCase.setPassed(false);
            testCase.setNumber_of_tries(0);
            return testCase;
        }

        testCase.setTested(true);
        testCase.setPassed(passed);

        return testCase;
    }

}
