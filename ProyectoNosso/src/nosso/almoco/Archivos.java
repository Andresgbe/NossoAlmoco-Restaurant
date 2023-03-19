package nosso.almoco;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Archivos {
	
	Registro nombrex = new Registro();
	
	

    public void createFile(String fileName) {  
    	String nombre = null; String cedulax = null;  String direcciox = null; String telefono = null; String correo = null;  String clavex = null;
    	

    	
        System.out.println("=== Creando el archivo " + fileName + " ===");
        boolean fileCreated = false;
        File file = new File(fileName); 
        try {
            fileCreated = file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(nombrex.apellidos_nombres(nombre) + "_" + nombrex.cedula(cedulax) + "_" + nombrex.direccion(direcciox) + "_" + nombrex.numero_telefono(telefono) + "_" + nombrex.mail(correo) + "_" + nombrex.clave(clavex) + "_");          
            fileWriter.close();
            if(fileCreated) {
                System.out.println("=== El archivo se creo correctamente ===");
            } else {
                System.out.println("=== El archivo ya existe ===");
            }
        } catch (IOException e) {
            System.out.println("=== Excepcion al crear el archivo " + e);
        }
    }
    
    
    
    
    ///////////////////////
    ///////////////////////
    
    
    
    
    public void createFileAdmin(String fileNames) {  
  
        boolean fileCreated = false;
        File file = new File(fileNames); 
        try {
            fileCreated = file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("admin@gmail.com_clave123_2345678_");          
            fileWriter.close();
            if(fileCreated) {
                System.out.println("=== El archivo se creo correctamente ===");
            } else {
                System.out.println("=== El archivo ya existe ===");
            }
        } catch (IOException e) {
            System.out.println("=== Excepcion al crear el archivo " + e);
        }
    } 
    
    
    
    

 
    
    
    
    
    
    /////////////////
    //////////////
    
    
    
    
    
    
    
 
    
    
   public String readFile(String fileName, String data) {
   //    System.out.println("=== Leyendo el archivo " + fileName + " ===");
       File file = new File(fileName);
       try {
           Scanner sc = new Scanner(file);
           while (sc.hasNextLine()) {
               data = sc.nextLine();
           //    System.out.println(data);
           }
       } catch (FileNotFoundException e) {
           System.out.println(" === Hubo un error al abrir el archivo " + e);
       }
       return data;
   }

     
   
   
   
   
   
   
   
   
   
   
   
   
   
    
    
    
   
    
    
    
    
    
    public void deleteFile(String fileName) {
        System.out.println("=== Borrando el archivo " + fileName + " ===");
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("=== El archivo se borro correctamente ===");
        } else {
            System.out.println("=== No se pudo borrar el archivo ===");
        }
    }

    

    
    
    

    
    
    
    
    
    
    
    
    
   
   public int autenticar_usuario(){  /// INICIAR SESION CLIENTES
	  String dato = "cliente.txt"; String datos = null; int i = 0;    int  intentos = 0; String aux;
	  int valido = 1;
	   int intentox = 3; int autenticador = 0;
	   
	   String correo = "";
	   String clave = "";
	   String correox = "";
	   String clavex = "";
	   
	  
	   
	  Scanner sc = new Scanner(System.in);
	 // readFile(dato, datos);
	  
	  char[] matriz = readFile(dato, datos).toCharArray();
	  
	
	  
	  
	  
	  while (matriz[i] != '_') {
	  
	  
	  i++;
   } i++;
   
   
   
   
   while (matriz[i] != '_') {
	  
	   i++;   
   }  i++;  
   
   
   
   while (matriz[i] != '_') {
	   
	   i++; 
   }  i++;  
   
   
   while (matriz[i] != '_') {
	  
	   i++;   
   } i++;     
   
   
 
  
   
   while (matriz[i] != '_') {
	   correo = correo + matriz[i];
	   i++;
	  
	  
	   
		  
   }  i++;  
   
   while (matriz[i] != '_') {
	   clave = clave + matriz[i];
	   i++;
	  
	  
	   
		  
   }  i++;  
   
   
   int es_valido = 0; int correcto = 0; int correctox = 0; int opcion = 0;
   
 
   	do 
   	{
   		es_valido = 0; valido = 1;
   		System.out.println("Introduzca su correo para iniciar sesion");   
   		System.out.println("Le quedan " + intentox + " intentos");
   		System.out.println("");
   		System.out.print("Correo: ");
   		correox = sc.nextLine();
   
   		if (correo.equals(correox)) {
   			correcto = 1;
   			opcion = 1;
   		} else {
   			intentos++;
   			intentox--;
   		}
   		
   		if (intentos > 2) {
   			opcion = 1;
   		}
   		
   		
 
   	}while(opcion != 1);

   	
   	if (correcto == 1) {
   			
   		intentos = 0;
   		do {
   			es_valido = 0; valido = 1;
   			opcion = 0;
   			System.out.println("Ahora introduzca su clave");
   			System.out.println("Le quedan " + intentox + " intentos");
   			System.out.println("");
   			System.out.print("Clave: ");  
   			clavex = sc.nextLine();
   		
   			if (clave.equals(clavex)) {
   	   			correctox = 1;
   	   			opcion = 1;
   	   		} else {
   	   			intentos++;
   	   			intentox--;
   	   		}
   	   		
   	   		if (intentos > 2) {
   	   			correctox = 1;
   	   		}
		
   		
   	   		
   			}while(correctox != 1);
   		
   		
   		}
   	else {
	 System.out.println("Intentelo mas tarde");
 }
 		if ((opcion == 1) && (correcto == 1)){
 			autenticador = 1;
 			}
   	return autenticador;
 
  }
   

   
   
   /////////////
   ////////////
   
   
   void recuperar_datos_usuario() {  /// RECUPERAR DATOS CLIENTE
	   String dato = "cliente.txt"; String datos = null;  String cedula = "";
	   String correo = ""; String clave = ""; String cedulax = "";
	   int i = 0;
		  Scanner sc = new Scanner(System.in);
			 // readFile(dato, datos);
			
			 char[] matriz = readFile(dato, datos).toCharArray();
			  
			
			 
			while (matriz[i ] != '_') {
			  
			  
			  i++;
		   } i++;
		   
		   
		   
		   
		   while (matriz[i] != '_') {
 
			cedula = cedula + matriz[i];
			 
			   i++;   
		   }  i++;  
		   
		  
		   
		   while (matriz[i] != '_') {
			   
			   i++; 
		   }  i++;  
		   
		   
		   while (matriz[i] != '_') {
			  
			   i++;   
		   } i++;     
		   
		   
		 
		  
		   
		   while (matriz[i] != '_') {
			   correo = correo + matriz[i];
			   i++;
			  
			  
			   
				  
		   }  i++;  
		   
		   while (matriz[i] != '_') {
			   clave = clave + matriz[i];
			   i++;
			  
			  
			   
				  
		   }  i++;  
		   
		   int opcion = 0; int valido = 0; String cedulav = ""; String cedulae = "";
		   
	  while(opcion != 1) {
		  opcion = 1;
		  System.out.println("Ingrese su cedula para recuperar los datos, solo ingrese numeros");
		  cedulax = sc.nextLine();
		  
		  
		  cedulav = "V-" + cedulax;
		  
		  		
		  		cedulae = "E-" + cedulax;
				  
		  		if (cedulae.equals(cedula)) {
		  			opcion = 1;
		  			valido = 1;
		  		} else {
		  			opcion = 0;
		  			
		  		}
		  
		  		if (cedulav.equals(cedula)) {
		  			opcion = 1;
		  			valido = 1;
		  		} else {
		  			opcion = 0;
		  			
		  		}
		  
	  }
		   
		   if (valido == 1) {
			   nombrex.limpia_pantallas();
			   System.out.println("La direccion de correo es " + correo);
			   System.out.println("La clave es " + clave);
			   System.out.println("");
			   
       		System.out.print("\nPresione Cualquier Tecla para Continuar\n");
       		new java.util.Scanner(System.in).nextLine();
		   }
		   
		   
	   
   }
  
   
   ///////////
   
   
   
   
   
   	public int autenticar_admin() { // INICIAR SESION ADMIN
   		int validador = 0;
   		String dato = "admin.txt"; String datos = null; int autenticador = 0;
   		int correcto = 0;
    
	  Scanner sc = new Scanner(System.in);
	 // readFile(dato, datos);
	  
	  char[] matriz = readFile(dato, datos).toCharArray();
	  
	  
	  String cedula = "";
	  String correo = ""; 
	  String clave = ""; 
	
	   int i = 0;
	

			  
			
			 
			while (matriz[i ] != '_') {
			  correo = correo + matriz[i];
			  
			  i++;
		   } i++;
		   
		   
		   
		   
		   while (matriz[i] != '_') {

			clave = clave + matriz[i];
			 
			   i++;   
		   }  i++;  
		   
		  
		   
		   while (matriz[i] != '_') {
			  cedula = cedula + matriz[i];
			   i++; 
		   }  i++;  
		  
		   
		   
		   int es_valido = 0;  int correctox = 0; int opcion = 0; int intentox = 3;
		   int valido = 0; String correox = ""; int intentos = 0; String clavex = "";
		 
		   	do 
		   	{
		   		es_valido = 0; valido = 1;
		   		System.out.println("Introduzca su correo para iniciar sesion");   
		   		System.out.println("Le quedan " + intentox + " intentos");
		   		System.out.println("");
		   		System.out.print("Correo: ");
		   		correox = sc.nextLine();
		   
		   		if (correox.equals(correo)) {
		   			correcto = 1;
		   			opcion = 1;
		   		} else {
		   			intentos++;
		   			intentox--;
		   		}
		   		
		   		if (intentos > 2) {
		   			opcion = 1;
		   		}
		   		
		   		
		 
		   	}while(opcion != 1);

		   	
		   	if (correcto == 1) {
		   			
		   		intentos = 0;
		   		do {
		   			es_valido = 0; valido = 1;
		   
		   		
		   			System.out.println("Ahora introduzca su clave");
		   			System.out.println("Le quedan " + intentox + " intentos");
		   			System.out.println("");
		   			System.out.print("Clave: ");  
		   			clavex = sc.nextLine();
		   		
		   			if (clavex.equals(clave)) {
		   				es_valido=1;
		   	   			correctox = 1;
		   	   			opcion = 1;
		   	   		} else {
		   	   			intentos++;
		   	   			intentox--;
		   	   		}
		   	   		
		   	   		if (intentos > 2) {
		   	   			correctox = 1;
		   	   		}
				
		   		
		   	   		
		   		}while(correctox != 1);
		   		
		   		
		 } else {
			 System.out.println("Intentelo mas tarde");
		 }
		 		if ((correcto == 1) && (es_valido == 1)){
		 			autenticador = 1;
		 			}
		 		
		   	return autenticador;
		   
	  
	  

   	}
   	
   	//////////////////
   	/////////////////
   	
   	
   	public void recuperar_datos_admin() {
   		String dato = "admin.txt"; String datos = null;
 
    
	  Scanner sc = new Scanner(System.in);
	 // readFile(dato, datos);
	  
	  char[] matriz = readFile(dato, datos).toCharArray();
	  
	  
	  String cedula = "";
	  String correo = ""; 
	  String clave = ""; 
	  String cedulax = "";
	
	   int i = 0;
	

			  
			
			 
			while (matriz[i ] != '_') {
			  correo = correo + matriz[i];
			  
			  i++;
		   } i++;
		   
		   
		   
		   
		   while (matriz[i] != '_') {

			clave = clave + matriz[i];
			 
			   i++;   
		   }  i++;  
		   
		  
		   
		   while (matriz[i] != '_') {
			  cedula = cedula + matriz[i];
			   i++; 
		   }  i++;  
		   
		  
   		
		   
		   
		   
		   
				   int opcion = 0; int valido = 0; 
				   
					  while(opcion != 1) {
						  opcion = 1;
						  System.out.println("Ingrese su cedula para recuperar los datos, solo ingrese numeros");
						  cedulax = sc.nextLine();
						  
						 
								  
						  		if (cedulax.equals(cedula)) {
						  			opcion = 1;
						  			valido = 1;
						  		} else {
						  			opcion = 0;
						  			
						  		}
						  
					  }
						   
						   if (valido == 1) {
							   nombrex.limpia_pantallas();
							   System.out.println("La direccion de correo es " + correo);
							   System.out.println("La clave es " + clave);
							   System.out.println("");							   
							   System.out.print("\nPresione Cualquier Tecla para Continuar\n");
		                		new java.util.Scanner(System.in).nextLine();
						   }
		   
		   
   	}
   
}



