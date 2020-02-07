package net.ausiasmarch.claseAuxiliar;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Helper {
	
	public static void main(String[] args) {
		
		List<String> listaStrings = new ArrayList<String>();
		listaStrings.add("Juan Perez");
		listaStrings.add("Manolo Perez");
		listaStrings.add("Antonio Sanchez");
		listaStrings.add("Pedro Jimenez");
		
		Map<String, Float> map = new HashMap<String, Float>();
		map.put("Pedro Lopez", 15.6f);
		map.put("Juan Garcia", 45.8f);
		map.put("Ana Perez", 200f);
		map.put("Antonio Perez", 34.99f);
		
		System.out.println("\n\nMostramos listaStrings: ");
		for ( String st: listaStrings)
			System.out.println(st);
		
		
		System.out.println("\n\nMostramos map: ");
		for (String clave: map.keySet())
			System.out.println(map.get(clave));
		
		
		
		//Guardamos la lista en fichero datosLista.dat
		serializaEnFichero("datosLista.dat", listaStrings);
		
		//Guardamos el HAshMAp en fichero datosHashmap.dat
		serializaEnFichero("datosHashmap.dat", map);
		
		List<String> nuevaLista = new ArrayList<String>();
		Map<String, Float> nuevoMap = new HashMap<String, Float>();
		
		nuevaLista = (List<String>) deserializaDesdeFichero("datosLista.dat");
		nuevoMap = (Map<String, Float>) deserializaDesdeFichero("datosHashmap.dat");
		
		System.out.println("\n\nMostramos nuevaLista: ");
		for ( String st: nuevaLista)
			System.out.println(st);
		
		
		System.out.println("\n\nMostramos nuevoMap: ");
		for (String clave: nuevoMap.keySet())
			System.out.println(nuevoMap.get(clave));
			
		
		
		
		
		// TODO Auto-generated method stub

	}


	public static void serializaEnFichero(String nombreFichero, Object objetoSerializable) {

		try
		{					
			FileOutputStream fos = new FileOutputStream(nombreFichero);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(objetoSerializable);
			
			oos.close();
			fos.close();
			System.out.println("Serializacion OK. Se ha guardado en fichero: "+nombreFichero);
		}
		catch (IOException ioe)
		{
			System.out.println("Error al serializar. Error "+ioe.getMessage());
			ioe.printStackTrace();
		}
	}
	
	public static Object deserializaDesdeFichero(String nombreFichero) {

		Object objetoSerializable = null;
		try
		{
			FileInputStream fis = new FileInputStream(nombreFichero);
			ObjectInputStream ois = new ObjectInputStream(fis);
			objetoSerializable = ois.readObject();
			
			ois.close();
			fis.close();
			System.out.println("Deserializacion OK. Se ha leido del fichero: "+nombreFichero);
		}
		catch (IOException ioe)
		{
			System.out.println("Error al serializar. Error: "+ioe.getMessage());
			ioe.printStackTrace();			
		}
		catch (ClassNotFoundException c)
		{
			System.out.println("Class not found. Error: "+c.getMessage());
			c.printStackTrace();			
		}
		
		return objetoSerializable;
	}
	

}
