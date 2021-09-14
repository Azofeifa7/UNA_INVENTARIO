package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.TransaccionDTO;
import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.services.ITransaccionService;
import org.una.inventario.services.IUsuarioService;

import java.util.Optional;

@RestController
@RequestMapping("/transacciones")
@Api(tags = {"Transacciones"})

public class TransaccionController {
    @Autowired
    private ITransaccionService transaccionService;


    @ApiOperation(value = "Obtiene una transaccion por ID", response = TransaccionDTO.class, tags = "Transacciones")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<TransaccionDTO> transaccionFound = transaccionService.findById(id);
        return new ResponseEntity<>(transaccionFound, HttpStatus.OK);

    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Crea una transaccion", response = TransaccionDTO.class, tags = "Transacciones")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody TransaccionDTO transaccionDTO) {
        Optional<TransaccionDTO> transaccionCreated = transaccionService.create(transaccionDTO);
        return new ResponseEntity<>(transaccionCreated, HttpStatus.CREATED);

    }
}
