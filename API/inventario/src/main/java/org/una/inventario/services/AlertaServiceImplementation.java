package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.inventario.dto.AlertaDTO;
import org.una.inventario.entities.Alerta;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.AlertaRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;
@Service
public class AlertaServiceImplementation implements IAlertaService{

    @Autowired
    private AlertaRepository alertaRepository;

    @Override
    public Optional<List<AlertaDTO>> findAll() {
        List<AlertaDTO> alertaDTOList = MapperUtils.DtoListFromEntityList(alertaRepository.findAll(), AlertaDTO.class);
        return Optional.ofNullable(alertaDTOList);
    }

    @Override
    public Optional<AlertaDTO> findById(Long id) {
        Optional< Alerta> alerta = alertaRepository.findById(id);
        if (alerta.isEmpty()) throw new NotFoundInformationException();

        AlertaDTO alertaDTO = MapperUtils.DtoFromEntity(alerta.get(),  AlertaDTO.class);
        return Optional.ofNullable(alertaDTO);
    }

    @Override
    public Optional<List<AlertaDTO>> findByEstado(String estado) {
        List< Alerta> alertaList =alertaRepository.findByEstado(estado);
        List< AlertaDTO> alertaDTOList = MapperUtils.DtoListFromEntityList(alertaList,  AlertaDTO.class);
        return Optional.ofNullable(alertaDTOList);
    }

    private AlertaDTO getSavedAlertaDTO(AlertaDTO  alertaDTO) {
        Alerta alerta = MapperUtils.EntityFromDto(alertaDTO, Alerta.class);
        Alerta alertaCreated = alertaRepository.save(alerta);
        return MapperUtils.DtoFromEntity(alertaCreated, AlertaDTO.class);
    }

    @Override
    public Optional<AlertaDTO> create(AlertaDTO alertaDTO) {
        return Optional.ofNullable(getSavedAlertaDTO(alertaDTO));
    }

    @Override
    public Optional<AlertaDTO> update(AlertaDTO alertaDTO, Long id) {
        if (alertaRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedAlertaDTO(alertaDTO));
    }

    @Override
    public void delete(Long id) {
       alertaRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        alertaRepository.deleteAll();
    }
}
