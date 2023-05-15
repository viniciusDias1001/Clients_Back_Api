package io.github.vinicus1001.Zero20.Controller;

import io.github.vinicus1001.Zero20.entity.Usuario;
import io.github.vinicus1001.Zero20.exception.UsuarioCadastradoException;
import io.github.vinicus1001.Zero20.repository.UsuarioRepository;
import io.github.vinicus1001.Zero20.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping(("api/usuarios"))
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public Usuario save(@RequestBody @Valid Usuario usuario){
        try{
            return usuarioService.salvar(usuario);

        }catch (UsuarioCadastradoException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}
