/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assistec.mcontreras.sistemadecombaterpg;

/**
 *
 * @author assistec.infogtgmail.com
 */
public class Personaje {
    String nombre;
    double puntosVida;
    double puntosVidaMax;
    double puntosAtaque;
    double puntosDefensa;
    int nivel;    
    public static int totalPersonajesCreados;
    
    //consructor predeterminado
    
    public Personaje() {
        this.nombre = "Guerrero Novato";
        this.puntosVidaMax = 100.0;
        this.puntosVida = 100.0;
        this.puntosAtaque = 15.0;
        this.puntosDefensa = 5.0;
        this.nivel = 1;
        totalPersonajesCreados++;
    }

    // Constructor parametrizado
    public Personaje(String nombre, double puntosVida, double puntosVidaMax, double puntosAtaque, double puntosDefensa, int nivel) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.puntosVidaMax = puntosVidaMax;
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.nivel = nivel;
        totalPersonajesCreados++;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPuntosVida() {
        return puntosVida;
    }

    public double getPuntosVidaMax() {
        return puntosVidaMax;
    }

    public double getPuntosAtaque() {
        return puntosAtaque;
    }

    public double getPuntosDefensa() {
        return puntosDefensa;
    }

    public int getNivel() {
        return nivel;
    }

    public static int getTotalPersonajesCreados() {
        return totalPersonajesCreados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntosVida(double puntosVida) {
        this.puntosVida = puntosVida;
    }

    public void setPuntosVidaMax(double puntosVidaMax) {
        this.puntosVidaMax = puntosVidaMax;
    }

    public void setPuntosAtaque(double puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    public void setPuntosDefensa(double puntosDefensa) {
        this.puntosDefensa = puntosDefensa;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public static void setTotalPersonajesCreados(int totalPersonajesCreados) {
        Personaje.totalPersonajesCreados = totalPersonajesCreados;
    }
    
    
    public void atacar(Personaje objetivo) {
        double dano = this.puntosAtaque - objetivo.puntosDefensa;
        if (dano <= 0) {
            dano = 3.0;
        }
        objetivo.recibirDano(dano);
        System.out.println(this.nombre + " atacó a " + objetivo.nombre + " y le provocó " + dano + " de daño.");
    }
    
    public void recibirDano(double cantidad) {
        this.puntosVida -= cantidad;
        if (this.puntosVida < 0) {
            this.puntosVida = 0.0;
        }
    }
    
     public void curar() {
        double vidaAnterior = this.puntosVida;
        this.puntosVida += 25.0;
        if (this.puntosVida > this.puntosVidaMax) {
            this.puntosVida = this.puntosVidaMax;
        }
        double recuperada = this.puntosVida - vidaAnterior;
        System.out.println(this.nombre + " recuperó " + recuperada + " de vida. Vida actual: " + this.puntosVida);
    }
     
     public boolean estaVivo() {
        return this.puntosVida > 0.0;
    }
     
      public void subirNivel() {
        this.nivel++;
        this.puntosVidaMax += 20.0;
        this.puntosAtaque += 5.0;
        this.puntosDefensa += 2.0;
        this.puntosVida = this.puntosVidaMax;
        System.out.println("¡" + this.nombre + " subió al nivel " + this.nivel + "!");
        System.out.println("Nuevos atributos -> Vida máx: " + this.puntosVidaMax
                + " | Ataque: " + this.puntosAtaque
                + " | Defensa: " + this.puntosDefensa);
    }
      
      public void mostrarEstado() {
        System.out.println("Nombre : " + this.nombre);
        System.out.println("Nivel  : " + this.nivel);
        System.out.println("Vida   : " + this.puntosVida + " / " + this.puntosVidaMax);
        System.out.println("Ataque : " + this.puntosAtaque);
        System.out.println("Defensa: " + this.puntosDefensa);
    }
      
      
     

    
    
}
