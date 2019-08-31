package paquete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;


public class Principal {

        int cont =1;
	
	public static void main(String[] args) {//falata calcular la moda Pedro, el método es imperfecto, el resto está...
		
        Principal miClase = new Principal();
		
        if(args.length==1){
        
		String ruta = args[0];// hecho!!!
		
		LinkedList<String> lineasLeidas = miClase.leeLinea(ruta);//va bien 
        
		for(String s: lineasLeidas){
		
			LinkedList<String> paraEscribir = new LinkedList<String>();
		
		paraEscribir.add(0, s);//A) la tira leida...
		
		LinkedList<String> tokens = miClase.devuelveLineasSinPuntoyComa(s);
		LinkedList<Integer> enterosValidos = miClase.enterosValidos(tokens);
		String enterosSeparadosComas = "";
		
		for(Integer i: enterosValidos){
			
			enterosSeparadosComas = enterosSeparadosComas+i+";";
			
		}
		paraEscribir.add(1, enterosSeparadosComas);//B)enteros Validos separados por ";"
		
		paraEscribir.add(2, miClase.valoresNoValidosPorPuntoYComa(tokens));//C) no validos ";"
		
		String maximoValido =""+miClase.maximoEnteroValido(enterosValidos);
		
		paraEscribir.add(3,maximoValido);//D) maximo entero valido
		
		String minValido =""+ miClase.minimoEnteroValido(enterosValidos);
		
		paraEscribir.add(4, minValido);//E) min Entero valido
		
		String factorialDelMax =""+ miClase.factorialDelMaximo(Integer.parseInt(maximoValido));
		
		paraEscribir.add(5, factorialDelMax);//F) factorial del max valido
		
		LinkedList<Integer> validosMenorAMayor = miClase.enterosValidosMenorAMayor(enterosValidos);
		
		String validosMenorAMayorString ="";
		
		for(Integer i: validosMenorAMayor){
			
			validosMenorAMayorString =validosMenorAMayorString+i+" ";
			
		}
		
		paraEscribir.add(6, validosMenorAMayorString);//F2) validos de menor a mayor
		
		LinkedList<Integer>validosMayorAMenor= miClase.enterosValidosDeMayorAMenor(enterosValidos);
		
		String valMayorAMenorString ="";
		
		for(Integer i: validosMayorAMenor){
			
			valMayorAMenorString = valMayorAMenorString+i+" ";
			
		}
		
		paraEscribir.add(7, valMayorAMenorString);//G)validos de mayor a menor
		
		LinkedList<Integer> valoresRep = miClase.valoresRepetidos(enterosValidos);
		
		String rep ="";
		
		for(Integer i: valoresRep){
			
			
			rep = rep+i+" ";
			
		}
		
		paraEscribir.add(8, rep);//H)repetidos
		
		String mediaAritmetica =""+miClase.mediaAritmetica(enterosValidos);
		
		paraEscribir.add(9, mediaAritmetica);//I)media aritmetica
		
		String paraMediana =""+miClase.mediana(validosMenorAMayor);
		
		paraEscribir.add(10, paraMediana);//J)mediana
		
		String moda =""+miClase.moda(validosMenorAMayor);
		
		paraEscribir.add(11, moda);//K)moda
		
		LinkedList<Integer> pares = miClase.pares(validosMenorAMayor);
		
		String paresString = "";
		
		for(Integer i: pares){
			
			paresString = paresString+i+" ";
			
		}
		
		paraEscribir.add(12, paresString);//L)Pares
		
		LinkedList<Integer> impares = miClase.impares(enterosValidos);
		
		String imparesString = "";
		
		for(Integer i: impares){
			
			imparesString = imparesString+i+" ";
			
		}
		
		paraEscribir.add(13, imparesString);//M)impares
		
		LinkedList<Integer> primos = miClase.listaDePrimos(enterosValidos);
		
		String primosString ="";//
		
		for(Integer i: primos){
			
			primosString = primosString+i+" ";
			
		}
		
		paraEscribir.add(14, primosString);//N)primos
		
		LinkedList<Integer> sinRepetidos = miClase.numerosSinRepetidos(enterosValidos);
		
		String sinRepetidosString ="";
		
		for(Integer i: sinRepetidos){
			
			sinRepetidosString = sinRepetidosString+i+" ";
			
		}
		
		paraEscribir.add(15, sinRepetidosString);//O)validos sin repetidos
		
		
		//Aqui escribe el archivo!!!
		
		miClase.escribeLineas(ruta, paraEscribir);
		
	}//fin del for each principal
	 
		System.out.println("Proceso terminado...");
		
        	}else{
        	
        	System.out.println("No hay archivo!!!");
        	
        }
		
	}//fin del main
	
	
	
