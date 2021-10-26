package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.inventario.entities.Categoria;
import org.una.inventario.entities.ContratoGarantia;

import java.util.List;

public interface IContratoGarantiaRepository extends JpaRepository<ContratoGarantia, Long> {
    List<ContratoGarantia> findByEstado(String term);
}
