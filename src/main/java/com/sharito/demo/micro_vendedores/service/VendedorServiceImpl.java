package com.sharito.demo.micro_vendedores.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharito.demo.micro_vendedores.dto.VendedorDto;
import com.sharito.demo.micro_vendedores.entity.VendedorEntity;
import com.sharito.demo.micro_vendedores.repository.VendedorRepository;

@Service
public class VendedorServiceImpl implements VendedorService {

	@Autowired
	private VendedorRepository vendedorRepository;

	@Override
	public VendedorDto crear(VendedorDto vendedorDto) {
		VendedorEntity vendedorEntity = new VendedorEntity();
		vendedorEntity.setCodigoVendedor(vendedorDto.getCodigoVendedor());
		vendedorEntity.setNombres(vendedorDto.getNombres());
		vendedorEntity.setPrimerApellido(vendedorDto.getPrimerApellido());
		vendedorEntity.setSegundoApellido(vendedorDto.getSegundoApellido());

		if (vendedorRepository.existsByCodigoVendedor(vendedorDto.getCodigoVendedor())) {
			throw new IllegalArgumentException("ya existe este codigo");
		} else {
			vendedorRepository.save(vendedorEntity);
		}

		return vendedorDto;
	}

	@Override
	public VendedorDto actualizar(VendedorDto vendedorDto, String codigoVendedor) {
		if (vendedorRepository.existsByCodigoVendedor(codigoVendedor)) {
			if (!vendedorDto.getCodigoVendedor().equals(codigoVendedor)
					&& vendedorRepository.existsByCodigoVendedor(vendedorDto.getCodigoVendedor())) {
				throw new IllegalArgumentException("ya existe esta matricula");
			}
			VendedorEntity vendedorEntity = vendedorRepository.findByCodigoVendedor(codigoVendedor);
			vendedorEntity.setCodigoVendedor(vendedorDto.getCodigoVendedor());
			vendedorEntity.setNombres(vendedorDto.getNombres());
			vendedorEntity.setPrimerApellido(vendedorDto.getPrimerApellido());
			vendedorEntity.setSegundoApellido(vendedorDto.getSegundoApellido());
			vendedorRepository.save(vendedorEntity);
		} else {
			throw new IllegalArgumentException("NO existe este vendedor");
		}

		return vendedorDto;
	}

	@Override
	public List<VendedorDto> consultarVendedores() {
		List<VendedorEntity> vendedorEntity = vendedorRepository.findAll();
		List<VendedorDto> vendedoresDto = new ArrayList<>();
		for (VendedorEntity vendedorEntity2 : vendedorEntity) {
			VendedorDto vendedorDto = new VendedorDto();
			vendedorDto.setCodigoVendedor(vendedorEntity2.getCodigoVendedor());
			vendedorDto.setNombres(vendedorEntity2.getNombres());
			vendedorDto.setPrimerApellido(vendedorEntity2.getPrimerApellido());
			vendedorDto.setSegundoApellido(vendedorEntity2.getSegundoApellido());
			vendedoresDto.add(vendedorDto);

		}

		return vendedoresDto;
	}

	@Override
	public void eliminar(Integer id) {
		if (vendedorRepository.existsById(id)) {
			vendedorRepository.deleteById(id);
		}
	}

}
