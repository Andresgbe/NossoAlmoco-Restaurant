package nosso.almoco;

import java.util.Scanner;

public class main {
	
	static main mainLlama= new main();
	
	static Scanner leer = new Scanner(System.in);
	ArbolContor contornoAVL= new ArbolContor();
	ContorNodo raizContor = null;
	
	ArbolCateg categoriasAVL= new ArbolCateg();
	CategNodo raizCateg=null;
	
	ArbolPlatos platosAVL = new ArbolPlatos();
	PlatoNodo raizPlatos= null; 
	
	ArbolCarta menuDiaAVL = new ArbolCarta();
	CartaNodo raizMenuDia= null;
	
	static Archivos Archivos = new Archivos();
	Registro Registro = new Registro();
	static String fileName = "cliente.txt";
    static String fileNames = "admin.txt";
	
	public static void main(String[] args){
		  int op;
		  
		  do{
			System.out.println("\n\n\n\n\n\n\n\n");
			System.out.println("******************************************");
			System.out.println("*            Nosso                       *");
			System.out.println("*                Almoco                  *");
			System.out.println("******************************************");
			System.out.println("* 1. Registro de Usuario                 *");
			System.out.println("* 2. Autenticacion                       *");
			System.out.println("* 3. Recuperacion de datos               *");
			System.out.println("* 4. Salir                               *");
			System.out.println("******************************************");
			op = leer.nextInt();
			
		    switch (op){

		      case 1:{
		    	  //registro de usuario
		    	  Archivos.createFile(fileName);
		        break;
			    }

		      case 2:{
		    	  mainLlama.menuCloPer();
		        break;
		      }   

			  case 3:{
				  mainLlama.menuClienteoPersonaRecuperarDatos();
		        break;
		      }  
			  
			  default: 
              	if (op != 4){
              		System.out.println( "Indique una opcion valida\n");  
					System.out.print("\nPresione Cualquier Tecla para Continuar\n");
					new java.util.Scanner(System.in).nextLine();
              	} 
	          	break;
	            
		    }
		    
		  }while (op!=4);
	}
	
	
	void menuCloPer() {
        int num;
		  
		  do{
			System.out.println("\n\n\n\n\n\n\n\n");
			System.out.println("******************************************");
			System.out.println("*            Nosso                       *");
			System.out.println("*                Almoco                  *");
			System.out.println("******************************************");
            System.out.println("*     Usted es Cliente o Personal?       *");
			System.out.println("******************************************");
			System.out.println("* 1. Cliente                             *");
			System.out.println("* 2. Personal                            *");
            System.out.println("* 3. Salir                               *");
            System.out.println("******************************************");
			
            num = leer.nextInt();
			
		    switch (num){
                case 1:{
                	//Se autentica el usuario primero
                	int x;
                	x = Archivos.autenticar_usuario();
                	if (x == 1) {
                	mainLlama.menuClientesSesion();
                	}
                    break;
                }
    
                case 2:{
                	//Se autentica el usuario primero
                	int x;
                	x = Archivos.autenticar_admin();
                	if (x == 1) {
                		mainLlama.menuPersonalRestaurantSesion();
                	}
                    break;
                }
                
                default: 
                	if (num != 3){
                		System.out.println( "Indique una opcion valida\n");  
                		System.out.print("\nPresione Cualquier Tecla para Continuar\n");
                		new java.util.Scanner(System.in).nextLine();
                	}
    	          	break;
    
		    }
		  }while (num!=3);
    }	

	
	void menuClienteoPersonaRecuperarDatos() {
        int num;
		  
		  do{
			System.out.println("\n\n\n\n\n\n\n\n");
			System.out.println("******************************************");
			System.out.println("*            Nosso                       *");
			System.out.println("*                Almoco                  *");
			System.out.println("******************************************");
            System.out.println("*     Usted es Cliente o Personal?       *");
			System.out.println("******************************************");
			System.out.println("* 1. Cliente                             *");
			System.out.println("* 2. Personal                            *");
            System.out.println("* 3. Salir                               *");
            System.out.println("******************************************");
			
            num = leer.nextInt();
			
		    switch (num){
                case 1:{
                	//Recuperar datos de Cliente
                	Archivos.recuperar_datos_usuario();
                    break;
                }
    
                case 2:{
                	//Recuperar datos de Personal
                	Archivos.recuperar_datos_admin();
                    break;
                }
                
                default: 
                	if (num != 3){
                		System.out.println( "Indique una opcion valida\n");  
                		System.out.print("\nPresione Cualquier Tecla para Continuar\n");
                		new java.util.Scanner(System.in).nextLine();
                	}
    	          	break;
    
		    }
		  }while (num!=3);
    }	
	
	
    void menuClientesSesion(){
        int num;
		  
		  do{
			System.out.println("\n\n\n\n\n\n\n\n");
			System.out.println("******************************************");
			System.out.println("*            Nosso                       *");
			System.out.println("*                Almoco                  *");
            System.out.println("*                                        *");
            System.out.println("*               Clientes                 *");
			System.out.println("******************************************");
			System.out.println("* 1. Cambio de datos de usuario          *");
			System.out.println("* 2. Ver Menu del Dia                    *");
			System.out.println("* 3. Realizar pedido                     *");
            System.out.println("* 4. Cerrar Sesion                       *");
			System.out.println("******************************************");
			
            num = leer.nextInt();
			
		    switch (num){
		    
		      case 1:{
                //se cambian los datos
		        break;
			    }
		      
		      case 2:{
                //se ve la carta
              	System.out.print("\n\n\n\n_______________________________________________________________________________________________________________");
                System.out.print("\n| Nombre\t | Codigo\t | Categoria\t | Descripcion del plato \t| Precio\t| Contorno\t|\n");
                System.out.print("|________________|_______________|_______________|______________________________|_______________|_______________|\t\n");
                menuDiaAVL.inOrderPlatosCarta(raizMenuDia);  
                System.out.print("|________________|_______________|_______________|______________________________|_______________|_______________|\t\n");
				System.out.print("\nPresione Cualquier Tecla para Continuar\n");
				new java.util.Scanner(System.in).nextLine();
		        break;
		      }   
		      
		      case 3:{
                //se realizan pedidos
              	System.out.print("\n\n\n\n_______________________________________________________________________________________________________________");
                System.out.print("\n| Nombre\t | Codigo\t | Categoria\t | Descripcion del plato \t| Precio\t| Contorno\t|\n");
                System.out.print("|________________|_______________|_______________|______________________________|_______________|_______________|\t\n");
                menuDiaAVL.inOrderPlatosCarta(raizMenuDia);  
                System.out.print("|________________|_______________|_______________|______________________________|_______________|_______________|\t\n");
                System.out.print("\nIndique el Codigo del Plato que Desea\n");
                
                System.out.print("\nPresione Cualquier Tecla para Continuar\n");
				new java.util.Scanner(System.in).nextLine();
				
		        break;
		      }   
		      
		      default: 
              	if (num != 4){
              		System.out.println( "Indique una opcion valida\n");  
					System.out.print("\nPresione Cualquier Tecla para Continuar\n");
					new java.util.Scanner(System.in).nextLine();
              	}
		        break;
		    }
		    
		  }while (num!=4);
    }

