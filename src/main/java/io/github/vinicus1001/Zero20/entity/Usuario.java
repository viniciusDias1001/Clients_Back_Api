package io.github.vinicus1001.Zero20.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "usuario")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Column(name = "login")
    @NotEmpty(message = "O campo UserName não pode ser vazio ")
    @NotNull
    @Getter
    @Setter
    private String username;

    @Column(name = "senha")
    @NotEmpty(message = "o campo senha não pode ser vazio")
    @NotNull
    @Getter
    private String senha;
}
