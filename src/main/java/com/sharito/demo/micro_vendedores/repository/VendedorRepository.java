package com.sharito.demo.micro_vendedores.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sharito.demo.micro_vendedores.entity.VendedorEntity;

@Repository
public interface VendedorRepository extends JpaRepository<VendedorEntity, Integer> {

}
