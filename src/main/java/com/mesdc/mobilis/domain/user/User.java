package com.mesdc.mobilis.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // <-- ESSENCIAL para o Spring saber que isso é uma entidade JPA
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Pode usar UUID se o campo for `String`
    private String id;

    private String name;
    private String email;
    private String password;
}
