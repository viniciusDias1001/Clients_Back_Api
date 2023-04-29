package io.github.vinicus1001.Zero20.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoPrestadoDTO {
    private String descricao;
    private String preco;
    private String data;
    private Integer idCliente;
}
