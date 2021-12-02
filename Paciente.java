
public class Paciente extends Persona {

  public Paciente(String nombre, String apellido, String DNI, int edad) {
    super(nombre, apellido, DNI, edad);
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
  public void borrarDNI() {
    this.DNI = "";
  }

}