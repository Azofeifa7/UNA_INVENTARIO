package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.ParametroDTO;
import org.una.inventario.services.IParametroService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parametros")
@Api(tags = {"Parametros"})
public class ParametroController {

    @Autowired
    private IParametroService parametroService;

    @ApiOperation(value = "Obtiene una lista de todos los parametros ", response = ParametroDTO.class, responseContainer = "List", tags = "Parametros")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<ParametroDTO>> result = parametroService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene un parametro por ID", response = ParametroDTO.class, tags = "Parametros")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ParametroDTO> usuarioFound = parametroService.findById(id);
        return new ResponseEntity<>(usuarioFound, HttpStatus.OK);

    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Crea un parametro", response = ParametroDTO.class, tags = "Parametros")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ParametroDTO usuarioDTO) {
        Optional<ParametroDTO> parametroCreated = parametroService.create(usuarioDTO);
        return new ResponseEntity<>(parametroCreated, HttpStatus.CREATED);

    }

    @ApiOperation(value = "Obtiene una lista parametro por estado", response = ParametroDTO.class, responseContainer = "List", tags = "Parametros")
    @GetMapping("/estado/{term}")
    public ResponseEntity<?> findByEstado(@PathVariable(value = "term") String term) {

        Optional<List<ParametroDTO>> result = parametroService.findByEstado(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene un parametro por nombre", response = ParametroDTO.class, tags = "Parametros")
    @GetMapping("/cedula/{term}")
    public ResponseEntity<?> findByNombre(@PathVariable(value = "term") String term) {
        Optional<ParametroDTO>result = parametroService.findByNombre(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Modifica un parametro", response =ParametroDTO.class, tags = "Parametros")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ParametroDTO parametroModified) {

        Optional<ParametroDTO> parametroUpdated = parametroService.update(parametroModified, id);
        return new ResponseEntity<>(parametroUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        // try {
        parametroService.delete(id);
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
