package org.una.inventario.services;

import org.una.inventario.dto.RolDTO;
import org.una.inventario.dto.TransaccionDTO;
import org.una.inventario.entities.Transaccion;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ITransaccionService {
    public Optional<TransaccionDTO> findById(Long id);

    //public Optional<List<Transaccion>> findByUsuarioIdAndFechaCreacionBetween(Long usuarioId, Date startDate, Date endDate);

    //public Optional<List<Transaccion>> findByRolIdAndFechaCreacionBetween(Long rolId, Date startDate, Date endDate);

    //public Optional<List<Transaccion>> findByObjetoAndFechaCreacionBetween(String objetoId, Date startDate, Date endDate);

   // public Optional<List<Transaccion>> findByFechaCreacionBetween(Date startDate, Date endDate);

    public Optional<TransaccionDTO> create(TransaccionDTO transaccionDTO);
}


