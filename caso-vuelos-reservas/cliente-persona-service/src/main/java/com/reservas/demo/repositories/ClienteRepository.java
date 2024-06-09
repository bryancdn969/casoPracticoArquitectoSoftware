package com.reservas.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservas.demo.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}