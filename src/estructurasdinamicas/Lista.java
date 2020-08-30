
package estructurasdinamicas;

public class Lista {
    // ATRIBUTOS Y OBJETOS
    private Nodo primero;
    private Nodo apuntador;
    private Nodo ultimo;
    private int contadorNodos; // tamaño
    private boolean vacia = true; // valor inicial
    private Boolean ordenada; // indica si esta ordenada o no lo esta [true / false]



    // CLASES
    private final class Nodo
    {
        // INFORMACION DEL NODO
        private Object objeto;
        private String nombre;
        private String apellidoPaterno;
        private String apellidoMaterno;
        private byte edad;
        private int indiceNodo;
        // ENLACE O SIGUIENTE
        private Nodo siguiente;
        
        // CONSTRUCTOR
        public Nodo()
        {
            
        }
        
        public Nodo(Object objeto, String nombre, String apellidoPaterno,
                String apellidoMaterno, byte edad)
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

        public byte getEdad() {
            return this.edad;
        }

        public void setEdad(byte edad) {
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
    public Nodo getPrimero() {
        return this.primero;
    }

    public void setPrimero(Nodo nodoInicial) {
        this.primero = nodoInicial;
    }

    public Nodo getApuntador() {
        return this.apuntador;
    }

    public void setApuntador(Nodo apuntador) {
        this.apuntador = apuntador;
    }

    public Nodo getUltimo() {
        return this.ultimo;
    }

    public void setUltimo(Nodo ultimoNodo) {
        this.ultimo = ultimoNodo;
    }

    public int getContadorNodos() {
        return this.contadorNodos;
    }

    public boolean isVacia() {
        if(this.contadorNodos == 0)
            return this.vacia = true;
        return this.vacia = false;
    }
   
    public boolean isOrdenada() {
        return ordenada;
    }

    // METODOS
    private boolean esUltimo(Nodo nodo)
     {
         if(nodo.getSiguiente() == null && !isVacia()) // Valida que estemos en el ultimo nodo
             return true;              // true = ultimo y false = es cualquier otro nodo
         return false;
     }
     
    private void inicializaRecorrido()
    {
        this.apuntador = this.primero;
    }
            
    private void apuntaAlUltimo()
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
    
    public void buscaAnterior(int posicion)
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
        }
        else if(isVacia())
        {
            System.out.println("Lista vacia, no es posible esta operacion");
        }
        else if(posicion < 0 || this.Tamanio() < posicion)
        {
            System.out.println("Posicion fuera del dominio");
        }
    }
    
    public void imprimeTodo()
    {
        this.inicializaRecorrido();
        System.out.println("this.apuntador = " + this.apuntador);
        
        if(!this.isVacia())
        {
            while(!this.esUltimo(apuntador))
            {
                this.apuntador = this.apuntador.getSiguiente();
                System.out.println("this.apuntador = " + this.apuntador);
            }                  
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
            this.primero = this.ultimo = new Nodo(); // Aqui creamos el primer nodo
            this.primero.setIndiceNodo(contadorNodos++); // Aumento en Pos-Order
            this.vacia = false; // y estableciendo una lista NO vacia
        }
        else
        {
            this.apuntaAlUltimo();
            this.apuntador.setSiguiente(new Nodo());
            this.apuntador.getSiguiente().setIndiceNodo(contadorNodos++); // Aumento Pos-Order
            this.ultimo = this.apuntador.getSiguiente();
            this.vacia = false;
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
            this.primero = this.apuntador;
            this.apuntador.setSiguiente(auxiliar); // se reapunto
            this.apuntador.setIndiceNodo(posicion);
            this.recorreIndices(posicion);
            this.apuntaAlUltimo();
            this.ultimo = this.apuntador; // reapunta el ultimoNodo
            this.contadorNodos++;
            this.vacia = false;
        }
        else if(0 < posicion && posicion < this.Tamanio())
        {
            this.buscaAnterior(posicion);
            //var auxiliar1 = this.apuntador; // guarda Nodo Anterior
            var auxiiar2 = this.apuntador.getSiguiente(); // nodo siguiente que se recorrera
            this.apuntador.setSiguiente(new Nodo());    // inserta nuevo
            this.apuntador = this.apuntador.getSiguiente(); // avanza
            this.apuntador.setIndiceNodo(posicion);
            this.apuntador.setSiguiente(auxiiar2);
            this.recorreIndices(posicion);
            this.contadorNodos++;
            this.vacia = false;
        }
        else
        {
            System.out.println("Posicion fuera del dominio, OPERACION IMPOSIBLE");
        }
    }
    
