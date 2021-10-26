package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.inventario.dto.ParametroDTO;
import org.una.inventario.entities.Marca;
import org.una.inventario.entities.Parametro;

import java.util.List;
import java.util.Optional;
@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

    public List<Marca> findByEstado(String estado);

    public Marca findByNombre(String nombre);
}
