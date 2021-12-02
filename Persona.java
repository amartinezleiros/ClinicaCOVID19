import java.util.ArrayList;
import java.time.LocalDate;


public class Persona {
  // instance variables - replace the example below with your own
  protected String nombre, apellido, DNI;
  protected int edad;
  LocalDate InicioConfin = null;
  LocalDate FinConfin = null;
  LocalDate ultimaPCR = LocalDate.of(1, 1, 1);
  LocalDate ultimaSEROLOGICA = LocalDate.of(1, 1, 1);
  protected boolean confinado = false;

  public Persona(String nombre, String apellido, String DNI, int edad) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.DNI = DNI;
    this.edad = edad;
  }
  public String getNombre() {
    return nombre;
  }
  public String getApellido() {
    return apellido;
  }
  public int getEdad() {
    return edad;
  }
  public String getDNI() {
    return DNI;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public void setApellido(String apellido) {
    this.apellido = apellido;
  }
  public void setDNI(String DNI) {
    this.DNI = DNI;
  }
  public void setEdad(int edad) {
    this.edad = edad;
  }
  public void setUltimaPCR(LocalDate a) {
    this.ultimaPCR = a;
  }
  public void setUltimaSEROLOGICA(LocalDate a) {
    this.ultimaSEROLOGICA = a;
  }
  public LocalDate getUltimaPCR() {
    return ultimaPCR;
  }
  public LocalDate getUltimaSEROLOGICA() {
    return ultimaSEROLOGICA;
  }
  public boolean getConfinado() {
    return confinado;
  }
  public void setConfinado(boolean b) {
    this.confinado = b;
  }
  public LocalDate getInicioConfin() {
    return InicioConfin;
  }
  public LocalDate getFinConfin() {
    return FinConfin;
  }
  public void setInicioConfin(LocalDate ld) {
    this.InicioConfin = ld;
  }
  public void setFinConfin(LocalDate ld) {
    this.FinConfin = ld;
  }
  public void borrarDNI() {
    this.DNI = "";
  }
}