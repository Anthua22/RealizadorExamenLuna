
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.realizadorexamen.enums.TipoPreguntas;
import com.realizadorexamen.modelos.ApartadoPreguntaDesarrollo;
import com.realizadorexamen.modelos.Asignatura;
import com.realizadorexamen.modelos.Examen;
import com.realizadorexamen.modelos.Pregunta;
import com.realizadorexamen.modelos.RespuestaTest;
import com.realizadorexamen.modelos.preguntas.PreguntaDesarrolloPractico;

import com.realizadorexamen.modelos.preguntas.PreguntaRellenar;
import com.realizadorexamen.modelos.preguntas.PreguntaTeorica;
import com.realizadorexamen.modelos.preguntas.PreguntaTest;

public class RealizadorExamen {

	private static final Scanner scan = new Scanner(System.in);
	private static final String fileExamenes = "./files/persistencia/examenes.json";
	private static final String fileAsignaturas = "./files/persistencia/asignaturas.json";

	public static void main(String[] args) {
		boolean terminado = false;
		try {
			do {
				System.out.println("*************************************************");
				System.out.println("**************REALIZADOR DE EXAMENES*************");
				System.out.println("*************************************************");
				System.out.println("Escribe el número de algunas de las siguientes opciones: ");
				System.out.println("1. Crear Pregunta\n2. Crear examen\n3. Ver exámenes guardados\n4. Salir");
				int opcion = Integer.parseInt(scan.nextLine());
				List<Asignatura> asig = getAsignaturas();

				switch (opcion) {
				case 1:
					System.out.println("Escriba el tipo de pregunta a realizar:");
					System.out.println("1. Teórico\n2. Test\n3. Desarrollo de código\n4. Rellenar");
					int opc = Integer.parseInt(scan.nextLine());
					Pregunta x = null;

					if (opc == 1) {
						x = makePregunta(TipoPreguntas.Teoria);
						checkSaveBefore(x, asig);

					} else if (opc == 2) {
						x = makePregunta(TipoPreguntas.Test);
						checkSaveBefore(x, asig);

					} else if (opc == 3) {
						x = makePregunta(TipoPreguntas.Desarrollo);
						checkSaveBefore(x, asig);
					} else if (opc == 4) {
						x = makePregunta(TipoPreguntas.Rellenar);
						checkSaveBefore(x, asig);
					} else {
						System.out.println("Opción no válida...");
					}

					break;
				case 2:
					break;
				case 3:
					List<Examen> examenesGuardados = getExamenes();
					break;
				default:
					System.out.println("Hasta Luego");
					terminado = true;
					break;
				}

			} while (!terminado);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public static void checkSaveBefore(Pregunta x, List<Asignatura> asig) {
		if (x != null) {
			asig.forEach(asi -> System.out.println(asi));
			System.out.println("\nEscriba el código de la asignatura que se quiera asignar la pregunta");
			String cod = scan.nextLine();
			Asignatura existe = null;
			String dd = x.getClass().getName();
			for (int i = 0; i < asig.size(); i++) {

				if (asig.get(i).getCodigo().equals(cod)) {
					if (x instanceof PreguntaTeorica) {
						PreguntaTeorica df = new PreguntaTeorica(x.getTextoPregunta(), x.getTextoAclaratorio(),
								x.getNota(), ((PreguntaTeorica) x).getRespuestaCorrecta());
						asig.get(i).getPreguntasTeoricas().add(df);
						existe = asig.get(i);
					} else if (x instanceof PreguntaDesarrolloPractico) {
						PreguntaDesarrolloPractico df = new PreguntaDesarrolloPractico(x.getTextoPregunta(),
								x.getTextoAclaratorio(), x.getNota(), ((PreguntaDesarrolloPractico) x).getApartados());
						asig.get(i).getPreguntasDesarrollo().add(df);
						existe = asig.get(i);
					} else if (x instanceof PreguntaRellenar) {
						PreguntaRellenar df = new PreguntaRellenar(x.getTextoPregunta(), x.getTextoAclaratorio(),
								x.getNota(), ((PreguntaRellenar) x).getFraseACompletar(),
								((PreguntaRellenar) x).getFrase());
						asig.get(i).getPreguntasRellenar().add(df);
						existe = asig.get(i);
					} else {
						PreguntaTest df = new PreguntaTest(x.getTextoPregunta(), x.getTextoAclaratorio(), x.getNota(),
								((PreguntaTest) x).isResta(), ((PreguntaTest) x).getOpciones(),
								((PreguntaTest) x).getNumeroRespuestas());
						asig.get(i).getPreguntasTest().add(df);
						existe = asig.get(i);
					}

				}
			}

			if (existe == null) {
				System.out.println("No existe el código introducido");
			} else {
				guardarDatos(asig, fileAsignaturas);
			}
		}

	}

	public static void guardarDatos(Object ob, String fileName) {
		try {
			Gson gson = new Gson();
			File file = new File(fileName);
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			Writer writer = new BufferedWriter(osw);
			// Write data using a String variable
			String jugadoresJson = gson.toJson(ob);

			writer.write(jugadoresJson);

			writer.close();
			osw.close();
			fos.close();

		} catch (Exception e) {
			System.err.println("Ha ocurrido un error guardando los datos...");
		} finally {
			System.out.println("Datos guardados correctamente.");
		}

	}

	private static Pregunta makePregunta(TipoPreguntas tipo) {
		Pregunta x = null;
		char[] apartadosLetras = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
		System.out.println("Escriba la pregunta:...");
		String pregunta = scan.nextLine();
		System.out.println("Escriba una aclaración a la pregunta anterior..");
		String aclaracion = scan.nextLine();
		System.out.println("Escriba los puntos que vale esta pregunta ...");
		int nota = Integer.parseInt(scan.nextLine());

		if (TipoPreguntas.Test.equals(tipo)) {
			String fin = "";
			ArrayList<RespuestaTest> opcionesRes = new ArrayList();

			int cont = 0;
			System.out.println("Escriba cuantas respuestas hay: ");
			int nrespr = Integer.parseInt(scan.nextLine());
			while (!fin.toLowerCase().equals("n")) {
				System.out.println("Escriba una opción: ");

				String opcion = apartadosLetras[cont] + ") " + scan.nextLine();
				System.out.println("Escriba si esta solucion es correcta: (y/n)");
				boolean correcta = scan.nextLine().toLowerCase().equals("y");
				RespuestaTest te = new RespuestaTest(opcion, correcta);
				opcionesRes.add(te);

				System.out.println("Deseas crear más opciones? (y/n)");
				fin = scan.nextLine();
				cont++;
			}

			x = new PreguntaTest(pregunta, aclaracion, nota, false, opcionesRes, nrespr);

		} else if (TipoPreguntas.Teoria.equals(tipo)) {
			System.out.println("Escriba la respuesta a la pregunta teórica...");
			String reps = scan.nextLine();

			x = new PreguntaTeorica(pregunta, aclaracion, nota, reps);

		} else if (TipoPreguntas.Rellenar.equals(tipo)) {
			System.out.println(
					"Escriba la frase a rellenar. Coloque tantos ? como caracteres tenga la palabra a rellenar");
			String fraseRellenar = scan.nextLine();
			String fin = "";
			ArrayList<String> frases = new ArrayList();
			while (!fin.toLowerCase().equals("n")) {
				System.out.println("Escriba en orden las respuestas de las frases a rellenar:");
				String frase = scan.nextLine();
				frases.add(frase);
				System.out.println("Hay más frases a rellenar? (y/n)");
				fin = scan.nextLine();
			}
			x = new PreguntaRellenar(pregunta, aclaracion, nota, fraseRellenar, frases);

		} else {

			int contador = 0;
			String fin = "";
			ArrayList<ApartadoPreguntaDesarrollo> apartados = new ArrayList();
			while (!fin.toLowerCase().equals("n")) {
				System.out.println("Escriba un apartado de la pregunta de tipo de desarrollo:");
				String apartado = apartadosLetras[contador] + ") " + scan.nextLine();
				System.out.println("Escriba el porcentaje de nota de este apartado:");
				int porcentaje = Integer.parseInt(scan.nextLine());
				ApartadoPreguntaDesarrollo ap = new ApartadoPreguntaDesarrollo(apartado, porcentaje);
				apartados.add(ap);
				System.out.println("Deseas escribir más partados? (y/n)");
				fin = scan.nextLine();
				contador++;
			}

			x = new PreguntaDesarrolloPractico(pregunta, aclaracion, nota, apartados);

		}

		System.out.println("*****************************************");
		System.out.println("La pregunta quedaría asi:");
		System.out.println(x.imprimirSimple());
		System.out.println("*****************************************");
		return x;
	}

	private static List<Asignatura> getAsignaturas() {
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

			Asignatura[] asig = gson.fromJson(contenido, Asignatura[].class);

			result = Arrays.asList(asig);

		} catch (Exception e) {
			System.err.println("Ha ocurrido un error obteniendo los datos...");
		}
		return result;
	}

	private static List<Examen> getExamenes() {
		List<Examen> result = new ArrayList<Examen>();
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

			Examen[] jug = gson.fromJson(contenido, Examen[].class);

			result = Arrays.asList(jug);

		} catch (Exception e) {
			System.err.println("No existen examenes guardados...");
		}
		return result;
	}
}