    void menuPersonalRestaurantSesion() {
        int num;
		  
		  do{
			System.out.println("\n\n\n\n\n\n\n\n");
			System.out.println("******************************************");
			System.out.println("*            Nosso                       *");
			System.out.println("*                Almoco                  *");
            System.out.println("*                                        *");
            System.out.println("*               Personal                 *");
			System.out.println("******************************************");
			System.out.println("* 1. Administrar categorias              *");
			System.out.println("* 2. Administrar platos                  *");
            System.out.println("* 3. Administrar contornos               *");
            System.out.println("* 4. Administrar menu del dia            *");
            System.out.println("* 5. Reportes del sistema                *");
            System.out.println("* 6. Cerrar Sesion                       *");
            System.out.println("******************************************");
			
            num = leer.nextInt();
			
		    switch (num){
                case 1:{
                	mainLlama.menuCateg();
                    break;
                }
    
                case 2:{
                	mainLlama.menuPlatos();
                    break;
                }
    
                case 3:{
                	mainLlama.menuContornos();
                    break;
                }
    
                case 4:{
                	mainLlama.menuMenuDia();
                    break;
                }
    
                case 5:{
                	mainLlama.menuReportes();
                    break;
                }
                
                default: 
                	if (num != 6){
                		System.out.println( "Indique una opcion valida\n");  
                		System.out.print("\nPresione Cualquier Tecla para Continuar\n");
                		new java.util.Scanner(System.in).nextLine();
                	}
    		        break;
		    }
		  }while (num!=6);
    }

