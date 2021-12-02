import java.time.LocalDate;

public class SEROLOGICA extends Prueba {

  int resultado;

  public SEROLOGICA(String r, String e, String t, LocalDate f, int resultado) {
    super(r, e, t, f, "SEROLOGICA");
    this.resultado = resultado;

  }

}