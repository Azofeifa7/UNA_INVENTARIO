package org.una.inventario.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ParametroDTO {

    private Long id;
    private String valor;
    private String nombre;
    private String estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
}
