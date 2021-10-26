package org.una.inventario.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "proveedores")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Proveedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, name = "nombre")
    private String nombreCompleto;

    @Column(length = 250, name = "notas")
    private String notas;

    @Column(length = 10, name = "telefono")
    private String telefono;

    @Column(length = 100, name = "correo")
    private String correo;

    @Column(length = 10, name = "estado")
    private String estado;

    @Column(name = "fecha_Creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaCreacion;

    @Column(name = "fecha_Modificacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaModificacion;

   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor")
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
