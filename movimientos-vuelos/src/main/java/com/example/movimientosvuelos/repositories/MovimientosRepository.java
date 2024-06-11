package com.example.movimientosvuelos.repositories;


import com.example.movimientosvuelos.models.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovimientosRepository extends JpaRepository<Movimientos, Long> {
    List<Movimientos> findByCuentaIdAndFechaBetween(Long cuentaId, Date fechaInicio, Date fechaFin);
}