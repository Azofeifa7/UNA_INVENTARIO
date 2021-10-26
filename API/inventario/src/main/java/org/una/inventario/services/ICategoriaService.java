package org.una.inventario.services;

import org.una.inventario.dto.CategoriaDTO;
import org.una.inventario.dto.ExepcionDTO;
import org.una.inventario.dto.InventarioDTO;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {

    public Optional<CategoriaDTO> findById(Long id);
    public Optional<CategoriaDTO> create(CategoriaDTO categoriaDTO);
    public Optional<CategoriaDTO> update(CategoriaDTO categoriaDTO, Long id);
    public void delete(Long id);
    public void deleteAll();
    Optional<List<CategoriaDTO>> findbyEstado(String term);
    public Optional<List<CategoriaDTO>> findAll();
    public Optional<CategoriaDTO> findByNombre(String nombre);

}
