package test;

import estructurasdinamicas.Lista;

public class TestLista {

    public static void main(String[] args) {
        Lista alumnos = new Lista();
        alumnos.insertaNodo(null, "Roberto", "Cordova", "Galvan", 8);
        alumnos.insertaNodo(null, "Alberto", "Armenta", "Galvan", 4);
        alumnos.insertaNodo(null, "Juan", "Melendez", "Sanchez", 6);
        alumnos.insertaNodo(null,"Pedro","de la mar", "LOL", 2);
        alumnos.imprimeTodo();
        System.out.println("FIN ORIGINAL");
       // alumnos.prueba();
        alumnos.ordenEdadAIntercambio();
        alumnos.imprimeTodo();
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
