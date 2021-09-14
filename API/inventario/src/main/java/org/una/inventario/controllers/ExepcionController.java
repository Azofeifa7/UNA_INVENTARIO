package org.una.inventario.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.DepartamentoDTO;
import org.una.inventario.dto.ExepcionDTO;
import org.una.inventario.dto.RolDTO;
import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.services.IDepartamentoService;
import org.una.inventario.services.IExepcionService;
import org.una.inventario.services.IUsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exepciones")
@Api(tags = {"Exepciones"})

public class ExepcionController {

    @Autowired
    private IExepcionService exepcionService;

    @ApiOperation(value = "Obtiene una exepcion por ID", response = ExepcionDTO.class, tags = "Exepciones")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ExepcionDTO> rolFound = exepcionService.findById(id);
        return new ResponseEntity<>(rolFound, HttpStatus.OK);

    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Crea una exepcion", response = ExepcionDTO.class, tags = "Exepciones")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ExepcionDTO exepcionDTO) {
        Optional<ExepcionDTO> exepcionCreated = exepcionService.create(exepcionDTO);
        return new ResponseEntity<>(exepcionCreated, HttpStatus.CREATED);

    }

    @ApiOperation(value = "Modifica una exepcion", response = ExepcionDTO.class, tags = "Exepciones")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ExepcionDTO exepcionModified) {

        Optional<ExepcionDTO> exepcionUpdated = exepcionService.update(exepcionModified, id);
        return new ResponseEntity<>(exepcionUpdated, HttpStatus.OK);

    }

    @ApiOperation(value = "Obtiene una exepcion por estado", response = ExepcionDTO.class, responseContainer = "List", tags = "Exepciones")
    @GetMapping("/estado/{term}")
    public ResponseEntity<?> findbyEstado(@PathVariable(value = "term") boolean term) {

        Optional<List<ExepcionDTO>> result = exepcionService.findbyEstado(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        // try {
        exepcionService.delete(id);
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
