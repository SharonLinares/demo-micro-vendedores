package com.sharito.demo.micro_vendedores.service;

import java.util.List;

import com.sharito.demo.micro_vendedores.dto.VendedorDto;

public interface VendedorService {

	public VendedorDto crear(VendedorDto vendedorDto);

	public VendedorDto actualizar(VendedorDto vendedorDto, Integer id);

	public List<VendedorDto> consultarVendedores();

	public void eliminar(Integer id);

}
