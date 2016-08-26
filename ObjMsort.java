package dyv;

public class ObjMsort implements Problema, Solucion {
  
  private int[] secuencia;
  private int ini;
  private int fin;
  
  public ObjMsort (int[] sec, int i, int f) {
    secuencia = sec;
    ini = i;
    fin = f;
  }
  
  public int getIni () {
    return ini;
  }
  
  public int getFin () {
    return fin;
  }
  
  public int[] getSec () {
    return secuencia;
  }
}
