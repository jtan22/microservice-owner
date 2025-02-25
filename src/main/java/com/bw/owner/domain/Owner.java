package com.bw.owner.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name = "owners")
@Data
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    @NotBlank(message = "Owner first name must not be blank")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Owner last name must not be blank")
    private String lastName;

    @NotBlank(message = "Owner address must not be blank")
    private String address;

    @NotBlank(message = "Owner city must not be blank")
    private String city;

    @NotBlank(message = "Owner telephone must not be blank")
    @Pattern(regexp = "^[0-9]{10}$", message = "Owner telephone must be 10 digits")
    private String telephone;

}
