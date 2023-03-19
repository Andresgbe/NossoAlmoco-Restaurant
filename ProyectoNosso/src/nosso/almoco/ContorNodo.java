package nosso.almoco;

public class ContorNodo {

    ContorNodo hijoIzquierdo;
    ContorNodo hijoDerecho;
    ContorNodo padre;
    int altura = 1;
    int codigo;
    String nombreContor;

    ContorNodo (int val,String nombreContorno) {
        this.codigo = val;
        this.nombreContor=nombreContorno;
    }
}

