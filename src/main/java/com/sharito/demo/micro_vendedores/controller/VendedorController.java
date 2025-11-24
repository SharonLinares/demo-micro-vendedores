package com.sharito.demo.micro_vendedores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharito.demo.micro_vendedores.dto.VendedorDto;
import com.sharito.demo.micro_vendedores.service.VendedorService;

@RestController
@RequestMapping("vendedores")
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;

	@PostMapping
	public ResponseEntity<VendedorDto> crear(@RequestBody VendedorDto vendedorDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(vendedorService.crear(vendedorDto));
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<VendedorDto> actualizar(@RequestBody VendedorDto vendedorDto, @PathVariable String codigoVendedor) {
		return ResponseEntity.status(HttpStatus.CREATED).body(vendedorService.actualizar(vendedorDto, codigoVendedor));
	}

	@GetMapping("/consultarvendedores")
	public ResponseEntity<List<VendedorDto>> consultarVendedores() {
		return ResponseEntity.ok(vendedorService.consultarVendedores());
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		vendedorService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
