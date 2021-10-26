package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.inventario.dto.ValoracionDTO;
import org.una.inventario.entities.Valoracion;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.ValoracionRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;
@Service
public class ValoracionServiceImplementation implements IValoracionService {
    @Autowired
    private ValoracionRepository valoracionRepository;


    @Override
    public Optional<List<ValoracionDTO>> findAll() {

        List<ValoracionDTO> valoracionDTOList = MapperUtils.DtoListFromEntityList(valoracionRepository.findAll(), ValoracionDTO.class);
        return Optional.ofNullable(valoracionDTOList);
    }

    @Override
    public Optional<ValoracionDTO> findById(Long id) {
        Optional<Valoracion> valoracion= valoracionRepository.findById(id);
        if (valoracion.isEmpty()) throw new NotFoundInformationException();

        ValoracionDTO valoracionDTO = MapperUtils.DtoFromEntity(valoracion.get(), ValoracionDTO.class);
        return Optional.ofNullable(valoracionDTO);
    }

    private ValoracionDTO getSavedValoracionDTO(ValoracionDTO valoracionDTO) {
        Valoracion valoracion = MapperUtils.EntityFromDto(valoracionDTO, Valoracion.class);
        Valoracion valoracionCreated = valoracionRepository.save(valoracion);
        return MapperUtils.DtoFromEntity(valoracionCreated, ValoracionDTO.class);
    }

    @Override
    public Optional<ValoracionDTO> create(ValoracionDTO valoracionDTO) {
        return Optional.ofNullable(getSavedValoracionDTO(valoracionDTO));
    }

    @Override
    public Optional<ValoracionDTO> update(ValoracionDTO valoracionDTO, Long id) {
        if (valoracionRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedValoracionDTO(valoracionDTO));
    }

    @Override
    public void delete(Long id) {
       valoracionRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        valoracionRepository.deleteAll();
    }
}
