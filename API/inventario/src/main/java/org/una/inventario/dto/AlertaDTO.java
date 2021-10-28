package org.una.inventario.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AlertaDTO {

    private Long id;
    private String tipo;
    private String descripcion;
    private String estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Long responsable;
}
