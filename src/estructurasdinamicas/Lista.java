
package estructurasdinamicas;
// GITHUB: Cogar98
// IMPORTANTE
// LOS METODOS QUE RECIBEN PARAMETRO NODO FUNCIONAN UNICAMENTE CON REFERENCIA EN MEMORIA
// LOS METODOS QUE UTILIZAN POSICION FUNCIONAN CON EL INDICE DEL NODO SUPONIENDO QUE ESTE ORDENADA
public class Lista {
    // ATRIBUTOS Y OBJETOS
    private Nodo primero;
    private Nodo apuntador;
    private Nodo ultimo;
    private int contadorNodos; // tamaño = indice + 1 
    private int magnitud; // SIEMPRE magnitud = contadorNodos - 1 [0,n] 
    private boolean vacia = true; // valor inicial
    private Boolean ordenada; // indica si esta ordenada o no lo esta [true / false / null] null si no tiene nodos

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
    
    // CLASES
    
    private Lista(Nodo primero, Nodo ultimo, int contadorNodos)
    { // ES PRIVADO PORQUE FUNCIONA SOLO PARA METODOS QUE RECIBAN COMO PARAMETRO NODO
        this.primero = primero;
        this.ultimo = ultimo;
        this.contadorNodos = contadorNodos;
    }

    // METODOS
    public Boolean revisaOrden() // | True | False | Null |
    {
        if(!isVacia())  // valida que no sea lista vacia
        {
            this.inicializaRecorrido();
            while(!this.esUltimo(this.apuntador))
            {
                if(this.apuntador.getIndiceNodo() != this.apuntador.getSiguiente().getIndiceNodo() - 1)
                    return this.ordenada = false;
                else
                    this.avanzaApuntador();
            }
            return this.ordenada = true;
        }
        return this.ordenada = null;
    }

    private boolean esUltimo(Nodo nodo)
     {
         if(nodo != null && nodo.getSiguiente() == null && !isVacia()) // Valida que estemos en el ultimo nodo
             return true;              // true = ultimo y false = es cualquier otro nodo
         return false;
     }
    
    private boolean tieneSiguiente(Nodo nodo)
     {
         if(nodo.getSiguiente() != null) // Valida que el nodo posea un siguiente
             return true;              // true = si tiene enlace
         return false;  // false = no tiene un nodo siguiente
     }    
     
    private void inicializaRecorrido()
    {
        this.apuntador = this.primero;
    }
    
    private void avanzaApuntador()
    {
        this.apuntador = this.apuntador.getSiguiente();
    }
            
    private void apuntaAlUltimo()
    {
        this.inicializaRecorrido();
        while(!this.esUltimo(this.apuntador))
        {
            this.avanzaApuntador();
        }
    }
    
    public void buscaNodo(int posicion)
    {
        this.inicializaRecorrido();
        while( (!this.esUltimo(this.apuntador)) && (this.apuntador.getIndiceNodo() != posicion) )
        {
            this.avanzaApuntador();
        }
    }
    
