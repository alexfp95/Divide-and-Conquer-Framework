package dyv;

public class Cuadratico {
  
  public static Contador Comparaciones = new Contador ();
  
  public int[] resolver (int[] problema) {
    int min;
    int[] sol = new int [problema.length];
    
    for(int i = 0; i < problema.length; i++) {
      min = i;
      for(int j = i; j < problema.length; j++) {
        if(problema[j] < problema[min]) 
          min = j;
        Comparaciones.aumentar();
      }
      sol[i] = problema[min];
    }
    
    return sol;
  }
  
}
