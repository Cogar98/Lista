package test;

import estructurasdinamicas.Lista;

public class TestLista {

    public static void main(String[] args) {
        Lista lista1 = new Lista();
        lista1.insertaNodo();
        lista1.insertaNodo();
        lista1.insertaNodo();
        lista1.imprimeTodo();
        System.out.println("lista1.contadorNodos = " + lista1.getContadorNodos());
        System.out.println("");
        lista1.prueba();
        lista1.imprimeTodo();
        System.out.println("lista1.contadorNodos = " + lista1.getContadorNodos());
//        lista1.insertaNodo();
//        lista1.imprimeTodo();
//        System.out.println("lista1.contadorNodos = " + lista1.getContadorNodos());
//        lista1.remueveNodo(3);
//        System.out.println("");
//        lista1.imprimeTodo();
//        System.out.println("lista1.contadorNodos = " + lista1.getContadorNodos());
//        lista1.modificaDatos(0, "Odette", "Quiroz", "Cordova", (byte)21);
//        lista1.modificaDatos(2, "Jacqueline", "Robledo", "Cordova", (byte)21);
//        System.out.println("");
//        lista1.imprimeTodo();
//        System.out.println("lista1.contadorNodos = " + lista1.getContadorNodos()); 
//        lista1.remueveNodo(2);
//        lista1.remueveNodo(0);
//        lista1.remueveNodo(0);
//        System.out.println("");
//        lista1.imprimeTodo();
//        System.out.println("lista1.contadorNodos = " + lista1.getContadorNodos());         
//        lista1.insertaNodo(1);
//        lista1.insertaNodo(0, null, "Roberto", "Cordova", "Galvan", (byte)21);
//        lista1.insertaNodo();
//        lista1.insertaNodo();
//        lista1.imprimeTodo();
//        System.out.println("");
//        lista1.imprimeTodo();
    }
}
