package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.inventario.dto.ActivoAsignadoDTO;
import org.una.inventario.entities.ActivoAsignado;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.ActivoAsignadoRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;
@Service
public class ActivoAsignadoServiceImplementation implements IActivoAsignadoService{
    @Autowired
    private ActivoAsignadoRepository activoAsignadoRepository;

    @Override
    public Optional<List<ActivoAsignadoDTO>> findAll() {
        List< ActivoAsignadoDTO> activoAsignadoDTOList = MapperUtils.DtoListFromEntityList(activoAsignadoRepository.findAll(), ActivoAsignadoDTO.class);
        return Optional.ofNullable(activoAsignadoDTOList);
    }

    @Override
    public Optional<ActivoAsignadoDTO> findById(Long id) {
        Optional< ActivoAsignado> activoAsignado = activoAsignadoRepository.findById(id);
        if (activoAsignado.isEmpty()) throw new NotFoundInformationException();

        ActivoAsignadoDTO activoAsignadoDTO = MapperUtils.DtoFromEntity(activoAsignado.get(),  ActivoAsignadoDTO.class);
        return Optional.ofNullable(activoAsignadoDTO);
    }

    @Override
    public Optional<List<ActivoAsignadoDTO>> findByEstado(String estado) {
        List< ActivoAsignado> activoAsignadoList =activoAsignadoRepository.findByEstado(estado);
        List< ActivoAsignadoDTO> activoAsignadoDTOList = MapperUtils.DtoListFromEntityList(activoAsignadoList,  ActivoAsignadoDTO.class);
        return Optional.ofNullable(activoAsignadoDTOList);
    }

    private ActivoAsignadoDTO getSavedActivoAsignadoDTO(ActivoAsignadoDTO  activoAsignadoDTO) {
        ActivoAsignado activoAsignado = MapperUtils.EntityFromDto(activoAsignadoDTO, ActivoAsignado.class);
        ActivoAsignado activoAsignadoCreated = activoAsignadoRepository.save(activoAsignado);
        return MapperUtils.DtoFromEntity(activoAsignadoCreated, ActivoAsignadoDTO.class);
    }

    @Override
    public Optional<ActivoAsignadoDTO> create(ActivoAsignadoDTO activoAsignadoDTO) {
        return Optional.ofNullable(getSavedActivoAsignadoDTO(activoAsignadoDTO));
    }

    @Override
    public Optional<ActivoAsignadoDTO> update(ActivoAsignadoDTO activoAsignadoDTO, Long id) {
        if (activoAsignadoRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedActivoAsignadoDTO(activoAsignadoDTO));
    }

    @Override
    public void delete(Long id) {
        activoAsignadoRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        activoAsignadoRepository.deleteAll();
    }
}
