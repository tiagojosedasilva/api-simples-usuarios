package com.api7.apisimplesusuarios.repositorio;

import com.api7.apisimplesusuarios.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuario extends JpaRepository<Usuarios, Long> {
}
