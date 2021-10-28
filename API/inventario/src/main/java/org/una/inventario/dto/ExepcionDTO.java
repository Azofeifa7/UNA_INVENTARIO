package org.una.inventario.dto;

import lombok.*;
import org.una.inventario.entities.Usuario;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ExepcionDTO {

    private Long id;
    private String descripcion;
    private boolean estado;
    private Date fechaCreacion;
    private UsuarioDTO usuario;
}
