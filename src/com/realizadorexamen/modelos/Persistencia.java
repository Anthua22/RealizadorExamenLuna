package com.realizadorexamen.modelos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class Persistencia {

	public static void guardar(Object x, String ruta) {
		try {
			Gson gson = new Gson();
			File file = new File(ruta);
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			Writer writer = new BufferedWriter(osw);
			// Write data using a String variable
			String objJson = gson.toJson(x);

			writer.write(objJson);

			writer.close();
			osw.close();
			fos.close();

		} catch (Exception e) {
			System.err.println("Ha ocurrido un error guardando los datos...");
		} finally {
			System.out.println("Datos guardados correctamente.");
		}
	}

	public static List<Asignatura> getAsignaturas(String fileAsignaturas) {
		List<Asignatura> result = new ArrayList<Asignatura>();

		try {

			File file = new File(fileAsignaturas);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			Gson gson = new Gson();
			String linea;
			String contenido = "";
			while ((linea = br.readLine()) != null) {
				contenido += linea;
			}
			br.close();
			fr.close();
			Asignatura[] asig = gson.fromJson(contenido, Asignatura[].class);

			result = Arrays.asList(asig);

		} catch (Exception e) {
			Asignatura asig1 = new Asignatura("POO", "Programación Orientada a Objetos");
			Asignatura asig2 = new Asignatura("DAM", "Desarrollo de aplicaciones para dispositivos móviles");
			result.add(asig1);
			result.add(asig2);
			guardar(result, fileAsignaturas);

		}
		return result;
	}

	public static ArrayList<Examen> getExamenes(String fileExamenes) {
		ArrayList<Examen> result = new ArrayList<Examen>();
		try {
			File file = new File(fileExamenes);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			Gson gson = new Gson();
			String linea;
			String contenido = "";
			while ((linea = br.readLine()) != null) {
				contenido += linea;
			}

			Examen[] exas = gson.fromJson(contenido, Examen[].class);
			for (Examen x : exas) {
				result.add(x);
			}
			fr.close();
			br.close();

		} catch (FileNotFoundException e) {

		} catch (Exception ex) {
			System.err.println("Ha ocurrido un error guardando los datos...: " + ex.getMessage());
		}
		return result;
	}
}
