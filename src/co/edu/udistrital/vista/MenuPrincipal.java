package co.edu.udistrital.vista;

import co.edu.udistrital.modelo.ElCoreDelJuego;
import co.edu.udistrital.modelo.Jugador;

import java.util.List;

public class MenuPrincipal {

    private final ElCoreDelJuego elCoreDelJuego;

    public MenuPrincipal(ElCoreDelJuego elCoreDelJuego) {
        this.elCoreDelJuego = elCoreDelJuego;
    }

    public void jugar() {
        String opcion = "";
        do {
            System.out.println("\n\n*** JUEGO DE PALABRAS ***");
            System.out.println("1. Administrador.");
            System.out.println("2. Jugador.");
            System.out.println("3. Ver puntajes.");
            System.out.println("0. Salir.");
            System.out.printf("Digite la opción: ");
            opcion = InOut.leerLinea();
            switch (opcion) {
                case "1":
                    opcionAdministrador();
                    break;
                case "2":
                    opcionJugador();
                    break;
                case "3":
                    opcionVerPuntajes();
                    break;
                case "0":
                    break;
            }
        } while (!opcion.equals("0"));
        System.out.println("Gracias por utilizar el sistema.");
    }

    private void opcionAdministrador() {
        MenuAdministracion menuAdministracion = new MenuAdministracion(elCoreDelJuego);
        menuAdministracion.ingresarAdministrar();
    }

    private void opcionJugador() {
        VistaJuego vistaJuego = new VistaJuego(elCoreDelJuego);
        vistaJuego.ingresarJuego();
    }

    private void opcionVerPuntajes() {
        List<Jugador> jugadores = elCoreDelJuego.getJugadores();
        for(Jugador jugador : jugadores) {
            System.out.println("Jugador '" + jugador.getNombre() + "', puntajes: " + jugador.getPuntajes());
        }
    }
}
