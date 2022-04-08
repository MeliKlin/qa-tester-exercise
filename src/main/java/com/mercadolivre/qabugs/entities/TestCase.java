package com.mercadolivre.qabugs.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class TestCase {

    private long id_case;
    private String description;
    private boolean tested;
    private boolean passed;
    private int number_of_tries;
    private Date last_update;

}
