package org.una.inventario.services;

import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.dto.ValoracionDTO;

import java.util.List;
import java.util.Optional;

public interface IValoracionService {

    public Optional<List<ValoracionDTO>> findAll();

    public Optional<ValoracionDTO> findById(Long id);

    public Optional<ValoracionDTO> create(ValoracionDTO valoracionDTO);

    public Optional<ValoracionDTO> update(ValoracionDTO valoracionDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
