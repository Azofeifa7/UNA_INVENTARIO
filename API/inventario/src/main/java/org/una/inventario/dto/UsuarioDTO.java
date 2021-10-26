package org.una.inventario.dto;

import lombok.*;
import org.una.inventario.entities.Departamento;
import org.una.inventario.entities.Rol;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UsuarioDTO {

    private Long id;
    private String nombreCompleto;
    private String cedula;
    private boolean estado;
    private Date fechaRegistro;
    private Date fechaModificacion;
    private Long departamentoId;
    private String passwordEncriptado;
    private boolean esJefe;
    private DepartamentoDTO departamento;
    private RolDTO rol;
}


