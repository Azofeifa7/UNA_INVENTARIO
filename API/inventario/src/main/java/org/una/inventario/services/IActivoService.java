package org.una.inventario.services;

import org.springframework.data.repository.query.Param;
import org.una.inventario.dto.ActivoDTO;
import org.una.inventario.dto.CategoriaDTO;
import org.una.inventario.entities.Activo;


import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IActivoService {

    public Optional<ActivoDTO> findById(Long id);
    public Optional<ActivoDTO> create(ActivoDTO activoDTO);
    public Optional<ActivoDTO> update(ActivoDTO activoDTO, Long id);
    public void delete(Long id);
    public void deleteAll();
    Optional<List<ActivoDTO>> findbyEstado(String term);
    public Optional<List<ActivoDTO>> findAll();
    public Optional<ActivoDTO> findByNombre(String nombre);

    public Optional<List<ActivoDTO>> findByProveedorIdAndStart(Long id, Date fechaInicio, Date fechaFinal);

}
