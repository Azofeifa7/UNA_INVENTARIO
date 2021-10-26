package org.una.inventario.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.una.inventario.entities.Categoria;
import org.una.inventario.entities.Proveedor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActivoDTO {
    private Long id;
    private String nombre;
    private boolean estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    //private Proveedor proveedor;
   // private Categoria categoria;
}
