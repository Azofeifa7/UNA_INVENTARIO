package org.una.inventario.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "activos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Activo implements Serializable {
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

    @Column(name = "fecha_Modificacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaModificacion;

    @ManyToOne
    @JoinColumn(name="marcas_id")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name="proveedor_id")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        fechaCreacion = new Date();
        fechaModificacion = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        fechaCreacion = new Date();
        fechaModificacion = new Date();
    }

}
