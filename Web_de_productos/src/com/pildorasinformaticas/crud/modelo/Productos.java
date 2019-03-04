package com.pildorasinformaticas.crud.modelo;

import java.util.Date;

public class Productos {
	
	private String codigoarticulo;
	private String seccion;
	private String nombrearticulo;
	private double precio;
	private Date fecha;
	private String importado;
	private String paisorigen;
	
	public Productos(String seccion, String nombrearticulo, double precio, Date fecha, String importado,
			String paisorigen) {
		
		this.seccion = seccion;
		this.nombrearticulo = nombrearticulo;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.paisorigen = paisorigen;
	}

	public Productos(String codigoarticulo, String seccion, String nombrearticulo, double precio, Date fecha,
			String importado, String paisorigen) {
		
		this.codigoarticulo = codigoarticulo;
		this.seccion = seccion;
		this.nombrearticulo = nombrearticulo;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.paisorigen = paisorigen;
	}

	public String getCodigoarticulo() {
		return codigoarticulo;
	}

	public void setCodigoarticulo(String codigoarticulo) {
		this.codigoarticulo = codigoarticulo;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getNombrearticulo() {
		return nombrearticulo;
	}

	public void setNombrearticulo(String nombrearticulo) {
		this.nombrearticulo = nombrearticulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getImportado() {
		return importado;
	}

	public void setImportado(String importado) {
		this.importado = importado;
	}

	public String getPaisorigen() {
		return paisorigen;
	}

	public void setPaisorigen(String paisorigen) {
		this.paisorigen = paisorigen;
	}

	@Override
	public String toString() {
		return "Productos [Codigo Articulo=" + codigoarticulo + ", Seccion=" + seccion + ", Nombre Articulo="
				+ nombrearticulo + ", Precio=" + precio + ", Fecha=" + fecha + ", Importable=" + importado
				+ ", Pais Origen=" + paisorigen + "]";
	}
	
	

}


