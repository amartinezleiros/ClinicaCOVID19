import java.time.LocalDate;

public class Antigenos extends Prueba {
  boolean resultado;

  public Antigenos(String r, String e, String t, LocalDate f, boolean resultado) {
    super(r, e, t, f, "ANTIGENOS");
    this.resultado = resultado;

  }

}