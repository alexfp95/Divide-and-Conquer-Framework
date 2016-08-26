package dyv;

public class MergeSort extends DyV {
  
  public Boolean esCasoBase (Problema p) {
    ObjMsort aux = (ObjMsort) p;
    if (aux.getIni() >= aux.getFin())
      return true;
    else
      return false;
  }
  
  public Solucion simple (Problema p) {
    return (Solucion) p;
  }
  
  public Problema[] descomponer (Problema p) {
    ObjMsort aux = (ObjMsort) p;
    int cent = (aux.getIni() + aux.getFin()) / 2;
    
    Problema[] problemas = new Problema[2];
    problemas[0] = new ObjMsort (aux.getSec(), aux.getIni(), cent);
    problemas[1] = new ObjMsort (aux.getSec(), cent+1, aux.getFin());
    
    return problemas;
  }
  
  public Solucion combinar (Problema p, Solucion[] soluciones) {
    ObjMsort pr = (ObjMsort) p;
    ObjMsort[] sol = new ObjMsort[2];
    sol[0] = (ObjMsort) soluciones[0];
    sol[1] = (ObjMsort) soluciones[1];
    
    int i = sol[0].getIni();
    int j = sol[1].getIni();
    int[] secuencia =  pr.getSec();
    
    int ini = sol[0].getIni();
    int cen = sol[1].getIni() - 1;
    int fin = sol[1].getFin();
    
    int[] aux = new int [fin+1];
    int k = ini;
    
    while((i <= cen) && (j <= fin)) {
      if(secuencia[i] < secuencia[j]) {
        aux[k] = secuencia[i];
        i++;
      } else {
        aux[k] = secuencia[j];
        j++;
      }
      Comparaciones.aumentar();
      k++;
    }

    if(i > cen) {
      while(j <= fin) {
        aux[k] = secuencia[j];
        j++; k++;
      }
    } else {
      while(i <= cen) {
        aux[k] = secuencia[i];
        i++; k++;
      }
    }
    
    for(int z = ini; z <= fin; z++)
      secuencia[z] = aux[z];
    
    /*System.out.print("Resultado mezcla: ");
    
    for(int q=0; q<secuencia.length; q++)
      System.out.print(secuencia[q] + " ");
    System.out.println(" ");*/
    
    return (Solucion) new ObjMsort (secuencia, ini, fin);
  }
  
  public static Contador Comparaciones = new Contador ();
  
}
