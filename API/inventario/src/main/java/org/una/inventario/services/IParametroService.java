package org.una.inventario.services;

import org.una.inventario.dto.ParametroDTO;
import org.una.inventario.dto.UsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface IParametroService {

    public Optional<List<ParametroDTO>> findAll();

    public Optional<ParametroDTO> findById(Long id);

    public Optional<List<ParametroDTO>> findByEstado(String estado);

    public Optional<ParametroDTO> findByNombre(String nombre);

    public Optional<ParametroDTO> create(ParametroDTO parametroDTO);

    public Optional<ParametroDTO> update(ParametroDTO parametroDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
