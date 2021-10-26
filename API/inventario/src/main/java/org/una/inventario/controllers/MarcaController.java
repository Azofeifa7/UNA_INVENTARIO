package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.MarcaDTO;
import org.una.inventario.services.IMarcaService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marcas")
@Api(tags = {"Marcas"})
public class MarcaController {

    @Autowired
    private IMarcaService marcaService;

    @ApiOperation(value = "Obtiene una lista de todos los parametros ", response = MarcaDTO.class, responseContainer = "List", tags = "Marcas")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<MarcaDTO>> result = marcaService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una marca por ID", response = MarcaDTO.class, tags = "Marcas")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<MarcaDTO> marcaFound = marcaService.findById(id);
        return new ResponseEntity<>(marcaFound, HttpStatus.OK);

    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Crea una marca", response = MarcaDTO.class, tags = "Marcas")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody MarcaDTO marcaDTO) {
        Optional<MarcaDTO> marcaCreated = marcaService.create(marcaDTO);
        return new ResponseEntity<>(marcaCreated, HttpStatus.CREATED);

    }

    @ApiOperation(value = "Obtiene una lista marca por estado", response = MarcaDTO.class, responseContainer = "List", tags = "Marcas")
    @GetMapping("/estado/{term}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "term") String term) {

        Optional<List<MarcaDTO>> result = marcaService.findByEstado(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una marca por nombre", response = MarcaDTO.class, tags = "Marcas")
    @GetMapping("/cedula/{term}")
    public ResponseEntity<?> findByNombre(@PathVariable(value = "term") String term) {
        Optional<MarcaDTO>result = marcaService.findByNombre(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Modifica una marca", response =MarcaDTO.class, tags = "Marcas")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody MarcaDTO marcaModified) {

        Optional<MarcaDTO> marcaUpdated =marcaService.update(marcaModified, id);
        return new ResponseEntity<>(marcaUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        // try {
        marcaService.delete(id);
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