	//***********Métodos***********
	
	public LinkedList<String> leeLinea(String ruta){//**************************************************************
		
		LinkedList<String> arrayLineas = new LinkedList<String>();
		
		//int cont = 0;
		
		Path path =
				Paths.get(ruta);
		
				try {
		
					BufferedReader reader =
				
							Files.newBufferedReader(path,
				
									Charset.defaultCharset());
				
					String linea = "";
				
					while (linea != null) {
						
						linea = reader.readLine();
						
						if(linea==null){ return arrayLineas;}//***
						arrayLineas.add(linea);
				
					}
					
					return arrayLineas;
				}
			
				catch (IOException x) {
				
					System.err.format("IOException:%s%n", x);
				
				}
				return null ;
	}
	
	
	public String devuelveNombreArchivoSinExtencion(String nombre){
		
		int ultima_ocurrencia = nombre.lastIndexOf(".txt");
		
		String nombre_sin_extension = nombre.substring(0, ultima_ocurrencia);
		
		return nombre_sin_extension;
	}
	
	public void escribeLineas(String entrada,LinkedList<String> lineasAEscribir){//*********************************
		
		Principal p = new Principal();
		String nombre_simple = p.devuelveNombreArchivoSinExtencion(entrada);
		
		
		Path path_salida = Paths.get(nombre_simple+"_salida_"+cont+".txt");
		try {
			
			BufferedWriter writer = Files.newBufferedWriter(path_salida, Charset.defaultCharset());
			
			for(String s: lineasAEscribir){
			
			String linea = s;
			
			writer.write(linea);
			
			writer.newLine();}
			
			writer.close();
			
			
		
		} catch (IOException x) {
		
			System.err.format("IOException:%s%n", x);
		
		}finally {
			cont++;//**********************************************************************************************
		}
		
	}

	public LinkedList<Integer> enterosValidos(LinkedList<String> array){//******************************************
		
		LinkedList<Integer> enteros = new LinkedList<Integer>();
		
		
		for(String s: array){
			
			try{
				enteros.addLast(Integer.parseInt(s));
			
				
			}catch(Exception e){
				
				
				}
				
			}
		
		return enteros;
	}
	
	public String valoresNoValidosPorPuntoYComa(LinkedList<String> array){//****************************************
		
		String valores="";
	
		for(String s: array){
			
			try{
				
				int entero = Integer.parseInt(s);
				
			}catch(Exception e){
				
				valores = valores+s+";";
			}
			
			
		}
			
		return valores;
	}
	
	public int maximoEnteroValido(LinkedList<Integer> array){//****************************************************
		
		LinkedList<Integer> mayor = enterosValidosDeMayorAMenor(array);
	
		return mayor.getFirst();
	}
	
	public int minimoEnteroValido(LinkedList<Integer> array){//*****************************************************
		
		LinkedList<Integer> menor = enterosValidosMenorAMayor(array);
		
		return menor.getFirst();
	}
	
	public long factorialDelMaximo(long maximo){//********************************************************************
		
		if(maximo<0)
		
			return 0;
		
		if (maximo==0)
	    
			return 1;
	   
		else
	    
			return maximo*(factorialDelMaximo(maximo-1));//********************************************************
		
		}
	
	public LinkedList<Integer> enterosValidosMenorAMayor(LinkedList<Integer> array){//*****************************
		
		int contenedor;
		
		for(int i =0; i< array.size(); i++){
			for(int x =0; x<array.size(); x++){
				
				if(array.get(i)<array.get(x)){
					
					contenedor = array.get(i);
					array.set(i, array.get(x));//array set i a array get x
					array.set(x, contenedor);
					
				}
				
				
			}
			
			
		}
		
		
		return array;//*********************************************************************************************
	}
	
	public LinkedList<Integer> enterosValidosDeMayorAMenor(LinkedList<Integer> array){//****************************
		
int contenedor;
		
		for(int i =0; i< array.size(); i++){
			for(int x =0; x<array.size(); x++){
				
				if(array.get(i)>array.get(x)){
					
					contenedor = array.get(i);
					array.set(i, array.get(x));//array set i a array get x
					array.set(x, contenedor);
					
				}
				
				
			}
			
			
		}
		
		
		return array;//*********************************************************************************************
	}
	
