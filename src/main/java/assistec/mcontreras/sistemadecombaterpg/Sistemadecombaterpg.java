/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package assistec.mcontreras.sistemadecombaterpg;


import java.util.Scanner;


public class Sistemadecombaterpg {

    
    
    public static void main(String[] args) {
        
        Scanner esc = new Scanner(System.in);
        Personaje p1 = new Personaje();
        Personaje p2 = new Personaje();
        int opcion;
   
        // recorrido del menu principal con ciclo do-while y utilizando switch
            do {
            mostrarMenu();
            opcion = leerEntero("Elige una opción: ");

            switch (opcion) {
                case 1: {
                    System.out.println("1. Crear personaje personalizado");
                    System.out.println("2. Usar personaje predeterminado");
                    int tipo = leerEntero("Elige una opción: ");

                    if (tipo == 1) {
                        p1 = crearPersonaje(1);
                    } else if (tipo == 2) {
                        p1 = new Personaje();
                        System.out.println("Personaje 1 creado con valores predeterminados: " + p1.getNombre());
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;
                }
                case 2:
                    p2 = crearPersonaje(2);
                    break;
                case 3:
                    mostrarFicha("Personaje 1", p1);
                    mostrarFicha("Personaje 2", p2);
                    break;
                case 4: {
                    Personaje p = elegirPersonaje(p1, p2);
                    if (p != null) p.subirNivel();
                    break;
                }
                case 5: {
                    Personaje p = elegirPersonaje(p1, p2);
                    if (p != null) p.curar();
                    break;
                }
                case 6: {
                    if (p1 == null || p2 == null) {
                        System.out.println("Necesitas crear ambos personajes primero.");
                    } else {
                        int atacante = leerEntero("¿Quién ataca? (1 o 2): ");
                        if (atacante == 1) {
                            p1.atacar(p2);
                        } else if (atacante == 2) {
                            p2.atacar(p1);
                        } else {
                            System.out.println("Opción inválida.");
                        }
                    }
                    break;
                }
                case 7: {
                    if (p1 == null || p2 == null) {
                        System.out.println("Necesitas crear ambos personajes primero.");
                    } else {
                        while (p1.estaVivo() && p2.estaVivo()) {
                            p1.atacar(p2);
                            if (p2.estaVivo()) {
                                p2.atacar(p1);
                            }
                        }
                        Personaje ganador = p1.estaVivo() ? p1 : p2;
                        System.out.println("¡Ganador: " + ganador.getNombre() + "!");
                    }
                    break;
                }
                case 8:
                    System.out.println("Personajes creados: " + Personaje.getTotalPersonajesCreados());
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 9);
    }
            
    
        // objeto menu principal
        static void mostrarMenu() {
            System.out.println("--------------------------------------------");
            System.out.println("--------- SIMULADOR DE COMBATE RPG ---------");
            System.out.println("--------------------------------------------");
            System.out.println("");
            System.out.println("");
            System.out.println("---------------- MAIN MENU -----------------");
            System.out.println("1. CREAR PERSONAJE 1");
            System.out.println("2. CREAR PERSONAJE 2");
            System.out.println("3. FICHA TECNICA DE LOS PEERSONAJES");
            System.out.println("4. SUBIR DE NIVEL A UN PERSONAJE");
            System.out.println("5. CURAR UN PERSONAJE");
            System.out.println("6. REALIZAR UN ATAQUE INDIVIDUAL");
            System.out.println("7. LETS BATTLE");
            System.out.println("8. PERSONAJES");
            System.out.println("9. SALIR");
      }
        
        
        // objeto crear personaje
        static Personaje crearPersonaje(int numero) {
            Scanner esc = new Scanner(System.in);
            System.out.print("Nombre del personaje " + numero + ": ");
            String nombre = esc.nextLine();

            double vidaMax = leerDouble("Puntos de vida máxima: ");
            double vida = leerDouble("Puntos de vida actual: ");
            while (vida > vidaMax) {
                System.out.println("La vida actual no puede ser mayor que la vida máxima (" + vidaMax + ").");
                vida = leerDouble("Puntos de vida actual: ");
            }

            double ataque = leerDouble("Puntos de ataque: ");
            double defensa = leerDouble("Puntos de defensa: ");
            int nivel = leerEntero("Nivel: ");

            Personaje p = new Personaje(nombre, vida, vidaMax, ataque, defensa, nivel);
            System.out.println("Personaje " + numero + " creado: " + nombre);
            return p;
        }
        
        static void mostrarFicha(String titulo, Personaje p) {
            System.out.println("--- " + titulo + " ---");
            if (p == null) {
                System.out.println("Advertencia: Este soldado aún no existe en nuestras filas.");
            } else {
                p.mostrarEstado();
            }
        }
        
        
        static Personaje elegirPersonaje(Personaje p1, Personaje p2) {
            int n = leerEntero("¿Qué personaje? (1 o 2): ");
            Personaje p = (n == 1) ? p1 : (n == 2) ? p2 : null;
            if (p == null) {
                System.out.println("Ese personaje no existe o la opción es inválida.");
            }
            return p;
        }
        
        static int leerEntero(String mensaje) {
            Scanner esc = new Scanner(System.in);
            while (true) {
                System.out.print(mensaje);
                try {
                    return Integer.parseInt(esc.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Ingresa un número entero válido.");
                }
            }
        }
        
        static double leerDouble(String mensaje) {
            Scanner esc = new Scanner(System.in);
            while (true) {
                System.out.print(mensaje);
                try {
                    return Double.parseDouble(esc.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Ingresa un número válido.");
                }
            }
        }
        
        
    
}