    void menuReportes() {
        int num;
		  
		  do{
			System.out.println("\n\n\n\n\n\n\n\n");
			System.out.println("******************************************");
			System.out.println("*            Nosso                       *");
			System.out.println("*                Almoco                  *");
            System.out.println("*                                        *");
            System.out.println("*               Personal                 *");
			System.out.println("******************************************");
			System.out.println("* 1. Ver Menu                            *");
			System.out.println("* 2. Mostrar platos vendidos por fecha   *");
            System.out.println("* 3. Mostrar platos vendidos por fechas  *");
            System.out.println("* 4. Mostrar platos vendidos por mes     *");
            System.out.println("* 5. Salir                               *");
            System.out.println("******************************************");
			
            num = leer.nextInt();
			
		    switch (num){
                case 1:{
                	System.out.print("\n\n\n\n_______________________________________________________________________________________________________________");
                    System.out.print("\n| Nombre\t | Codigo\t | Categoria\t | Descripcion del plato \t| Precio\t| Contorno\t|\n");
                    System.out.print("|________________|_______________|_______________|______________________________|_______________|_______________|\t\n");
                    menuDiaAVL.inOrderPlatosCarta(raizMenuDia);  
                    System.out.print("|________________|_______________|_______________|______________________________|_______________|_______________|\t\n");
					System.out.print("\nPresione Cualquier Tecla para Continuar\n");
					new java.util.Scanner(System.in).nextLine();
                    break;
                }
    
                case 2:{
                    //platos vendidos por fecha
                    break;
                }
    
                case 3:{
                    //platos vendidos por fechas
                    break;
                }
    
                case 4:{
                    //platos vendidos por mes
                    break;
                }
                
                default: 
                	if (num != 5){
    				System.out.println( "Indique una opcion valida\n");  
					System.out.print("\nPresione Cualquier Tecla para Continuar\n");
					new java.util.Scanner(System.in).nextLine();
                	} 
    		        break;
		    }
		  }while (num!=5);
    }

