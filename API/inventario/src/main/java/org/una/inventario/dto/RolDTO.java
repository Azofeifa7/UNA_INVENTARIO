package org.una.inventario.dto;

import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class RolDTO {
    private Long id;
    private String nombre;
    private Date fechaCreacion;
    private boolean estado;
}
