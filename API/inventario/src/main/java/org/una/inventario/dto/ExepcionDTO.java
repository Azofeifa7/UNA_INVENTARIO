package org.una.inventario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.inventario.entities.Usuario;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExepcionDTO {

    private Long id;
    private String descripcion;
    private boolean estado;
    private Date fechaCreacion;
    private Usuario usuario;
}
