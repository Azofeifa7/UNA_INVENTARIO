package org.una.inventario.dto;


import lombok.*;
import org.una.inventario.entities.Categoria;
import org.una.inventario.entities.Proveedor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ActivoDTO {
    private Long id;
    private String nombre;
    private boolean estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private ProveedorDTO proveedor;
    private CategoriaDTO categoria;
    private String correo;
    private String telefono;
    private String nota;
    private Long continente;
}