    public void insertaNodo(int posicion,Object objeto, String nombre, String apellidoPaterno,
                String apellidoMaterno, byte edad )
    {
        if(isVacia() && posicion == 0) // lista VACIA
        { 
            this.insertaNodo(objeto, nombre, apellidoPaterno, apellidoMaterno, edad);
        }
        else if(!isVacia() && posicion == 0) // lista NO VACIA
        {
            this.inicializaRecorrido();
            var auxiliar = this.apuntador; 
            this.apuntador = new Nodo(objeto, nombre, apellidoPaterno, apellidoMaterno, edad); 
            this.primero = this.apuntador;
            this.apuntador.setSiguiente(auxiliar); // se reapunto
            this.apuntador.setIndiceNodo(posicion);
            this.recorreIndices(posicion);
            this.apuntaAlUltimo();
            this.ultimo = this.apuntador; // reapunta el ultimoNodo
            this.contadorNodos++;
            this.vacia = false;
        }
        else if(0 < posicion && posicion < this.Tamanio())
        {
            this.buscaAnterior(posicion);
            //var auxiliar1 = this.apuntador; // guarda Nodo Anterior
            var auxiiar2 = this.apuntador.getSiguiente(); // nodo siguiente que se recorrera
            this.apuntador.setSiguiente(new Nodo(objeto, nombre, apellidoPaterno, apellidoMaterno, edad));    // inserta nuevo
            this.apuntador = this.apuntador.getSiguiente(); // avanza
            this.apuntador.setIndiceNodo(posicion);
            this.apuntador.setSiguiente(auxiiar2);
            this.recorreIndices(posicion);
            this.contadorNodos++;
            this.vacia = false;
        }
        else
        {
            System.out.println("Posicion fuera del dominio, OPERACION IMPOSIBLE");
        }        
    }
    
    public void insertaNodo(Object objeto, String nombre, String apellidoPaterno,
                String apellidoMaterno, byte edad)
    {
        if(isVacia())
        {
            this.primero = this.ultimo = new Nodo(objeto, nombre, apellidoPaterno, apellidoMaterno, edad);
            this.primero.setIndiceNodo(this.contadorNodos++);
            this.vacia = false;
        }
        else
        {
            this.apuntaAlUltimo();
            this.apuntador.setSiguiente(new Nodo(objeto, nombre, apellidoPaterno, apellidoMaterno, edad));
            this.apuntador = this.apuntador.getSiguiente();
            this.apuntador.setIndiceNodo(this.contadorNodos++);
            this.ultimo = this.apuntador;
            this.vacia = false;
        }
    }
    
    private void recorreIndices(int posicion) // Recorre de forma
    {
        this.inicializaRecorrido();
        while(0 <= posicion && posicion < this.contadorNodos && (!esUltimo(this.apuntador)))
        {
               if( this.apuntador.getIndiceNodo() == this.apuntador.getSiguiente().getIndiceNodo()
                       || this.apuntador.getIndiceNodo() > posicion)
               {
                   this.apuntador = this.apuntador.getSiguiente(); // avanzo al nodo duplicado o desfasado
                   var nuevoIndice = this.apuntador.getIndiceNodo() + 1;
                   this.apuntador.setIndiceNodo(nuevoIndice);
               }
               else
                    this.apuntador = this.apuntador.getSiguiente(); // avanza
        }
    }
    
