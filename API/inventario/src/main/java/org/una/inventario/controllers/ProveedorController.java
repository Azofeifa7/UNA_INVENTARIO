package org.una.inventario.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.InventarioDTO;
import org.una.inventario.dto.ProveedorDTO;
import org.una.inventario.services.IInventarioService;
import org.una.inventario.services.IProveedorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proveedores")
@Api(tags = {"Proveedores"})

public class ProveedorController {

    @Autowired
    private IProveedorService proveedorService;

    @ApiOperation(value = "Obtiene un proveedor por ID", response = ProveedorDTO.class, tags = "Proveedores")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        Optional<ProveedorDTO> proveedorFound = proveedorService.findById(id);
        return new ResponseEntity<>(proveedorFound, HttpStatus.OK);

    }

    @ApiOperation(value = "Obtiene una lista de todos los proveedores ", response =ProveedorDTO.class, responseContainer = "List", tags = "Proveedores")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<ProveedorDTO>> result = proveedorService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene un proveedor por estado", response = ProveedorDTO.class, responseContainer = "List", tags = "Proveedores")
    @GetMapping("/estado/{term}")
    public ResponseEntity<?> findbyEstado(@PathVariable(value = "term") String term) {

        Optional<List<ProveedorDTO>> result = proveedorService.findbyEstado(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Crea un proveedor", response = ProveedorDTO.class, tags = "Proveedores")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody ProveedorDTO proveedorDTO) {
        Optional<ProveedorDTO> proveedorCreated = proveedorService.create(proveedorDTO);
        return new ResponseEntity<>(proveedorCreated, HttpStatus.CREATED);

    }

    @ApiOperation(value = "Modifica un proveedor", response = ProveedorDTO.class, tags = "Proveedores")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody ProveedorDTO proveedorModified) {

        Optional<ProveedorDTO> proveedorUpdated = proveedorService.update(proveedorModified, id);
        return new ResponseEntity<>(proveedorUpdated, HttpStatus.OK);

    }

    @GetMapping("/nombre/{term}")
    @ApiOperation(value = "Obtiene una lista de los proveedores por nombre", response = ProveedorDTO.class, responseContainer = "List", tags = "Proveedores")
    public ResponseEntity<?> findByNombreCompletoAproximateIgnoreCase(@PathVariable(value = "term") String term) {
        Optional<List<ProveedorDTO>> result = proveedorService.findByNombreCompletoAproximateIgnoreCase(term);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        // try {
        proveedorService.delete(id);
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
