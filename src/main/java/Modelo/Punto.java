/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juald
 */
public class Punto {

    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Punto(Punto P) {
        this.x = P.getX();
        this.y = P.getY();
    }

    //Setters y getters
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.x = y;
    }

    /**
     * Metodo para hallar la distancia entre dos puntos
     *
     * @param P1
     * @param P2
     * @return
     */
    public static double distancia(Punto P1, Punto P2) {
        return Math.sqrt(Math.pow(P1.x - P2.x, 2) + Math.pow(P1.y - P2.y, 2));
    }

    /**
     * Metodo para probar el cálculo de la distancia entre dos puntos
     */
    public static void PruebaDistancia() {
        Punto[] P = new Punto[5];

        P[0] = new Punto(1, 1);
        P[1] = new Punto(2, 4);
        P[2] = new Punto(4, 6);
        P[3] = new Punto(3, 1);
        P[4] = new Punto(5, 2);

        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                double distancia = Punto.distancia(P[i], P[j]);

                System.out.println("---------------------------");
                System.out.println("Distancia entre [P" + (i + 1) + "] y [P" + (j + 1) + "]: " + distancia);
                System.out.println("---------------------------");
            }
        }
    }
    @Override
    public String toString() {
        return "Punto{" + "x=" + x + ", y=" + y + '}';
    }
}