    private void retrocedeIndices(int posicion) 
    {
        if(!isVacia())
        {
            this.inicializaRecorrido();
            while(this.apuntador != null) // recorre hasta llegar al nodo ultimo.siguiente = null
            {
                if(posicion <= this.apuntador.getIndiceNodo())
                    this.apuntador.setIndiceNodo(this.apuntador.getIndiceNodo() - 1);
                this.apuntador = this.apuntador.getSiguiente();
            }
        }
    }    
    
    public void remueveUltimoNodo()
    {
        if(!isVacia())
        {
            this.inicializaRecorrido();
            if(this.apuntador == this.ultimo)
            {
                this.apuntador = this.primero = this.ultimo = null;
                this.vacia = true;
            }
            else
            {
                while(!this.esUltimo(this.apuntador.getSiguiente()) && !this.esUltimo(this.apuntador))
                {
                    this.apuntador = this.apuntador.getSiguiente();
                }            
                this.apuntador.setSiguiente(null);
                this.ultimo = this.apuntador;     
                this.vacia = false;
            }
            this.contadorNodos--;
        }
        else
        {
            System.out.println("Operacion imposible. contadorNodos = " + this.contadorNodos);
        }
    }
    
    public void remuevePrimerNodo()
    {
        if(!isVacia() && this.contadorNodos == 1)
        {
            this.primero = this.ultimo = null;
            this.contadorNodos--;
            this.vacia = true;
            this.ordenada = null;
        }
        else if(!isVacia() && 1 < this.contadorNodos)
        {
            this.primero = this.primero.getSiguiente();
            this.contadorNodos--;
            this.vacia = false;
            this.retrocedeIndices(this.primero.getIndiceNodo());
            this.ordenada = true;
        }
    }
    
    public void remueveNodo(int posicion)
    {
        if(!isVacia() && 0 <= posicion && posicion < this.Tamanio()) // evita ejecutarse y errores de NullPointerException
        {
            if( posicion == 0)
                this.remuevePrimerNodo();
            else if( posicion == this.ultimo.getIndiceNodo())
                this.remueveUltimoNodo();
            else
            {
                this.buscaNodo(posicion + 1);
                var auxiliar = this.apuntador;
                this.buscaAnterior(posicion);
                this.apuntador.setSiguiente(auxiliar);
                this.retrocedeIndices(posicion + 1);
                this.contadorNodos--;
            }
        }
        else
            System.out.println("OPERACION IMPOSIBLE, revise posicion y tamaño de la lista");
    }
    
    public void modificaDatos(int posicion,Object objeto, String nombre, 
            String apellidoPaterno, String apellidoMaterno, byte edad)
    {
        if(0 <= posicion && posicion < this.Tamanio())
        {
            this.buscaNodo(posicion);
            this.apuntador.setObjeto(objeto);
            this.apuntador.setNombre(nombre);
            this.apuntador.setApellidoPaterno(apellidoPaterno);
            this.apuntador.setApellidoMaterno(apellidoMaterno);
            this.apuntador.setEdad(edad);
        }
        else
            System.out.println("OPERACION IMPOSIBLE, revise la posicion y tamaño de lista");
    }
     public void modificaDatos(int posicion,String nombre, 
            String apellidoPaterno, String apellidoMaterno, byte edad)
    {
        if(0 <= posicion && posicion < this.Tamanio())
        {
            this.buscaNodo(posicion);
            this.apuntador.setNombre(nombre);
            this.apuntador.setApellidoPaterno(apellidoPaterno);
            this.apuntador.setApellidoMaterno(apellidoMaterno);
            this.apuntador.setEdad(edad);
        }
        else
            System.out.println("OPERACION IMPOSIBLE, revise la posicion y tamaño de lista");
    }   
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista{nodoInicial=").append(this.primero);
        sb.append(", apuntador=").append(this.apuntador);
        sb.append(", ultimoNodo=").append(this.ultimo);
        sb.append(", contadorNodos=").append(this.contadorNodos);
        sb.append(", vacia=").append(this.vacia);
        sb.append(", ordenada=").append(this.ordenada);
        sb.append('}');
        return sb.toString();
    }
    
}
