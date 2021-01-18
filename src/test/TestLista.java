package test;

import estructurasdinamicas.Lista;

public class TestLista {

    public static void main(String[] args) {
        Lista alumnos = new Lista();

        alumnos.insertaNodo(0, null, "Roberto", "Cordova", "Galvan", (byte)21);
        alumnos.insertaNodo(1, null, "Alberto", "Armenta", "Galvan", (byte)27);
        alumnos.insertaNodo(1, null, "Juan", "Melendez", "Sanchez", (byte)20);
        alumnos.insertaNodo();
        alumnos.insertaNodo();
        alumnos.insertaNodo();
        alumnos.insertaNodo();
        alumnos.insertaNodo(new Object(), "t", "d", "o",(byte)0);
        alumnos.insertaNodo(1, new Object(), "Damian", "Sarabia", "Beltran", (byte)20);
        alumnos.imprimeTodo();
        alumnos.prueba();
        alumnos.imprimeTodo();
        System.out.println("alumnos.revisaOrden() = " + alumnos.revisaOrden());
        System.out.println("alumnos = " + alumnos);
        /*
        
        */
        /*int [] a = {7,9,0,75};
        int i , j;

        System.out.println(a[0] + " " + a[1] + " "  + a[2] + " "  + a[3]);
        
        for ( j = 0 ; j < a.length - 1 ; j ++ ) {
            for (i = j+1; i < a.length; i++) // esto representa una sola pasada y recorre todo el arreglo
            {
                if (a[j] > a[i]) {
                    var c = a[j]; // auxiliar
                    a[j] = a[i];
                    a[i] = c;
                }
            }
            System.out.println(a[0] + " " + a[1] + " " + a[2] + " " + a[3]);
        }*/
    }
}
