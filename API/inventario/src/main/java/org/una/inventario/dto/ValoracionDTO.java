package org.una.inventario.dto;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ValoracionDTO {

    private Long id;
    private double precio;
    private Date fechaCreacion;
}
