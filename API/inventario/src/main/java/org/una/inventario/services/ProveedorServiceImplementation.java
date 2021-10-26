package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.inventario.dto.InventarioDTO;
import org.una.inventario.dto.ProveedorDTO;
import org.una.inventario.entities.Inventario;
import org.una.inventario.entities.Proveedor;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.IInventarioRepository;
import org.una.inventario.repositories.IProveedorRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;
@Service
public class ProveedorServiceImplementation implements IProveedorService{


    @Autowired
    private IProveedorRepository proveedorRepository;


    @Override
    @Transactional(readOnly = true)
    public Optional<ProveedorDTO> findById(Long id) {
        Optional<Proveedor> proveedor = proveedorRepository.findById(id);
        if (proveedor.isEmpty()) throw new NotFoundInformationException();

        ProveedorDTO proveedorDTO = MapperUtils.DtoFromEntity(proveedor.get(), ProveedorDTO.class);
        return Optional.ofNullable(proveedorDTO);
    }
    private ProveedorDTO getSavedProveedorDTO(ProveedorDTO proveedorDTO) {
        Proveedor proveedor = MapperUtils.EntityFromDto(proveedorDTO, Proveedor.class);
        Proveedor  proveedorCreated = proveedorRepository.save(proveedor);
        return MapperUtils.DtoFromEntity(proveedorCreated, ProveedorDTO.class);
    }


    @Override
    public Optional<ProveedorDTO> create(ProveedorDTO proveedorDTO) {
        return Optional.ofNullable(getSavedProveedorDTO(proveedorDTO));
    }

    @Override
    public Optional<ProveedorDTO> update(ProveedorDTO proveedorDTO, Long id) {
        if (proveedorRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedProveedorDTO(proveedorDTO));
    }

    @Override
    public void delete(Long id) {
        proveedorRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        proveedorRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ProveedorDTO>> findAll() {
        List<ProveedorDTO> proveedorDTOList = MapperUtils.DtoListFromEntityList(proveedorRepository.findAll(), ProveedorDTO.class);
        return Optional.ofNullable(proveedorDTOList);
    }

    @Override
    public Optional<List<ProveedorDTO>> findbyEstado(String estado) {
        List<Proveedor> proveedorList = proveedorRepository.findByEstado(estado);
        List<ProveedorDTO> proveedorDTOList = MapperUtils.DtoListFromEntityList(proveedorList, ProveedorDTO.class);
        return Optional.ofNullable(proveedorDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ProveedorDTO>> findByNombreCompletoAproximateIgnoreCase(String nombreCompleto) {
        List<Proveedor> proveedorList = proveedorRepository.findByNombreCompletoContainingIgnoreCase(nombreCompleto);
        List<ProveedorDTO> proveedorDTOList = MapperUtils.DtoListFromEntityList(proveedorList, ProveedorDTO.class);
        return Optional.ofNullable(proveedorDTOList);
    }
}
