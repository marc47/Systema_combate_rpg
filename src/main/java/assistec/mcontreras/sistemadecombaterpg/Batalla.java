/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assistec.mcontreras.sistemadecombaterpg;

/**
 *
 * @author assistec.infogtgmail.com
 */
public class Batalla {
    
    public static void ejecutarAtaqueCritico(Personaje atacante, Personaje objetivo, double multiplicador) {
        double danoPotenciado = atacante.getPuntosAtaque() * multiplicador;
        int danoCritico = (int) danoPotenciado;
        objetivo.recibirDano(danoCritico);
        System.out.println("¡Golpe Crítico! " + atacante.getNombre() + " golpeó a "
                + objetivo.getNombre() + " causando " + danoCritico + " de daño.");
    }
    
    public static void iniciarPeleaAutomatica(Personaje p1, Personaje p2) {
        System.out.println("¡Comienza la batalla: " + p1.getNombre() + " vs " + p2.getNombre() + "!");
        while (p1.estaVivo() && p2.estaVivo()) {
            p1.atacar(p2);
            if (p2.estaVivo()) {
                p2.atacar(p1);
            }
        }
        if (p1.estaVivo()) {
            System.out.println("¡El ganador es " + p1.getNombre() + "!");
        } else {
            System.out.println("¡El ganador es " + p2.getNombre() + "!");
        }
    }
    
    
    
}
