
package test;
import estructurasdinamicas.Lista;

public class TestLista {
    public static void main(String[] args) {
        Lista lista1 = new Lista();
        lista1.insertaNodo();
        lista1.insertaNodo();
        lista1.insertaNodo();
        lista1.imprimeTodo();
        lista1.insertaNodo(0,"ID = 36543", "Jacqueline", "Robledo", "Cordova", 21);
        lista1.insertaNodo(1,null, "Odette", "Quiroz", "Roman", 21);
        lista1.insertaNodo(2,null, "Roberto", "Cordova", "Galvan", 21);
        lista1.imprimeTodo();
        System.out.println("lista1 = " + lista1);
        System.out.println("lista1.getContadorNodos() = " + lista1.getContadorNodos());
    }
}
