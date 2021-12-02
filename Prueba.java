import java.time.LocalDate;
public class Prueba {
  
  public String recibidor, enfermero, tecnico, tipo;
  LocalDate fecha;
  boolean finished = false;
  boolean resultado;
  int resultadoint;
  boolean analizado;

  public Prueba(String r, String e, String t, LocalDate f, String tipo) {
    this.recibidor = r;
    this.enfermero = e;
    this.tecnico = t;
    this.fecha = f;
    this.tipo = tipo;
  }

  public String getEnfermero() {
    return enfermero;
  }

  public String getTecnico() {
    return tecnico;
  }
  public LocalDate getFecha() {
    return fecha;
  }
  public String getRecibidor() {
    return recibidor;
  }

  public boolean getEstado() {
    return finished;
  }

  public void setEstado(boolean estado) {
    this.finished = estado;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  public String getTipo() {
    return tipo;
  }

  public void setResultado(Boolean bool) {
    this.resultado = bool;
  }

  public void setResultadoInt(int integer) {
    this.resultadoint = integer;
  }

  public boolean getResultado() {
    return resultado;
  }

  public int getResultadoInt() {
    return resultadoint;
  }

  public boolean getRealizado() {
    return analizado;
  }

  public void setRealizado(boolean a) {
    this.analizado = a;
  }
}