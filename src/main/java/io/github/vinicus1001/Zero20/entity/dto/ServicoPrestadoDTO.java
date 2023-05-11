package io.github.vinicus1001.Zero20.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.text.NumberFormat;
import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoPrestadoDTO {

    @NotEmpty(message = "O campo Descrição é obrigatorio")
    private String descricao;

    @NotEmpty(message = "O campo preço é Obrigatorio")
    private String preco;

    @NotEmpty(message = "O campo Data é obrigatorio")
    private String data;

    private Integer idCliente;


}
