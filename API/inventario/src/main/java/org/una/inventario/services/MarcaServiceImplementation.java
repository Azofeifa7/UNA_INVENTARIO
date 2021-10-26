package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.inventario.dto.MarcaDTO;
import org.una.inventario.entities.Marca;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.MarcaRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;
@Service
public class MarcaServiceImplementation implements IMarcaService{

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public Optional<List<MarcaDTO>> findAll() {
        List<MarcaDTO> marcaDTOList = MapperUtils.DtoListFromEntityList(marcaRepository.findAll(),MarcaDTO.class);
        return Optional.ofNullable(marcaDTOList);
    }

    @Override
    public Optional<MarcaDTO> findById(Long id) {
        Optional<Marca> marca = marcaRepository.findById(id);
        if (marca.isEmpty()) throw new NotFoundInformationException();

        MarcaDTO marcaDTO = MapperUtils.DtoFromEntity(marca.get(), MarcaDTO.class);
        return Optional.ofNullable(marcaDTO);
    }

    @Override
    public Optional<List<MarcaDTO>> findByEstado(String estado) {
        List<Marca> marcaList = marcaRepository.findByEstado(estado);
        List<MarcaDTO> marcaDTOList = MapperUtils.DtoListFromEntityList(marcaList, MarcaDTO.class);
        return Optional.ofNullable(marcaDTOList);
    }

    @Override
    public Optional<MarcaDTO> findByNombre(String nombre) {
        Optional<Marca> marca =Optional.ofNullable( marcaRepository.findByNombre(nombre));
        if (marca.isEmpty()) throw new NotFoundInformationException();
        MarcaDTO marcaDTO = MapperUtils.DtoFromEntity(marca.get(), MarcaDTO.class);
        return Optional.ofNullable(marcaDTO);
    }

    private MarcaDTO getSavedMarcaDTO(MarcaDTO marcaDTO) {
        Marca marca = MapperUtils.EntityFromDto(marcaDTO, Marca.class);
        Marca marcaCreated = marcaRepository.save(marca);
        return MapperUtils.DtoFromEntity(marcaCreated, MarcaDTO.class);
    }

    @Override
    public Optional<MarcaDTO> create(MarcaDTO marcaDTO) {
        return Optional.ofNullable(getSavedMarcaDTO(marcaDTO));
    }

    @Override
    public Optional<MarcaDTO> update(MarcaDTO marcaDTO, Long id) {
        if (marcaRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedMarcaDTO(marcaDTO));
    }

    @Override
    public void delete(Long id) {
        marcaRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
       marcaRepository.deleteAll();
    }
}
