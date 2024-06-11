package com.example.reservavuelos.repositories;

import com.example.reservavuelos.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}