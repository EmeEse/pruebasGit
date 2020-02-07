package net.ausiasmarch.claseAuxiliar;

import java.io.Serializable;
import java.util.*;

public class Persona implements Serializable {

	protected String dni;
	protected String apellidos;
	protected String nombres;
	protected String sexo;
	protected int edad;
	protected double peso;

	public Persona(String dni, String apellidos, String nombres,
			String sexo, int edad, double peso) {
		this.dni = dni;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.sexo = sexo;
		this.edad = edad;
		this.peso = peso;
	}

	public Persona(String dni) {
		this.dni = dni;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Persona{" + "dni=" + dni + ", apellidos=" + apellidos + ", nombres="
				+ nombres + ", sexo=" + sexo + ", edad=" + edad + ", peso=" + peso + "}";
	}

	/**********************************************************************/
	//************Falta metodo equals y hashcode**************************/
	/**********************************************************************/



}