    void menuMenuDia() {
        int num;
		  
		  do{
			System.out.println("\n\n\n\n\n\n\n\n");
			System.out.println("******************************************");
			System.out.println("*            Nosso                       *");
			System.out.println("*                Almoco                  *");
            System.out.println("*                                        *");
            System.out.println("*               Personal                 *");
			System.out.println("******************************************");
			System.out.println("* 1. Crear Menu del dia                  *");
			System.out.println("* 2. Agregar plato al Menu del dia       *");
            System.out.println("* 3. Eliminar Plato Menu del dia         *");
            System.out.println("* 4. Eliminar Menu del dia               *");
            System.out.println("* 5. Mostrar Menu del dia                *");
            System.out.println("* 6. Salir                               *");
            System.out.println("******************************************");
			
            num = leer.nextInt();
			
		    switch (num){
                case 1:{
                    //crear menu
                    int platCant, x=0, platoCode;
                    System.out.print("_______________________________________________________________________________________________________________");
                    System.out.print("\n| Nombre\t | Codigo\t | Categoria\t | Descripcion del plato \t| Precio\t| Contorno\t|\n");
                    System.out.print("|________________|_______________|_______________|______________________________|_______________|_______________|\t\n");
                    platosAVL.inOrderPlatos(raizPlatos);
                    System.out.print("|________________|_______________|_______________|______________________________|_______________|_______________|\t\n");
                    System.out.println("\nIndique la cantidad de Platos que desea en el Menu Del dia\n");
                    platCant=leer.nextInt();
                    
                    while (x < platCant){
                    	x++;
                    	System.out.print("\n\n\n_______________________________________________________________________________________________________________");
                        System.out.print("\n| Nombre\t | Codigo\t | Categoria\t | Descripcion del plato \t| Precio\t| Contorno\t|\n");
                        System.out.print("|________________|_______________|_______________|______________________________|_______________|_______________|\t\n");
                        platosAVL.inOrderPlatos(raizPlatos);
                        System.out.print("|________________|_______________|_______________|______________________________|_______________|_______________|\t\n");
                        System.out.println("\nIndique el codigo del Plato que desea agregar al Menu del Dia\n");
                        
                        platoCode=leer.nextInt();  
                         
                        if (!platosAVL.estaPlato(raizPlatos, platoCode)||menuDiaAVL.existePlatoCarta(raizMenuDia, platoCode)){                           
                        	System.out.println("\nEl plato que intenta Agregar no se encuentra en el menu, o ya esta registrado en el menu Del Dia \n\n");
                            System.out.println("\n\nIntentelo de Nuevo\n");  
          					System.out.print("\nPresione Cualquier Tecla para Continuar\n");
        					new java.util.Scanner(System.in).nextLine();
                        }
                        else{
                        String nombrePlato = platosAVL.buscarPlato(platoCode, raizPlatos).nombrePlatos;
                    	String nombreCategoriaPlato = platosAVL.buscarPlato(platoCode, raizPlatos).nombreCategoriaPlato;
                    	int codigoCategoriaplato = platosAVL.buscarPlato(platoCode, raizPlatos).codigoCategoriaplato;
                    	int precio = platosAVL.buscarPlato(platoCode, raizPlatos).precio;
                    	boolean contornos = platosAVL.buscarPlato(platoCode, raizPlatos).contornos;
                    	String descripcion = platosAVL.buscarPlato(platoCode, raizPlatos).descripcion;              
                    	raizMenuDia=menuDiaAVL.insertarPlatoCarta(raizMenuDia, platoCode, nombrePlato, nombreCategoriaPlato, codigoCategoriaplato, precio, contornos, descripcion); 
                    	
                    	System.out.println("\n\nSe ha insertado Correctamente el Plato\n");                  	  
    					System.out.print("\nPresione Cualquier Tecla para Continuar\n");
    					new java.util.Scanner(System.in).nextLine();
                        }
                    }
                    break;
                }
    
                case 2:{
                    //agg plato al menu
                	int platoCode;
                	System.out.print("_______________________________________________________________________________________________________________");
                    System.out.print("\n| Nombre\t | Codigo\t | Categoria\t | Descripcion del plato \t| Precio\t| Contorno\t|\n");
                    System.out.print("|________________|_______________|_______________|______________________________|_______________|_______________|\t\n");
                    menuDiaAVL.inOrderPlatosCarta(raizMenuDia);  
                    System.out.print("|________________|_______________|_______________|______________________________|_______________|_______________|\t\n");
                    System.out.println("\nIndique el Plato que desea agregar\n");
                    
                    leer.nextLine();
                    platoCode=leer.nextInt();
                     
                    if(platosAVL.estaPlato(raizPlatos, platoCode)){

                      if(!menuDiaAVL.existePlatoCarta(raizMenuDia, platoCode)){

                          String nombrePlato=platosAVL.buscarPlato(platoCode, raizPlatos).nombrePlatos;
                          String nombreCategoriaPlato=platosAVL.buscarPlato(platoCode, raizPlatos).nombreCategoriaPlato;
                          int codigoCategoriaplato=platosAVL.buscarPlato(platoCode, raizPlatos).codigoCategoriaplato;
                          int precio=platosAVL.buscarPlato(platoCode, raizPlatos).precio;
                          boolean contornos=platosAVL.buscarPlato(platoCode, raizPlatos).contornos;
                          String descripcion=platosAVL.buscarPlato(platoCode, raizPlatos).descripcion;

                          raizMenuDia=menuDiaAVL.insertarPlatoCarta(raizMenuDia, platoCode, nombrePlato, nombreCategoriaPlato, codigoCategoriaplato, precio, contornos, descripcion);

                          //guardarMenuDia(menuDelDia);
                          System.out.println("\n\nSe ha insertado Correctamente el Plato\n");}

                      else{
                          System.out.println("\n\nEl plato ya se encuenta en el menu del dia\n\n");}}
                    else{
                      System.out.println("\n\nEl Plato no se encuentra en el menu\n\n");
                    }
                    break;
                }
    
                case 3:{
                    //elim plato
                	int platoCode;
                	System.out.print("_______________________________________________________________________________________________________________");
                    System.out.print("\n| Nombre\t | Codigo\t | Categoria\t | Descripcion del plato \t| Precio\t| Contorno\t|\n");
                    System.out.print("|________________|_______________|_______________|______________________________|_______________|_______________|\t\n");
                    menuDiaAVL.inOrderPlatosCarta(raizMenuDia);  
                    System.out.print("|________________|_______________|_______________|______________________________|_______________|_______________|\t\n");
                    System.out.println("\nIndique el Plato que desea eliminar\n");
                    
                    platoCode=leer.nextInt();              

                      if(menuDiaAVL.existePlatoCarta(raizMenuDia, platoCode)){
                          menuDiaAVL.existePlatoCarta(raizMenuDia, platoCode);
                          //guardarMenuDia(menuDelDia);
                          System.out.println("\n\nSe ha eliminado Correctamente el Plato\n");
                          }

                      else{

                      System.out.println("\n\n El plato que desea eliminar no se encuentra\n\n");}
                    break;
                }
    
                case 4:{
                    //elim menu
                    break;
                }

                case 5:{
                    //mostrar menu
                	System.out.print("_______________________________________________________________________________________________________________");
                    System.out.print("\n| Nombre\t | Codigo\t | Categoria\t | Descripcion del plato \t| Precio\t| Contorno\t|\n");
                    System.out.print("|________________|_______________|_______________|______________________________|_______________|_______________|\t\n");
                    menuDiaAVL.inOrderPlatosCarta(raizMenuDia);  
                    System.out.print("|________________|_______________|_______________|______________________________|_______________|_______________|\t\n");
					System.out.print("\nPresione Cualquier Tecla para Continuar\n");
					new java.util.Scanner(System.in).nextLine();
                    break;
                }
                
                default: 
                	if (num != 6){
    				System.out.println( "Indique una opcion valida\n");  
					System.out.print("\nPresione Cualquier Tecla para Continuar\n");
					new java.util.Scanner(System.in).nextLine();
                	}
    		        break;
		    }
		  }while (num!=6);
    }

