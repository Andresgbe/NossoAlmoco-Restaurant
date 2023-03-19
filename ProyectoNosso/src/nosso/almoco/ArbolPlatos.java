package nosso.almoco;

import java.util.Scanner;

public class ArbolPlatos {
	Scanner leer = new Scanner(System.in);
	Scanner leer2= new Scanner(System.in);

    private int altura (PlatoNodo N) {
        if (N == null)
             return 0;
        return N.altura;
    }
    
    
    
    PlatoNodo insertarPlato(PlatoNodo node, int codigoPlato,String nombrePlato,String nombreCategoriaPlato, int codigoCategoriaplato, int precio, boolean contornos, String descripcion) {
           
            if (node == null) {
                return(new PlatoNodo(nombrePlato,codigoPlato,codigoCategoriaplato,nombreCategoriaPlato,descripcion,precio,contornos));}
    
            if (codigoPlato < node.codigoPlatos)
                node.hijoIzquierdo  = insertarPlato(node.hijoIzquierdo, codigoPlato,nombrePlato, nombreCategoriaPlato,codigoCategoriaplato,precio,contornos,descripcion);
            else
                node.hijoDerecho = insertarPlato(node.hijoDerecho, codigoPlato,nombrePlato, nombreCategoriaPlato,codigoCategoriaplato,precio,contornos,descripcion);
    
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
    
    
    
    
    
    private PlatoNodo rotacionDerecha(PlatoNodo y) {
    		PlatoNodo x = y.hijoIzquierdo;
            PlatoNodo T2 = x.hijoDerecho;
    
           
            x.hijoDerecho = y;
            y.hijoIzquierdo = T2;
    
    
            y.altura = Math.max(altura(y.hijoIzquierdo), altura(y.hijoDerecho))+1;
            x.altura = Math.max(altura(x.hijoIzquierdo), altura(x.hijoDerecho))+1;
    
            return x;
    }
    
    private PlatoNodo rotacionIzquierda(PlatoNodo x) {
    		PlatoNodo y = x.hijoDerecho;
            PlatoNodo T2 = y.hijoIzquierdo;
    
           
            y.hijoIzquierdo = x;
            x.hijoDerecho = T2;
    
          
            x.altura = Math.max(altura(x.hijoIzquierdo), altura(x.hijoDerecho))+1;
            y.altura = Math.max(altura(y.hijoIzquierdo), altura(y.hijoDerecho))+1;
    
          
            return y;
    }
    
     
    private int obtenerBalance(PlatoNodo N) {
        if (N == null)
            return 0;
        return altura(N.hijoIzquierdo) - altura(N.hijoDerecho);
    }
    
    public void inOrderPlatos(PlatoNodo raiz) {
        if (raiz != null) {
            inOrderPlatos(raiz.hijoIzquierdo);
            System.out.println("| " + raiz.nombrePlatos + "\t | " + raiz.codigoPlatos + "\t\t | " + raiz.nombreCategoriaPlato + "\t | " + raiz.descripcion + "\t\t| " + raiz.precio + "\t\t | " + raiz.contornos + "\t\t|");
            inOrderPlatos(raiz.hijoDerecho);
        }
    }
    
    private PlatoNodo nodoConMinValorPlatos(PlatoNodo node) {
    	PlatoNodo current = node;
        while (current.hijoIzquierdo != null)
            current = current.hijoIzquierdo;
        return current;
    }
    
    
    PlatoNodo eliminarNodoPlatos(PlatoNodo platosAVL, int value) {
           
    
            if (platosAVL == null)
                return platosAVL;
    
            if ( value < platosAVL.codigoPlatos )
                platosAVL.hijoIzquierdo = eliminarNodoPlatos(platosAVL.hijoIzquierdo, value);
    
            
            else if( value > platosAVL.codigoPlatos )
                platosAVL.hijoDerecho = eliminarNodoPlatos(platosAVL.hijoDerecho, value);
    
           
            else {
               
                if( (platosAVL.hijoIzquierdo == null) || (platosAVL.hijoDerecho == null) ) {
    
                	PlatoNodo temp;
                    if (platosAVL.hijoIzquierdo != null)
                            temp = platosAVL.hijoIzquierdo;
                    else
                        temp = platosAVL.hijoDerecho;
    
                  
                    if(temp == null) {
                        temp = platosAVL;
                        platosAVL = null;
                    }
                    else 
                        platosAVL = temp; 
    
                    temp = null;
                }
                else {
                    
                	PlatoNodo temp = nodoConMinValorPlatos(platosAVL.hijoDerecho);
    
                    
                    platosAVL.codigoPlatos = temp.codigoPlatos;
    
                    
                    platosAVL.hijoDerecho = eliminarNodoPlatos(platosAVL.hijoDerecho, temp.codigoPlatos);
                }
            }
    
           
            if (platosAVL == null)
                return platosAVL;
    
           
            platosAVL.altura = Math.max(altura(platosAVL.hijoIzquierdo), altura(platosAVL.hijoDerecho)) + 1;
    
            
            int balance = obtenerBalance(platosAVL);
    
          
    
           
            if (balance > 1 && obtenerBalance(platosAVL.hijoIzquierdo) >= 0)
                return rotacionDerecha(platosAVL);
    
            
            if (balance > 1 && obtenerBalance(platosAVL.hijoIzquierdo) < 0) {
                platosAVL.hijoIzquierdo =  rotacionIzquierda(platosAVL.hijoIzquierdo);
                return rotacionDerecha(platosAVL);
            }
    
           
            if (balance < -1 && obtenerBalance(platosAVL.hijoDerecho) <= 0)
                return rotacionIzquierda(platosAVL);
    
           
            if (balance < -1 && obtenerBalance(platosAVL.hijoDerecho) > 0) {
                platosAVL.hijoDerecho = rotacionDerecha(platosAVL.hijoDerecho);
                return rotacionIzquierda(platosAVL);
            }
    
            return platosAVL;
    }




    PlatoNodo eliminarNodoPlatosCate(PlatoNodo platosAVL, int codigoCate) {
           
    
        if (platosAVL == null)
            return platosAVL;

        if ( codigoCate < platosAVL.codigoCategoriaplato )
            platosAVL.hijoIzquierdo = eliminarNodoPlatos(platosAVL.hijoIzquierdo, codigoCate);

        
        else if( codigoCate > platosAVL.codigoCategoriaplato )
            platosAVL.hijoDerecho = eliminarNodoPlatos(platosAVL.hijoDerecho, codigoCate);

       
        else {
           
            if( (platosAVL.hijoIzquierdo == null) || (platosAVL.hijoDerecho == null) ) {

            	PlatoNodo temp;
                if (platosAVL.hijoIzquierdo != null)
                        temp = platosAVL.hijoIzquierdo;
                else
                    temp = platosAVL.hijoDerecho;

              
                if(temp == null) {
                    temp = platosAVL;
                    platosAVL = null;
                }
                else 
                    platosAVL = temp; 

                temp = null;
            }
            else {
                
            	PlatoNodo temp = nodoConMinValorPlatos(platosAVL.hijoDerecho);

                
                platosAVL.codigoCategoriaplato = temp.codigoCategoriaplato;

                
                platosAVL.hijoDerecho = eliminarNodoPlatos(platosAVL.hijoDerecho, temp.codigoCategoriaplato);
            }
        }

       
        if (platosAVL == null)
            return platosAVL;

       
        platosAVL.altura = Math.max(altura(platosAVL.hijoIzquierdo), altura(platosAVL.hijoDerecho)) + 1;

        
        int balance = obtenerBalance(platosAVL);

      

       
        if (balance > 1 && obtenerBalance(platosAVL.hijoIzquierdo) >= 0)
            return rotacionDerecha(platosAVL);

        
        if (balance > 1 && obtenerBalance(platosAVL.hijoIzquierdo) < 0) {
            platosAVL.hijoIzquierdo =  rotacionIzquierda(platosAVL.hijoIzquierdo);
            return rotacionDerecha(platosAVL);
        }

       
        if (balance < -1 && obtenerBalance(platosAVL.hijoDerecho) <= 0)
            return rotacionIzquierda(platosAVL);

       
        if (balance < -1 && obtenerBalance(platosAVL.hijoDerecho) > 0) {
            platosAVL.hijoDerecho = rotacionDerecha(platosAVL.hijoDerecho);
            return rotacionIzquierda(platosAVL);
        }

        return platosAVL;
    }


    public PlatoNodo buscarPlato(int codigo ,PlatoNodo platosAVL) {
    	if(platosAVL==null) {
    		return null;
    	}else if (platosAVL.codigoPlatos==codigo) {
    		return platosAVL;
    	}else if (platosAVL.codigoPlatos<codigo) {
    		return buscarPlato(codigo,platosAVL.hijoDerecho);
    	}else {
    		return buscarPlato(codigo,platosAVL.hijoIzquierdo); 
    	}
    }


    boolean estaPlato(PlatoNodo platosAVL, int codigoPlatos) {
    
        boolean gefunden = false;
            
            while ((platosAVL != null) && !gefunden) {
                int rosalia = platosAVL.codigoPlatos;
                
                if (platosAVL.codigoPlatos < rosalia)
                    platosAVL = platosAVL.hijoIzquierdo;
                else if (platosAVL.codigoPlatos > rosalia)
                    platosAVL = platosAVL.hijoDerecho;
                else {
                	gefunden = true;
                    break;
                }
                gefunden = estaPlato(platosAVL,codigoPlatos);
            }
            return gefunden;
    }
      
    
    
    public void modificarPlato (PlatoNodo platosAVL, CartaNodo menuDiaAVL,int codigoPlatos){
    	boolean gefunden = false;
    	boolean gefunden2=false;

    	int op=1;  
    	String nuevosDatos; 
    	int nuevosDatosint; 
    	boolean contornosBool = false; 

    
        while ((platosAVL != null) && !gefunden) {
            int rval = platosAVL.codigoPlatos;
            if (codigoPlatos < rval)
                platosAVL = platosAVL.hijoIzquierdo;
            else if (codigoPlatos > rval)
                platosAVL = platosAVL.hijoDerecho;
            else {
            	gefunden = true;
                break;
            }
        }

        while ((menuDiaAVL != null) && !gefunden2) {
            int rval = menuDiaAVL.codigoPlatos;
            if (codigoPlatos < rval)
                menuDiaAVL = menuDiaAVL.hijoIzquierdo;
            else if (codigoPlatos > rval)
                menuDiaAVL = menuDiaAVL.hijoDerecho;
            else {
            	gefunden2 = true;
                break;
            }
        }

            if (gefunden){
                do{ 

        			System.out.println("\n\n******************************************");
        			System.out.println("*      Que Desea Cambiar Del Plato?      *");
        			System.out.println("******************************************");
        			System.out.println("* 1. Nombre del Plato                    *");
        			System.out.println("* 2. Descripcion Plato                   *");
                    System.out.println("* 3. Precio del Plato                    *");
                    System.out.println("* 4. Contorno                            *");
                    System.out.println("* 5. Salir                               *");
                    System.out.println("******************************************");
                    op = leer.nextInt();
        
                    switch(op){
                        
                          case 1:
                        	  System.out.println("\nIndique el Nuevo Nombre Del Plato\n");
                        	  leer.nextLine();
                        	  nuevosDatos=leer.nextLine();
                        	  platosAVL.nombrePlatos=nuevosDatos;
                                
                        	  if(gefunden2){
                        		  menuDiaAVL.nombrePlatos=nuevosDatos;
                        	  }
                        	  System.out.println("\n\nSe ha modificado el nombre correctamente\n");                        
                        	  System.out.print("\nPresione Cualquier Tecla para Continuar\n");
                        	  new java.util.Scanner(System.in).nextLine();                     
                        	  break;
                    
                          case 2:                            
                        	  System.out.println("\nIndique La descripcion Del Plato\n");
                        	  System.out.println("Indique Nueva descripcion->  ");
                        	  nuevosDatos=leer2.nextLine();
                        	  platosAVL.descripcion=nuevosDatos;
                              if(gefunden2){
                            	  menuDiaAVL.descripcion=nuevosDatos;
                              }        
                              System.out.println("\n\nSe ha modificado el codigo correctamente\n");  
                              System.out.print("\nPresione Cualquier Tecla para Continuar\n");
                              new java.util.Scanner(System.in).nextLine(); 
                              break;
        
                          case 3:        
                        	  System.out.println("\nIndique el nuevo precio del Plato\n");
                        	  System.out.println("Indique Nuevo precio ->  ");
                        	  nuevosDatosint=leer.nextInt();
                            
                        	  platosAVL.precio=nuevosDatosint;
        
                        	  if(gefunden2){
                        		  menuDiaAVL.precio=nuevosDatosint;
                        	  }
        
                        	  System.out.println("\n\nSe ha modificado el precio correctamente\n");  
                        	  System.out.print("\nPresione Cualquier Tecla para Continuar\n");
                        	  new java.util.Scanner(System.in).nextLine();
        
                        	  break;
        
        
                          case 4:
        
                        	  System.out.println("\nIndique si el plato permite contornos 1.SI/0.NO\n");
                        	  System.out.println("Indique su Opcion ->  ");
                        	  nuevosDatosint=leer.nextInt();
                           
        
                        	  while ((nuevosDatosint!=1)&&(nuevosDatosint!=0)){ 
                        		  System.out.println("\n\nIndique si el plato permite contornos 1.SI/0.NO\n");
                        		  System.out.println("Indique su Opcion ->  ");
                        		  nuevosDatosint=leer.nextInt();
                        	  }
                            
                        	  if (nuevosDatosint==1){
                        		  contornosBool = true;
                        	  }
        
                        	  platosAVL.contornos = contornosBool;

                        	  if(gefunden2){
                        		  menuDiaAVL.contornos = contornosBool;
                        	  }
        
                        	  System.out.println("\n\nSe ha modificado el contorno correctamente\n");  
       						  System.out.print("\nPresione Cualquier Tecla para Continuar\n");
       						  new java.util.Scanner(System.in).nextLine();
       						  break;
       
                       default: 
                    	   if (op != 5){
                    		   System.out.println( "Indique una opcion valida\n");  
                    		   System.out.print("\nPresione Cualquier Tecla para Continuar\n");
                    		   new java.util.Scanner(System.in).nextLine();
                    	   }
                    	   break;                        
                    }               
               
                }while(op!=5);
            }
    	}

    public void ModificarCatePlatos(PlatoNodo raiz,String nombreCate, String nuevoNombre) {
    	if (raiz != null) {
    		ModificarCatePlatos(raiz.hijoIzquierdo,nombreCate, nuevoNombre);

    		if(raiz.nombreCategoriaPlato==nombreCate){
    			raiz.nombreCategoriaPlato=nuevoNombre;
    		}
    		ModificarCatePlatos(raiz.hijoDerecho,nombreCate, nuevoNombre);
    	}
    }

}