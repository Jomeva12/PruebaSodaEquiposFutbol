/*
 Desarrolle un programa que permite ingresar la siguiente información
de un equipo de futbol:
-Nombre del equipo
-Estadio del equipo
-Cantidad de títulos
-Lista de jugadores titulares (Cada uno con nombre y posición)
-Lista de jugadores suplentes (Cada uno con nombre y posición)
Después de ingresar la información, el programa debe dar la
opción para generar algunos de estos reportes:
1. Reporte básico (Nombre del equipo, títulos ganados y cantidad total de
jugadores)
2. Reporte detallado (Nombre del equipo, listado con el detalle de
todos los titulares y todos los suplentes)
Al seleccionar la opción deseada el programa debe imprimir la información que
se pide en cada reporte.
Nota: Se debe realizar el ejercicio con programación orientada objetos.
No se requiere interfaz gráfica.
 */
package equiposdefutbol;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Jorge Melendez
 */
public class EquiposDeFutbol {

  public static void main(String[] args) {
// Se crea un objeto Scanner para la entrada de usuario.
    Scanner scanner = new Scanner(System.in);
     // Se crea un objeto Equipo para almacenar la información del equipo.
    Equipo equipo = new Equipo();
     // Se crean listas separadas para los jugadores titulares y suplentes.
    ArrayList<Jugador> listaJugadorTitular = new ArrayList<>();
    ArrayList<Jugador> listaJugadorSuplente = new ArrayList<>();
    int opt = 0;
 // Ciclo principal del programa que muestra el menú hasta que el usuario elija salir.
    do {
      System.out.print("#### Escriba un numero en las opciones del menu #####\n\n");
      System.out.print("1. Ingresar Equipo:\n");
      System.out.print("2. Listar equipos (Reporte básico)\n");
      System.out.print("3. Listar equipos (Reporte detallado)\n");
      System.out.print("9. Salir de la aplicacion\n");
      System.out.print("=>:  ");
      String input = scanner.next();

      if (input.matches("\\d+")) {
        opt = Integer.parseInt(input);

        switch (opt) {
          case 1:
            agregarEquipo(scanner, equipo, listaJugadorTitular, listaJugadorSuplente);

            break;
          case 2:
            equipo.imprimirInformacionEquipo();
            break;
          case 3:
            equipo.imprimirReporteDetallado();
            break;
          case 9:
 // Salir de la aplicación.
            break;
          default:
            System.out.print("El numero ingresado no se encuentra en el menu\n");
            opt = -1;
        }
      } else {
        System.out.println("No es un número válido\n");
        opt = -1;
      }

    } while (opt != 9);

  }
/**
 * Permite al usuario ingresar información sobre un equipo, incluyendo el nombre del equipo,
 * el estadio y la cantidad de títulos ganados. Luego, permite al usuario ingresar información
 * sobre jugadores, incluyendo sus nombres y posiciones, y decide si son titulares o suplentes.
 * La información ingresada se almacena en un objeto de tipo Equipo y se gestiona a través de
 * las listas de jugadores titulares y suplentes.
 *
 * @param scanner El objeto Scanner para la entrada del usuario.
 * @param e El objeto Equipo en el que se almacena la información del equipo y los jugadores.
 * @param listaJugadorTitular La lista de jugadores titulares del equipo.
 * @param listaJugadorSuplente La lista de jugadores suplentes del equipo.
 */
  private static void agregarEquipo(Scanner scanner, Equipo e, ArrayList<Jugador> listaJugadorTitular, ArrayList<Jugador> listaJugadorSuplente) {

    System.out.print("NombreEquipo =>:  ");
    e.setNombreEquipo(scanner.next());
    System.out.print("Estadio del equipo =>:  ");
    e.setEstadio(scanner.next());
    System.out.print("Cuantos titulos tiene el equipo? =>:  ");
    e.setCantidadTitulos(validarnumero(scanner.next(), scanner, e));
    System.out.print("\n#. Ingresar jugador a [" + e.getNombreEquipo() + "]\n");

    String opt = "";
    do {
      Jugador jugador = new Jugador();
      System.out.print(".   Nombre jugador =>:  ");
      jugador.setNombreJugador(scanner.next());
      System.out.print("    Posicion jugador =>:  ");
      jugador.setPosicion(scanner.next());
      menuEstadoJugador(jugador, scanner, listaJugadorTitular, listaJugadorSuplente);
      opt = menuAgregarJugador(scanner);
      System.out.print("----------------\n");
    } while (opt.equals("s"));
    e.setListaJugadoresTitulares(listaJugadorTitular);
    e.setListaJugadoresSuplentes(listaJugadorSuplente);

  }

