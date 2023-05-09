package io.github.vinicus1001.Zero20.Controller;


import io.github.vinicus1001.Zero20.Util.BigDecimalConverter;
import io.github.vinicus1001.Zero20.entity.dto.ServicoPrestadoDTO;
import io.github.vinicus1001.Zero20.entity.Cliente;
import io.github.vinicus1001.Zero20.entity.ServicoPrestado;
import io.github.vinicus1001.Zero20.repository.ClienteRepository;
import io.github.vinicus1001.Zero20.repository.ServicoPrestadoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/servico-prestado")
@RequiredArgsConstructor
public class ServicoPrestadoController {

    private final ServicoPrestadoRepository servicoPrestadoRepository;
    private final ClienteRepository clienteRepository;
    private final BigDecimalConverter bIgconvert ;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody @Valid ServicoPrestadoDTO servicoPrestadoDTO){

        LocalDate  date = LocalDate.parse(servicoPrestadoDTO.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer clienteId = servicoPrestadoDTO.getIdCliente();

        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado, para o ID desejado"));

        ServicoPrestado servicoPrestado = new ServicoPrestado();

        System.out.println(servicoPrestado.getId());
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setData(date);
        servicoPrestado.setDescricao(servicoPrestadoDTO.getDescricao());
        servicoPrestado.setValor(bIgconvert.converter(servicoPrestadoDTO.getPreco()));
        servicoPrestadoRepository.save(servicoPrestado);
        return  servicoPrestado;
    }

    @GetMapping
    public List<ServicoPrestado> buscar(@RequestParam(value = "nome", required = false, defaultValue = "") String nome, @RequestParam(value = "mes" , required = false)  Integer mes){
        return servicoPrestadoRepository.findByNomeClienteAdnMes( "%" + nome + "%" , mes);
    }
}
