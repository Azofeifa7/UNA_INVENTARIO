package org.una.inventario.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InventarioDTO {
    private Long id;
    private Long responsable;
    private String descripcion;
    private String estado;
    private Date fechaCreacion;
}
