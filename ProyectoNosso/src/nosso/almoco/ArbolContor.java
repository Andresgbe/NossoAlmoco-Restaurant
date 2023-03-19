package nosso.almoco;

public class ArbolContor {

	private int altura (ContorNodo N) {
		if (N == null)
			return 0;
		return N.altura;
	}


	ContorNodo insertarContorno(ContorNodo node, int value,String nombre) {
       
        if (node == null) {
            return(new ContorNodo(value,nombre));}

        if (value < node.codigo)
            node.hijoIzquierdo  = insertarContorno(node.hijoIzquierdo, value,nombre);
        else
            node.hijoDerecho = insertarContorno(node.hijoDerecho, value,nombre);

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


	private ContorNodo rotacionDerecha(ContorNodo y) {
		ContorNodo x = y.hijoIzquierdo;
        ContorNodo T2 = x.hijoDerecho;
       
        x.hijoDerecho = y;
        y.hijoIzquierdo = T2;

        y.altura = Math.max(altura(y.hijoIzquierdo), altura(y.hijoDerecho))+1;
        x.altura = Math.max(altura(x.hijoIzquierdo), altura(x.hijoDerecho))+1;

        return x;
	}

	private ContorNodo rotacionIzquierda(ContorNodo x) {
		ContorNodo y = x.hijoDerecho;
        ContorNodo T2 = y.hijoIzquierdo;
      
        y.hijoIzquierdo = x;
        x.hijoDerecho = T2;
      
        x.altura = Math.max(altura(x.hijoIzquierdo), altura(x.hijoDerecho))+1;
        y.altura = Math.max(altura(y.hijoIzquierdo), altura(y.hijoDerecho))+1;

      
        return y;
	}


	private int obtenerBalance(ContorNodo N) {
		if (N == null)
			return 0;
		return altura(N.hijoIzquierdo) - altura(N.hijoDerecho);
	}

	void inOrder(ContorNodo raiz) {
		if (raiz != null) {
			inOrder(raiz.hijoIzquierdo);
			System.out.println("| " + raiz.nombreContor + "\t | " + raiz.codigo + "\t\t|");
			inOrder(raiz.hijoDerecho);
		}
	}

	private ContorNodo nodoConMinValor(ContorNodo node) {
		ContorNodo current = node;
	    while (current.hijoIzquierdo != null)
	        current = current.hijoIzquierdo;
	    return current;
	}


	ContorNodo eliminarNodo(ContorNodo raiz, int codeina) {
       
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
            	ContorNodo Naux = null; //Nodo Auxiliar
            	
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
                
            	ContorNodo temp = nodoConMinValor(raiz.hijoDerecho);

                
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

	ContorNodo buscarcontorno(int codigo ,ContorNodo contornosAVL) {
	    if(contornosAVL==null) {
	        return null;
	    }else if (contornosAVL.codigo==codigo) {
	        return contornosAVL;
	    }else if (contornosAVL.codigo<codigo) {
	        return buscarcontorno(codigo,contornosAVL.hijoDerecho);
	    }else {
	        return buscarcontorno(codigo,contornosAVL.hijoIzquierdo); 
	    }
	}


	boolean existe(ContorNodo contornoAVL, int code) {

	    boolean gia = false;
	        
	        while ((contornoAVL != null) && !gia) {
	            int tan = contornoAVL.codigo;
	            if (code < tan)
	                contornoAVL = contornoAVL.hijoIzquierdo;
	            else if (code > tan)
	                contornoAVL = contornoAVL.hijoDerecho;
	            else {
	                gia = true;
	                break;
	            }
	            gia = existe(contornoAVL, code);
	        }
	     return gia;
	}
  


	public void modificar (ContorNodo contornoAVL, int codigo,String nuevoNombre){
		boolean gefunden = false;
	
	    while ((contornoAVL != null) && !gefunden) {
	        int real = contornoAVL.codigo;
	        if (codigo < real)
	            contornoAVL = contornoAVL.hijoIzquierdo;
	        else if (codigo > real)
	            contornoAVL = contornoAVL.hijoDerecho;
	        else {
	        	gefunden = true;
	            break;
	        }
	    }
	    if (gefunden){
	    	contornoAVL.nombreContor=nuevoNombre;
	    }
	}
}
