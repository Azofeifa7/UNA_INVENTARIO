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
    private String estado;
    private Long numero;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long continente;
    private MarcaDTO marca;
    private ProveedorDTO proveedor;

}
