package io.github.vinicus1001.Zero20.Controller;

import io.github.vinicus1001.Zero20.entity.Usuario;
import io.github.vinicus1001.Zero20.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(("api/usuarios"))
@RequiredArgsConstructor
public class UsuarioController {


    private final UsuarioRepository usuarioRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody @Valid Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
