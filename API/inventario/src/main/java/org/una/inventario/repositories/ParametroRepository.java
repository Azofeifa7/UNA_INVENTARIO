package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.dto.ParametroDTO;
import org.una.inventario.entities.Parametro;
import org.una.inventario.entities.Usuario;

import java.util.List;
import java.util.Optional;
@Repository
public interface ParametroRepository extends JpaRepository<Parametro, Long> {

    public List<Parametro> findByEstado(String estado);

    public Parametro findByNombre(String nombre);
}
