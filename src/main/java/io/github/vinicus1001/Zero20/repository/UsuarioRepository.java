package io.github.vinicus1001.Zero20.repository;

import io.github.vinicus1001.Zero20.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    Optional<Usuario> findByUsername(String username);

    boolean existsByUsername(String username);
}
