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
		vendedorRepository.save(vendedorEntity);

		return vendedorDto;
	}

	@Override
	public VendedorDto actualizar(VendedorDto vendedorDto, Integer id) {
		VendedorEntity vendedorEntity = vendedorRepository.findById(id).orElse(null);
		if (vendedorEntity != null) {
			vendedorEntity.setCodigoVendedor(vendedorDto.getCodigoVendedor());
			vendedorEntity.setNombres(vendedorDto.getNombres());
			vendedorEntity.setPrimerApellido(vendedorDto.getPrimerApellido());
			vendedorEntity.setSegundoApellido(vendedorDto.getSegundoApellido());
			vendedorRepository.save(vendedorEntity);
		}

		return vendedorDto;
	}

	@Override
	public List<VendedorDto> consultarVendedores() {
		List<VendedorEntity> vendedoresEntity = vendedorRepository.findAll();
		List<VendedorDto> vendedoresDto = new ArrayList<>();
		for (VendedorEntity vendedorEntity : vendedoresEntity) {
			VendedorDto vendedorDto = new VendedorDto();
			vendedorDto.setCodigoVendedor(vendedorEntity.getCodigoVendedor());
			vendedorDto.setNombres(vendedorEntity.getNombres());
			vendedorDto.setPrimerApellido(vendedorEntity.getPrimerApellido());
			vendedorDto.setSegundoApellido(vendedorEntity.getSegundoApellido());
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
