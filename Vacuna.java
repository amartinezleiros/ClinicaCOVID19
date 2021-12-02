import java.time.LocalDate;


public class Vacuna {
  protected int dosis;
  protected String enfermero, recibidor, tipo;
  protected boolean done = false;
  protected LocalDate fecha1;
  protected LocalDate fecha2;
  protected boolean primeradosis = false;
  protected boolean segundadosis = false;

  public Vacuna(String enfermero, String recibidor, LocalDate fecha1, LocalDate fecha2, String tipo) {
    this.enfermero = enfermero;
    this.recibidor = recibidor;
    this.fecha1 = fecha1;
    this.fecha2 = fecha2;
    this.tipo = tipo;
  }
  public String getEnfermero() {
    return enfermero;
  }
  public String getRecibidor() {
    return recibidor;
  }
  public void setEstado(boolean estado) {
    this.done = estado;
  }
  public boolean getEstado() {
    return done;
  }
  public String getTipo() {
    return tipo;
  }
  public LocalDate getFecha1() {
    return fecha1;
  }
  public LocalDate getFecha2() {
    return fecha2;
  }
  public boolean get1dosis() {
    return primeradosis;
  }
  public boolean get2dosis() {
    return segundadosis;
  }
  public void set1dosis(boolean done) {
    this.primeradosis = done;
  }
  public void set2dosis(boolean done) {
    this.segundadosis = done;
  }
}