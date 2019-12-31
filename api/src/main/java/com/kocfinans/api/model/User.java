package com.kocfinans.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
@Entity(name = "user_entity")
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID  id;

    @NotEmpty(message = "Kimlik alanı boş geçilemez")
    @Column(unique = true)
    private String citizenNumber;

    @NotEmpty(message = "İsim alanı boş geçilemez")
    private String name;

    @NotEmpty(message = "Soyisim alanı boş geçilemez")
    private String lastName;

    @NotNull(message = "Aylık kazanç boş geçilemez")
    private float monthlyIncome;

    private int creditScore;

    @NotNull(message = "Telefon alanı boş geçilemez")
    @Pattern(regexp = "^(05([0-9]{9}))$",message = "Lütfen geçerli bir telefon numarası giriniz.")
    @Column(unique = true)
    private String phone;


    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<CreditApplication> creditApplication;


    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private  Date updated;

}
