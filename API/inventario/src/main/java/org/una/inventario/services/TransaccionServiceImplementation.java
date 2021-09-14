package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.inventario.dto.TransaccionDTO;
import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.entities.Transaccion;
import org.una.inventario.entities.Usuario;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.IRolRepository;
import org.una.inventario.repositories.ITransaccionRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.Optional;

@Service
public class TransaccionServiceImplementation implements ITransaccionService {

    @Autowired
    private ITransaccionRepository transaccionRepository;

    @Override
    public Optional<TransaccionDTO> findById(Long id) {
        Optional<Transaccion> transaccion = transaccionRepository.findById(id);
        if (transaccion.isEmpty()) throw new NotFoundInformationException();

        TransaccionDTO transaccionDTO = MapperUtils.DtoFromEntity(transaccion.get(), TransaccionDTO.class);
        return Optional.ofNullable(transaccionDTO);
    }

    private TransaccionDTO getSavedTransaccionDTO(TransaccionDTO transaccionDTO) {
        Transaccion transaccion = MapperUtils.EntityFromDto(transaccionDTO, Transaccion.class);
        Transaccion transaccionCreated = transaccionRepository.save(transaccion);
        return MapperUtils.DtoFromEntity(transaccionCreated, TransaccionDTO.class);
    }

    @Override
    public Optional<TransaccionDTO> create(TransaccionDTO transaccionDTO) {
        return Optional.ofNullable(getSavedTransaccionDTO(transaccionDTO));
    }
}