package dyv;

import java.io.*;
import java.util.Random;

public class Principal {
 
  public static void main(String[] args) throws IOException {
    
    FileWriter fichero = null;
    fichero = new FileWriter("estudio.txt");
    
    BufferedReader br = new BufferedReader ( new InputStreamReader (System.in) );
    Random rand = new Random();
    Boolean aumentar = true;
    
    MergeSort.Comparaciones.reset();
    Cuadratico.Comparaciones.reset();
    
    MergeSort msort = new MergeSort ();
    Cuadratico cuadr = new Cuadratico ();
    
    System.out.print("DIVIDE Y VENCERAS: MERGESORT");
    System.out.println("\t\t\tALEXIS DANIEL FUENTES PEREZ\n");
    
    System.out.print("Introducir el tamaño del problema: ");
    int size = Integer.parseInt(br.readLine());
    System.out.print("Introducir el numero de pruebas: ");
    int pruebas = Integer.parseInt(br.readLine());
    
    fichero.write("Numero de pruebas: " + pruebas);
    
    while(aumentar) {
      int[] problema = new int [size];
      
      for(int z = 0; z < pruebas; z++) {
        System.out.print("\nVector inicial: ");
        
        for(int i = 0; i < size; i++) {
          problema[i] = rand.nextInt(100 - (-100) + 1) - 100;
          System.out.print(problema[i] + " ");
        }
            
        Problema p = new ObjMsort(problema, 0, problema.length - 1);
        
        MergeSort.Comparaciones.start();
        ObjMsort s = (ObjMsort) msort.resolver(p);
        MergeSort.Comparaciones.stop();
        
        int [] solucion = s.getSec();
        
        System.out.print("\nVector ordenado: ");
        
        for(int i = 0; i < size; i++) {
          System.out.print(solucion[i] + " ");
        }
        
        Cuadratico.Comparaciones.start();
        int [] solucion2 = cuadr.resolver(problema);
        Cuadratico.Comparaciones.stop();
      }
      
      fichero.write("\n\nSize: " + size);
      
      System.out.println("\n\nMERGESORT COMPARACIONES ");
      System.out.println(MergeSort.Comparaciones);
      
      fichero.write("\n\nMERGESORT COMPARACIONES");
      fichero.write("\n" + MergeSort.Comparaciones);
      
      System.out.println("\n\nCUADRATICO COMPARACIONES ");
      System.out.println(Cuadratico.Comparaciones);
      
      fichero.write("\n\nCUADRATICO COMPARACIONES");
      fichero.write("\n" + Cuadratico.Comparaciones);
      
      MergeSort.Comparaciones.reset();
      Cuadratico.Comparaciones.reset();
      
      System.out.print("\nAumentar {+10} el tamaño del problema? [S/N]: ");
      String go = br.readLine();
      
      if(go.toUpperCase().equals("S")) {
        aumentar = true;
        size = size + 10;
      } else {
        aumentar = false;
        fichero.close();
      }  
    }
  }

}
