/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juald
 */
public class Trio {

    private Punto Trio_de_Puntos[] = new Punto[3];
    private double distancia;

    public Trio(Punto P1, Punto P2, Punto P3) {
        double distancia1, distancia2, distancia3;
        this.Trio_de_Puntos[0] = new Punto(P1);
        this.Trio_de_Puntos[1] = new Punto(P2);
        this.Trio_de_Puntos[2] = new Punto(P3);
        Punto vertice = new Punto(Trio_de_Puntos[0]);

        //Calculamos la distancia del punto 1 al punto 2 y le sumamos la distancia del punto 1 al punto 3
        distancia1 = Punto.distancia(Trio_de_Puntos[0], Trio_de_Puntos[1])
                + Punto.distancia(Trio_de_Puntos[0], Trio_de_Puntos[2]);

        //Calculamos la distancia del punto 2 al punto 1 y le sumamos la distancia del punto 2 al punto 3
        distancia2 = Punto.distancia(Trio_de_Puntos[1], Trio_de_Puntos[0])
                + Punto.distancia(Trio_de_Puntos[1], Trio_de_Puntos[2]);

        //Calculamos la distancia del punto 3 al punto 1 y le sumamos la distancia del punto 3 al punto 2
        distancia3 = Punto.distancia(Trio_de_Puntos[2], Trio_de_Puntos[0])
                + Punto.distancia(Trio_de_Puntos[2], Trio_de_Puntos[1]);

        if (distancia1 < distancia2) {
            this.distancia = distancia1;
        } else {
            this.distancia = distancia2;
            vertice = new Punto(Trio_de_Puntos[1]);
        }
        if (distancia3 < this.distancia) {
            this.distancia = distancia3;
            vertice = new Punto(Trio_de_Puntos[2]);
        }
    }

    /**
     * Metodo para hallar la solución de los 3 puntos más cercanos mediante
     * un algoritmo exhaustivo
     * @param T
     * @param i
     * @param d
     * @return
     */
    public static Trio algoritmoExhaustivo(Punto T[], int i, int d) {

        Trio solucion = new Trio(T[0], T[1], T[2]);
        Trio auxiliar;

        for (int a1 = i; a1 <= d; a1++) {
            for (int a2 = a1 + 1; a2 <= d; a2++) {
                for (int a3 = a2 + 1; a3 <= d; a3++) {

                    auxiliar = new Trio(T[a1], T[a2], T[a3]);

                    if (auxiliar.distancia < solucion.distancia) {
                        solucion = auxiliar;
                    }
                }
            }
        }
        return solucion;
    }
    @Override
    public String toString() {
        return "\nP1 = " + this.Trio_de_Puntos[0]
                + "\nP2 = " + this.Trio_de_Puntos[1]
                + "\nP3 = " + this.Trio_de_Puntos[2] + "\nDistancia: " + distancia;
    }
    public static void pruebaAlgoritmoExhaustivo() {
        Punto P[] = new Punto[5];
        
        P[0] = new Punto(1, 1);
        P[1] = new Punto(2, 4);
        P[2] = new Punto(4, 6);
        P[3] = new Punto(3, 1);
        P[4] = new Punto(5, 2);
        
        Trio solucion = Trio.algoritmoExhaustivo(P, 0, 4);
        System.out.println("El trio de puntos mas cercano es: " + solucion);
    }
}
