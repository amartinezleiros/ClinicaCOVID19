
public abstract class Empleado extends Persona {
  
  protected String contraseña;
  protected String puesto;

  public Empleado(String nombre, String apellido, String DNI, int edad, String contraseña, String puesto) {
    super(nombre, apellido, DNI, edad);
    this.nombre = nombre;
    this.apellido = apellido;
    this.DNI = DNI;
    this.edad = edad;
    this.contraseña = contraseña;
    this.puesto = puesto;
  }

}