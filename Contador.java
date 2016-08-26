package dyv;

public class Contador {
  
  private int cuenta;
  private int min;
  private int max;
  private int acumulado;
  private int pruebas;
  
  public Contador () {
    cuenta = 0;
    min = 0;
    max = 0;
    acumulado = 0;
    pruebas = 0;
  }
  
  public void reset () {
    cuenta = 0;
    min = 0;
    max = 0;
    acumulado = 0;
    pruebas = 0;
  }
  
  public void start () {
    cuenta = 0;
  }
  
  public void stop () {
    if(min == 0)
      min = cuenta;
    
    else {
      if(min > cuenta)
        min = cuenta;
    }
    
    if(max < cuenta)
      max = cuenta;
    
    acumulado += cuenta;
    
    pruebas++;
  }
  
  public void aumentar () {
    cuenta++;
  }
  
  public String toString () {
    int medio = acumulado / pruebas;
    String out = "Minimo\tMedio\tMaximo\n";
    out += min + "\t" + medio + "\t" + max;
    return out;
  }
}
