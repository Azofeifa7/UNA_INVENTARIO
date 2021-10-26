package org.una.inventario.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.CategoriaDTO;
import org.una.inventario.dto.InventarioDTO;
import org.una.inventario.services.ICategoriaService;
import org.una.inventario.services.IInventarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
@Api(tags = {"Categorias"})


public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;


    @ApiOperation(value = "Obtiene una categoria por ID", response = CategoriaDTO.class, tags = "Categorias")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<CategoriaDTO> categoriaFound = categoriaService.findById(id);
        return new ResponseEntity<>(categoriaFound, HttpStatus.OK);

    }

    @ApiOperation(value = "Obtiene una lista de todas las categorias ", response =CategoriaDTO.class, responseContainer = "List", tags = "Categorias")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<CategoriaDTO>> result = categoriaService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una categoria por estado", response = CategoriaDTO.class, responseContainer = "List", tags = "Categorias")
    @GetMapping("/estado/{term}")
    public ResponseEntity<?> findbyEstado(@PathVariable(value = "term") String term) {

        Optional<List<CategoriaDTO>> result = categoriaService.findbyEstado(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Crea una categoria", response = CategoriaDTO.class, tags = "Categorias")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody CategoriaDTO categoriaDTO) {
        Optional<CategoriaDTO> categoriaCreated = categoriaService.create(categoriaDTO);
        return new ResponseEntity<>(categoriaCreated, HttpStatus.CREATED);

    }

    @ApiOperation(value = "Modifica una categoria", response = CategoriaDTO.class, tags = "Categorias")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody CategoriaDTO categoriaModified) {

        Optional<CategoriaDTO> categoriaUpdated = categoriaService.update(categoriaModified, id);
        return new ResponseEntity<>(categoriaUpdated, HttpStatus.OK);

    }


    @ApiOperation(value = "Obtiene una categoria por nombre", response = CategoriaDTO.class, tags = "Categorias")
    @GetMapping("/{nombre}")
    public ResponseEntity<?> findByNombre(@PathVariable(value = "nombre") String nombre) {
        Optional<CategoriaDTO> categoriaFound = categoriaService.findByNombre(nombre);
        return new ResponseEntity<>(categoriaFound, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        // try {
        categoriaService.delete(id);
        return new ResponseEntity<>("Ok", HttpStatus.OK);

        // } catch (Exception e) {
        //     return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        // }
    }

    @DeleteMapping("/")
    public void deleteAll() throws Exception {
//        //TODO: Implementar este método
//        throw new Exception("Not implemented Function");

    }
}
