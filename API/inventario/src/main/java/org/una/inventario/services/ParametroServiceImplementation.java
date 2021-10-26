package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.inventario.dto.ParametroDTO;
import org.una.inventario.entities.Parametro;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.ParametroRepository;
import org.una.inventario.utils.MapperUtils;


import java.util.List;
import java.util.Optional;
@Service
public class ParametroServiceImplementation implements IParametroService{

    @Autowired
    private ParametroRepository parametroRepository;

    @Override
    public Optional<List<ParametroDTO>> findAll() {
        List<ParametroDTO> parametroDTOList = MapperUtils.DtoListFromEntityList(parametroRepository.findAll(), ParametroDTO.class);
        return Optional.ofNullable(parametroDTOList);
    }

    @Override
    public Optional<ParametroDTO> findById(Long id) {
        Optional<Parametro> parametro= parametroRepository.findById(id);
        if (parametro.isEmpty()) throw new NotFoundInformationException();

        ParametroDTO parametroDTO = MapperUtils.DtoFromEntity(parametro.get(), ParametroDTO.class);
        return Optional.ofNullable(parametroDTO);
    }

    @Override
    public Optional<List<ParametroDTO>> findByEstado(String estado) {
        List<Parametro> parametroList = parametroRepository.findByEstado(estado);
        List<ParametroDTO> parametroDTOList = MapperUtils.DtoListFromEntityList(parametroList, ParametroDTO.class);
        return Optional.ofNullable(parametroDTOList);
    }

    @Override
    public Optional<ParametroDTO> findByNombre(String nombre) {
        Optional<Parametro> parametro =Optional.ofNullable( parametroRepository.findByNombre(nombre));
        if (parametro.isEmpty()) throw new NotFoundInformationException();
        ParametroDTO parametroDTO = MapperUtils.DtoFromEntity(parametro.get(), ParametroDTO.class);
        return Optional.ofNullable(parametroDTO);
    }

    private ParametroDTO getSavedParametroDTO(ParametroDTO parametroDTO) {
        Parametro parametro = MapperUtils.EntityFromDto(parametroDTO, Parametro.class);
        Parametro parametroCreated = parametroRepository.save(parametro);
        return MapperUtils.DtoFromEntity(parametroCreated, ParametroDTO.class);
    }

    @Override
    public Optional<ParametroDTO> create(ParametroDTO parametroDTO) {
        return Optional.ofNullable(getSavedParametroDTO(parametroDTO));
    }

    @Override
    public Optional<ParametroDTO> update(ParametroDTO parametroDTO, Long id) {
        if (parametroRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedParametroDTO(parametroDTO));
    }

    @Override
    public void delete(Long id) {
       parametroRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
     parametroRepository.deleteAll();
    }
}
