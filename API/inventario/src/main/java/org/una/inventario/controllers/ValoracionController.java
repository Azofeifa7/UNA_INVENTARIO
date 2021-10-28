package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.ValoracionDTO;
import org.una.inventario.services.IValoracionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/valoraciones")
@Api(tags = {"Valoraciones"})
public class ValoracionController {

    @Autowired
    private IValoracionService valoracionService;

    @ApiOperation(value = "Obtiene una lista de todos las valoraciones ", response = ValoracionDTO.class, responseContainer = "List", tags = "Valoraciones")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<ValoracionDTO>> result = valoracionService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene una valoracion por ID", response = ValoracionDTO.class, tags = "Valoraciones")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ValoracionDTO> usuarioFound = valoracionService.findById(id);
        return new ResponseEntity<>(usuarioFound, HttpStatus.OK);

    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Crea una valoracion", response = ValoracionDTO.class, tags = "Valoraciones")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ValoracionDTO usuarioDTO) {
        Optional<ValoracionDTO> valoracionCreated = valoracionService.create(usuarioDTO);
        return new ResponseEntity<>(valoracionCreated, HttpStatus.CREATED);

    }

    @ApiOperation(value = "Modifica una valoracion", response =ValoracionDTO.class, tags = "Valoraciones")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ValoracionDTO valoracionModified) {

        Optional<ValoracionDTO> valoracionUpdated = valoracionService.update(valoracionModified, id);
        return new ResponseEntity<>(valoracionUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        // try {
        valoracionService.delete(id);
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
