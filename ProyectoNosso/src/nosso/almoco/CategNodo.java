package nosso.almoco;

public class CategNodo {

    CategNodo hijoIzquierdo;
    CategNodo hijoDerecho;
    CategNodo padre;
    int altura = 1;
    int codigo;
    String nombreCate;

    CategNodo (int val,String nombreCate) {
        this.codigo = val;
        this.nombreCate=nombreCate;
    }
}

