package org.una.inventario.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.DepartamentoDTO;
import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.services.IDepartamentoService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/departamentos")
@Api(tags = {"Departamentos"})

public class DepartamentoController {

   @Autowired
    private IDepartamentoService departamentoService;

    @ApiOperation(value = "Obtiene un departamento por estado", response = DepartamentoDTO.class, responseContainer = "List", tags = "Departamentos")
    @GetMapping("/estado/{term}")
    public ResponseEntity<?> findbyEstado(@PathVariable(value = "term") boolean term) {

        Optional<List<DepartamentoDTO>> result = departamentoService.findbyEstado(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Crea un departamento", response = DepartamentoDTO.class, tags = "Departamentos")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody DepartamentoDTO departamentoDTO) {
        Optional<DepartamentoDTO> departamentoCreated = departamentoService.create(departamentoDTO);
        return new ResponseEntity<>(departamentoCreated, HttpStatus.CREATED);

    }
}
