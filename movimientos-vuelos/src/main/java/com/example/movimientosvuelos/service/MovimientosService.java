package com.example.movimientosvuelos.service;

import com.example.movimientosvuelos.models.Movimientos;
import com.example.movimientosvuelos.repositories.MovimientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientosService {

    @Autowired
    private MovimientosRepository movimientosRepository;

    public List<Movimientos> findAll() {
        return movimientosRepository.findAll();
    }

    public Optional<Movimientos> findById(Long id) {
        return movimientosRepository.findById(id);
    }

    public Movimientos save(Movimientos movimientos) {
        return movimientosRepository.save(movimientos);
    }

    public void deleteById(Long id) {
        movimientosRepository.deleteById(id);
    }
}