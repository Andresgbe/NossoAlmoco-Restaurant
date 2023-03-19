package nosso.almoco;

import java.util.Scanner;

public class ArbolCarta {
	Scanner leer= new Scanner(System.in);
	Scanner leer2= new Scanner(System.in);

    private int altura (CartaNodo N) {
        if (N == null)
             return 0;
        return N.altura;
    }
    
    
    CartaNodo insertarPlatoCarta(CartaNodo node, int codigoPlato,String nombrePlato,String nombreCategoriaPlato, int codigoCategoriaplato, int precio, boolean contornos, String descripcion) {
           
            if (node == null) {
                return(new CartaNodo(nombrePlato,codigoPlato,codigoCategoriaplato,nombreCategoriaPlato,descripcion,precio,contornos));}
    
            if (codigoPlato < node.codigoPlatos)
                node.hijoIzquierdo  = insertarPlatoCarta(node.hijoIzquierdo, codigoPlato,nombrePlato, nombreCategoriaPlato,codigoCategoriaplato,precio,contornos,descripcion);
            else
                node.hijoDerecho = insertarPlatoCarta(node.hijoDerecho, codigoPlato,nombrePlato, nombreCategoriaPlato,codigoCategoriaplato,precio,contornos,descripcion);
    
            node.altura = Math.max(altura(node.hijoIzquierdo), altura(node.hijoDerecho)) + 1;
           
            int balance = obtenerBalance(node);
    
            if (balance > 1 && codigoPlato < node.hijoIzquierdo.codigoPlatos)
                return rotacionDerecha(node);
    
           
            if (balance < -1 && codigoPlato > node.hijoDerecho.codigoPlatos)
                return rotacionIzquierda(node);
    
           
            if (balance > 1 && codigoPlato > node.hijoIzquierdo.codigoPlatos){
                node.hijoIzquierdo =  rotacionIzquierda(node.hijoIzquierdo);
                return rotacionDerecha(node);
            }
    
            if (balance < -1 && codigoPlato < node.hijoDerecho.codigoPlatos){
                node.hijoDerecho = rotacionDerecha(node.hijoDerecho);
                return rotacionIzquierda(node);
            }
    
            
        return node;
    }
    
    
    
    
    
    private CartaNodo rotacionDerecha(CartaNodo y) {
    		CartaNodo x = y.hijoIzquierdo;
    		CartaNodo T2 = x.hijoDerecho;
    
           
            x.hijoDerecho = y;
            y.hijoIzquierdo = T2;
    
    
            y.altura = Math.max(altura(y.hijoIzquierdo), altura(y.hijoDerecho))+1;
            x.altura = Math.max(altura(x.hijoIzquierdo), altura(x.hijoDerecho))+1;
    
            return x;
    }
    
    private CartaNodo rotacionIzquierda(CartaNodo x) {
    		CartaNodo y = x.hijoDerecho;
            CartaNodo T2 = y.hijoIzquierdo;
    
           
            y.hijoIzquierdo = x;
            x.hijoDerecho = T2;
    
          
            x.altura = Math.max(altura(x.hijoIzquierdo), altura(x.hijoDerecho))+1;
            y.altura = Math.max(altura(y.hijoIzquierdo), altura(y.hijoDerecho))+1;
    
          
            return y;
    }
    
     
    private int obtenerBalance(CartaNodo N) {
        if (N == null)
            return 0;
        return altura(N.hijoIzquierdo) - altura(N.hijoDerecho);
    }
    
    public void inOrderPlatosCarta(CartaNodo raiz) {
        if (raiz != null) {
            inOrderPlatosCarta(raiz.hijoIzquierdo);
            System.out.println("| " + raiz.nombrePlatos + "\t | " + raiz.codigoPlatos + "\t\t | " + raiz.nombreCategoriaPlato + "\t | " + raiz.descripcion + "\t\t| " + raiz.precio + "\t\t | " + raiz.contornos + "\t\t|");
            inOrderPlatosCarta(raiz.hijoDerecho);
        }
    }
    
