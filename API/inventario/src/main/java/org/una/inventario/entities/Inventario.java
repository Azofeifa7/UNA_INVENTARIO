package org.una.inventario.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "inventarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Inventario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long responsable;

    @Column(length = 100, name = "descripcion")
    private String descripcion;

    @Column(length = 100, name = "estado")
    private String estado;

    @Column(name = "fecha_Creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaCreacion;

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
