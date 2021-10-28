package org.una.inventario.dto;

import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ActivoAsignadoDTO {

    private Long id;
    private String justificacion;
    private String estado;
    private Date fechaCreacion;
}
