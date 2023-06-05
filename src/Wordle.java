import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Wordle {

	public static void main(String[] args) {
		// CREAMOS UN STRING DE PALABRAS
		String[] palabras = new String[] { "ARBOL", "NOVEDAD", "ACCESO", "HELADO", "DEBAJO", "CEREALES", "ORILLA",
				"PLAYA", "POZO", "ZURDO", "REFUGIO", "HUMO", "JIRAFA", "OVEJA", "SALIDA", "CAJA", "VENTANA", "MUERTA",
				"JEFE", "APROBADO" };
		// ELIGE UNA PALABRA AL AZAR CON UN RANDOM NUMBER
		int RandomNumber = numeroAzar(0, 19);
		String palabra = palabras[RandomNumber];
		// System.out.println(" La palabra secreta es : " + palabra);
		int longitudpalabra = palabra.length();
		String mostrar = "";
		String palabrausuario;
		boolean letraenpalabra = false;
		String fVerde = "\033[42m";
		String negro = "\033[30m";
		String fAmarillo = "\033[43m";
		String fBlanco = "\033[47m";
		Scanner scanner = new Scanner(System.in);
		int letracorrecta = 0;
		int cont = 0;
		// DA LA BIENVENIDA Y DICE EL NUMERO DE LETRAS EN FUNCION DE LA PALABRA QUE
		// TOQUE
		System.out.println("Bienvenido al WORDLE. Adivina la palabra con " + longitudpalabra + " letras.");
		// IMPRIME EL NUMERO DE LINEAS CORRESPONDIENTE AL NUMERO DE LETRAS QUE TIENE LA
		// PALABRA
		for (int i = 0; i < palabra.length(); i++) {
			mostrar = mostrar + "_ ";
		}
		System.out.println(mostrar);
		do {
			letracorrecta = 0;
			// Pide una palabra al usuario
			System.out.println("  Inserte una palabra: ");
			palabrausuario = scanner.nextLine();
			// SI LA PALABRA TIENE UNA LONGITUD DISTINTA A LA PEDIDA, SE PIDE OTRA PALABRA
			if (longitudpalabra != palabrausuario.length()) {
				System.out.println("Longitud incorrecta. Tiene que tener " + longitudpalabra + " letras");
			} else {
				cont += 1;
				for (int i = 0; i < palabra.length(); i++) {
					// COMPRUEBA SI LA LETRA ESTA EN SU SITIO
					if (palabra.charAt(i) == palabrausuario.charAt(i)) {
						System.out.print(fVerde + negro + palabrausuario.charAt(i) + fBlanco);
						// CADA LETRA EN POSICION CORRECTA SUMA 1 PARA PODER SALIR DEL BUCLE CUANDO
						// TODAS LAS LETRAS SEAN CORRECTAS
						letracorrecta = letracorrecta + 1;
					} else {
						// COMPRUEBA SI ALGUNA LETRA ESTA EN OTRA POSICION O SI NO EXISTE
						for (int j = 0; j < palabrausuario.length(); j++) {
							if (palabrausuario.charAt(i) == palabra.charAt(j)) {
								letraenpalabra = true;
							}
						}
						// SI ESTA EN OTRA POSICION SE IMPRIMIRA EN AMARILLO
						if (letraenpalabra) {
							System.out.print(fAmarillo + negro + palabrausuario.charAt(i) + fBlanco);
							letraenpalabra = false;
							// SI NO EXISTE ESA LETRA SE IMPRIMIRA EN BLANCO
						} else {
							System.out.print(negro + palabrausuario.charAt(i));
						}
					}
				}
			}
			// PARA SALIR DEL BUCLE SI SE ACIERTA LA PALABRA O SUPERA LOS 6 FALLOS
		} while (letracorrecta != longitudpalabra && cont < 6);
		if (cont >= 6) {
			System.out.println("  Lo sentimos has agotado las oportunidades");
		} else {
			System.out.println(fVerde + "    Enhorabuena! Lo has conseguido");
		}
	}

	// CREADO PARA TENER UN NUMERO AL AZAR PARA ELEGIR LA PALABRA
	private static int numeroAzar(int inferior, int superior) {
		Random r = new Random();
		int inicio = inferior;
		int fin = superior + 1;
		return r.nextInt(fin - inicio) + inicio;
	}
}
