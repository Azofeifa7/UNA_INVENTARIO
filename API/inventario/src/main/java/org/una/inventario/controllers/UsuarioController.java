package org.una.inventario.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.una.inventario.dto.AuthenticationResponse;
import org.una.inventario.dto.UsuarioDTO;
import org.una.inventario.exceptions.InvalidCredentialsException;
import org.una.inventario.exceptions.MissingInputsException;
import org.una.inventario.services.IUsuarioService;

import java.util.List;
import java.util.Optional;


@RequestMapping("/usuarios")
@Api(tags = {"Usuarios"})
@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;


    @ApiOperation(value = "Obtiene una lista de todos los Usuarios", response = UsuarioDTO.class, responseContainer = "List", tags = "Usuarios")
    @GetMapping()
    public @ResponseBody
    ResponseEntity<?> findAll() {
        Optional<List<UsuarioDTO>> result = usuarioService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene un usuario por ID", response = UsuarioDTO.class, tags = "Usuarios")
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('AUDITOR')")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
            Optional<UsuarioDTO> usuarioFound = usuarioService.findById(id);
                return new ResponseEntity<>(usuarioFound, HttpStatus.OK);

    }

    @ApiOperation(value = "Obtiene un usuario por cedula", response = UsuarioDTO.class, responseContainer = "List", tags = "Usuarios")
    @GetMapping("/cedula/{term}")
    public ResponseEntity<?> findByCedulaAproximate(@PathVariable(value = "term") String term) {

            Optional<List<UsuarioDTO>> result = usuarioService.findByCedulaAproximate(term);

                return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @ApiOperation(value = "Obtiene un usuario por nombre", response = UsuarioDTO.class, responseContainer = "List", tags = "Usuarios")
    @GetMapping("/nombre/{term}")
    public ResponseEntity<?> findByNombreCompletoAproximateIgnoreCase(@PathVariable(value = "term") String term) {

            Optional<List<UsuarioDTO>> result = usuarioService.findByNombreCompletoAproximateIgnoreCase(term);
            return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Crea un usuario", response = UsuarioDTO.class, tags = "Usuarios")
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody UsuarioDTO usuarioDTO) {
            Optional<UsuarioDTO> usuarioCreated = usuarioService.create(usuarioDTO);
            return new ResponseEntity<>(usuarioCreated, HttpStatus.CREATED);

    }

    @ApiOperation(value = "Modifica un usuario", response = UsuarioDTO.class, tags = "Usuarios")
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody UsuarioDTO usuarioModified) {

            Optional<UsuarioDTO> usuarioUpdated = usuarioService.update(usuarioModified, id);
                return new ResponseEntity<>(usuarioUpdated, HttpStatus.OK);

    }

    @ApiOperation(value = "Obtiene un departamento por id", response = UsuarioDTO.class, responseContainer = "List", tags = "Usuarios")
    @GetMapping("/id/{term}")
    public ResponseEntity<?> findByDepartamentoId(@PathVariable(value = "term") Long term) {

        Optional<List<UsuarioDTO>> result = usuarioService.findByDepartamentoId(term);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
       // try {
            usuarioService.delete(id);
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
