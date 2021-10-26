package org.una.inventario.services;

import org.una.inventario.dto.DepartamentoDTO;
import org.una.inventario.dto.RolDTO;

import java.util.List;
import java.util.Optional;

public interface IDepartamentoService {

    public Optional<List<DepartamentoDTO>> findbyEstado(boolean estado);
    public Optional<DepartamentoDTO> create(DepartamentoDTO departamentoDTO);
}
