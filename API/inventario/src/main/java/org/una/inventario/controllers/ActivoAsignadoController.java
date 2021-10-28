package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.ActivoAsignadoDTO;
import org.una.inventario.services.IActivoAsignadoService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/activosAsignados")
@Api(tags = {"ActivosAsignados"})
public class ActivoAsignadoController {


    @Autowired
    private IActivoAsignadoService activoAsignadoService;

    @ApiOperation(value = "Obtiene una lista de todos las alertas ", response = ActivoAsignadoDTO.class, responseContainer = "List", tags = "ActivosAsignados")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<ActivoAsignadoDTO>> result = activoAsignadoService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene un activo Asignado por ID", response = ActivoAsignadoDTO.class, tags = "ActivosAsignados")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ActivoAsignadoDTO> activoAsignadoFound = activoAsignadoService.findById(id);
        return new ResponseEntity<>(activoAsignadoFound, HttpStatus.OK);

    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Crea un activo Asignado", response = ActivoAsignadoDTO.class, tags = "ActivosAsignados")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ActivoAsignadoDTO activoAsignadoDTO) {
        Optional<ActivoAsignadoDTO> activoAsignadoCreated = activoAsignadoService.create(activoAsignadoDTO);
        return new ResponseEntity<>(activoAsignadoCreated, HttpStatus.CREATED);

    }

    @ApiOperation(value = "Obtiene una lista de activos Asignados por estado", response = ActivoAsignadoDTO.class, responseContainer = "List", tags = "ActivosAsignados")
    @GetMapping("/estado/{term}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "term") String term) {

        Optional<List<ActivoAsignadoDTO>> result = activoAsignadoService.findByEstado(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Modifica un activo Asignado", response = ActivoAsignadoDTO.class, tags = "ActivosAsignados")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ActivoAsignadoDTO activoAsignadoModified) {

        Optional<ActivoAsignadoDTO> activoAsignadoUpdated = activoAsignadoService.update(activoAsignadoModified, id);
        return new ResponseEntity<>(activoAsignadoUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        // try {
        activoAsignadoService.delete(id);
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
