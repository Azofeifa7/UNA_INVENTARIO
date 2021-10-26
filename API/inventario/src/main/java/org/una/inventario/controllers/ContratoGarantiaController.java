package org.una.inventario.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.CategoriaDTO;
import org.una.inventario.dto.ContratoGarantiaDTO;
import org.una.inventario.services.ICategoriaService;
import org.una.inventario.services.IContratoGarantiaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contratosGarantias")
@Api(tags = {"ContratosGarantias"})


public class ContratoGarantiaController {

    @Autowired
    private IContratoGarantiaService contratoService;


    @ApiOperation(value = "Obtiene un ContratoGarantia por ID", response = ContratoGarantiaDTO.class, tags = "ContratosGarantias")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ContratoGarantiaDTO> contratoFound = contratoService.findById(id);
        return new ResponseEntity<>(contratoFound, HttpStatus.OK);

    }

    @ApiOperation(value = "Obtiene una lista de todas los ContratoGarantia ", response =ContratoGarantiaDTO.class, responseContainer = "List", tags = "ContratosGarantias")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<ContratoGarantiaDTO>> result = contratoService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene un ContratoGarantia por estado", response = ContratoGarantiaDTO.class, responseContainer = "List", tags = "ContratosGarantias")
    @GetMapping("/estado/{term}")
    public ResponseEntity<?> findbyEstado(@PathVariable(value = "term") String term) {

        Optional<List<ContratoGarantiaDTO>> result = contratoService.findbyEstado(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Crea un ContratoGarantia", response = ContratoGarantiaDTO.class, tags = "ContratosGarantias")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ContratoGarantiaDTO contratoGDTO) {
        Optional<ContratoGarantiaDTO> contratoCreated = contratoService.create(contratoGDTO);
        return new ResponseEntity<>(contratoCreated, HttpStatus.CREATED);

    }

    @ApiOperation(value = "Modifica un ContratoGarantia", response = ContratoGarantiaDTO.class, tags = "ContratosGarantias")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ContratoGarantiaDTO contratoGModified) {

        Optional<ContratoGarantiaDTO> contratoUpdated = contratoService.update(contratoGModified, id);
        return new ResponseEntity<>(contratoUpdated, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        // try {
        contratoService.delete(id);
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
