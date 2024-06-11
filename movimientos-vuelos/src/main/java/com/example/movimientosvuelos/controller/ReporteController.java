package com.example.movimientosvuelos.controller;


import com.example.movimientosvuelos.models.Cuenta;
import com.example.movimientosvuelos.models.Movimientos;
import com.example.movimientosvuelos.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public ResponseEntity<?> getReporte(
            @RequestParam Long clienteId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {

        List<Cuenta> cuentas = reporteService.getCuentasPorCliente(clienteId);
        if (cuentas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        for (Cuenta cuenta : cuentas) {
            List<Movimientos> movimientos = reporteService.getMovimientosPorCuentaYFechas(cuenta.getId(), fechaInicio, fechaFin);
            cuenta.setMovimientos(movimientos);
        }

        return ResponseEntity.ok(cuentas);
    }
}