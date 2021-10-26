package org.una.inventario.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "categorias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, name = "nombre")
    private String nombre;

    @Column(length = 100, name = "estado")
    private String estado;

    @Column(name = "fecha_Creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaCreacion;


    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    @Builder.Default
    private List<Activo> activos = new ArrayList<>();*/

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
