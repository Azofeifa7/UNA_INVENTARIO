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
public class ProveedorDTO {
    private Long id;
    private String nombreCompleto;
    private String notas;
    private String telefono;
    private String correo;
    private String estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
}
