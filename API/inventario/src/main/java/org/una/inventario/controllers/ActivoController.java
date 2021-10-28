package org.una.inventario.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.ActivoDTO;
import org.una.inventario.dto.CategoriaDTO;
import org.una.inventario.services.IActivoService;
import org.una.inventario.services.ICategoriaService;

import javax.xml.crypto.Data;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/activos")
@Api(tags = {"Activos"})

public class ActivoController {

    @Autowired
    private IActivoService activoService;


    @ApiOperation(value = "Obtiene un activo por ID", response = ActivoDTO.class, tags = "Activos")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ActivoDTO> activoFound = activoService.findById(id);
        return new ResponseEntity<>(activoFound, HttpStatus.OK);

    }

    @ApiOperation(value = "Obtiene una lista de todos los activos ", response =ActivoDTO.class, responseContainer = "List", tags = "Activos")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<ActivoDTO>> result = activoService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene un activo por estado", response = ActivoDTO.class, responseContainer = "List", tags = "Activos")
    @GetMapping("/estado/{term}")
    public ResponseEntity<?> findbyEstado(@PathVariable(value = "term") String term) {

        Optional<List<ActivoDTO>> result = activoService.findbyEstado(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Crea un activo", response = ActivoDTO.class, tags = "Activos")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ActivoDTO activoDTO) {
        Optional<ActivoDTO> activoCreated = activoService.create(activoDTO);
        return new ResponseEntity<>(activoCreated, HttpStatus.CREATED);

    }

    @ApiOperation(value = "Obtiene una lista de activos por id de proveedor y un intervalo de fechas", response = ActivoDTO.class, responseContainer = "List", tags = "Activos")
    @GetMapping("/findByProveedorIdAndStartDateAndEndDate/{idProve},{fechaInicio},{fechaFinal}")
    public ResponseEntity<?> findByProveedorIdAndStartDateAndEndDate(@PathVariable(value = "idProve") Long idProve, @PathVariable(value = "fechaInicio")
    @DateTimeFormat (pattern = "yyyy,MM,dd") Date fechaInicio, @PathVariable(value = "fechaFinal")
    @DateTimeFormat (pattern = "yyyy,MM,dd") Date fechaFinal) {

        Optional<List<ActivoDTO>> result = activoService.findByProveedorIdAndStart(idProve, fechaInicio, fechaFinal);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @ApiOperation(value = "Modifica un activo", response = ActivoDTO.class, tags = "Activos")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ActivoDTO activoModified) {

        Optional<ActivoDTO> activoUpdated = activoService.update(activoModified, id);
        return new ResponseEntity<>(activoUpdated, HttpStatus.OK);

    }


    @ApiOperation(value = "Obtiene un activo por nombre", response = ActivoDTO.class, tags = "Activos")
    @GetMapping("/{nombre}")
    public ResponseEntity<?> findByNombre(@PathVariable(value = "nombre") String nombre) {
        Optional<ActivoDTO> activoFound = activoService.findByNombre(nombre);
        return new ResponseEntity<>(activoFound, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        // try {
        activoService.delete(id);
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