    void menuContornos() {
        int num;
		String contorName = " ";
		  do{
			System.out.println("\n\n\n\n\n\n\n\n");
			System.out.println("******************************************");
			System.out.println("*            Nosso                       *");
			System.out.println("*                Almoco                  *");
            System.out.println("*                                        *");
            System.out.println("*               Personal                 *");
			System.out.println("******************************************");
			System.out.println("* 1. Crear Contornos                     *");
            System.out.println("* 2. Eliminar Contorno                   *");
            System.out.println("* 3. Mostrar Contornos                   *");
            System.out.println("* 4. Modificar Contorno                  *");
            System.out.println("* 5. Salir                               *");
            System.out.println("******************************************");
			
            num = leer.nextInt();
			
		    switch (num){
                case 1:{
                	System.out.print("\nIndique el nombre del Contorno que desea agregar:\n");
                	leer.nextLine();
                    contorName = leer.nextLine();
                     
                    int codigo = (int)(Math.random()*1000+1); //codigo random del contorno
                     
                    if(!contornoAVL.existe(raizContor,codigo)){
                    	raizContor = contornoAVL.insertarContorno(raizContor,codigo,contorName); 
                    	System.out.print( "\nSe ha insertado correctamente el contorno:  " + contorName);
                    	System.out.print( "\nCuyo Codigo Sera:  " + codigo + "\n\n");
 						System.out.print("\nPresione Cualquier Tecla para Continuar\n");
 						new java.util.Scanner(System.in).nextLine();
                    }	 
                    else{
                        System.out.print("\n\nEl Contorno ya se encuentra\n\n"); 
 						System.out.print("\nPresione Cualquier Tecla para Continuar\n");
 						new java.util.Scanner(System.in).nextLine();
		    		}
                    break;
                }
    
                case 2:{
                    //elim cont
                	int codigoDado = 0;
                	
                	System.out.print("\nLos Contornos Son:\n\n\n");
                	System.out.print("_________________________________");
                    System.out.print("\n| Nombre\t | Codigo\t|\n");
                    System.out.print("|________________|______________|\t\n");
                    contornoAVL.inOrder(raizContor);
                    System.out.print("|________________|______________|\t\n");
                    
                    System.out.print("\n\nIndique El codigo del Contorno que desea eliminar:");
                    leer.nextLine();
                    codigoDado=leer.nextInt();                          

                    if(!contornoAVL.existe(raizContor, codigoDado)){
                        System.out.print("\n\nEl Contorno que busca no existe\n");
                        System.out.print("Vuelva a Intentarlo\n"); 
 						System.out.print("\nPresione Cualquier Tecla para Continuar\n");
 						new java.util.Scanner(System.in).nextLine();
                    }
                    else{ 
                    	contornoAVL.eliminarNodo(raizContor, codigoDado);
                    	
                        System.out.print("\nCategoria Eliminada Correctamente\n");
 						System.out.print("\nPresione Cualquier Tecla para Continuar\n");
 						new java.util.Scanner(System.in).nextLine();
                    }

                    break;
                }
    
                case 3:{
                    //msotrar cont
                	System.out.print("\nLos Contornos Son:\n\n\n");
                	System.out.print("_________________________________");
                    System.out.print("\n| Nombre\t | Codigo\t|\n");
                    System.out.print("|________________|______________|\t\n");
                    contornoAVL.inOrder(raizContor);
                    System.out.print("|________________|______________|\t\n");
                    System.out.print("\n\nPresione Cualquier Tecla para Continuar\n");
					new java.util.Scanner(System.in).nextLine();
                    break;
                }
                
                case 4:{ 
                	int codigoDado;
                   	System.out.print("\nLos Contornos Son:\n\n\n");
                	System.out.print("_________________________________");
                    System.out.print("\n| Nombre\t | Codigo\t|\n");
                    System.out.print("|________________|______________|\t\n");
                    contornoAVL.inOrder(raizContor);
                    System.out.print("|________________|______________|\t\n");
                	
                    System.out.print("\n\nIndique El codigo del Contorno que desea modificar:");
                    codigoDado=leer.nextInt();

                        if(!contornoAVL.existe(raizContor, codigoDado)){
                            System.out.print("\n\nEl Contorno que busca no existe\n");
                            System.out.print("Vuelva a Intentarlo\n"); 
     						System.out.print("\nPresione Cualquier Tecla para Continuar\n");
     						new java.util.Scanner(System.in).nextLine();
                        }
                        else{ 
                        	String nombreContorno = contornoAVL.buscarcontorno(codigoDado, raizContor).nombreContor;
                                
                            System.out.print("\n\nIndique nombre del nuevo contorno\n");
                            leer.nextLine();
                            contorName=leer.nextLine();

                            contornoAVL.modificar(raizContor, codigoDado, contorName);
                            
                            System.out.print("\nContorno Modificadoa Correctamente\n");
     						System.out.print("\nPresione Cualquier Tecla para Continuar\n");
     						new java.util.Scanner(System.in).nextLine();
                        }
                }
                
                default: 
                	if (num != 4){
    				System.out.println( "Indique una opcion valida\n");  
					System.out.print("\nPresione Cualquier Tecla para Continuar\n");
					new java.util.Scanner(System.in).nextLine();
                	}  
    		        break;
		    }
		  }while (num!=4);
    }

