import java.time.LocalDate;

public class Moderna extends Vacuna {

  public Moderna(String enfermero, String recibidor, LocalDate fecha1, LocalDate fecha2, String tipo) {
    super(enfermero, recibidor, fecha1, fecha2, "Moderna");
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