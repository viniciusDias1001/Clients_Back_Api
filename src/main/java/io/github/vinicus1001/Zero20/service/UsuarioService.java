package io.github.vinicus1001.Zero20.service;


import io.github.vinicus1001.Zero20.entity.Usuario;
import io.github.vinicus1001.Zero20.exception.UsuarioCadastradoException;
import io.github.vinicus1001.Zero20.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario){
        boolean exist = usuarioRepository.existsByUsername(usuario.getUsername());
        if (exist == true){
            throw new UsuarioCadastradoException();
        }
        return  usuarioRepository.save(usuario);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("login não encontrado"));
        return User.builder().username(usuario.getUsername()).password(usuario.getSenha()).roles("USER").build();
    }
}
