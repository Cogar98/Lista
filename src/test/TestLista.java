package test;

import estructurasdinamicas.Lista;

public class TestLista {

    public static void main(String[] args) {
        Lista alumnos = new Lista();
        alumnos.insertaNodo(null, "Roberto", "Cordova", "Galvan", 8);
        alumnos.insertaNodo(null, "Alberto", "Armenta", "Galvan", 4);
        alumnos.insertaNodo(null, "Juan", "Melendez", "Sanchez", 6);
        alumnos.insertaNodo(null,"Pedro","de la mar", "LOL", 2);
        alumnos.insertaNodo(null,"Juancho","Robleddo", "WOW", 0);
        alumnos.imprimeTodo();
    /*    for(int i = 10000; i >= 0 ; i--)
        {
            alumnos.insertaNodo(null, "Otro", "Cordova", "Galvan", i);
        }     */   
        System.out.println("alumnos.getContadorNodos() = " + alumnos.getContadorNodos());
        System.out.println("FIN ORIGINAL");

        alumnos.ordenEdadIntercambioA();
        alumnos.imprimeTodo();
    }
}
