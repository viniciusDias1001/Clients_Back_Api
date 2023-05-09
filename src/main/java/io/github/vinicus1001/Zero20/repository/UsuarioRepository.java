package io.github.vinicus1001.Zero20.repository;

import io.github.vinicus1001.Zero20.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
