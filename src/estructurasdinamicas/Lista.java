
package estructurasdinamicas;

public class Lista {
    // ATRIBUTOS Y OBJETOS
    private Nodo nodoInicial;
    private Nodo apuntador;
    private Nodo ultimoNodo;
    private int contadorNodos; // tamaño
    private boolean vacia;
    private boolean ordenada;

    // CLASES
    private final class Nodo
    {
        // INFORMACION DEL NODO
        private Object objeto;
        private String nombre;
        private String apellidoPaterno;
        private String apellidoMaterno;
        private int edad;
        private int indiceNodo;
        // ENLACE O SIGUIENTE
        private Nodo siguiente;
        
        // CONSTRUCTOR
        public Nodo()
        {
            
        }
        
        public Nodo(Object objeto, String nombre, String apellidoPaterno,
                String apellidoMaterno, int edad)
        {
           this.objeto = objeto;
           this.nombre = nombre;
           this.apellidoPaterno = apellidoPaterno;
           this.apellidoMaterno = apellidoMaterno;
           this.edad = edad;
        }
        // GETTER Y SETTERS
        public Object getObjeto() {
            return this.objeto;
        }

        public void setObjeto(Object objeto) {
            this.objeto = objeto;
        }

        public String getNombre() {
            return this.nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellidoPaterno() {
            return this.apellidoPaterno;
        }

        public void setApellidoPaterno(String apellidoPaterno) {
            this.apellidoPaterno = apellidoPaterno;
        }

        public String getApellidoMaterno() {
            return this.apellidoMaterno;
        }

        public void setApellidoMaterno(String apellidoMaterno) {
            this.apellidoMaterno = apellidoMaterno;
        }

        public int getEdad() {
            return this.edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public Nodo getSiguiente() {
            return this.siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

        public int getIndiceNodo() {
            return this.indiceNodo;
        }

        public void setIndiceNodo(int indiceNodo) {
            this.indiceNodo = indiceNodo;
        }        

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Nodo{objeto=").append(objeto);
            sb.append(", nombre=").append(nombre);
            sb.append(", apellidoPaterno=").append(apellidoPaterno);
            sb.append(", apellidoMaterno=").append(apellidoMaterno);
            sb.append(", edad=").append(edad);
            sb.append(", indiceNodo=").append(indiceNodo);
            sb.append(", ").append(super.toString());
            sb.append('}');
            return sb.toString();
        }
    }

    // CONSTRUCTORES
    public Lista()
    {
        this.vacia = true;
    }
    
    // SETTERS Y GETTERS
    public Nodo getNodoInicial() {
        return this.nodoInicial;
    }

    public void setNodoInicial(Nodo nodoInicial) {
        this.nodoInicial = nodoInicial;
    }

    public Nodo getApuntador() {
        return this.apuntador;
    }

    public void setApuntador(Nodo apuntador) {
        this.apuntador = apuntador;
    }

    public Nodo getUltimoNodo() {
        return this.ultimoNodo;
    }

    public void setUltimoNodo(Nodo ultimoNodo) {
        this.ultimoNodo = ultimoNodo;
    }

    public int getContadorNodos() {
        return this.contadorNodos;
    }

    public void setContadorNodos(int contadorNodos) {
        this.contadorNodos = contadorNodos;
    }
 
    public boolean isVacia() {
        if(this.contadorNodos == 0)
            return this.vacia = true;
        return this.vacia;
    }
   
    public boolean isOrdenada() {
        return ordenada;
    }

    // METODOS
    public boolean esUltimo(Nodo nodo)
     {
         if(nodo.getSiguiente() == null) // Valida que estemos en el ultimo nodo
             return true;              // true = ultimo y false = es cualquier otro nodo
         return false;
     }
     
    public void inicializaRecorrido()
    {
        this.apuntador = this.nodoInicial;
    }
            
    public void recorreHastaUltimo()
    {
        this.inicializaRecorrido();
        while(!this.esUltimo(apuntador))
        {
            this.apuntador = this.apuntador.getSiguiente();
        }
    }
    
    public void buscaNodo(int posicion)
    {
        this.inicializaRecorrido();
        while( (!this.esUltimo(this.apuntador)) && (this.apuntador.getIndiceNodo() != posicion) )
        {
            this.apuntador = this.apuntador.getSiguiente();
        }
    }
    
    public Nodo buscaNodoAnterior(int posicion)
    {
        // Debe encontrar al nodo anterior con una posicion de 1 hasta tamaño-1
        // Dominio de esta funcion  0 < posicion < tamaño - 1
        
        if( 0 < posicion && posicion < this.Tamanio() && !isVacia())
        {
            inicializaRecorrido();
            while(!esUltimo(this.apuntador) && posicion != this.apuntador.getSiguiente().getIndiceNodo())
            {
                this.apuntador = this.apuntador.getSiguiente();
            }  // avanzara mientras no sea el ultimo nodo y el nodo siguiente sea distinto al del la posicion buscada
            return this.apuntador; // este es el nodo anterior en este momento
        }
        else if(isVacia())
        {
            System.out.println("Lista vacia, no es posible esta operacion");
        }
        else if(posicion < 0 || this.Tamanio() < posicion)
        {
            System.out.println("Posicion fuera del dominio");
        }
        return null;
    }
    
    public void imprimeTodo()
    {
        this.inicializaRecorrido();
        System.out.println("this.apuntador = " + this.apuntador);
        while(!this.esUltimo(apuntador))
        {
            this.apuntador = this.apuntador.getSiguiente();
            System.out.println("this.apuntador = " + this.apuntador);
        }       
    }
    
    public int Tamanio()
    {
        return this.contadorNodos;
    }
    
    public void insertaNodo()
    {
        if(isVacia())
        {
            this.nodoInicial = this.ultimoNodo = new Nodo(); // Aqui creamos el primer nodo
            this.nodoInicial.setIndiceNodo(contadorNodos++); // Aumento en Pos-Order
            this.vacia = false; // y estableciendo una lista NO vacia
        }
        else
        {
            this.recorreHastaUltimo();
            this.apuntador.setSiguiente(new Nodo());
            this.apuntador.getSiguiente().setIndiceNodo(contadorNodos++); // Aumento Pos-Order
            this.ultimoNodo = this.apuntador.getSiguiente();
        }
    }
    
    public void insertaNodo(int posicion)
    { // inserta un nuevo nodo en la posicion si es posible
        
        if(isVacia() && posicion == 0) // lista VACIA
        { 
            this.insertaNodo();
        }
        else if(!isVacia() && posicion == 0) // lista NO VACIA
        {
            this.inicializaRecorrido();
            var auxiliar = this.apuntador; 
            this.apuntador = new Nodo(); 
            this.nodoInicial = this.apuntador;
            this.apuntador.setSiguiente(auxiliar); // se reapunto
            this.reordenaNodoAFinal(auxiliar);
            this.recorreHastaUltimo();
            this.ultimoNodo = this.apuntador;
        }
        else if(this.Tamanio() > 0 && 0 < posicion && posicion < this.Tamanio())
        {
            var auxiliar = this.buscaNodoAnterior(posicion);
            System.out.println("auxiliar = " + auxiliar);
        }
        else
        {
            System.out.println("Posicion fuera del dominio, OPERACION IMPOSIBLE");
        }
    }
    
    public void insertaNodo(Object objeto, String nombre, String apellidoPaterno,
                String apellidoMaterno, int edad)
    {
        
    }
    
    private void reordenaNodoAFinal(Nodo nodo)
    {
        this.inicializaRecorrido();
        this.buscaNodoAnterior(auxiliar.getIndiceNodo());
    }
}
