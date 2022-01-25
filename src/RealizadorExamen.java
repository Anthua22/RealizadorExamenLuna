
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.realizadorexamen.enums.Convocatoria;
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
						System.out.println("Opci�n no v�lida...");
					}

					break;
				case 2:
					Examen examen = makeEamen(asig);
					if (examen != null) {
						examen.setPreguntasDesarrollo(examen.getPreguntasDesarrollo() == null ? new ArrayList<>()
								: examen.getPreguntasDesarrollo());
						examen.setPreguntasTeoricas(examen.getPreguntasTeoricas() == null ? new ArrayList<>()
								: examen.getPreguntasTeoricas());
						examen.setPreguntasTest(
								examen.getPreguntasTest() == null ? new ArrayList<>() : examen.getPreguntasTest());
						examen.setPreguntasDesarrollo(examen.getPreguntasDesarrollo() == null ? new ArrayList<>()
								: examen.getPreguntasDesarrollo());
						List<Examen> examenesGuardados = getExamenes();
						if (examenesGuardados == null) {
							examenesGuardados = new ArrayList<Examen>();
						}
						examenesGuardados.add(examen);
						guardarDatos(examenesGuardados, fileExamenes);
					} else {
						System.out.println("No existe la asignatura");
					}

					break;
				case 3:
					List<Examen> examenesGuardadosLectura = getExamenes();
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
			asig.forEach(asi -> System.out.println("c�digo: " + asi.getCodigo() + " nombre: " + asi.getTitulo()));
			System.out.println("\nEscriba el c�digo de la asignatura que se quiera asignar la pregunta");
			String cod = scan.nextLine();
			Asignatura existe = null;

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
				System.out.println("No existe el c�digo introducido");
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
				System.out.println("Escriba una opci�n: ");

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
				System.out.println("Escriba los puntos que vale este apartado:");
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
		System.out.println("La pregunta quedaría así:");
		System.out.println(x.imprimirSimple());
		System.out.println("*****************************************");
		return x;
	}

	private static List<Asignatura> getAsignaturas() throws IOException {
		List<Asignatura> result = new ArrayList<Asignatura>();
		;
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
			guardarDatos(result, fileAsignaturas);

		}
		return result;
	}

	private static Examen makeEamen(List<Asignatura> asig) {
		System.out.println("*************************************************");
		asig.forEach(asi -> System.out.println("código: " + asi.getCodigo() + " nombre: " + asi.getTitulo()));
		System.out.println("*************************************************");
		System.out.println("\nEscriba el código de la asignatura que se quiere crear el examen");

		String cod = scan.nextLine();

		String autor = null;
		Convocatoria convo = null;

		Asignatura a = null;
		for (Asignatura y : asig) {
			if (y.getCodigo().equals(cod)) {
				a = y;
			}
		}

		if (a != null) {
			System.out.println("Escriba el nombre del autor: ");
			autor = scan.nextLine();
			System.out.println("Escriba la convocatoria:\n1. Junio\n2. Septiembre\n3. Diciembre");
			int opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case 1:
				convo = Convocatoria.Junio;
				break;
			case 2:
				convo = Convocatoria.Septiembre;
				break;
			case 3:
				convo = Convocatoria.Diciembre;
				break;
			default:
				System.out.println("Opci�n introducida incorrecta..");
				break;
			}

			System.out.println("Escriba el curso: ");
			String curso = scan.nextLine();
			System.out.println(
					"Escriba el tipo de pregunta a realizar:\n1. Test \n2. Teorico\n3. Práctico\n4. Rellenar\n5. Mixto");
			int tipoPregunta = Integer.parseInt(scan.nextLine());
			Examen exa = new Examen(new Date(), autor, a, convo, curso);
			TipoPreguntas tipo = null;
			if (tipoPregunta == 1) {
				tipo = TipoPreguntas.Test;
				List<Pregunta> preguntas = getPregutasExamen(tipo);
				ArrayList<PreguntaTest> tests = getPreguntaToPreguntaTest(preguntas);
				exa.setPreguntasTest(tests);
			} else if (tipoPregunta == 2) {
				tipo = TipoPreguntas.Teoria;
				List<Pregunta> preguntas = getPregutasExamen(tipo);
				ArrayList<PreguntaTeorica> teoricas = getPreguntaToPreguntaTeorica(preguntas);
				exa.setPreguntasTeoricas(teoricas);

			} else if (tipoPregunta == 3) {
				tipo = TipoPreguntas.Desarrollo;
				List<Pregunta> preguntas = getPregutasExamen(tipo);
				ArrayList<PreguntaDesarrolloPractico> desarrollos = getPreguntaToPreguntaDesarrolloPractico(preguntas);
				exa.setPreguntasDesarrollo(desarrollos);
			} else if (tipoPregunta == 4) {
				tipo = TipoPreguntas.Rellenar;
				List<Pregunta> preguntas = getPregutasExamen(tipo);
				ArrayList<PreguntaRellenar> rellenar = getPreguntaToPreguntaRellenar(preguntas);
				exa.setPreguntasRellenar(rellenar);

			} else if (tipoPregunta == 5) {
				ArrayList<PreguntaRellenar> rellenar = new ArrayList<PreguntaRellenar>();
				ArrayList<PreguntaDesarrolloPractico> desarrollos = new ArrayList<PreguntaDesarrolloPractico>();
				ArrayList<PreguntaTeorica> teoricas = new ArrayList<PreguntaTeorica>();
				ArrayList<PreguntaTest> tests = new ArrayList<PreguntaTest>();

				for (int i = 0; i < TipoPreguntas.values().length; i++) {
					List<Pregunta> preguntas = getPregutasExamen(TipoPreguntas.values()[i]);
					ArrayList<PreguntaRellenar> auxrellenar = getPreguntaToPreguntaRellenar(preguntas);
					ArrayList<PreguntaDesarrolloPractico> desarrollosAux = getPreguntaToPreguntaDesarrolloPractico(
							preguntas);
					ArrayList<PreguntaTeorica> teoricasAux = getPreguntaToPreguntaTeorica(preguntas);
					ArrayList<PreguntaTest> testsAux = getPreguntaToPreguntaTest(preguntas);
					if (auxrellenar.size() > 0) {
						rellenar = auxrellenar;
					} else if (desarrollosAux.size() > 0) {
						desarrollos = desarrollosAux;
					} else if (teoricasAux.size() > 0) {
						teoricas = teoricasAux;
					} else if (testsAux.size() > 0) {
						tests = testsAux;
					}
				}

				exa.setPreguntasDesarrollo(desarrollos);
				exa.setPreguntasTeoricas(teoricas);
				exa.setPreguntasTest(tests);
				exa.setPreguntasRellenar(rellenar);

			} else {
				System.err.println("Opci�n introducida no v�lida!");
			}

			return exa;

		}

		return null;

	}

	private static ArrayList<PreguntaDesarrolloPractico> getPreguntaToPreguntaDesarrolloPractico(
			List<Pregunta> preguntas) {
		ArrayList<PreguntaDesarrolloPractico> result = new ArrayList<PreguntaDesarrolloPractico>();
		preguntas.forEach(x -> {
			if (x instanceof PreguntaDesarrolloPractico) {
				result.add(new PreguntaDesarrolloPractico(x.getTextoPregunta(), x.getTextoAclaratorio(), x.getNota(),
						((PreguntaDesarrolloPractico) x).getApartados()));
			}
		});

		return result;
	}

	private static ArrayList<PreguntaRellenar> getPreguntaToPreguntaRellenar(List<Pregunta> preguntas) {
		ArrayList<PreguntaRellenar> result = new ArrayList<PreguntaRellenar>();
		preguntas.forEach(x -> {
			if (x instanceof PreguntaRellenar) {
				result.add(new PreguntaRellenar(x.getTextoPregunta(), x.getTextoAclaratorio(), x.getNota(),
						((PreguntaRellenar) x).getFraseACompletar(), ((PreguntaRellenar) x).getFrase()));
			}
		});

		return result;
	}

	private static ArrayList<PreguntaTeorica> getPreguntaToPreguntaTeorica(List<Pregunta> preguntas) {
		ArrayList<PreguntaTeorica> result = new ArrayList<PreguntaTeorica>();
		preguntas.forEach(x -> {
			if (x instanceof PreguntaTeorica) {
				result.add(new PreguntaTeorica(x.getTextoPregunta(), x.getTextoAclaratorio(), x.getNota(),
						((PreguntaTeorica) x).getRespuestaCorrecta()));
			}
		});

		return result;
	}

	private static ArrayList<PreguntaTest> getPreguntaToPreguntaTest(List<Pregunta> preguntas) {
		ArrayList<PreguntaTest> result = new ArrayList<PreguntaTest>();
		preguntas.forEach(x -> {
			if (x instanceof PreguntaTest) {
				result.add(new PreguntaTest(x.getTextoPregunta(), x.getTextoAclaratorio(), x.getNota(),
						((PreguntaTest) x).isResta(), ((PreguntaTest) x).getOpciones(),
						((PreguntaTest) x).getNumeroRespuestas()));
			}
		});

		return result;
	}

	private static List<Pregunta> getPregutasExamen(TipoPreguntas tipo) {
		List<Pregunta> preguntas = new ArrayList<Pregunta>();
		boolean termina = false;

		while (!termina) {
			Pregunta x = makePregunta(tipo);
			preguntas.add(x);
			System.out.println("Deseas añadir otra tipo de pregunta como esta?(y/n)");
			termina = scan.nextLine().toLowerCase().equals("n");

		}
		return preguntas;
	}

	private static ArrayList<Examen> getExamenes() {
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
