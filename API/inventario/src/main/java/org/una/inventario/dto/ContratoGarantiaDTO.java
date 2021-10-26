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
public class ContratoGarantiaDTO {


    private Long id;
    private boolean montoAsegurado;
    private boolean costo;
    private String estado;
    private String fechaVencimiento;
    private Date fechaCreacion;
    private Date fechaModificacion;

}
