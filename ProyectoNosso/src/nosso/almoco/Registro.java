package nosso.almoco;

import java.util.Scanner;
import java.util.regex.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Registro {
	
Scanner sc = new Scanner(System.in);





public int validador(String termino) {
	char caracter; 
	int longitud, valido;
	int vnumero = 0, vletra = 0, vgrafico = 0;
	char[] matriz = termino.toCharArray();  
	
	longitud = termino.length();
	valido = 0;
	
		for (int i=0; i < longitud; i++) 
		{	
			caracter = matriz[i];		
					
			if (Character.isDigit(caracter)) {			
				vnumero = 1; 	
			//	System.out.println("numero");
	        } else if (Character.isLetter(caracter)) {
	           vletra = 1; 
	       //    System.out.println("letra");
	        } else {       	
	           vgrafico = 1;   
	       //   System.out.println("grafico");
	        }
		} 
		 
		if ((vnumero == 1) && (vletra == 0) && (vgrafico == 0))  {            // 1 SOLO NUMEROS
			valido = 1;
		} else if ((vnumero == 0) && (vletra == 1) && (vgrafico == 0)) {      // 2 SOLO LETRAS
			valido = 2;
		} else if ((vnumero == 0) && (vletra == 0) && (vgrafico == 1)) {      // 3 SOLO GRAFICO
			valido = 3;
		} else if ((vnumero == 1) && (vletra == 1) && (vgrafico == 0)) {      // 4 NUMERO & LETRA
			valido = 4;
		} else if ((vnumero == 1) && (vgrafico == 1) && (vletra == 0)) {      // 5 NUMERO & GRAFICO
			valido = 5;
		} else if ((vletra == 1) && (vgrafico == 1) && (vnumero == 0)) {      // 6 LETRA & Y GRAFICO
			valido = 6;
		} else if ((vnumero == 1) && (vletra == 1) && (vgrafico == 1)) {      //  7 Everything
			valido = 7;
		}
	//	System.out.println(valido);
		return valido;
	}
	




/////////////////////////////////
/////////////////////////////////






public String readFile(String fileName, String data) {
    System.out.println("=== Leyendo el archivo " + fileName + " ===");
    File file = new File(fileName);
    try {
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            data = sc.nextLine();
            System.out.println(data);
        }
    } catch (FileNotFoundException e) {
        System.out.println(" === Hubo un error al abrir el archivo " + e);
    }
    return data;
}


public void limpia_pantallas() {
	System.out.println("");
	System.out.println("");
	System.out.println("");
	System.out.println("");
	System.out.println("");
	System.out.println("");
	System.out.println("");
	System.out.println("");
	System.out.println("");
	System.out.println("");
	System.out.println("");
	System.out.println("");
	System.out.println("");
	System.out.println("");
	System.out.println("");
	System.out.println("");
	System.out.println("");
	System.out.println("");
}
	
	
	















//////////////////////
/////////////////////











public String apellidos_nombres(String nombre_completo) {
	int opc = 0; int longitud = 0; char caracter; int incorrecto = 0; int validador = 0; int comprueba = 0;
	
	do {
	opc = 0;
	
	
	System.out.println("Introduce tus nombres y apellidos");
	nombre_completo = sc.nextLine();
	
	char[] matriz = nombre_completo.toCharArray(); 
	
	longitud = nombre_completo.length();
	
	for(int i=0; i < longitud; i++)
	{
		caracter = matriz[i]; 
		if (Character.isLetter(caracter) || Character.isSpaceChar(caracter)) {	
			comprueba = 1;
		} else {
			limpia_pantallas();
			incorrecto = 1;
			System.out.println("Introduce solamente letras!");
			System.out.println("Ejemplo: Luis Paredes");
			System.out.println("");
	
		}
	}
	
	if ((incorrecto == 0) && (comprueba == 1))
	{
		validador = 1;
	} else {
		comprueba = 0; incorrecto = 0;
	}
	
	}while(validador != 1);
	
	
	return nombre_completo;
}


















///////////////////////////
//////////////////////////







public String cedula(String ci) {
	int opcion, opc; String nacionalidad; int longitud;
	
	
	
	do {
		limpia_pantallas();
		System.out.println("Escoge tu nacionalidad");
		System.out.println("Escoge un numero del 1 al 2 como opcion");
		System.out.println("");
		System.out.println("1.) Venezolan@");
		System.out.println("2.) Extranjer@");
		System.out.println("");
		System.out.println("");
		opcion = sc.nextInt();
		
			if ((opcion != 1) && (opcion != 2)) {
				limpia_pantallas();
				System.out.println("Introduce un numero entre el 1 y el 2");
				System.out.println("");
			}
	}while((opcion != 1) && (opcion != 2));
	
	if (opcion == 1) {
		nacionalidad = "V-";
	} else {
		nacionalidad = "E-";
	}
	
	opc = 0;
	
		do {
			limpia_pantallas();
			System.out.println("Ahora vas a introducir tu cedula, solo introduzca los numeros");
			System.out.println("");
			System.out.println("Ejemplo: 29876234");
			System.out.print(nacionalidad);
			ci = sc.nextLine();
			longitud = ci.length();
			
			 	
			 		if ((validador(ci) == 1) && (longitud > 4) && (longitud < 11))
			 		{
						opc =1;
			 		}
						/* else {
			 			System.out.println("La cedula solo puede contener numeros!");
			 			ci = "";	
			 		} 	*/
			}while(opc != 1);
		
		ci = nacionalidad + ci;
		
		return ci;
		}











