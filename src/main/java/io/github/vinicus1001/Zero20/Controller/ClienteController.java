package io.github.vinicus1001.Zero20.Controller;


import io.github.vinicus1001.Zero20.entity.Cliente;
import io.github.vinicus1001.Zero20.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody @Valid Cliente cliente  ){
            return clienteRepository.save( cliente);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        clienteRepository.findById(id).map(cliente -> {
            clienteRepository.delete(cliente);
            return cliente;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado no DB"));
    }

    @GetMapping("{id}")
    public Cliente getById(@PathVariable Integer id){
        return clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado no DB"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody @Valid Cliente cliente, @PathVariable Integer id){
        clienteRepository.findById(id).map( cliente1 -> {
            cliente.setId(cliente1.getId());
            clienteRepository.save(cliente);
            return cliente;

        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado no DB"));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> getAll(){
       return clienteRepository.findAll();
    }


}