  /**
   * Valida una cadena como número entero y la convierte en un entero si es
   * válida. Si la cadena no es un número válido, se solicitará una nueva
   * entrada recursivamente.
   *
   * @param n La cadena que se va a validar como número.
   * @param scanner El objeto Scanner para la entrada del usuario.
   * @param e El objeto Equipo utilizado para almacenar la cantidad de títulos.
   * @return El número entero validado.
   */
  private static int validarnumero(String n, Scanner scanner, Equipo e) {

    if (n.matches("\\d+")) {
      return Integer.parseInt(n);
    } else {
      System.out.println("No es un número válido\n");
      System.out.print("Cuantos titulos tiene el equipo? =>:  ");
      e.setCantidadTitulos(validarnumero(scanner.next(), scanner, e));
    }
    return 0;
  }
/**
 * Permite al usuario seleccionar el estado de un jugador (titular o suplente) y 
 * guardar esa información en las listas correspondientes del equipo. El método
 * muestra un menú de opciones en el que el usuario puede elegir si el jugador es
 * titular, suplente o volver atrás (por defecto, suplente).
 *
 * @param jugador El objeto Jugador para el cual se establecerá el estado.
 * @param scanner El objeto Scanner para la entrada del usuario.
 * @param listaJugadorTitular La lista de jugadores titulares del equipo.
 * @param listaJugadorSuplente La lista de jugadores suplentes del equipo.
 
 */
  private static void menuEstadoJugador(Jugador jugador, Scanner scanner, ArrayList<Jugador> listaJugadorTitular, ArrayList<Jugador> listaJugadorSuplente) {

    int opt = 0;
    System.out.print("####Marque####\n");

    do {
      System.out.print("     1. Si es titular\n");
      System.out.print("     2. Si es suplente\n");
      System.out.print("     3. Atrás (suplente por defecto)\n");
      String input = scanner.next();

      if (input.matches("\\d+")) {
        opt = Integer.parseInt(input);

        switch (opt) {
          case 1:
            listaJugadorTitular.add(jugador);
            System.out.print("Jugador guardado!\n ");
            opt = 3;
            break;
          case 2:
            listaJugadorSuplente.add(jugador);
            System.out.print("Jugador guardado!\n ");
            opt = 3;
            break;
          case 3:
            listaJugadorSuplente.add(jugador);
            System.out.print("Jugador guardado!\n ");

            break;
          default:
            System.out.print("El número " + opt + " no se encuentra en el menú\n");
            opt = -1;
            break;
        }
      } else {
        System.out.print("Ingrese un número válido del menú\n");
        opt = -1;
      }
    } while (opt != 3);

  }
/**
 * Muestra un menú al usuario para preguntar si desea agregar otro jugador.
 * El método solicita una entrada (s/n) y espera hasta que el usuario proporcione
 * una respuesta válida (s para sí y n para no, no distingue entre mayúsculas y minúsculas).
 *
 * @param scanner El objeto Scanner para la entrada del usuario.
 * @return "s" si el usuario elige agregar otro jugador, "n" si no.
 */
  private static String menuAgregarJugador(Scanner scanner) {
    String opt;
    do {
      System.out.print("Desea agregar otro jugador? (s/n)=>: ");
      opt = scanner.next().toLowerCase(); // Convierte la entrada a minúsculas
      if (!opt.equals("s") && !opt.equals("n")) {
        System.out.print("Escriba la letra correspondiente (s/n)\n");
      }
    } while (!opt.equals("n") && !opt.equals("s"));
    return opt;
  }

}
