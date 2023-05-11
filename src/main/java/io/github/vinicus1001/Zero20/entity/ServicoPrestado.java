package io.github.vinicus1001.Zero20.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "SERVICO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoPrestado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "A descrição não pode ser nula")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column
    @NotNull(message = "O valor não pode ser nulo")
    private BigDecimal valor;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "A data não pode ser nula")
    private LocalDate data;






}