    public void buscaNodo(Nodo nodo)
    {
        if(!isVacia())
        {
            this.inicializaRecorrido();
            do
            {
                if(this.apuntador == nodo)
                    break;
                this.avanzaApuntador();
            }while(!this.esUltimo(this.apuntador));
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
                this.avanzaApuntador();
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
    
    public void buscaAnterior(Nodo nodo)
    {
        if(!isVacia() && 1 < this.contadorNodos)
        {
            this.inicializaRecorrido();
            while(this.apuntador.getSiguiente() != null)
            {
                if(this.apuntador == this.primero && this.apuntador == nodo)
                {
                    System.out.println("OPERACION IMPOSIBLE, el nodo es el primero de la lista");
                    break;
                }
                else if(this.apuntador.getSiguiente() == nodo)
                    break;
                else
                    this.avanzaApuntador();
            }   // al romper el ciclo, this.apuntador es el nodo anterior
        }
    }
    
    public void eliminaSiguiente(Nodo nodo)
    {
        if(!this.esUltimo(nodo))
            nodo.setSiguiente(null);
    }
    
    public void imprimeTodo()
    {
        this.inicializaRecorrido();
        System.out.println("this.apuntador = " + this.apuntador);
        
        if(!this.isVacia())
        {
            while(!this.esUltimo(apuntador))
            {
                this.avanzaApuntador();
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
            this.ordenada = true;
        }
        else
        {
            //this.apuntaAlUltimo();
            this.apuntador = this.ultimo;
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
           // this.apuntaAlUltimo();
            //this.ultimo = this.apuntador; // reapunta el ultimoNodo
            this.contadorNodos++;
            this.vacia = false;
        }
        else if(0 < posicion && posicion < this.Tamanio())
        {
            this.buscaAnterior(posicion);
            //var auxiliar1 = this.apuntador; // guarda Nodo Anterior
            var auxiiar2 = this.apuntador.getSiguiente(); // nodo siguiente que se recorrera
            this.apuntador.setSiguiente(new Nodo());    // inserta nuevo
            this.avanzaApuntador(); // avanza
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
    //    if( 0<= posicion && posicion <= this.contadorNodos - 1 || posicion == 0 && this.contadorNodos == 0)
            this.insertaNodo(posicion, new Nodo(objeto, nombre, apellidoPaterno, apellidoMaterno, edad));
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
            this.avanzaApuntador();
            this.apuntador.setIndiceNodo(this.contadorNodos++);
            this.ultimo = this.apuntador;
            this.vacia = false;
        }
    }
    
    private void insertaNodo(int posicion, Nodo nodo)
    {
        if(isVacia() && posicion == 0)
        {
            this.insertaNodo(nodo);
        }
        else if(!isVacia() && posicion == 0)
        {
            byte contadorPosicion = 0;
            var auxiliar = this.primero;
            this.primero = nodo;
            this.primero.setIndiceNodo(0);
            this.primero.setSiguiente(auxiliar);
            this.apuntador = this.primero.getSiguiente();
             // reordena los indices
             while(this.apuntador != null)
             {
                if(posicion <= this.apuntador.getIndiceNodo())
                    this.apuntador.setIndiceNodo(1 + contadorPosicion);
                contadorPosicion++;
                this.avanzaApuntador();
             }
            this.contadorNodos++;
            this.ordenada = true;
        }
        else if(!isVacia() && 0 < posicion && posicion < this.Tamanio())
        {
            byte contadorPosicion , contadorBusqueda;
            contadorPosicion = contadorBusqueda = 0;
            
            this.inicializaRecorrido();
            do
            {   // Este ciclo encuentra al nodo en la posicion que se necesita recorrer
                if(contadorPosicion == posicion)
                    break;
                this.avanzaApuntador();
                contadorPosicion++;
            }while(this.tieneSiguiente(this.apuntador));

            var auxiliar = this.apuntador; // se guarda el nodo que se recorrera 
            this.inicializaRecorrido();

            do
            {   // Este ciclo me posiciona en el nodo anterior para la insercion
                if(contadorBusqueda == contadorPosicion - 1)
                    break;
                this.avanzaApuntador();
                contadorBusqueda++;
            }while(this.tieneSiguiente(this.apuntador));
            
            this.apuntador.setSiguiente(nodo);
            this.apuntador.getSiguiente().setIndiceNodo(posicion);
            this.avanzaApuntador();
            this.apuntador.setSiguiente(auxiliar);
            // reordenamiento de los indices
            do
            {
                if(this.apuntador.getSiguiente().getIndiceNodo() != this.apuntador.getIndiceNodo() + 1)
                    this.apuntador.getSiguiente().setIndiceNodo(++contadorPosicion);
                this.avanzaApuntador();
            }while(!this.esUltimo(this.apuntador));
            this.contadorNodos++;
            this.ordenada = true;
        }
        else if(!isVacia() && this.Tamanio() == posicion)
        {
            this.insertaNodo(nodo);
        }
        else
        {
            System.out.println("OPERACION IMPOSIBLE, posicion deseada: " + posicion
            + " | Tamaño de lista: " + this.Tamanio());
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
                   this.avanzaApuntador(); // avanzo al nodo duplicado o desfasado
                   var nuevoIndice = this.apuntador.getIndiceNodo() + 1;
                   this.apuntador.setIndiceNodo(nuevoIndice);
               }
               else
                    this.avanzaApuntador(); // avanza
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
                this.avanzaApuntador();
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
                    this.avanzaApuntador();
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
     
     //                     IMPORTANTE!!
     // LOS SIGUIENTES METODOS ARRIESGAN EL ORDEN DE LA LISTA
     // La utilizacion de la variable ordenada sera indispensable
     
     // -----ALGORITMOS DE ORDENAMIENTO
     // NOTESE QUE EN EL NOMBRE EL LA LETRA A = ASCENDENTE  Y D = DESCENDENTE
     
     private void intercambiaNodos(Lista lista,Nodo a, Nodo b)
     {
         // primero debemos verificar cual de los nodos a y b esta antes que el otro
         Nodo auxiliar;
         
         lista.inicializaRecorrido();
         while(!lista.esUltimo(lista.apuntador))
         {
             if(lista.apuntador == a || lista.apuntador == b)
                 break;
             lista.avanzaApuntador();
         }
         auxiliar = a;
         a = lista.apuntador == a ? a : b ; // si encontre primero al nodo a se queda igual, caso contrario vale b
         b = lista.apuntador == b ? auxiliar : b ; // si encontre a b hace un momento entonces b vale el auxiliar = a
         // este codigo anterior lo hice para verificar el orden de los nodos al ingresarlos
         
         if( a == lista.primero || b == lista.primero )
         {
             Nodo target = a == lista.primero ? b : a;
             auxiliar = lista.primero.getSiguiente();
             
             lista.buscaAnterior(target);
             lista.apuntador.setSiguiente(lista.primero);
             lista.avanzaApuntador();
             lista.apuntador.setSiguiente(target.getSiguiente()); // asigna "a" o "b" si comparten referencia del primero
             lista.primero = target;
             lista.primero.setSiguiente(auxiliar);
             System.out.println("FUNCIONA EL INTERCAMBIO");
         }
         else
         {
             auxiliar = a.getSiguiente();
             lista.buscaAnterior(b);
             lista.apuntador.setSiguiente(a);
             a.setSiguiente(b.getSiguiente());
             lista.buscaAnterior(a);
             b.setSiguiente(auxiliar);
             lista.apuntador.setSiguiente(b);
             System.out.println("INTERCAMBIO NO PRIMERO FUNCIONA");
         }
     }
     
     public void ordenEdadAIntercambio() // ordenamiento por edad Ascendente por metodo de intercambio
     {
      if(!isVacia())
      {
          int j,i;
          this.inicializaRecorrido();
          Nodo auxiliar1 = this.primero;
          
          for(j = 0 ; j < this.magnitud ; j++)
          {
              for( i = j + 1  ; i <= this.magnitud ; i++)
              {
                  if( auxiliar1.getEdad() > this.apuntador.getEdad())
                  {
                      this.intercambiaNodos(this , auxiliar1 , this.apuntador);
                  }
              }
          }
      }
      else
             System.out.println("Lista vacia cantidad de nodos: " + this.contadorNodos);
     }
     
     private Lista ordenamientoIntercambio(Lista lista, Object objeto)
     {
         
         return lista;
     }
     
     public void ordenEdadDIntercambio() // ordenamiento por edad Descendente por metodo de intercambio
     {
         
     }
     
     // GETTERS Y SETTERS
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
   
    public boolean isOrdenada()  {
        return ordenada;
    }
    
    private void insertaNodo(Nodo nuevoNodo) { // inserta al final
        // Valida que solo tengamos un nodo a insertar sin enlace a siguiente
        if(this.tieneSiguiente(nuevoNodo))
            this.eliminaSiguiente(nuevoNodo);
        // Insercion
        if(isVacia())
        {
            this.primero = this.ultimo = nuevoNodo;
            this.primero.setIndiceNodo(this.magnitud = this.contadorNodos++);
        }
        else if(!isVacia() && this.contadorNodos == 1)
        {
            this.primero.setSiguiente(nuevoNodo);
            this.ultimo = this.primero.getSiguiente();
            this.ultimo.setIndiceNodo(this.magnitud = contadorNodos++);
        }
        else
        {
            if(this.esUltimo(this.ultimo))
            {
                this.ultimo.setSiguiente(nuevoNodo);
                this.ultimo = this.ultimo.getSiguiente();
                this.ultimo.setIndiceNodo(this.magnitud = this.contadorNodos++);
            }
        }
    }
    
    public void prueba()
    {
        this.buscaNodo(3);
        var aux1 = this.apuntador;
        this.buscaNodo(6);
        var aux2 = this.apuntador;
        this.intercambiaNodos(this, aux1, aux2);
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
