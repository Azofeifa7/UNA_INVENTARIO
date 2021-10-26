package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.inventario.dto.CategoriaDTO;
import org.una.inventario.dto.ContratoGarantiaDTO;
import org.una.inventario.entities.Categoria;
import org.una.inventario.entities.ContratoGarantia;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.ICategoriaRepository;
import org.una.inventario.repositories.IContratoGarantiaRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service

public class ContratoGarantiaServiceImplementation implements IContratoGarantiaService{

    @Autowired
    private IContratoGarantiaRepository contratoRepository;


    @Override
    @Transactional(readOnly = true)
    public Optional<ContratoGarantiaDTO> findById(Long id) {
        Optional<ContratoGarantia> contratoG = contratoRepository.findById(id);
        if (contratoG.isEmpty()) throw new NotFoundInformationException();

        ContratoGarantiaDTO contratoGarantiaDTO = MapperUtils.DtoFromEntity(contratoG.get(), ContratoGarantiaDTO.class);
        return Optional.ofNullable(contratoGarantiaDTO);
    }

    private ContratoGarantiaDTO getSavedContratoGarantiaDTO(ContratoGarantiaDTO contratoGarantiaDTO) {
        ContratoGarantia contratoG = MapperUtils.EntityFromDto(contratoGarantiaDTO, ContratoGarantia.class);
        ContratoGarantia  contratoCreated = contratoRepository.save(contratoG);
        return MapperUtils.DtoFromEntity(contratoCreated, ContratoGarantiaDTO.class);
    }

    @Override
    public Optional<ContratoGarantiaDTO> create(ContratoGarantiaDTO contratoGarantiaDTO) {
        return Optional.ofNullable(getSavedContratoGarantiaDTO(contratoGarantiaDTO));
    }

    @Override
    public Optional<ContratoGarantiaDTO> update(ContratoGarantiaDTO contratoGarantiaDTO, Long id) {
        if (contratoRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedContratoGarantiaDTO(contratoGarantiaDTO));
    }

    @Override
    public void delete(Long id) {
        contratoRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        contratoRepository.deleteAll();
    }

    @Override
    public Optional<List<ContratoGarantiaDTO>> findbyEstado(String term) {
        List<ContratoGarantia> contratoList = contratoRepository.findByEstado(term);
        List<ContratoGarantiaDTO> contratoDTOList = MapperUtils.DtoListFromEntityList(contratoList, ContratoGarantiaDTO.class);
        return Optional.ofNullable(contratoDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ContratoGarantiaDTO>> findAll() {
        List<ContratoGarantiaDTO> contratoDTOList = MapperUtils.DtoListFromEntityList(contratoRepository.findAll(), ContratoGarantiaDTO.class);
        return Optional.ofNullable(contratoDTOList);
    }
}
