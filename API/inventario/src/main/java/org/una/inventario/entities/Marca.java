package org.una.inventario.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "marcas")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Marca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 250, name = "nombre")
    private String nombre;

    @Column(length = 10, name = "estado")
    private String estado;

    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.PUBLIC)
    private Date fechaCreacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marca")
    @Builder.Default
    private List<Activo> activo = new ArrayList<>();

    private static final long serialVersionUID = 1L;

//    @PrePersist
//    public void prePersist() {
//        //fechaCreacion = new Date();
//    }
}
