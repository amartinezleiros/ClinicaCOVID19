import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Enfermero extends Empleado {

  public LocalDate[] fechas = new LocalDate[5];

  public Enfermero(String nombre, String apellido, String DNI, int edad, String contraseña, String puesto) {
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
  public void MeterFecha(int i, LocalDate fecha) {
    this.fechas[i] = fecha;
  }
  public LocalDate getFecha(int i) {
    return fechas[i];
  }
  public void borrarDNI() {
    this.DNI = "";
  }
}