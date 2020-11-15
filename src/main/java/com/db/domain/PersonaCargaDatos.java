package com.db.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONACARGADATOS")
public class PersonaCargaDatos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String cedula; 
	@Column(name = "EDAD", nullable = false)
	private int edad;
	@Column(name = "GENERO", nullable = false)
	private String genero;
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	public PersonaCargaDatos () {
		
	}
	
	public PersonaCargaDatos (String cedula, int edad, String genero, String nombre) {
		this.setCedula(cedula);
		this.setEdad(edad);
		this.setGenero(genero);
		this.setNombre(nombre);
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "PersonaCargaDatos [cedula=" + cedula + ", edad=" + edad + ", genero=" + genero + ", nombre=" + nombre
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
		result = prime * result + edad;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonaCargaDatos other = (PersonaCargaDatos) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		if (edad != other.edad)
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
