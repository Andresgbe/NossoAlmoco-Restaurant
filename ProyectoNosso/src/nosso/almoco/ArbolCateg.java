package nosso.almoco;

public class ArbolCateg {

	private int altura (CategNodo N) {
		if (N == null)
			return 0;
		return N.altura;
	}


	CategNodo insertarCategoria(CategNodo node, int value,String nombre) {
       
        if (node == null) {
            return(new CategNodo(value,nombre));}

        if (value < node.codigo)
            node.hijoIzquierdo  = insertarCategoria(node.hijoIzquierdo, value,nombre);
        else
            node.hijoDerecho = insertarCategoria(node.hijoDerecho, value,nombre);

        node.altura = Math.max(altura(node.hijoIzquierdo), altura(node.hijoDerecho)) + 1;
       
        int balance = obtenerBalance(node);

        if (balance > 1 && value < node.hijoIzquierdo.codigo)
            return rotacionDerecha(node);

       
        if (balance < -1 && value > node.hijoDerecho.codigo)
            return rotacionIzquierda(node);

       
        if (balance > 1 && value > node.hijoIzquierdo.codigo){
            node.hijoIzquierdo =  rotacionIzquierda(node.hijoIzquierdo);
            return rotacionDerecha(node);
        }

        if (balance < -1 && value < node.hijoDerecho.codigo){
            node.hijoDerecho = rotacionDerecha(node.hijoDerecho);
            return rotacionIzquierda(node);
        }
        
        return node;
	}


	private CategNodo rotacionDerecha(CategNodo y) {
		CategNodo x = y.hijoIzquierdo;
        CategNodo T2 = x.hijoDerecho;
       
        x.hijoDerecho = y;
        y.hijoIzquierdo = T2;

        y.altura = Math.max(altura(y.hijoIzquierdo), altura(y.hijoDerecho))+1;
        x.altura = Math.max(altura(x.hijoIzquierdo), altura(x.hijoDerecho))+1;

        return x;
	}

	private CategNodo rotacionIzquierda(CategNodo x) {
		CategNodo y = x.hijoDerecho;
        CategNodo T2 = y.hijoIzquierdo;
      
        y.hijoIzquierdo = x;
        x.hijoDerecho = T2;
      
        x.altura = Math.max(altura(x.hijoIzquierdo), altura(x.hijoDerecho))+1;
        y.altura = Math.max(altura(y.hijoIzquierdo), altura(y.hijoDerecho))+1;

      
        return y;
	}


	private int obtenerBalance(CategNodo N) {
		if (N == null)
			return 0;
		return altura(N.hijoIzquierdo) - altura(N.hijoDerecho);
	}

	void inOrder(CategNodo raiz) {
		if (raiz != null) {
			inOrder(raiz.hijoIzquierdo);
			System.out.println("| " + raiz.nombreCate + "\t | " + raiz.codigo + "\t\t|");
			inOrder(raiz.hijoDerecho);
		}
	}

	private CategNodo nodoConMinValor(CategNodo node) {
		CategNodo current = node;
	    while (current.hijoIzquierdo != null)
	        current = current.hijoIzquierdo;
	    return current;
	}


	CategNodo eliminarNodo(CategNodo raiz, int codeina) {
       
        if (raiz == null) {
            return raiz;
        }
        if ( codeina < raiz.codigo ) {
            raiz.hijoIzquierdo = eliminarNodo(raiz.hijoIzquierdo, codeina);
        }
        
        else if( codeina > raiz.codigo ) {
            raiz.hijoDerecho = eliminarNodo(raiz.hijoDerecho, codeina);
        }
       
        else {
           
            if( (raiz.hijoIzquierdo == null) || (raiz.hijoDerecho == null) ) {
            	CategNodo Naux = null; //Nodo Auxiliar
            	
                if (raiz.hijoIzquierdo != null) {
                        Naux = raiz.hijoIzquierdo;
                }
                else if (raiz.hijoDerecho != null) {
                    Naux = raiz.hijoDerecho;
                }
              
                if(Naux == null) {
                    Naux = raiz;
                    raiz = null;
                }
                else 
                    raiz = Naux; 

                Naux = null;
            }
            else {
                
            	CategNodo temp = nodoConMinValor(raiz.hijoDerecho);

                
                raiz.codigo = temp.codigo;

                
                raiz.hijoDerecho = eliminarNodo(raiz.hijoDerecho, temp.codigo);
            }
        }

       //Despues de eliminar
        if (raiz == null)
            return raiz;
       
        raiz.altura = Math.max(altura(raiz.hijoIzquierdo), altura(raiz.hijoDerecho)) + 1;

        
        int balance = obtenerBalance(raiz);      

       
        if (balance > 1 && obtenerBalance(raiz.hijoIzquierdo) >= 0)
            return rotacionDerecha(raiz);

        
        if (balance > 1 && obtenerBalance(raiz.hijoIzquierdo) < 0) {
            raiz.hijoIzquierdo =  rotacionIzquierda(raiz.hijoIzquierdo);
            return rotacionDerecha(raiz);
        }

       
        if (balance < -1 && obtenerBalance(raiz.hijoDerecho) <= 0)
            return rotacionIzquierda(raiz);

       
        if (balance < -1 && obtenerBalance(raiz.hijoDerecho) > 0) {
            raiz.hijoDerecho = rotacionDerecha(raiz.hijoDerecho);
            return rotacionIzquierda(raiz);
        }

        return raiz;
}

CategNodo buscarCategoria(int codigo ,CategNodo categoriasAVL) {
    if(categoriasAVL==null) {
        return null;
    }else if (categoriasAVL.codigo==codigo) {
        return categoriasAVL;
    }else if (categoriasAVL.codigo<codigo) {
        return buscarCategoria(codigo,categoriasAVL.hijoDerecho);
    }else {
        return buscarCategoria(codigo,categoriasAVL.hijoIzquierdo); 
    }
}


boolean existe(CategNodo categoriaAVL, int code) {

    boolean gia = false;
        
        while ((categoriaAVL != null) && !gia) {
            int tan = categoriaAVL.codigo;
            if (code < tan)
                categoriaAVL = categoriaAVL.hijoIzquierdo;
            else if (code > tan)
                categoriaAVL = categoriaAVL.hijoDerecho;
            else {
                gia = true;
                break;
            }
            gia = existe(categoriaAVL, code);
        }
        return gia;
	}
  


	public void modificar (CategNodo categoriaAVL, int codigo,String nuevoNombre){
		boolean gefunden = false;
	
	    while ((categoriaAVL != null) && !gefunden) {
	        int real = categoriaAVL.codigo;
	        if (codigo < real)
	            categoriaAVL = categoriaAVL.hijoIzquierdo;
	        else if (codigo > real)
	            categoriaAVL = categoriaAVL.hijoDerecho;
	        else {
	        	gefunden = true;
	            break;
	        }
	    }
	    if (gefunden){
	    	categoriaAVL.nombreCate=nuevoNombre;
	    }
	}
}