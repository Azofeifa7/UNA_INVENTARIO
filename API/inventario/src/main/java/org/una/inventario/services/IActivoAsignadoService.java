package org.una.inventario.services;

import org.una.inventario.dto.ActivoAsignadoDTO;
import org.una.inventario.dto.MarcaDTO;

import java.util.List;
import java.util.Optional;

public interface IActivoAsignadoService {

    public Optional<List<ActivoAsignadoDTO>> findAll();

    public Optional<ActivoAsignadoDTO> findById(Long id);

    public Optional<List<ActivoAsignadoDTO>> findByEstado(String estado);

    public Optional<ActivoAsignadoDTO> create(ActivoAsignadoDTO activoAsignadoDTO);

    public Optional<ActivoAsignadoDTO> update(ActivoAsignadoDTO activoAsignadoDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
