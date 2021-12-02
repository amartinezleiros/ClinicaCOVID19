import java.time.LocalDate;

public class PCR extends Prueba {

  boolean resultado;

  public PCR(String r, String e, String t, LocalDate f, boolean resultado) {
    super(r, e, t, f, "PCR");
    this.resultado = resultado;

  }

}