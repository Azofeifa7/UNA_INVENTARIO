package org.una.inventario.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean estado;

    @Column(length = 100, name = "nombre")
    private String nombre;

    @Column(name = "fecha_Creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaCreacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
     @Builder.Default
    private List<Usuario> usuarios = new ArrayList<>();

    private static final long serialVersionUID = 1L;


    @PrePersist
    public void prePersist() {
        estado = true;
        fechaCreacion = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        fechaCreacion = new Date();
    }
}
