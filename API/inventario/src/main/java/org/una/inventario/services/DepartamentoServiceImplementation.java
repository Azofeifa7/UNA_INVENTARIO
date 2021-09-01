package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.inventario.dto.DepartamentoDTO;
import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.entities.Departamento;
import org.una.inventario.repositories.IDepartamentoRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;
@Service
public class DepartamentoServiceImplementation implements IDepartamentoService{

    @Autowired
    private IDepartamentoRepository departamentoRepository;

    @Override
    @Transactional
    public Optional<List<DepartamentoDTO>> findbyEstado(boolean estado) {
        List<Departamento> departamentoList = departamentoRepository.findByEstado(estado);
        List<DepartamentoDTO> departamentoDTOList = MapperUtils.DtoListFromEntityList(departamentoList, DepartamentoDTO.class);
        return Optional.ofNullable(departamentoDTOList);
    }
}
