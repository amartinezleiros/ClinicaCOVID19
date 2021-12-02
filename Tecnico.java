import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class Tecnico extends Empleado {
  LocalDate[] fechas = new LocalDate[4];

  public Tecnico(String nombre, String apellido, String DNI, int edad, String contraseña, String puesto) {
    super(nombre, apellido, DNI, edad, contraseña, puesto);
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
  public String getContraseña() {
    return contraseña;
  }
  public LocalDate getFecha(int i) {
    return fechas[i];
  }
  public void MeterFecha(int i, LocalDate fecha) {
    this.fechas[i] = fecha;
  }
  public void borrarDNI() {
    this.DNI = "";
  }
}