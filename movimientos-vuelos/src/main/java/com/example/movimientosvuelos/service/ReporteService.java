package com.example.movimientosvuelos.service;

import com.example.movimientosvuelos.models.Cuenta;
import com.example.movimientosvuelos.models.Movimientos;
import com.example.movimientosvuelos.repositories.CuentaRepository;
import com.example.movimientosvuelos.repositories.MovimientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientosRepository movimientosRepository;

    public List<Cuenta> getCuentasPorCliente(Long clienteId) {
        return cuentaRepository.findByClienteId(clienteId);
    }

    public List<Movimientos> getMovimientosPorCuentaYFechas(Long cuentaId, Date fechaInicio, Date fechaFin) {
        return movimientosRepository.findByCuentaIdAndFechaBetween(cuentaId, fechaInicio, fechaFin);
    }
}