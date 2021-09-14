package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.services.IDataInitializerService;
import org.una.inventario.services.IDepartamentoService;

@RestController
@RequestMapping("/data")

public class DataInitializerController {

    @Autowired
    private IDataInitializerService dataService;


    @PostMapping("/")
    @ApiOperation(value = "Agrega la informacion de inicio",tags = "Data")
    public ResponseEntity<?> initDevelopData(){
        dataService.initDevelopData();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
