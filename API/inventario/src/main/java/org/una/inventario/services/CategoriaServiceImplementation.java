package org.una.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.inventario.dto.CategoriaDTO;
import org.una.inventario.dto.InventarioDTO;
import org.una.inventario.entities.Categoria;
import org.una.inventario.entities.Inventario;
import org.una.inventario.exceptions.NotFoundInformationException;
import org.una.inventario.repositories.ICategoriaRepository;
import org.una.inventario.repositories.IDepartamentoRepository;
import org.una.inventario.utils.MapperUtils;

import java.util.List;
import java.util.Optional;
@Service

public class CategoriaServiceImplementation implements ICategoriaService{


    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<CategoriaDTO> findById(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isEmpty()) throw new NotFoundInformationException();

        CategoriaDTO categoriaDTO = MapperUtils.DtoFromEntity(categoria.get(), CategoriaDTO.class);
        return Optional.ofNullable(categoriaDTO);
    }

    private CategoriaDTO getSavedCategoriaDTO(CategoriaDTO categoriaDTO) {
        Categoria categoria = MapperUtils.EntityFromDto(categoriaDTO, Categoria.class);
        Categoria  categoriaCreated = categoriaRepository.save(categoria);
        return MapperUtils.DtoFromEntity(categoriaCreated, CategoriaDTO.class);
    }

    @Override
    public Optional<CategoriaDTO> create(CategoriaDTO categoriaDTO) {
        return Optional.ofNullable(getSavedCategoriaDTO(categoriaDTO));
    }

    @Override
    public Optional<CategoriaDTO> update(CategoriaDTO categoriaDTO, Long id) {
        if (categoriaRepository.findById(id).isEmpty()) throw new NotFoundInformationException();

        return Optional.ofNullable(getSavedCategoriaDTO(categoriaDTO));
    }

    @Override
    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        categoriaRepository.deleteAll();
    }

    @Override
    public Optional<List<CategoriaDTO>> findbyEstado(String term) {
        List<Categoria> categoriaList = categoriaRepository.findByEstado(term);
        List<CategoriaDTO> categoriaDTOList = MapperUtils.DtoListFromEntityList(categoriaList, CategoriaDTO.class);
        return Optional.ofNullable(categoriaDTOList);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CategoriaDTO>> findAll() {
        List<CategoriaDTO> categoriaDTOList = MapperUtils.DtoListFromEntityList(categoriaRepository.findAll(), CategoriaDTO.class);
        return Optional.ofNullable(categoriaDTOList);
    }

    @Override
    public Optional<CategoriaDTO> findByNombre(String nombre) {
        Optional<Categoria> categoria = categoriaRepository.findByNombre(nombre);
        if (categoria.isEmpty()) throw new NotFoundInformationException();

        CategoriaDTO categoriaDTO = MapperUtils.DtoFromEntity(categoria.get(), CategoriaDTO.class);
        return Optional.ofNullable(categoriaDTO);
    }
}
