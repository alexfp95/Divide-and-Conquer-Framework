package dyv;

abstract public class DyV {
  
  public Solucion resolver (Problema p) {
    Problema[] problemas;
    
    if(esCasoBase(p))
      return simple(p);
    else 
      problemas = descomponer(p);
    
    Solucion[] soluciones = new Solucion [problemas.length];
    
    for(int i=0; i<problemas.length; i++)
      soluciones[i] = resolver(problemas[i]);
    
    return combinar(p, soluciones);
  }
  
  abstract public Boolean esCasoBase (Problema p);
  abstract public Solucion simple (Problema p);
  abstract public Problema[] descomponer (Problema p);
  abstract public Solucion combinar (Problema p, Solucion[] soluciones);
}
