import java.time.LocalDate;


public class Johnson extends Vacuna {
  public Johnson(String enfermero, String recibidor, LocalDate fecha1, LocalDate fecha2, String tipo) {
    super(enfermero, recibidor, fecha1, null, "Moderna");
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