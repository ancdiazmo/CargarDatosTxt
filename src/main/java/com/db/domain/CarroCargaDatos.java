package com.db.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARROCARGADATOS")
public class CarroCargaDatos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id; 
	@Column(name = "MARCA", nullable = false)
	private String marca;
	
	public CarroCargaDatos () {}
	
	public CarroCargaDatos(String id, String marca) {
		super();
		this.id = id;
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "CarroCargaDatos [id=" + id + ", marca=" + marca + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
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
		CarroCargaDatos other = (CarroCargaDatos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		return true;
	}

}
