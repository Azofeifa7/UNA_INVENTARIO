package org.una.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.inventario.entities.Rol;
import org.una.inventario.entities.Transaccion;

public interface ITransaccionRepository extends JpaRepository<Transaccion, Long> {
}
