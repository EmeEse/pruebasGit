package net.ausiasmarch.claseAuxiliar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.*;

public class Alumno extends Persona implements Serializable {
	

	String asignatura;
	Float nota;
	String nombreCentro;
	private Map<String, Float> notas = new HashMap<>();
	
	/*
	 * @parametros de alumno, dni, apellidos, nombre, sexo, edad, peso, nombrecentro, notas
	 * 
	 */
	public Alumno(String dni, String apellidos, String nombres, String sexo, int edad, double peso, String nombreCentro,Map<String, Float> notas){
		super( dni, apellidos,  nombres, sexo,  edad,  peso);
		this.nombreCentro=nombreCentro;
		this.notas=notas;
	}


	public String getNombreCentro() {
		return nombreCentro;
	}


	public void setNombreCentro(String nombreCentro) {
		this.nombreCentro = nombreCentro;
	}

	/*
	 * Recorremos el map para obtener las notas del alumno
	 */
	public String getNotas() {
		
		StringBuilder nb = new StringBuilder();
		Iterator<String>
		it=notas.keySet().iterator();
		while( it.hasNext()) {
		String clave=it.next();
		Float valor=notas.get(clave);
		nb.append(clave+" " + valor);
		}
		
		return nb.toString();
	}


	public void setNotas(Map<String, Float> notas) {
		this.notas=notas;
	}
	/*
	 * devuelve un stringbuilder con las nota media de todas las asignaturas. 
	 * Recorrimos el map, y guardamos el valor dentro de una variable, luego la dividimos por 
	 * el largo del map
	 */
	public Float notaMedia() {

		float conta = 0;
		
		
		Iterator<String>
		it=notas.keySet().iterator();
		while( it.hasNext()) {
		String clave=it.next();
		Float valor=notas.get(clave);
		conta+=valor;
		}
		
		return conta/notas.size();
	}
	/*
	 * (non-Javadoc)
	 * @see net.ausiasmarch.claseAuxiliar.Persona#toString()
	 */
	public String toString() {
		return "Persona{" + "dni=" + dni + ", apellidos=" + apellidos + ", nombres="
				+ nombres + ", sexo=" + sexo + ", edad=" + edad + ", peso=" + peso +
				", NombreCentro ="+ nombreCentro + ", asgnaturas y notas = " + getNotas() + ", su nota media "+ notaMedia() +"}";
	}


}
