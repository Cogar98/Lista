
package test;
import estructurasdinamicas.Lista;

public class TestLista {
    public static void main(String[] args) {
        Lista lista1 = new Lista();
        lista1.insertaNodo();
        lista1.insertaNodo();
        lista1.insertaNodo();
        lista1.insertaNodo(2);
        lista1.imprimeTodo();
        System.out.println("lista1.contadorNodos = " + lista1.getContadorNodos());
        lista1.remueveUltimoNodo();
        lista1.remueveUltimoNodo();
        lista1.remueveUltimoNodo();
        lista1.remueveUltimoNodo();
        lista1.remueveUltimoNodo();
        System.out.println("");
        lista1.imprimeTodo();
        System.out.println("lista1.contadorNodos = " + lista1.getContadorNodos());
    }
}
