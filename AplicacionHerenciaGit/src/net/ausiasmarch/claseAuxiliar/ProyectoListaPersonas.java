package net.ausiasmarch.claseAuxiliar;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProyectoListaPersonas {
	
	private ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
	private List<Persona> nuevaLista = new ArrayList<Persona>();

	public static void main(String[] args) {
		
		int opcion;
		
		ProyectoListaPersonas proyectoPersonas = new ProyectoListaPersonas();
		Scanner entrada = new Scanner(System.in);
		
		do {
			System.out.println("\nLISTA DE PERSONAS:");
			System.out.println("[1] Registrar persona");
			System.out.println("[2] Buscar persona por DNI");
			System.out.println("[3] Eliminar persona");
			System.out.println("[4] Mostrar persona");
			System.out.println("[5] Lee personas de fichero");
			System.out.println("[6] Guarda personas en fichero");
			System.out.println("[7] Salir\n");
			System.out.print("Ingrese opción (1-7): ");
			opcion = entrada.nextInt();
			switch (opcion) {
			case 1:
				proyectoPersonas.registrarPersona();
				break;
			case 2:
				proyectoPersonas.buscarPersona();
				break;
			case 3:
				proyectoPersonas.eliminarPersona();
				break;
				
			case 4:
				proyectoPersonas.mostrarPersonas();
				break;
			case 5:
				proyectoPersonas.leerFichero();
				break;
			case 6:
				proyectoPersonas.Serializar();
				break;
				
			}
		} while (opcion != 7);
	}

	public void registrarPersona() {
		String dni, apellidos, nombres, sexo;
		int edad, numeroPersonas;
		double peso;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("¿Cuantas personas va a introducir?");
		numeroPersonas = entrada.nextInt();
		for (int i=0; i<numeroPersonas; i++) {
			
			System.out.println("\nDatos Persona "+(i+1)+":");
			System.out.print("\tDNI: ");
			dni = entrada.next();
			System.out.print("\tApellidos: ");
			apellidos = entrada.next();
			System.out.print("\tNombres: ");
			nombres = entrada.next();
			System.out.print("\tSexo: ");
			sexo = entrada.next();
			System.out.print("\tEdad: ");
			edad = entrada.nextInt();
			System.out.print("\tPeso: ");
			peso = entrada.nextDouble();
			/*****************************
			 * Preguntamos si es estudiante, profesor o persona. En caso de ser estudiante
			 * agregamos NombreCentro y Map de asignaturas y notas. Si es profesor, años trabajados, 
			 * y arraylist con asignaturas que imparte.
			 * Finalmente lo agregamos al ArrayList de listaPersonas
			 ******************************/
			
			System.out.print("\tEs estudiante[0], Profesor[1], ninguno [2]: ");
			int opcionA = entrada.nextInt();
			switch (opcionA) {
			case 0:
				System.out.print("\tNombre del Centro: ");
				String nombreCentro = entrada.next();
				System.out.print("\tCuantas asignaturas ingresa: ");
				int asig = entrada.nextInt();
				Map<String, Float> notas = new HashMap<>();
				for(int j = 0; j<asig; j++) {
					System.out.print("\tAsignatura: ");
					String asignatura = entrada.next();
					System.out.print("\tnota: ");
					Float nota = entrada.nextFloat();
					notas.put(asignatura, nota);
				}
				
				listaPersonas.add(new Alumno(dni, apellidos, nombres, sexo, edad, peso, nombreCentro, notas));
				break;
			case 1:
				
				
				System.out.print("\tAños trabajados: ");
				int anyoTrabajados = entrada.nextInt();
				System.out.print("\tDepartamento en el que trabaja: ");
				String departamentos = entrada.next();
				System.out.print("\tCuantas asignaturas imparte: ");
				int asig1 = entrada.nextInt();
				ArrayList<String> cursosImparte = new ArrayList<String>();
				for(int k = 0; k<asig1; k++) {
					System.out.print("\tNombre asignatura que imparte: ");
					String asignatura = entrada.next();
					cursosImparte.add(asignatura);
				}
	
		
				listaPersonas.add(new Professor(dni, apellidos, nombres, sexo, edad, peso, anyoTrabajados, departamentos, cursosImparte));
				break;
			case 2:
				Persona persona = new Persona(dni, apellidos, nombres, sexo, edad, peso);
				listaPersonas.add(persona);
				break;
			}
			
			/************************************************/
			/* añadir persona al ArrayList listaPersonas */
			/************************************************/
			
		}
	}

	public void buscarPersona() {
		String dni;
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese DNI a buscar: ");
		dni = entrada.next();
		StringBuilder nb = new StringBuilder();
		for(int i = 0; i < listaPersonas.size(); i++) {
			if (listaPersonas.get(i).getDni().equalsIgnoreCase(dni)){
				nb.append((listaPersonas.get(i).toString())); 
				
			}
			}
			if(nb.length()!=0){
				System.out.println(nb.toString());
			}else{
				System.out.println("La persona no se encuentra");
			}
		
		/************************************************/
		/* Buscar persona en ArrayList listaPersonas
		 * Si existe devuelve los datos de la persona
		 * Si no existe devuelve por consola el texto "La persona no se encuentra" */
		/************************************************/
	}

	public void eliminarPersona() {
		String dni;
		Scanner entrada = new Scanner(System.in);
		StringBuilder nb = new StringBuilder();
		System.out.print("Ingrese DNI para eliminar: ");
		dni = entrada.next();
		for(int i = 0; i < listaPersonas.size(); i++) {
			if (listaPersonas.get(i).getDni().equalsIgnoreCase(dni)){
				nb.append("La siguiente persona ser� eliminada : " + listaPersonas.get(i).toString());
				listaPersonas.remove(listaPersonas.get(i)); 	
			}
			
			}
		if(nb.length()!=0){
			System.out.println(nb.toString());
		}else{
			System.out.println("La persona no se encuentra");
		}
		
		/************************************************/
		/* Elimina a persona con DNI introducido del ArrayList listaPersonas
		 * Si existe devuelve por consola el texto "Persona eliminada" junto con los datos de la persona eliminada
		 * Si no existe devuelve el texto "La persona no se encuentra" */
		/************************************************/
	}

	public void mostrarPersonas() {
		for(int i = 0; i < listaPersonas.size(); i++) {
			System.out.println(listaPersonas.get(i).toString());
		}
		/************************************************/
		/* Recorre las personas en el ArrayList listaPersonas y muestra por consola sus datos	 
		 * Si no existe devuelve por consola el texto "No existen personas registradas" */
		/************************************************/
	}
	/*
	 * Serializamos los datos dentro de listaPersona y los ponemos en el archivo datosLista
	 */
	public void Serializar() {
		Helper.serializaEnFichero("datosLista.dat", listaPersonas);
		
	}
	
	/*
	 * des-serializamos el archivo datosLista, los ponemos en listaPersona y lo recorremos y
	 *  lo imprimimos en pantalla
	 */
	public void leerFichero() {
		listaPersonas = (ArrayList<Persona>) Helper.deserializaDesdeFichero("datosLista.dat");
		System.out.println("\n\nMostramos nuevaLista: ");
		for ( Persona st: listaPersonas)
			System.out.println(st);
	}
	
	
	
	public ProyectoListaPersonas() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
