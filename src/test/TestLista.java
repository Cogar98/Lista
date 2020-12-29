package test;

import estructurasdinamicas.Lista;

public class TestLista {

    public static void main(String[] args) {
        Lista alumnos = new Lista();
        alumnos.insertaNodo(0, null, "Roberto", "Cordova", "Galvan", (byte)21);
        alumnos.insertaNodo(1, null, "Alberto", "Armenta", "Galvan", (byte)27);
        alumnos.insertaNodo(2, null, "Juan", "Melendez", "Sanchez", (byte)20);
        alumnos.insertaNodo();
        alumnos.insertaNodo();
        alumnos.insertaNodo();
        alumnos.insertaNodo();
        alumnos.insertaNodo(new Object(), "t", "d", "o",(byte)0);
        alumnos.insertaNodo(1, new Object(), "Damian", "Sarabia", "Beltran", (byte)20);
        alumnos.imprimeTodo();
        System.out.println("alumnos.revisaOrden() = " + alumnos.revisaOrden());
        System.out.println("alumnos = " + alumnos);
    }
}
