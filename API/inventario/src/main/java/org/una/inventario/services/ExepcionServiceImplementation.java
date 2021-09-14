package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.inventario.dto.ExepcionDTO;
import org.una.inventario.entities.Exepcion;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.IExepcionRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class ExepcionServiceImplementation implements IExepcionService{
    @Autowired
    private IExepcionRepository exepcionRepository;


    @Override
    @Transactional(readOnly = true)
    public Optional<ExepcionDTO> findById(Long id) {

            Optional<Exepcion> exepcion = exepcionRepository.findById(id);
            if (exepcion.isEmpty()) throw new NotFoundInformationException();

            ExepcionDTO exepcionDTO = MapperUtils.DtoFromEntity(exepcion.get(), ExepcionDTO.class);
            return Optional.ofNullable(exepcionDTO);


    }

    @Override
    public Optional<List<ExepcionDTO>> findByFechaCreacionBetween(Date startDate, Date endDate) {
        return Optional.empty();
    }

    private ExepcionDTO getSavedExepcionDTO(ExepcionDTO exepcionDTO) {
        Exepcion exepcion = MapperUtils.EntityFromDto(exepcionDTO, Exepcion.class);
        Exepcion exepcionCreated = exepcionRepository.save(exepcion);
        return MapperUtils.DtoFromEntity(exepcionCreated, ExepcionDTO.class);
    }

    @Override
    public Optional<ExepcionDTO> create(ExepcionDTO exepcionDTO) {
        return Optional.ofNullable(getSavedExepcionDTO(exepcionDTO));
    }

    @Override
    public Optional<ExepcionDTO> update(ExepcionDTO exepcionDTO, Long id) {
        if (exepcionRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedExepcionDTO(exepcionDTO));
    }

    @Override
    public Optional<List<ExepcionDTO>> findByUsuarioId(Long id) {
        List<Exepcion> exepcionList = exepcionRepository.findByUsuarioId(id);
        if (exepcionList.isEmpty()) throw new NotFoundInformationException();

        List<ExepcionDTO> exepcionDTOList = MapperUtils.DtoListFromEntityList(exepcionList, ExepcionDTO.class);
        return Optional.ofNullable(exepcionDTOList);
    }

    @Override
    public void delete(Long id) {
        exepcionRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        exepcionRepository.deleteAll();
    }

    @Override
    public Optional<List<ExepcionDTO>> findbyEstado(boolean term) {
        List<Exepcion> exepcionList = exepcionRepository.findByEstado(term);
        List<ExepcionDTO> exepcionDTOList = MapperUtils.DtoListFromEntityList(exepcionList, ExepcionDTO.class);
        return Optional.ofNullable(exepcionDTOList);
    }
}