	public LinkedList<Integer> valoresRepetidos(LinkedList<Integer> array){//***************************************
		
		LinkedList<Integer> miLista =new LinkedList<Integer>();
		
		for(int i =0; i<array.size();i++){
			for(int j =i+1; j<array.size();j++){
				
				if(array.get(i)==array.get(j)){
					
					if(!miLista.contains(array.get(i)))
					miLista.add(array.get(i));
					
				}
				
			}
			
		}
			
		return miLista;//*******************************************************************************************
	}
	
	public double mediaAritmetica(LinkedList<Integer> array){//*****************************************************
		
		int contador =array.size();
		int acumula =0;
		
		
		for(int i =0; i<array.size(); i++){
			
			acumula = acumula+array.get(i);
			
		}
		
		return acumula/contador;//**********************************************************************************
	}
	
	public double mediana(LinkedList<Integer> arrayOrdenado){//*****************************************************
		
		int largo = arrayOrdenado.size();
		int mitad = largo/2;
		
		if(largo%2==0){
			
			return (double)(arrayOrdenado.get(mitad-1)+arrayOrdenado.get(mitad))/2;
			
		}else{
			
			return arrayOrdenado.get(mitad);//probar
			
		}
	
	}//***************************************************************************************************************
	
	public int moda(LinkedList<Integer> array){//NO es perfecto*************Modifocar!!!************************************
		
		int maxVecesQueSeRepite =0;
		int resModa =0;
		
		for(int i =0; i<array.size(); i++){
			
			int vecesQueSeRepite = 0;
			
			for(int j = 0; j<array.size(); j++){
				
				if(array.get(i)==array.get(j)){//se compara con si mismo, no importa todos se suman
					
					vecesQueSeRepite++;
				}
				
				
				if(vecesQueSeRepite> maxVecesQueSeRepite){
					
					resModa = array.get(i);
					
					maxVecesQueSeRepite = vecesQueSeRepite;
					
				}
			}
			
		}
	
		
		return resModa;//probar*******************************************************************************
	}
	
	public LinkedList<Integer> pares (LinkedList<Integer> array){//*************************************************
		
		LinkedList<Integer> arrayDePares= new LinkedList<Integer>();
		int cont = 0;
		
		for(int i = 0; i< array.size(); i++){
			
			if(array.get(i)%2==0&&array.get(i)>0){
				
				arrayDePares.add(cont, array.get(i));//add arrayDePares.add(cont,array.get(i));
				cont++;
			}
			
		}
	
		return arrayDePares;//**************************************************************************************
	}
	
	public LinkedList<Integer> impares(LinkedList<Integer> array){//************************************************
		
		LinkedList<Integer> arrayDeImpares = new LinkedList<Integer>();
		int cont =0;
		
		
		for(int i =0; i<array.size(); i++){
			
			if(array.get(i)%2!=0){
				
				arrayDeImpares.add(cont, array.get(i));;//index cont array get i
				cont++;
				
			}
			
		}		
		
		return arrayDeImpares;//************************************************************************************
	}
	
	public boolean esPrimo(int n){//********************************************************************************
		
		
		if(n<0)return false;
		//Comprobamos si es múltiplo de 2
        if (n%2==0) return false;
        
        //comprobamos si es divisible por algún número impar
        for(int i=3;i*i<=n;i+=2) {
        
        	if(n%i==0)
            
        		return false;
        }
        
        return true;//**********************************************************************************************
	}
	
	public LinkedList<Integer> listaDePrimos(LinkedList<Integer> array){//******************************************
		
		LinkedList<Integer> miLista = new LinkedList<Integer>();
		
		for(Integer i: array){
			
			if(esPrimo(i)){
				
				if(i>0)
				
					miLista.add(i);
				
			}
			
		}
		
	return miLista;	//OK********************************************************************************************
	}
	
	public LinkedList<Integer> numerosSinRepetidos(LinkedList<Integer> array){//************************************
		
		LinkedList<Integer> miList = new LinkedList<Integer>();
		
		for(Integer i: array){
			
			if(!miList.contains(i)){
				
				miList.add(i);
				
			}
			
		}
		
		return miList;//*******************************************************************************************
	}
	
	public LinkedList<String> devuelveLineasSinPuntoyComa(String linea){//*****************************************
		
		LinkedList<String> numerosEtc = new LinkedList<>();
		
		String[] dividida = linea.split(";");
		
		for(String s: dividida){
			
			numerosEtc.add(s);
			
		}
		
		return numerosEtc;

	}
	
}