public String mail(String email){
	int opc = 0;

//Patrón para validar el email
Pattern pattern = Pattern
        .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

// El email a validar


	while(opc != 1) {
		System.out.println("Introduce tu correo completo");
		email = sc.nextLine();

		Matcher mather = pattern.matcher(email);
		
		if (mather.find() == true) {
			System.out.println("El email ingresado es válido.");
			opc = 1;
		} else {
			limpia_pantallas();
			System.out.println("El email ingresado es inválido. Intentelo de nuevo");
			System.out.println("");
			opc = 0;
		}
	}
return email;
}


/* int number = 110101; 
String temp = Integer.toString(number);
int[] numbers = new int[temp.length()];
for (int i = 0; i < temp.length(); i++) {
    numbers[i] = temp.charAt(i) - '0'; 

}
} */









public String numero_telefono(String numero_telefonox) {
	int opc = 0; int longitud = 0; String prefijo;
	
	do {
		limpia_pantallas();
		System.out.println("Ingrese su prefijo telefonico, solo ingrese numeros");
		System.out.println("");
		System.out.println("Ejemplo: +58");
		System.out.print("+");
		prefijo = sc.nextLine();
		longitud = prefijo.length();

		
		if ((validador(prefijo) == 1) && (longitud < 7)) {
			opc = 1;
		}
	} while(opc != 1);
	
	opc = 0;
			
			do {
				limpia_pantallas();
				longitud = 0;
				System.out.println("Ahora introduzca su numero telefonico");	
				numero_telefonox = sc.nextLine();
				longitud = numero_telefonox.length();
				
				if ((validador(numero_telefonox) == 1) && (longitud == 11)) {
					opc = 2;
				}
				
			}while (opc != 2);
			numero_telefonox = "+" + prefijo + " " + numero_telefonox;
			System.out.println("Tu numero de telefono es: " + numero_telefonox);
			return numero_telefonox;
}













public String direccion(String direccion) {
	int opc = 0; int longitud = 0; char caracter; int valido = 0; 
	
	do {
	valido = 0;
	opc = 0;
	System.out.println("En que lugar de la UCAB te encuentras?");
	direccion = sc.nextLine();
	char[] matriz = direccion.toCharArray(); 
	longitud = direccion.length();
	
	for(int i=0; i < longitud; i++)
	{
		caracter = matriz[i]; 
		if (Character.isLetter(caracter) || Character.isSpaceChar(caracter)) {			
			
		} else {
			valido++;
		}
	}
	
	if (valido == 0) {
		opc = 1;
	}
	
	}while((opc != 1) && (valido == 0));
	return direccion;
}
















public String clave(String clavex) {
	
	int longitud = 0; int opcion = 0;
	
	
	
	while(opcion != 1) 
	{
		String caracter = "";
		int letras_contador = 0; int numeros_contador = 0; int grafico_contador = 0;
		
		
		System.out.println("Ingresa tu clave");
		System.out.println("Recuerda que debe de tener al menos:");
		System.out.println("1 Caracter Grafico, 2 Numeros, 3 Letras. La longitud debe de ser minimo de 8.");
		clavex = sc.nextLine();
		
		char[] matriz = clavex.toCharArray(); 
		longitud = clavex.length();
		
			for (int i=0; i < longitud; i++) 
			{
				caracter = "";
				caracter = caracter + matriz[i];
				
				
				if(validador(caracter) == 1)  // LETRAS 3
				{
					letras_contador++;
					
					
				} else if (validador(caracter) == 2) { // NUMEROS 2
					numeros_contador++;
					
				} else if (validador(caracter) == 3) {  // GRAFICO 1
					grafico_contador++;
					
				} else { 
					
				}
				
				
				
			}
			
			if ((letras_contador > 2) && (numeros_contador > 1) && (grafico_contador > 0) && (longitud > 7)) {
				opcion = 1;
			} else {
				letras_contador = 0; numeros_contador = 0; grafico_contador = 0; longitud = 0; clavex = "";
			}
	
	
	}
	
	
	
	
	
	return clavex;
}
	
		
}