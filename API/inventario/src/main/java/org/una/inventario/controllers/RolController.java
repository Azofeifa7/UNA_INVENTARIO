package org.una.inventario.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.RolDTO;
import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.entities.Rol;
import org.una.inventario.services.IRolService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/roles")
@Api(tags = {"Roles"})

public class RolController {
    @Autowired
    private IRolService RolService;


    @ApiOperation(value = "Obtiene un Rol por ID", response = RolDTO.class, tags = "Roles")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<RolDTO> rolFound = RolService.findById(id);
        return new ResponseEntity<>(rolFound, HttpStatus.OK);

    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Crea un rol", response = RolDTO.class, tags = "Roles")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody RolDTO rolDTO) {
        Optional<RolDTO> rolCreated = RolService.create(rolDTO);
        return new ResponseEntity<>(rolCreated, HttpStatus.CREATED);

    }

    @ApiOperation(value = "Modifica un rol", response = RolDTO.class, tags = "Roles")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody RolDTO rolModified) {

        Optional<RolDTO> rolUpdated = RolService.update(rolModified, id);
        return new ResponseEntity<>(rolUpdated, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
       // try {
            RolService.delete(id);
            return new ResponseEntity<>("Ok", HttpStatus.OK);

      //  } catch (Exception e) {
         //   return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
     //   }
    }


    @DeleteMapping("/")
    public void deleteAll() throws Exception {
//        //TODO: Implementar este método
//        throw new Exception("Not implemented Function");

    }
}
