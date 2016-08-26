package dyv;

public class Maximum extends DyV {

  public Boolean esCasoBase (Problema p) {
    ObjMax aux = (ObjMax) p;
    if (aux.getIni() == aux.getFin()) 
      return true;
    else
      return false;
  }

  public Solucion simple (Problema p) {
    return (Solucion) p;
  }

  public Problema[] descomponer (Problema p) {
    ObjMax aux = (ObjMax) p;
    int cen = (aux.getIni() + aux.getFin()) / 2;
    
    Problema[] problemas = new Problema [2];
    problemas[0] = new ObjMax (aux.getSec(), aux.getIni(), cen);
    problemas[1] = new ObjMax (aux.getSec(), cen+1, aux.getFin());
    
    return problemas;
  }

  public Solucion combinar (Problema p, Solucion[] soluciones) {
    ObjMax[] sol = new ObjMax[2];
    sol[0] = (ObjMax) soluciones[0];
    sol[1] = (ObjMax) soluciones[1];
    
    int[] sec1 = sol[0].getSec();
    int ini1 = sol[0].getIni();
    int[] sec2 = sol[1].getSec();
    int ini2 = sol[1].getIni();
    
    int [] resultado =  new int [1];
    
    if(sec1[ini1] > sec2[ini2])
      resultado[0] = sec1[ini1]; 
    else
      resultado[0] = sec2[ini2];
    
    /*System.out.print("Resultado combinar: ");

    for(int q=0; q<resultado.length; q++)
      System.out.print(resultado[q] + " ");
    System.out.println(" ");*/
       
    return (Solucion) new ObjMax (resultado, 0, 0);
  }
  
}
