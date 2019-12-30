package com.kocfinans.api.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Data
@Entity(name = "user_entity")
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID  id;

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
