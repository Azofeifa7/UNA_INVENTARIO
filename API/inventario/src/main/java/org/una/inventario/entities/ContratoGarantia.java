package org.una.inventario.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "contratosGarantias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ContratoGarantia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean montoAsegurado;

    @Column
    private boolean costo;

    @Column(length = 10, name = "estado")
    private String estado;

    @Column(length = 10, name = "fechaVencimiento")
    private String fechaVencimiento;

    @Column(name = "fecha_Creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaCreacion;

    @Column(name = "fecha_Modificacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaModificacion;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        fechaCreacion = new Date();

    }

    @PreUpdate
    public void preUpdate() {
        fechaCreacion = new Date();

    }

}
