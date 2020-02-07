package net.ausiasmarch.claseAuxiliar;

import java.util.ArrayList;
import java.io.*;

public class Professor extends Persona implements Serializable{


	private int anyosTrabajados;
	private String departamento;
	ArrayList<String> cursosImparte;
	
public Professor(String dni, String apellidos, String nombres, String sexo, int edad, double peso, int anyoTrabajados, String departamentos, ArrayList<String> cursosImparte) {
	super( dni, apellidos,  nombres, sexo,  edad,  peso);
	this.anyosTrabajados=anyoTrabajados;
	this.cursosImparte=cursosImparte;
	this.departamento=departamentos;
}

public int getAnyosTrabajados() {
	return anyosTrabajados;
}

public void setAnyosTrabajados(int anyosTrabajados) {
	this.anyosTrabajados = anyosTrabajados;
}

public String getDepartamento() {
	return departamento;
}

public void setDepartamento(String departamento) {
	this.departamento = departamento;
}
/*
 * Recorremos el arraylist para obtener todas las asignaturas del profesor
 */
public String getCursosImparte() {
	StringBuilder nb = new StringBuilder();
	for ( String st: cursosImparte)
		nb.append(st);
	return nb.toString();
}

public void setCursosImparte(ArrayList<String> cursosImparte) {
	cursosImparte.addAll(cursosImparte);
}
@Override
/*
 * (non-Javadoc)
 * @see net.ausiasmarch.claseAuxiliar.Persona#toString()
 */
public String toString() {
	return "Persona{" + "dni=" + dni + ", apellidos=" + apellidos + ", nombres="
			+ nombres + ", sexo=" + sexo + ", edad=" + edad + ", peso=" + peso +
			", años trabajados ="+ anyosTrabajados + ", departamento en el que trabaja = " + departamento 
			+ " cursos que imparte "+ getCursosImparte() + " }";
}	


}
