package nosso.almoco;

public class PlatoNodo {

    PlatoNodo hijoIzquierdo;
    PlatoNodo hijoDerecho;
    PlatoNodo padre;
    int altura = 1;
    String nombrePlatos;
    int codigoPlatos;
    int codigoCategoriaplato;
    String nombreCategoriaPlato;
    String descripcion;
    int precio;
    boolean contornos;

    public PlatoNodo(String nombrePlatos, int codigoPlatos, int codigoCategoriaplato, String nombreCategoriaPlato,String descripcion, int precio, boolean contornos) {
        this.nombrePlatos = nombrePlatos;
        this.codigoPlatos = codigoPlatos;
        this.codigoCategoriaplato = codigoCategoriaplato;
        this.nombreCategoriaPlato = nombreCategoriaPlato;
        this.descripcion = descripcion;
        this.precio = precio;
        this.contornos = contornos;
    }

}
