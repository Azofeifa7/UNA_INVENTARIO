package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.AlertaDTO;
import org.una.inventario.services.IAlertaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alertas")
@Api(tags = {"Alertas"})
public class AlertaController {


    @Autowired
    private IAlertaService alertaService;

    @ApiOperation(value = "Obtiene una lista de todos las alertas ", response = AlertaDTO.class, responseContainer = "List", tags = "Alertas")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<AlertaDTO>> result = alertaService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene un alerta por ID", response = AlertaDTO.class, tags = "Alertas")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<AlertaDTO> alertaFound = alertaService.findById(id);
        return new ResponseEntity<>(alertaFound, HttpStatus.OK);

    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Crea una alerta", response = AlertaDTO.class, tags = "Alertas")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody AlertaDTO alertaDTO) {
        Optional<AlertaDTO> alertaCreated = alertaService.create(alertaDTO);
        return new ResponseEntity<>(alertaCreated, HttpStatus.CREATED);

    }

    @ApiOperation(value = "Obtiene una lista de alertas por estado", response = AlertaDTO.class, responseContainer = "List", tags = "Alertas")
    @GetMapping("/estado/{term}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "term") String term) {

        Optional<List<AlertaDTO>> result = alertaService.findByEstado(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Modifica una alerta", response = AlertaDTO.class, tags = "Alertas")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody AlertaDTO alertaModified) {

        Optional<AlertaDTO> alertaUpdated = alertaService.update(alertaModified, id);
        return new ResponseEntity<>(alertaUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        // try {
        alertaService.delete(id);
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
