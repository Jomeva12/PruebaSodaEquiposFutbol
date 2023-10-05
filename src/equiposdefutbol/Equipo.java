/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equiposdefutbol;

import java.util.ArrayList;

/**
 *
 * @author Jorge Melendez
 */
public class Equipo {
  
 private String nombreEquipo;
 private String estadio;
 private int cantidadTitulos;
 private ArrayList<Jugador> listaJugadoresTitulares;
private ArrayList<Jugador> listaJugadoresSuplentes;

  public Equipo() {
  }

  

  public String getNombreEquipo() {
    return nombreEquipo;
  }

  public void setNombreEquipo(String nombreEquipo) {
    this.nombreEquipo = nombreEquipo;
  }

  public String getEstadio() {
    return estadio;
  }

  public void setEstadio(String estadio) {
    this.estadio = estadio;
  }

  public int getCantidadTitulos() {
    return cantidadTitulos;
  }

  public void setCantidadTitulos(int cantidadTitulos) {
    this.cantidadTitulos = cantidadTitulos;
  }

  public ArrayList<Jugador> getListaJugadoresTitulares() {
    return this.listaJugadoresTitulares;
  }

  public void setListaJugadoresTitulares(ArrayList<Jugador> listaJugadoresTitulares) {
    this.listaJugadoresTitulares = listaJugadoresTitulares;
  }

  public ArrayList<Jugador> getListaJugadoresSuplentes() {
    return this.listaJugadoresSuplentes;
  }

  public void setListaJugadoresSuplentes(ArrayList<Jugador> listaJugadoresSuplentes) {
    this.listaJugadoresSuplentes = listaJugadoresSuplentes;
  }
/**
 * Imprime un informe básico que muestra el nombre del equipo, la cantidad de títulos ganados y
 * la cantidad total de jugadores (titulares y suplentes).
 */
 public void imprimirInformacionEquipo() {
    System.out.println("\n********* Reporte basico *************");

    if (nombreEquipo == null || nombreEquipo.isEmpty()) {
        System.out.println("* No hay información de equipo disponible.");
    } else {
        System.out.println("* Nombre del Equipo: " + nombreEquipo);
        System.out.println("* Titulos Ganados: " + cantidadTitulos);

        int totalJugadores = 0;

        if (this.listaJugadoresTitulares != null) {
            totalJugadores += this.listaJugadoresTitulares.size();
        }

        if (this.listaJugadoresSuplentes != null) {
            totalJugadores += this.listaJugadoresSuplentes.size();
        }

        System.out.println("* Cantidad Total de Jugadores: " + totalJugadores);
    }

    System.out.println("*********************************************");
}
/**
 * Imprime un informe detallado que muestra información específica del equipo, incluyendo el nombre
 * del equipo, la cantidad de títulos ganados, el estadio y detalles de los jugadores titulares y
 * suplentes si los hay.
 */
public void imprimirReporteDetallado() {
    System.out.println("\n***********Reporte detallado***********");

    if (nombreEquipo == null || nombreEquipo.isEmpty()) {
        System.out.println("* No hay información de equipo disponible.");
    } else {
        System.out.println("* Nombre del Equipo: " + nombreEquipo);
        System.out.println("* Ttulos Ganados: " + cantidadTitulos);
        System.out.println("* Estadio: " + estadio);
        System.out.println("*\n* Detalle de Titulares:");

        if (listaJugadoresTitulares != null && !listaJugadoresTitulares.isEmpty()) {
            for (Jugador jugador : listaJugadoresTitulares) {
                System.out.println("* - Nombre: " + jugador.getNombreJugador());
                System.out.println("*   Posicion: " + jugador.getPosicion());
            }
        } else {
            System.out.println("*   No hay titulares registrados.");
        }

        System.out.println("*\n* Detalle de Suplentes:");

        if (listaJugadoresSuplentes != null && !listaJugadoresSuplentes.isEmpty()) {
            for (Jugador jugador : listaJugadoresSuplentes) {
                System.out.println("* - Nombre: " + jugador.getNombreJugador());
                System.out.println("*   Posicion: " + jugador.getPosicion());
            }
        } else {
            System.out.println("*   No hay suplentes registrados.");
        }
    }

    System.out.println("*********************************************");
}


}
