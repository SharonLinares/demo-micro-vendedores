package com.sharito.demo.micro_vendedores.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharito.demo.micro_vendedores.dto.VendedorDto;
import com.sharito.demo.micro_vendedores.entity.VendedorEntity;
import com.sharito.demo.micro_vendedores.repository.VendedorRepository;
import com.sharito.demo.micro_vendedores.service.VendedorService;

@Service
public class VendedorServiceImpl implements VendedorService {

	@Autowired
	private VendedorRepository vendedorRepository;

	@Override
	public VendedorDto crear(VendedorDto vendedorDto) {
		if (!vendedorRepository.existsByCodigoVendedor(vendedorDto.getCodigoVendedor())) {
			throw new IllegalArgumentException("ya existe este codigo");
		}

		VendedorEntity vendedor = dtoToEntity(vendedorDto);
		vendedorRepository.save(vendedor);

		return entityToDto(vendedor);
	}

	@Override
	public VendedorDto actualizar(VendedorDto vendedorDto, String codigoVendedor) {
		validarVendedor(vendedorDto, codigoVendedor);

		VendedorEntity vendedor = dtoToEntity(vendedorDto);
		vendedorRepository.save(vendedor);

		return entityToDto(vendedor);
	}

	private void validarVendedor(VendedorDto vendedorDto, String codigoVendedor) {

		if (!vendedorRepository.existsByCodigoVendedor(codigoVendedor)) {
			throw new IllegalArgumentException("NO existe este vendedor");
		}

		if (!vendedorDto.getCodigoVendedor().equals(codigoVendedor)) {

			if (vendedorRepository.existsByCodigoVendedor(vendedorDto.getCodigoVendedor())) {
				throw new IllegalArgumentException("ya existe alguien con ese codigo de vendedor");
			}
		}
	}

	@Override
	public List<VendedorDto> consultarVendedores() {
		List<VendedorEntity> entities = vendedorRepository.findAll();
		List<VendedorDto> dtos = new ArrayList<>();
		for (VendedorEntity vendedorEntity : entities) {
			VendedorDto vendedor = entityToDto(vendedorEntity);
			dtos.add(vendedor);
		}

		return dtos;
	}

	public VendedorDto entityToDto(VendedorEntity vendedorEntity) {
		VendedorDto vendedorDto = new VendedorDto();
		vendedorDto.setCodigoVendedor(vendedorEntity.getCodigoVendedor());
		vendedorDto.setNombres(vendedorEntity.getNombres());
		vendedorDto.setPrimerApellido(vendedorEntity.getPrimerApellido());
		vendedorDto.setSegundoApellido(vendedorEntity.getSegundoApellido());

		return vendedorDto;
	}

	public VendedorEntity dtoToEntity(VendedorDto vendedorDto) {
		VendedorEntity vendedorEntity = new VendedorEntity();
		vendedorEntity.setCodigoVendedor(vendedorDto.getCodigoVendedor());
		vendedorEntity.setNombres(vendedorDto.getNombres());
		vendedorEntity.setPrimerApellido(vendedorDto.getPrimerApellido());
		vendedorEntity.setSegundoApellido(vendedorDto.getSegundoApellido());

		return vendedorEntity;
	}

	@Override
	public void eliminar(Integer id) {
		if (!vendedorRepository.existsById(id)) {
			throw new IllegalArgumentException("NO Existe este id");

		}

		vendedorRepository.deleteById(id);
	}

	@Override
	public boolean existsByCodigoVendedor(String codigoVendedor) {
		return vendedorRepository.existsByCodigoVendedor(codigoVendedor);
	}

}
