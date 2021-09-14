package org.una.inventario.services;

import org.una.inventario.dto.ExepcionDTO;
import org.una.inventario.dto.RolDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IExepcionService {

    public Optional<ExepcionDTO> findById(Long id);
    public Optional<List<ExepcionDTO>> findByFechaCreacionBetween(Date startDate, Date endDate);
    public Optional<ExepcionDTO> create(ExepcionDTO exepcionDTO);
    public Optional<ExepcionDTO> update(ExepcionDTO exepcionDTO, Long id);
    public Optional<List<ExepcionDTO>> findByUsuarioId(Long id);
    public void delete(Long id);
    public void deleteAll();
    Optional<List<ExepcionDTO>> findbyEstado(boolean term);
}