    void menuPlatos() {
		int platoCode, categCode, platoPrice, siono, num;
		String categName, platoDesc, platoName;
		boolean tieneContornos;  
		
		  do{
			System.out.println("\n\n\n\n\n\n\n\n");
			System.out.println("******************************************");
			System.out.println("*            Nosso                       *");
			System.out.println("*                Almoco                  *");
            System.out.println("*                                        *");
            System.out.println("*               Personal                 *");
			System.out.println("******************************************");
			System.out.println("* 1. Agregar plato                       *");
			System.out.println("* 2. Modificar plato                     *");
            System.out.println("* 3. Mostrar platos                      *");
            System.out.println("* 4. Eliminar plato                      *");
            System.out.println("* 5. Salir                               *");
            System.out.println("******************************************");
			
            num = leer.nextInt();
			
		    switch (num){
                case 1:{
                	//agg Plato
                	if(raizCateg != null) {
                		
                		
                		System.out.println("Indique el Nombre del Plato a Agregar");
                        leer.nextLine();
                        platoName=leer.nextLine();

                    	System.out.print("\nLas Categorias Son:\n\n\n");
                    	System.out.print("_________________________________");
                        System.out.print("\n| Nombre\t | Codigo\t|\n");
                        System.out.print("|________________|______________|\t\n");
                        categoriasAVL.inOrder(raizCateg);
                        System.out.print("|________________|______________|\t\n");

                        System.out.println("Indique el codigo de la Categoria del Plato");
                        categCode = leer.nextInt();

                        if(categoriasAVL.existe(raizCateg, categCode)){
                        
                        	categName = " ";
                        	categName = (categoriasAVL.buscarCategoria(categCode, raizCateg).nombreCate);
                        	leer.nextLine();

                        	platoCode = (int)(Math.random()*1000+1);
                        	System.out.println("El Codigo del Plato sera: " + platoCode);
                        	
                        	System.out.println("Indique precio del Plato en Bolivares");
                        	platoPrice = leer.nextInt();
                        	leer.nextLine();
                        
                        	System.out.println("Indique la descripcion del Plato");
                        	platoDesc = leer.nextLine();

                        	System.out.println("Indique si el Plato tiene Contornos");
                        	System.out.println("0. No\n1. Si");
                        	siono = leer.nextInt();
                        	leer.nextLine();
                        
                        	while ((siono!=1)&&(siono!=0)){ 
                        		System.out.println("\n\nIndique si el plato permite contornos 1.SI/0.NO\n");
                        		siono=leer.nextInt();
                        		leer.nextLine();}
                        
                            	if(siono==1){
                            		tieneContornos = true;
                                	System.out.print("_________________________________");
                                    System.out.print("\n| Nombre\t | Codigo\t|\n");
                                    System.out.print("|________________|______________|\t\n");
                                    contornoAVL.inOrder(raizContor);
                                    System.out.print("|________________|______________|\t\n");
                                    System.out.print("\nIndique el codigo del contorno");
                            		int codes = leer.nextInt();
                            		leer.nextLine();
                            	}
                            	else{
                            		tieneContornos=false;
                            	}

                            	raizPlatos = platosAVL.insertarPlato(raizPlatos, platoCode, platoName, categName, categCode, platoPrice, tieneContornos, platoDesc);

                        	}

                        	else{
                        		System.out.println("Inserto Una categoria que no existe");  
                        		System.out.print("\nPresione Cualquier Tecla para Continuar\n");
                        		new java.util.Scanner(System.in).nextLine();   
                        	}
                		}
                		else {
                			System.out.println("No hay ninguna Categoria Creada");  
                			System.out.print("\nPresione Cualquier Tecla para Continuar\n");
                			new java.util.Scanner(System.in).nextLine(); 
                		}
                	break;
                	}
    
                
                case 2:{
                    //modif plato
                	System.out.print("_______________________________________________________________________________________________________________");
                    System.out.print("\n| Nombre\t | Codigo\t | Categoria\t | Descripcion del plato \t| Precio\t| Contorno\t|\n");
                    System.out.print("|________________|_______________|_______________|______________________________|_______________|_______________|\t\n");
                    platosAVL.inOrderPlatos(raizPlatos);
                    System.out.print("|________________|_______________|_______________|______________________________|_________s______|_______________|\t\n");
                    System.out.println("\nIndique el codigo del plato que desea modificar\n");
                    int nummer =leer.nextInt();
                    
                    if(platosAVL.estaPlato(raizPlatos, nummer) == true){
                    	platosAVL.modificarPlato(raizPlatos,raizMenuDia, nummer);  
                    }
                    else{
                        System.out.println("\n\nEl plato que intenta modificar no se encuenta\n");  
    					System.out.print("\nPresione Cualquier Tecla para Continuar\n");
    					new java.util.Scanner(System.in).nextLine();
    				}
                    break;
                }
    
                case 3:{
                    //mostrar plato
                	System.out.print("\nLos Platos Son:\n\n\n");
                	System.out.print("_______________________________________________________________________________________________________________");
                    System.out.print("\n| Nombre\t | Codigo\t | Categoria\t | Descripcion del plato \t| Precio\t| Contorno\t|\n");
                    System.out.print("|________________|_______________|_______________|______________________________|______________|_______________|\t\n");
                    platosAVL.inOrderPlatos(raizPlatos);
                    System.out.print("|________________|_______________|_______________|______________________________|______________|_______________|\t\n");
                    System.out.print("\n\nPresione Cualquier Tecla para Continuar\n");
					new java.util.Scanner(System.in).nextLine();
                    break;
                }
    
                case 4:{
                    //elim plato
                	System.out.print("_______________________________________________________________________________________________________________");
                    System.out.print("\n| Nombre\t | Codigo\t | Categoria\t | Descripcion del plato \t| Precio\t| Contorno\t|\n");
                    System.out.print("|________________|_______________|_______________|______________________________|______________|_______________|\t\n");
                    platosAVL.inOrderPlatos(raizPlatos);
                    System.out.print("|________________|_______________|_______________|______________________________|______________|_______________|\t\n");
                    System.out.println("\nIndique el codigo del plato que desea eliminar\n");
                    
                    leer.nextLine();
                    platoCode=leer.nextInt();
                    
                    if(platosAVL.estaPlato(raizPlatos, platoCode)){
                    	platosAVL.eliminarNodoPlatos(raizPlatos, platoCode); 
                        menuDiaAVL.eliminarNodoMenuDia(raizMenuDia, platoCode);
                        System.out.println("\nSe ha eliminado Correctamente el plato:  "+ platoCode); 
                        System.out.print("\n\nPresione Cualquier Tecla para Continuar\n");
    					new java.util.Scanner(System.in).nextLine();
                    }
                    else{
                        System.out.println("\nEl plato que intenta eliminar no se encuenta\n");
                        System.out.print("\n\nPresione Cualquier Tecla para Continuar\n");
    					new java.util.Scanner(System.in).nextLine();
                    }
                    break;
                }
                
                default: 
                	if (num != 5){
    				System.out.println( "Indique una opcion valida\n");  
					System.out.print("\nPresione Cualquier Tecla para Continuar\n");
					new java.util.Scanner(System.in).nextLine();
                	}
    		        break;
		    }
		  }while (num!=5);
    }

    
    void menuCateg(){
        int num, codigoDado=0;
        String categName="";
		  
		  do{
			System.out.println("\n\n\n\n\n\n\n\n");
			System.out.println("******************************************");
			System.out.println("*            Nosso                       *");
			System.out.println("*                Almoco                  *");
            System.out.println("*                                        *");
            System.out.println("*               Personal                 *");
			System.out.println("******************************************");
			System.out.println("* 1. Agregar Categoria                   *");
			System.out.println("* 2. Modificar Categoria                 *");
            System.out.println("* 3. Mostrar Categorias                  *");
            System.out.println("* 4. Eliminar Categoria                  *");
            System.out.println("* 5. Salir                               *");
            System.out.println("******************************************");
			
            num = leer.nextInt();
			
		    switch (num){
                case 1:{
                    //agg Categoria
                	System.out.print("\nIndique el nombre de la Categoria que desea agregar:\n");
                	leer.nextLine();
                    categName = leer.nextLine();
                     
                    int codigo = (int)(Math.random()*1000+1); //codigo random de la categoria
                     
                    if(!categoriasAVL.existe(raizCateg,codigo)){
                    	raizCateg = categoriasAVL.insertarCategoria(raizCateg,codigo,categName); 
                    	System.out.print( "\nSe ha insertado correctamente la categoria:  " + categName);
                    	System.out.print( "\nCuyo Codigo Sera:  " + codigo + "\n\n");
 						System.out.print("\nPresione Cualquier Tecla para Continuar\n");
 						new java.util.Scanner(System.in).nextLine();
                    }	 
                    else{
                        System.out.print("\n\nLa Categoria ya se encuentra\n\n"); 
 						System.out.print("\nPresione Cualquier Tecla para Continuar\n");
 						new java.util.Scanner(System.in).nextLine();
		    		}
                    break;
                }
    
                case 2:{
                	//modif categoria
                	System.out.print("\nLas Categorias Son:\n\n\n");
                	System.out.print("_________________________________");
                    System.out.print("\n| Nombre\t | Codigo\t|\n");
                    System.out.print("|________________|______________|\t\n");
                    categoriasAVL.inOrder(raizCateg);
                    System.out.print("|________________|______________|\t\n");
                	
                    System.out.print("\n\nIndique El codigo de la Categoria que desea modificar:");
                    codigoDado=leer.nextInt();

                        if(!categoriasAVL.existe(raizCateg, codigoDado)){
                            System.out.print("\n\nLa categoria que busca no existe\n");
                            System.out.print("Vuelva a Intentarlo\n"); 
     						System.out.print("\nPresione Cualquier Tecla para Continuar\n");
     						new java.util.Scanner(System.in).nextLine();
                        }
                        else{ 
                        	String nombreCategoria = categoriasAVL.buscarCategoria(codigoDado, raizCateg).nombreCate;
                                
                            System.out.print("\n\nIndique nombre de la nueva categoria\n");
                            leer.nextLine();
                            categName=leer.nextLine();

                            categoriasAVL.modificar(raizCateg, codigoDado, categName);
                            platosAVL.ModificarCatePlatos(raizPlatos, nombreCategoria, categName);
                            menuDiaAVL.ModificarCateCarta(raizMenuDia, nombreCategoria, categName);
                            
                            System.out.print("\nCategoria Modificada Correctamente\n");
     						System.out.print("\nPresione Cualquier Tecla para Continuar\n");
     						new java.util.Scanner(System.in).nextLine();
                        }
                	
                    break;
                }
    
                case 3:{
                	//mostrar categorias
                	System.out.print("\nLas Categorias Son:\n\n\n");
                	System.out.print("_________________________________");
                    System.out.print("\n| Nombre\t | Codigo\t|\n");
                    System.out.print("|________________|______________|\t\n");
                    categoriasAVL.inOrder(raizCateg);
                    System.out.print("|________________|______________|\t\n");
                    System.out.print("\n\nPresione Cualquier Tecla para Continuar\n");
					new java.util.Scanner(System.in).nextLine();
                    break;
                }
    
                case 4:{
                	//Elimina la Categoria
                	codigoDado = 0;
                	
                	System.out.print("\nLas Categorias Son:\n\n\n");
                	System.out.print("_________________________________");
                    System.out.print("\n| Nombre\t | Codigo\t|\n");
                    System.out.print("|________________|______________|\t\n");
                    categoriasAVL.inOrder(raizCateg);
                    System.out.print("|________________|______________|\t\n");
                    
                    System.out.print("\n\nIndique El codigo de la Categoria que desea eliminar:");
                    leer.nextLine();
                    codigoDado=leer.nextInt();                          

                    if(!categoriasAVL.existe(raizCateg,codigoDado)){
                        System.out.print("\n\nLa categoria que busca no existe\n");
                        System.out.print("Vuelva a Intentarlo\n"); 
 						System.out.print("\nPresione Cualquier Tecla para Continuar\n");
 						new java.util.Scanner(System.in).nextLine();
                    }
                    else{ 
                    	categoriasAVL.eliminarNodo(raizCateg, codigoDado);
                    	platosAVL.eliminarNodoPlatosCate(raizPlatos, codigoDado);
                    	menuDiaAVL.eliminarNodoMenuDiaCate(raizMenuDia, codigoDado);
                    	
                        System.out.print("\nCategoria Eliminada Correctamente\n");
 						System.out.print("\nPresione Cualquier Tecla para Continuar\n");
 						new java.util.Scanner(System.in).nextLine();
                    }
                    break;
                }
                
                default: 
                	if (num != 5){
    				System.out.println( "Indique una opcion valida\n");  
					System.out.print("\nPresione Cualquier Tecla para Continuar\n");
					new java.util.Scanner(System.in).nextLine();
                	}
    		        break;
    		        
		    }
		  }while (num!=5);
    }   
}

