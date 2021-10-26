package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.inventario.dto.ExepcionDTO;
import org.una.inventario.dto.InventarioDTO;
import org.una.inventario.entities.Exepcion;
import org.una.inventario.entities.Inventario;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.IInventarioRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioServiceImplementation implements IInventarioService{

    @Autowired
    private IInventarioRepository inventarioRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<InventarioDTO> findById(Long id) {
        Optional<Inventario> inventario = inventarioRepository.findById(id);
        if (inventario.isEmpty()) throw new NotFoundInformationException();

        InventarioDTO inventarioDTO = MapperUtils.DtoFromEntity(inventario.get(), InventarioDTO.class);
        return Optional.ofNullable(inventarioDTO);
    }

    private InventarioDTO getSavedInventarioDTO(InventarioDTO inventarioDTO) {
        Inventario inventario = MapperUtils.EntityFromDto(inventarioDTO, Inventario.class);
        Inventario  inventarioCreated = inventarioRepository.save(inventario);
        return MapperUtils.DtoFromEntity(inventarioCreated, InventarioDTO.class);
    }

    @Override
    public Optional<InventarioDTO> create(InventarioDTO inventarioDTO) {
        return Optional.ofNullable(getSavedInventarioDTO(inventarioDTO));
    }

    @Override
    public Optional<InventarioDTO> update(InventarioDTO inventarioDTO, Long id) {
        if (inventarioRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedInventarioDTO(inventarioDTO));
    }

    @Override
    public void delete(Long id) {
        inventarioRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        inventarioRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<InventarioDTO>> findAll() {
        List<InventarioDTO> inventarioDTOList = MapperUtils.DtoListFromEntityList(inventarioRepository.findAll(), InventarioDTO.class);
        return Optional.ofNullable(inventarioDTOList);
    }

    @Override
    public Optional<List<InventarioDTO>> findbyEstado(String estado) {
        List<Inventario> inventarioList = inventarioRepository.findByEstado(estado);
        List<InventarioDTO> inventarioDTOList = MapperUtils.DtoListFromEntityList(inventarioList, InventarioDTO.class);
        return Optional.ofNullable(inventarioDTOList);
    }

    @Override
    public Optional<InventarioDTO> findByResponsable(Long id) {
        Optional<InventarioDTO> inventario = inventarioRepository.findByResponsable(id);
        if (inventario.isEmpty()) throw new NotFoundInformationException();

        InventarioDTO inventarioDTO = MapperUtils.DtoFromEntity(inventario.get(), InventarioDTO.class);
        return Optional.ofNullable(inventarioDTO);
    }
}
