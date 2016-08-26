package dyv;

import java.io.*;
import java.util.Random;

public class Principal2 {

  public static void main(String[] args) throws IOException {
    System.out.print("DIVIDE Y VENCERAS: MAXIMO DE UN VECTOR");
    System.out.println("\t\t\tALEXIS DANIEL FUENTES PEREZ\n");
    
    BufferedReader br = new BufferedReader ( new InputStreamReader (System.in) );
    Random rand = new Random();
    Maximum m = new Maximum ();
    
    System.out.print("Introducir el tamaño del problema: ");
    int size = Integer.parseInt(br.readLine());
    
    int[] problema = new int [size];
    
    System.out.print("\nVector inicial: ");
      
    for(int i = 0; i < size; i++) {
      problema[i] = rand.nextInt(100 - (-100) + 1) - 100;
      System.out.print(problema[i] + " ");
    }
    
    Problema p = new ObjMax (problema, 0, problema.length - 1);
    ObjMax s = (ObjMax) m.resolver(p);
    
    int [] solucion = s.getSec();
    
    System.out.print("\nMaximo del vector: ");
    
    for(int i=0; i<solucion.length; i++) {
      System.out.print(solucion[i] + " ");
    }

  }

}
