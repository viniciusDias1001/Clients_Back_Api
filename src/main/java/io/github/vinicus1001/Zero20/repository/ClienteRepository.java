package io.github.vinicus1001.Zero20.repository;


import io.github.vinicus1001.Zero20.entity.Cliente;
import io.github.vinicus1001.Zero20.entity.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {


}
