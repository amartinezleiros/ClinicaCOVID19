import java.time.LocalDate;


public class Pfizer extends Vacuna {
 
  public Pfizer(String enfermero, String recibidor, LocalDate fecha1, LocalDate fecha2, String tipo) {
    super(enfermero, recibidor, fecha1, fecha2, "Pfizer");
  }
  public int getDosis() {
    return dosis;
  }
  public void bajarDosis() {
    dosis--;
  }
  public void añadirDosis(int x) {
    this.dosis = this.dosis + x;
  }
}