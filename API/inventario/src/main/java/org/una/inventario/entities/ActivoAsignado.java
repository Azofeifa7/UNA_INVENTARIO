package org.una.inventario.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "activoAsignado")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActivoAsignado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "justificacion", length = 100)
    private String justificacion;

    @Column(length = 10, name = "estado")
    private String estado;

    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="activo_id")
    private Activo activo;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        fechaCreacion= new Date();
    }

    @PreUpdate
    public void preUpdate() {
        fechaCreacion = new Date();
    }
}
