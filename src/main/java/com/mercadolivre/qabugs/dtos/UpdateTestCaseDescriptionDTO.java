package com.mercadolivre.qabugs.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class UpdateTestCaseDescriptionDTO {

    @NotEmpty(message = "Descrição do teste é obrigatório")
    private String description;

}
