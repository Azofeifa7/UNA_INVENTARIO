package org.una.inventario.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.ExepcionDTO;
import org.una.inventario.dto.InventarioDTO;
import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.services.IInventarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventarios")
@Api(tags = {"Inventarios"})

public class InventarioController {
    @Autowired
    private IInventarioService inventarioService;

    @ApiOperation(value = "Obtiene un inventario por ID", response = InventarioDTO.class, tags = "Inventarios")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<InventarioDTO> inventarioFound = inventarioService.findById(id);
        return new ResponseEntity<>(inventarioFound, HttpStatus.OK);

    }

    @ApiOperation(value = "Obtiene una lista de todos los Inventarios ", response =InventarioDTO.class, responseContainer = "List", tags = "Inventarios")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<InventarioDTO>> result = inventarioService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene un inventario por estado", response = InventarioDTO.class, responseContainer = "List", tags = "Inventarios")
    @GetMapping("/estado/{term}")
    public ResponseEntity<?> findbyEstado(@PathVariable(value = "term") String term) {

        Optional<List<InventarioDTO>> result = inventarioService.findbyEstado(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Crea un inventario", response = InventarioDTO.class, tags = "Inventarios")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody InventarioDTO inventarioDTO) {
        Optional<InventarioDTO> inventarioCreated = inventarioService.create(inventarioDTO);
        return new ResponseEntity<>(inventarioCreated, HttpStatus.CREATED);

    }

    @ApiOperation(value = "Modifica un inventario", response = InventarioDTO.class, tags = "Inventarios")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody InventarioDTO inventarioModified) {

        Optional<InventarioDTO> inventarioUpdated = inventarioService.update(inventarioModified, id);
        return new ResponseEntity<>(inventarioUpdated, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        // try {
        inventarioService.delete(id);
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