    private CartaNodo nodoConMinValorPlatosMenuDia(CartaNodo node) {
		CartaNodo current = node;
        while (current.hijoIzquierdo != null)
            current = current.hijoIzquierdo;
        return current;
    }
    
    
    CartaNodo eliminarNodoMenuDia(CartaNodo menuDiaAVL, int value) {
           
    
            if (menuDiaAVL == null)
                return menuDiaAVL;
    
            if ( value < menuDiaAVL.codigoPlatos )
                menuDiaAVL.hijoIzquierdo = eliminarNodoMenuDia(menuDiaAVL.hijoIzquierdo, value);
    
            
            else if( value > menuDiaAVL.codigoPlatos )
                menuDiaAVL.hijoDerecho = eliminarNodoMenuDia(menuDiaAVL.hijoDerecho, value);
    
           
            else {
               
                if( (menuDiaAVL.hijoIzquierdo == null) || (menuDiaAVL.hijoDerecho == null) ) {
    
                	CartaNodo temp;
                    if (menuDiaAVL.hijoIzquierdo != null)
                            temp = menuDiaAVL.hijoIzquierdo;
                    else
                        temp = menuDiaAVL.hijoDerecho;
    
                  
                    if(temp == null) {
                        temp = menuDiaAVL;
                        menuDiaAVL = null;
                    }
                    else 
                        menuDiaAVL = temp; 
    
                    temp = null;
                }
                else {
                    
                	CartaNodo temp = nodoConMinValorPlatosMenuDia(menuDiaAVL.hijoDerecho);
    
                    
                    menuDiaAVL.codigoPlatos = temp.codigoPlatos;
    
                    
                    menuDiaAVL.hijoDerecho = eliminarNodoMenuDia(menuDiaAVL.hijoDerecho, temp.codigoPlatos);
                }
            }
    
           
            if (menuDiaAVL == null)
                return menuDiaAVL;
    
           
            menuDiaAVL.altura = Math.max(altura(menuDiaAVL.hijoIzquierdo), altura(menuDiaAVL.hijoDerecho)) + 1;
    
            
            int balance = obtenerBalance(menuDiaAVL);
    
          
    
           
            if (balance > 1 && obtenerBalance(menuDiaAVL.hijoIzquierdo) >= 0)
                return rotacionDerecha(menuDiaAVL);
    
            
            if (balance > 1 && obtenerBalance(menuDiaAVL.hijoIzquierdo) < 0) {
                menuDiaAVL.hijoIzquierdo =  rotacionIzquierda(menuDiaAVL.hijoIzquierdo);
                return rotacionDerecha(menuDiaAVL);
            }
    
           
            if (balance < -1 && obtenerBalance(menuDiaAVL.hijoDerecho) <= 0)
                return rotacionIzquierda(menuDiaAVL);
    
           
            if (balance < -1 && obtenerBalance(menuDiaAVL.hijoDerecho) > 0) {
                menuDiaAVL.hijoDerecho = rotacionDerecha(menuDiaAVL.hijoDerecho);
                return rotacionIzquierda(menuDiaAVL);
            }
    
            return menuDiaAVL;
}

CartaNodo eliminarNodoMenuDiaCate(CartaNodo menuDiaAVL, int value) {
           
    
    if (menuDiaAVL == null)
        return menuDiaAVL;

    if ( value < menuDiaAVL.codigoCategoriaplato )
        menuDiaAVL.hijoIzquierdo = eliminarNodoMenuDiaCate(menuDiaAVL.hijoIzquierdo, value);

    
    else if( value > menuDiaAVL.codigoCategoriaplato )
        menuDiaAVL.hijoDerecho = eliminarNodoMenuDiaCate(menuDiaAVL.hijoDerecho, value);

   
    else {
       
        if( (menuDiaAVL.hijoIzquierdo == null) || (menuDiaAVL.hijoDerecho == null) ) {

        	CartaNodo temp;
            if (menuDiaAVL.hijoIzquierdo != null)
                    temp = menuDiaAVL.hijoIzquierdo;
            else
                temp = menuDiaAVL.hijoDerecho;

          
            if(temp == null) {
                temp = menuDiaAVL;
                menuDiaAVL = null;
            }
            else 
                menuDiaAVL = temp; 

            temp = null;
        }
        else {
            
        	CartaNodo temp = nodoConMinValorPlatosMenuDia(menuDiaAVL.hijoDerecho);

            
            menuDiaAVL.codigoCategoriaplato = temp.codigoCategoriaplato;

            
            menuDiaAVL.hijoDerecho = eliminarNodoMenuDiaCate(menuDiaAVL.hijoDerecho, temp.codigoCategoriaplato);
        }
    }

   
    if (menuDiaAVL == null)
        return menuDiaAVL;

   
    menuDiaAVL.altura = Math.max(altura(menuDiaAVL.hijoIzquierdo), altura(menuDiaAVL.hijoDerecho)) + 1;

    
    int balance = obtenerBalance(menuDiaAVL);

  

   
    if (balance > 1 && obtenerBalance(menuDiaAVL.hijoIzquierdo) >= 0)
        return rotacionDerecha(menuDiaAVL);

    
    if (balance > 1 && obtenerBalance(menuDiaAVL.hijoIzquierdo) < 0) {
        menuDiaAVL.hijoIzquierdo =  rotacionIzquierda(menuDiaAVL.hijoIzquierdo);
        return rotacionDerecha(menuDiaAVL);
    }

   
    if (balance < -1 && obtenerBalance(menuDiaAVL.hijoDerecho) <= 0)
        return rotacionIzquierda(menuDiaAVL);

   
    if (balance < -1 && obtenerBalance(menuDiaAVL.hijoDerecho) > 0) {
        menuDiaAVL.hijoDerecho = rotacionDerecha(menuDiaAVL.hijoDerecho);
        return rotacionIzquierda(menuDiaAVL);
    }

    return menuDiaAVL;
}



public void ModificarCateCarta(CartaNodo raiz,String nombreCate, String nuevoNombre) {
    if (raiz != null) {
    	ModificarCateCarta(raiz.hijoIzquierdo,nombreCate, nuevoNombre);

        if(raiz.nombreCategoriaPlato==nombreCate){
            raiz.nombreCategoriaPlato=nuevoNombre;
        }
        ModificarCateCarta(raiz.hijoDerecho,nombreCate, nuevoNombre);
     }
}


    boolean existePlatoCarta(CartaNodo menuDiaAVL, int codigoPlatos) {
    
        boolean found = false;
            
            while ((menuDiaAVL != null) && !found) {
                int rval = menuDiaAVL.codigoPlatos;
                if (menuDiaAVL.codigoPlatos < rval)
                    menuDiaAVL = menuDiaAVL.hijoIzquierdo;
                else if (menuDiaAVL.codigoPlatos > rval)
                    menuDiaAVL = menuDiaAVL.hijoDerecho;
                else {
                    found = true;
                    break;
                }
                found = existePlatoCarta(menuDiaAVL,codigoPlatos);
            }
            return found;
    }  
}
