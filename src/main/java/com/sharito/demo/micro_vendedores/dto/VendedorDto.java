package com.sharito.demo.micro_vendedores.dto;

public class VendedorDto {

	private String codigoVendedor;
	private String nombres;
	private String primerApellido;
	private String segundoApellido;

	public VendedorDto() {
		super();
	}

	public VendedorDto(String codigoVendedor, String nombres, String primerApellido, String segundoApellido) {
		super();
		this.codigoVendedor = codigoVendedor;
		this.nombres = nombres;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
	}

	public String getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(String codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

}
