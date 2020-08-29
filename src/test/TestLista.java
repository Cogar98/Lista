
package test;
import estructurasdinamicas.Lista;

public class TestLista {
    public static void main(String[] args) {
        Lista lista1 = new Lista();
        lista1.insertaNodo();
        lista1.insertaNodo();
        lista1.insertaNodo();
        lista1.imprimeTodo();
        System.out.println("");
        lista1.insertaNodo(0);
        lista1.insertaNodo();
        lista1.imprimeTodo();
        System.out.println("");
        lista1.insertaNodo(1);
        lista1.insertaNodo(5);
        lista1.imprimeTodo();
        System.out.println("lista1.getContadorNodos() = " + lista1.getContadorNodos());
    }
}
