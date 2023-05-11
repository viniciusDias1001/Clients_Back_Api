package io.github.vinicus1001.Zero20.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "nome",length = 200,nullable = false)
    @NotEmpty(message = "O campo nome não pode ser Vazio")
    private String nome;

    @Column(name = "cpf",length = 14,nullable = false)
    @CPF(message = "CPF invalido, Preencha o campo com um cpf Valido")
    @NotEmpty(message = "O campo cpf não pode ser Vazio")
    private String cpf;

    @Column(name = "data",nullable = false, updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;



    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }

}
