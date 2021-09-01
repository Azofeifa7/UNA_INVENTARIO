package org.una.inventario.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.una.inventario.dto.DepartamentoDTO;
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
}
