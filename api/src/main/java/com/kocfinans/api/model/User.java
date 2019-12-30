package com.kocfinans.api.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@Entity
public class User {

    @NotEmpty(message = "Kimlik alanı boş geçilemez")
    private String citizenNumber;

    @NotEmpty(message = "İsim alanı boş geçilemez")
    private String name;

    @NotEmpty(message = "Soyisim alanı boş geçilemez")
    private String lastName;

    @NotEmpty(message = "Aylık kazanç boş geçilemez")
    private float monthlyIncome;

    @Pattern(regexp = "^(05([0-9]{9}))$")
    private String phone;

}
