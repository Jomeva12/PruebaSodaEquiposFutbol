/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equiposdefutbol;

/**
 *
 * @author Jorge Melendez
 */
/**
 * La clase Jugador representa a un jugador en un equipo de fubol.
 */
public class Jugador {
    private String nombreJugador; // El nombre del jugador.
    private String posicion;      // La posición en la que juega el jugador.

    /**
     * Constructor por defecto de la clase Jugador.
     * Crea una instancia de Jugador sin valores iniciales.
     */
    public Jugador() {
        // Constructor vacío.
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return El nombre del jugador.
     */
    public String getNombreJugador() {
        return nombreJugador;
    }

    /**
     * Establece el nombre del jugador.
     *
     * @param nombreJugador El nuevo nombre del jugador.
     */
    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    /**
     * Obtiene la posición en la que juega el jugador.
     *
     * @return La posición del jugador.
     */
    public String getPosicion() {
        return posicion;
    }

    /**
     * Establece la posición en la que juega el jugador.
     *
     * @param posicion La nueva posición del jugador.
     */
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}