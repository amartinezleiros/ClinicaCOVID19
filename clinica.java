import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;

//CLASE CLINICA
public  class clinica {

//DECLARACIÓN DE TODOS LOS ARRAYLIST A UTILIZAR Y ATRIBUTO SECRET
  static ArrayList < Persona > Apersona = new ArrayList();
  static ArrayList < Enfermero > Aenfermero = new ArrayList();
  static ArrayList < Tecnico > Atecnico = new ArrayList();
  static ArrayList < Paciente > Apaciente = new ArrayList();
  static ArrayList < Vacuna > AVacuna = new ArrayList();
  static ArrayList < Prueba > Aprueba = new ArrayList();

  static ArrayList < PCR > Apcr = new ArrayList();
  static ArrayList < SEROLOGICA > Aserologica = new ArrayList();
  static ArrayList < Antigenos > Aantigenos = new ArrayList();

  static ArrayList < Pfizer > Apfizer = new ArrayList();
  static ArrayList < Johnson > Ajohnson = new ArrayList();
  static ArrayList < Moderna > Amoderna = new ArrayList();

  static int secret = 0;

  public static void main() {
    Moderna moderna = new Moderna("", "", null, null, "Moderna");
    Amoderna.add(moderna);
    Pfizer pfizer = new Pfizer("", "", null, null, "Pfizer");
    Apfizer.add(pfizer);
    Johnson johnson = new Johnson("", "", null, null, "Johnson&Johnson");
    Ajohnson.add(johnson);
    Login();
  }

//FUNCION PARA LOGEARSE
  private static void Login() {
    String Usuario, Password, login;
    Scanner sc = new Scanner(System.in);
    System.out.println("---BIENVENIDO A LA CLÍNICA---\n\n  ----------LOGIN----------\n\n ·USUARIO:\n");
    Usuario = sc.nextLine();
    System.out.println("\n ·CONTRASEÑA: \n");
    Password = sc.nextLine();
    
    //CHECK SI ES ADMIN O NO
    if (Usuario.equals("admin") && Password.equals("1234")) {
      System.out.println("\nLogin correcto. Te has logeado como Administrador.\n\n");

      MenuAdmin();
    } else if (!Usuario.equals("admin") && !Password.equals("1234")) {
      //CHECK SI ES ENFERMERO O NO 
      for (int i = 0; i < Aenfermero.size(); i++) {
        if (Aenfermero.get(i).getNombre().equals(Usuario) && Aenfermero.get(i).getContraseña().equals(Password)) {
          login = Aenfermero.get(i).getDNI();
          System.out.println("\nLogin correcto. Te has logeado como Enfermero.\n\n");
          MenuEnfermero(login);
        }
      }
      //CHECK SI ES TECNICO O NO
      for (int i = 0; i < Atecnico.size(); i++) {
        if (Atecnico.get(i).getNombre().equals(Usuario) && Atecnico.get(i).getContraseña().equals(Password)) {
          login = Atecnico.get(i).getDNI();
          System.out.println("\nLogin correcto. Te has logeado como Técnico.\n\n");
          MenuTecnico(login);
        }
      }
      System.out.println("\nLogin incorrecto. Vuelva a intentarlo.\n\n");
      Login();

    }

  }
  //MENU PARA ADMINISTRADOR
  private static void MenuAdmin() {
    Scanner sc = new Scanner(System.in);
    boolean valido = false;
    int numero = 0;
    int num = 0;
    //BUCLE PARA ELEGIR LA FUNCIÓN, NOS LLEVARÁ A UN SWITCH EL CUAL SEGÚN EL NÚMERO INTRODUCIDO NOS LLEVARÁ A UNA FUNCIÓN U A OTRA
    while (valido == false && (num < 1 || num > 12)) {
      try {
        System.out.println("···········MENÚ ADMINISTRADOR··········\n|                                     |\n| 1-Dar de Alta                       |\n| 2-Dar de Baja                       |\n| 3-Modificar                         |\n| 4-Lista Personal                    |\n| 5-Asignacion Prueba                 |\n| 6-Asignacion Vacuna                 |\n| 7-Stock Vacunas                     |\n| 8-Visualizar Pacientes Asignados    |\n| 9-Visualizar Pacientes confinados   |\n| 10-Pruebas a confinados             |\n| 11-Log Out                          |\n|                                     |\n······································· ");
        sc = new Scanner(System.in);
        numero = sc.nextInt();
        valido = true;
      } catch (InputMismatchException e) {
        System.out.println("\nIntroduce un número entero.\n");
      }
      switch (numero) {
      case 1:
        AdminAltaEmpleado();
        break;
      case 2:
        AdminDarBaja();
        break;
      case 3:
        AdminModificar();
        break;
      case 4:
        ListadoPersonal();
        break;
      case 5:
        AdminAsignacionPrueba();
        break;
      case 6:
        AdminAsignacionVacuna();
        break;
      case 7:
        AdminStockVacunas();
        break;
      case 8:
        AdminPacientesAsignados();
        break;
      case 9:
        AdminVisualizarConfinados();
        break;
      case 10:
        AdminPruebaPostConfinamiento();
        break;
      case 11:
        Login();
        break;
      case 12:
        if (secret == 0) {
          Prueba();
        }
        System.out.println("\nLa funcion secreta ya ha sido usada anteriormente.\n");
        MenuAdmin();
        break;
      default:
        System.out.println("\nIntroduce un número entre el 1 y el 11.\n");
        MenuAdmin();
        break;
      }
    }

  }
  //FUNCION PARA DAR DE ALTA PERSONAS EN EL SISTEMA
  private static void AdminAltaEmpleado() {
    Scanner sc = new Scanner(System.in);
    int entradaTeclado, entradaNumero, ed;
    int check = 0;
    String nomb, ap, dni, pass, pass2, puest, entradaTeclado2, verificacion;
    dni = "";
    boolean valido = false;
    entradaTeclado = 0;
    //MEDIANTE UN WHILE NOS DEJARÁ ESCOGER QUE TIPO DE PERSONA QUEREMOS DAR DE ALTA(ENFERMERO, TECNICO, PACIENTE)
    while (valido == false) {
      try {
        System.out.println("\nQue quiere dar de alta?: \n\n   1-Enfermero\n\n   2-Tecnico\n\n   3-Paciente\n\n");
        sc = new Scanner(System.in);
        entradaTeclado = sc.nextInt();
        valido = true;
      } catch (InputMismatchException e) {}

    }
    valido = false;
    //CHEQUEO PARA NO BUGEAR EL PROGRAMA MEDIANTE WHILE
    while (entradaTeclado != 1 && entradaTeclado != 2 && entradaTeclado != 3) {
      try {
        System.out.println("\nTiene que escoger un numero del 1 al 3. Introduzca 0 para salir.\n");
        sc = new Scanner(System.in);
        entradaTeclado = sc.nextInt();
      } catch (InputMismatchException e) {}
      if (entradaTeclado == 0) {
        System.out.println("\nRedireccionando al menú principal..\n\n");
        MenuAdmin();
      }
    }
    //SWITCH QUE NOS LLEVARÁ A DAR DE ALTA UN ENFERMERO O UN TECNICO O UN PACIENTE SEGUN LO QUE HAYAMOS INTRODUCIDO CASE 1 - ENFERMERO  CASE 2 - TECNICO   CASE 3 - PACIENTE
    switch (entradaTeclado) {
    case 1:

      puest = "Enfermero";
      System.out.println("\nHas decidido dar de alta a un enfermero\n");
      do {
        System.out.println("\nIntroduzca un nombre: \n");
        sc = new Scanner(System.in);
        nomb = sc.nextLine();
      } while (nomb.length() < 1 || nomb.length() > 20);
      do {
        System.out.println("\nIntroduzca apellido: \n");
        sc = new Scanner(System.in);
        ap = sc.nextLine();
      } while (ap.length() < 1 || ap.length() > 20);

      do {
        if (check == 0) {
          System.out.println("\nIntroduzca DNI: \n");
          dni = sc.nextLine();
          check = 1;
          for (int i = 0; i < Apersona.size(); i++) {
            if (Apersona.get(i).getDNI().equals(dni)) {
              dni = "";
            }
          }
        } else if (check == 1) {
          System.out.println("Tiene que introducir un DNI válido, con 8 dígitos, una letra y que no esté ya dado de alta.\n");
          System.out.println("Introduzca DNI: \n");
          dni = sc.nextLine();
          for (int i = 0; i < Apersona.size(); i++) {
            if (Apersona.get(i).getDNI().equals(dni)) {
              dni = "";
            }
          }
        }
      } while (validardni(dni) == false);

      check = 0;
      ed = 0;

      do {
        try {
          if (check == 0) {
            System.out.println("\nIntroduzca edad: \n");
            sc = new Scanner(System.in);
            ed = sc.nextInt();
            check = 1;
          } else if (check == 1) {
            System.out.println("\nIntroduzca una edad entre 18 y 100 años.\n");
            sc = new Scanner(System.in);
            ed = sc.nextInt();
          }

        } catch (InputMismatchException e) {
          System.out.println("\nLa edad tiene que ser un número entero.");
          check = 0;
        }
      } while (ed < 18 || ed > 100);

      sc = new Scanner(System.in);
      check = 0;
      pass = "";
      pass2 = " ";
      do {
        if (check == 0) {
          System.out.println("\nIntroduzca contraseña:\n");
          pass = sc.nextLine();

          System.out.println("\nVerifique la contraseña:\n");
          pass2 = sc.nextLine();
          check = 1;
        } else if (check == 1) {
          System.out.println("\nTiene que introducir la misma contraseña en ambos campos. Vuelva a intentarlo.");
          System.out.println("\nIntroduzca contraseña:\n");
          pass = sc.nextLine();

          System.out.println("\nVerifique la contraseña:\n");
          pass2 = sc.nextLine();
        }
      } while (!pass.equals(pass2));

      puest = "Enfermero";
      verificacion = "";
      check = 0;

      while (!verificacion.equals("S") && !verificacion.equals("s") && !verificacion.equals("Si") && !verificacion.equals("si") && !verificacion.equals("N") && !verificacion.equals("n") && !verificacion.equals("No") && !verificacion.equals("no")) {

        if (check == 0) {
          check = 1;
          System.out.println("\nQuiere registrar a " + nomb + " " + ap + " con DNI " + dni + " y " + ed + " años de edad en el sistema?\n");
          verificacion = sc.nextLine();
        } else if (check == 1) {

          System.out.println("\nTiene que introducir Si o No.\n\n");
          verificacion = sc.nextLine();

        }

      }
      if (verificacion.equals("S") || verificacion.equals("s") || verificacion.equals("Si") || verificacion.equals("si")) {

        Enfermero enfermero = new Enfermero(nomb, ap, dni, ed, pass, puest);
        Persona persona = new Persona(nomb, ap, dni, ed);

        Aenfermero.add(enfermero);
        Apersona.add(persona);

        System.out.println("\nEnfermero registrado con éxito.\n");
      } else {
        System.out.println("\nRedireccionando al menú principal..\n\n");

      }
      MenuAdmin();

      break;

    case 2:
      System.out.println("\nHas decidido dar de alta a un Tecnico\n");

      System.out.println("\nIntroduzca un nombre: \n");
      sc = new Scanner(System.in);
      nomb = sc.nextLine();

      System.out.println("\nIntroduzca apellido: \n");
      sc = new Scanner(System.in);
      ap = sc.nextLine();
    
      do {
        if (check == 0) {
          System.out.println("\nIntroduzca DNI: \n");
          sc = new Scanner(System.in);
          dni = sc.nextLine();
          check = 1;
          for (int i = 0; i < Apersona.size(); i++) {
            if (Apersona.get(i).getDNI().equals(dni)) {
              dni = "";
            }
          }
        } else if (check == 1) {
          System.out.println("\nTiene que introducir un DNI válido, con 8 dígitos, una letra y que no esté ya dado de alta.\n");
          System.out.println("Introduzca DNI: \n");
          sc = new Scanner(System.in);
          dni = sc.nextLine();
          for (int i = 0; i < Apersona.size(); i++) {
            if (Apersona.get(i).getDNI().equals(dni)) {
              dni = "";
            }
          }
        }
      } while (validardni(dni) == false);

      check = 0;
      ed = 0;

      do {
        try {
          if (check == 0) {
            System.out.println("\nIntroduzca edad: \n");
            sc = new Scanner(System.in);
            ed = sc.nextInt();
            check = 1;
          } else if (check == 1) {
            System.out.println("\nIntroduzca una edad entre 18 y 100 años.\n");
            sc = new Scanner(System.in);
            ed = sc.nextInt();
          }

        } catch (InputMismatchException e) {
          System.out.println("\nLa edad tiene que ser un número entero.");
          check = 0;
        }
      } while (ed < 18 || ed > 100);

      sc = new Scanner(System.in);
      check = 0;
      pass = "";
      pass2 = " ";
      do {
        if (check == 0) {
          System.out.println("\nIntroduzca contraseña:\n");
          sc = new Scanner(System.in);
          pass = sc.nextLine();

          System.out.println("\nVerifique la contraseña:\n");
          sc = new Scanner(System.in);
          pass2 = sc.nextLine();
          check = 1;
        } else if (check == 1) {
          System.out.println("\nTiene que introducir la misma contraseña en ambos campos. Vuelva a intentarlo.");
          System.out.println("\nIntroduzca contraseña:\n");
          sc = new Scanner(System.in);
          pass = sc.nextLine();

          System.out.println("Verifique la contraseña:\n");
          sc = new Scanner(System.in);
          pass2 = sc.nextLine();
        }
      } while (!pass.equals(pass2));

      puest = "Tecnico";
      verificacion = "";
      check = 0;

      while (!verificacion.equals("S") && !verificacion.equals("s") && !verificacion.equals("Si") && !verificacion.equals("si") && !verificacion.equals("N") && !verificacion.equals("n") && !verificacion.equals("No") && !verificacion.equals("no")) {
        if (check == 0) {
          check = 1;
          System.out.println("\nQuiere registrar a " + nomb + " " + ap + " con DNI " + dni + " y " + ed + " años de edad en el sistema?\n");
          verificacion = sc.nextLine();
        } else if (check == 1) {
          System.out.println("Tiene que introducir Si o No.\n");
          verificacion = sc.nextLine();
        }
      }

      if (verificacion.equals("S") || verificacion.equals("s") || verificacion.equals("Si") || verificacion.equals("si")) {
        Tecnico tecnico = new Tecnico(nomb, ap, dni, ed, pass, puest);
        Persona persona1 = new Persona(nomb, ap, dni, ed);
        Apersona.add(persona1);
        Atecnico.add(tecnico);

        System.out.println("\nTécnico registrado con éxito.\n");
        System.out.println("\nRedireccionando a menú principal..\n");
        MenuAdmin();
      } else {
        System.out.println("\nRedireccionando a menú principal..\n");
        MenuAdmin();
      }
      break;

    case 3:

      System.out.println("\nHas decidido dar de alta a un Paciente\n");
      System.out.println("\nIntroduzca un nombre: \n");
      sc = new Scanner(System.in);
      nomb = sc.nextLine();

      System.out.println("\nIntroduzca apellido: \n");
      sc = new Scanner(System.in);
      ap = sc.nextLine();

      do {
        if (check == 0) {
          System.out.println("\nIntroduzca DNI: \n");
          sc = new Scanner(System.in);
          dni = sc.nextLine();
          check = 1;
          for (int i = 0; i < Apersona.size(); i++) {
            if (Apersona.get(i).getDNI().equals(dni)) {
              dni = "";
            }
          }
        } else if (check == 1) {
          System.out.println("Tiene que introducir un DNI válido, con 8 dígitos, una letra y que no esté ya dado de alta.\n");
          sc = new Scanner(System.in);
          System.out.println("Introduzca DNI: \n");
          dni = sc.nextLine();
          for (int i = 0; i < Apersona.size(); i++) {
            if (Apersona.get(i).getDNI().equals(dni)) {
              dni = "";
            }
          }
        }
      } while (validardni(dni) == false);

      check = 0;
      ed = 0;

      do {
        try {
          if (check == 0) {
            System.out.println("\nIntroduzca edad: \n");
            sc = new Scanner(System.in);
            ed = sc.nextInt();
            check = 1;
          } else if (check == 1) {
            System.out.println("\nIntroduzca una edad entre 18 y 100 años.\n");
            sc = new Scanner(System.in);
            ed = sc.nextInt();
          }

        } catch (InputMismatchException e) {
          System.out.println("\nLa edad tiene que ser un número entero.");
          check = 0;
        }
      } while (ed < 18 || ed > 100);

      verificacion = "";
      check = 0;
      sc = new Scanner(System.in);

      while (!verificacion.equals("S") && !verificacion.equals("s") && !verificacion.equals("Si") && !verificacion.equals("si") && !verificacion.equals("N") && !verificacion.equals("n") && !verificacion.equals("No") && !verificacion.equals("no")) {
        if (check == 0) {
          check = 1;
          System.out.println("\nQuiere registrar a " + nomb + " " + ap + " con DNI " + dni + " y " + ed + " años de edad en el sistema?\n");
          verificacion = sc.nextLine();
        } else if (check == 1) {
          System.out.println("Tiene que introducir Si o No.\n");
          verificacion = sc.nextLine();
        }
      }

      if (verificacion.equals("S") || verificacion.equals("s") || verificacion.equals("Si") || verificacion.equals("si")) {
        Paciente paciente = new Paciente(nomb, ap, dni, ed);
        Persona persona2 = new Persona(nomb, ap, dni, ed);
        Apaciente.add(paciente);
        Apersona.add(persona2);

        System.out.println("\nPaciente registrado con éxito.\n");
        MenuAdmin();
      } else {
        System.out.println("\nRedireccionando a menú principal..\n");
        MenuAdmin();
      }
      break;

    }
  }
  //FUNCIÓN PARA DAR DE BAJA PERSONAS DE LA BASE DE DATOS
  private static void AdminDarBaja() {
    Scanner sc = new Scanner(System.in);
    int index, numero;
    String palabra, dni;
    int blancos, tope;
    int check = 0;
    tope = 0;
    index = 0;
    //CHECK SI EXISTEN PERSONAS DADAS DE ALTA CON UN CONDICIONAL
    if (Apersona.size() > 0) {
      System.out.println("····················LISTADO DE PERSONAS···················\n\n");
      //BUCLE FOR PARA IMPRIMIR PERSONAS CON EL MISMO FORMATO DE IMPRESIÓN
      for (int i = 0; i < Apersona.size(); i++) {
        numero = i + 1;
        System.out.print("\n" + numero + " - " + Apersona.get(i).getNombre() + " " + Apersona.get(i).getApellido());
        blancos = 20 - (Apersona.get(i).getNombre().length() + Apersona.get(i).getApellido().length() + 1);
        tope++;
        for (int h = 0; h < blancos; h++) {
          System.out.print(" ");
        }

        System.out.println(" DNI: " + Apersona.get(i).getDNI() + " Edad: " + Apersona.get(i).getEdad() + " años");

      }
      //BUCLE DO-WHILE PARA ESCOGER PERSONA A DAR DE BAJA
      do {
        try {
          if (check == 1) {
            System.out.println("\nEscoja un número que aparezca en la lista.\n");
            sc = new Scanner(System.in);
            index = sc.nextInt();
          }
          if (check == 0) {
            System.out.println("\nEscoja el número de la persona que quiera dar de baja\n");
            sc = new Scanner(System.in);
            index = sc.nextInt();
            check = 1;
          }
        } catch (InputMismatchException e) {
          System.out.println("\nIntroduzca un número entero.\n");
        }
      } while (index < 1 || index > tope);
      System.out.println("\nEstá seguro de que desea dar de baja a " + Apersona.get(index - 1).getNombre() + " " + Apersona.get(index - 1).getApellido() + "?\n");
      palabra = sc.nextLine();
      //BUCLE DO-WHILE PARA COMPROBAR SI SE QUIERE DAR DE BAJA A ESA PERSONA
      do {
        System.out.println("Debes de responder Si o No\n");
        palabra = sc.nextLine();
      } while (!palabra.equals("S") && !palabra.equals("s") && !palabra.equals("Si") && !palabra.equals("si") && !palabra.equals("N") && !palabra.equals("n") && !palabra.equals("No") && !palabra.equals("no"));
      if (palabra.equals("S") || palabra.equals("s") || palabra.equals("Si") || palabra.equals("si")) {
        dni = Apersona.get(index - 1).getDNI();
        System.out.println("\nPersona dada de baja en la base de datos correctamente.\n");
        Apersona.remove(index - 1);
        //BUCLE FOR PARA BORRAR A ESA PERSONA SI ERA ENFERMERO DE LA BASE DE DATOS DE ENFERMEROS
        for (int i = 0; i < Aenfermero.size(); i++) {
          if (Aenfermero.get(i).getDNI().equals(dni)) {
            Aenfermero.remove(i);
          }
        }
        //BUCLE FOR PARA BORRAR A ESA PERSONA SI ERA TECNICO DE LA BASE DE DATOS DE TECNICOS
        for (int i = 0; i < Atecnico.size(); i++) {
          if (Atecnico.get(i).getDNI().equals(dni)) {
            Atecnico.remove(i);
          }
        }
        //BUCLE FOR PARA BORRAR A ESA PERSONA SI ERA PACIENTE DE LA BASE DE DATOS DE PACIENTES
        for (int i = 0; i < Apaciente.size(); i++) {
          if (Apaciente.get(i).getDNI().equals(dni)) {
            Apaciente.remove(i);
          }
        }

      }
      System.out.println("\nRedireccionando a menú principal..\n");
      MenuAdmin();
    } else if (Apersona.size() == 0) {
      System.out.println("\nNo hay personas dadas de alta en la base de datos todavía.\n");
      System.out.println("\nRedireccionando al menú principal..\n\n");
      MenuAdmin();
    }
  }
  //FUNCION PARA MODIFICAR PERSONAS DADAS DE ALTA EN LA BASE DE DATOS
  private static void AdminModificar() {
    Scanner sc = new Scanner(System.in);
    int index, numero, blancos, ed, check, tope;
    String palabra;
    String nomb, dni, verificacion, dniv, ap;
    tope = 0;
    
    //CHECK SI HAY PERSONAS DADAS DE ALTA EN LA BASE DE DATOS CON UN CONDICIONAL
    if (Apersona.size() > 0) {
      do {
        System.out.println("····················LISTADO DE PERSONAS···················\n\n");
        //BUCLE FOR PARA IMPRIMIR EL LISTADO DE LAS PERSONAS DADAS DE ALTAS EN LA BASE DE DATOS
        for (int i = 0; i < Apersona.size(); i++) {
          numero = i + 1;
          System.out.print("\n" + numero + " - " + Apersona.get(i).getNombre() + " " + Apersona.get(i).getApellido());
          blancos = 20 - (Apersona.get(i).getNombre().length() + Apersona.get(i).getApellido().length() + 1);
          for (int h = 0; h < blancos; h++) {
            System.out.print(" ");
          }

          System.out.println(" DNI: " + Apersona.get(i).getDNI() + " Edad: " + Apersona.get(i).getEdad() + " años");
          tope++;

        }
        index = -1;
        //BUCLE DO-WHILE PARA ESCOGER LA PERSONA A MODIFICAR
        do {
          try {
            System.out.println("\n\nEscoja el número de la persona a modificar. En caso de querer volver atrás pulse 0.\n");
            sc = new Scanner(System.in);
            index = sc.nextInt();
          } catch (InputMismatchException e) {
            System.out.println("\nTiene que introducir un número entero válido.");
          }
        } while (index < 0 || index > tope);
        if (index == 0) {
          System.out.println("\nRedireccionando al menú principal..\n\n");
          MenuAdmin();
        }
        System.out.println("\nEstá seguro de que desea modificar a " + Apersona.get(index - 1).getNombre() + " " + Apersona.get(index - 1).getApellido() + "?\n");
        sc = new Scanner(System.in);
        palabra = sc.nextLine();
        //DO-WHILE PARA ASEGURARSE DE SI ES ESA LA PERSONA A MODIFICAR
        do {
          System.out.println("\nDebes de responder Si o No\n");
          sc = new Scanner(System.in);
          palabra = sc.nextLine();
        } while (!palabra.equals("S") && !palabra.equals("s") && !palabra.equals("Si") && !palabra.equals("si") && !palabra.equals("N") && !palabra.equals("n") && !palabra.equals("No") && !palabra.equals("no"));
        if (palabra.equals("S") || palabra.equals("s") || palabra.equals("Si") || palabra.equals("si")) {
          String antiguodni = Apersona.get(index - 1).getDNI();
          System.out.println("\nIntroduzca nuevo nombre: \n");
          sc = new Scanner(System.in);
          nomb = sc.nextLine();
          Apersona.get(index - 1).setNombre(nomb);
          //BUCLES FOR PARA CAMBIAR EL NOMBRE DE LA PERSONA SEGÚN SU POSICIÓN
          for (int i = 0; i < Apaciente.size(); i++) {
            if (Apaciente.get(i).getDNI().equals(antiguodni)) {
              Apaciente.get(i).setNombre(nomb);
              break;
            }
          }
          for (int i = 0; i < Aenfermero.size(); i++) {
            if (Aenfermero.get(i).getDNI().equals(antiguodni)) {
              Aenfermero.get(i).setNombre(nomb);
              break;
            }
          }
          for (int i = 0; i < Atecnico.size(); i++) {
            if (Atecnico.get(i).getDNI().equals(antiguodni)) {
              Atecnico.get(i).setNombre(nomb);
              break;
            }
          }

          System.out.println("\nIntroduzca nuevo apellido: \n");
          sc = new Scanner(System.in);
          ap = sc.nextLine();
          Apersona.get(index - 1).setApellido(ap);
          //BUCLES FOR PARA CAMBIAR EL APELLIDO DE LA PERSONA SEGÚN SU POSICIÓN
          for (int i = 0; i < Apaciente.size(); i++) {
            if (Apaciente.get(i).getDNI().equals(antiguodni)) {
              Apaciente.get(i).setApellido(ap);
              break;
            }
          }
          for (int i = 0; i < Aenfermero.size(); i++) {
            if (Aenfermero.get(i).getDNI().equals(antiguodni)) {
              Aenfermero.get(i).setApellido(ap);
              break;
            }
          }
          for (int i = 0; i < Atecnico.size(); i++) {
            if (Atecnico.get(i).getDNI().equals(antiguodni)) {
              Atecnico.get(i).setApellido(ap);
              break;
            }
          }

          check = 0;
          dni = "";
          dniv = "";
          sc = new Scanner(System.in);
          //BUCLE DO-WHILE PARA SABER SI SE QUIERE MODIFICAR TAMBIEN EL DNI
          do {
            if (check == 1) {
              System.out.println("\nResponde con si o con no. \n");
              sc = new Scanner(System.in);
              dniv = sc.nextLine();

            }
            if (check == 0) {
              System.out.println("\nQuieres cambiar el Dni tambien?(si/no) \n");
              sc = new Scanner(System.in);
              dniv = sc.nextLine();
              check = 1;
            }
          } while (!dniv.equals("S") && !dniv.equals("s") && !dniv.equals("Si") && !dniv.equals("si") && !dniv.equals("N") && !dniv.equals("n") && !dniv.equals("No") && !dniv.equals("no"));
          check = 0;
          if (dniv.equals("S") || dniv.equals("s") || dniv.equals("Si") || dniv.equals("si")) {
            antiguodni = Apersona.get(index - 1).getDNI();
            Apersona.get(index - 1).borrarDNI();
            //SI SE QUIERE CAMBIAR DNI, CON ESTE DO-WHILE TE PEDIRAN EL NUEVO A INTRODUCIR Y CHEQUEANDO QUE SEA UN DNI VÁLIDO
            do {
              if (check == 1) {
                System.out.println("Tiene que introducir un DNI válido, con 8 dígitos, una letra y que no esté ya dado de alta.\n");
                sc = new Scanner(System.in);
                System.out.println("Introduzca DNI: \n");
                sc = new Scanner(System.in);
                dni = sc.nextLine();
                for (int i = 0; i < Apersona.size(); i++) {
                  if (Apersona.get(i).getDNI().equals(dni)) {
                    dni = "";
                  }
                }
              } else if (check == 0) {
                System.out.println("\nIntroduzca nuevo DNI: \n");
                sc = new Scanner(System.in);
                dni = sc.nextLine();
                check = 1;
                for (int i = 0; i < Apersona.size(); i++) {
                  if (Apersona.get(i).getDNI().equals(dni)) {
                    dni = "";

                  }
                }
              }
            } while (validardni(dni) == false);
            Apersona.get(index - 1).setDNI(dni);
            //CAMBIAR EL DNI DE LA PERSONA EN LAS DISTINTAS ARRAYLIST SEGUN SU PUESTO EN LA CLINICA
            for (int i = 0; i < Apaciente.size(); i++) {
              if (Apaciente.get(i).getDNI().equals(antiguodni)) {
                Apaciente.get(i).setDNI(dni);
                break;
              }
            }
            for (int i = 0; i < Aenfermero.size(); i++) {
              if (Aenfermero.get(i).getDNI().equals(antiguodni)) {
                Aenfermero.get(i).setDNI(dni);
                break;
              }
            }
            for (int i = 0; i < Atecnico.size(); i++) {
              if (Atecnico.get(i).getDNI().equals(antiguodni)) {
                Atecnico.get(i).setDNI(dni);
                break;
              }
            }

          }

          check = 0;
          ed = 0;
          //BUCLE DO-WHILE PARA MODIFICAR LA EDAD
          do {
            try {
              if (check == 0) {
                System.out.println("\nIntroduzca nueva edad: \n");
                sc = new Scanner(System.in);
                ed = sc.nextInt();
                Apersona.get(index - 1).setEdad(ed);
                check = 1;
              } else if (check == 1) {
                System.out.println("\nIntroduzca una edad entre 18 y 100 años.\n");
                sc = new Scanner(System.in);
                ed = sc.nextInt();
                Apersona.get(index - 1).setEdad(ed);
              }

            } catch (InputMismatchException e) {
              System.out.println("\nLa edad tiene que ser un número entero.");
              check = 0;
            }
          } while (ed < 18 || ed > 100);
          //BUCLES FOR PARA MODIFICAR LA EDAD EN LOS DIFERENTES ARRAYLIST SEGUN SU PUESTO EN LA CLINICA
          for (int i = 0; i < Apaciente.size(); i++) {
            if (Apaciente.get(i).getDNI().equals(antiguodni)) {
              Apaciente.get(i).setEdad(ed);
              break;
            }
          }
          for (int i = 0; i < Aenfermero.size(); i++) {
            if (Aenfermero.get(i).getDNI().equals(antiguodni)) {
              Aenfermero.get(i).setEdad(ed);
              break;
            }
          }
          for (int i = 0; i < Atecnico.size(); i++) {
            if (Atecnico.get(i).getDNI().equals(antiguodni)) {
              Atecnico.get(i).setEdad(ed);
              break;
            }
          }

          verificacion = "";
          check = 0;
          sc = new Scanner(System.in);
          System.out.println("\nCambios realizados satisfactoriamente.\n");
        }
        System.out.println("Desea modificar a alguna otra persona?\n");
        palabra = sc.nextLine();
        check = 0;
        //DO-WHILE PARA SABER SI SE QUIERE MODIFICAR A ALGUNA PERSONA MÁS
        do {
          if (check == 1) {
            System.out.println("Debes de responder Si o No\n");
            palabra = sc.nextLine();
          }
          check = 1;
        } while (!palabra.equals("S") && !palabra.equals("s") && !palabra.equals("Si") && !palabra.equals("si") && !palabra.equals("N") && !palabra.equals("n") && !palabra.equals("No") && !palabra.equals("no"));
      } while (palabra.equals("S") || palabra.equals("s") || palabra.equals("Si") || palabra.equals("si"));

      System.out.println("\nRedireccionando a menú principal..\n");
      MenuAdmin();
    } else if (Apersona.size() == 0) {
      System.out.println("\nNo hay personas dadas de alta todavía.\n");
      System.out.println("\nRedireccionando a menú principal..\n");
      MenuAdmin();
    }

  }
  //ESTA FUNCIÓN NOS IMPRIMIRA UNA LISTA DE TODAS LAS PERSONAS DADAS DE ALTA EN EL SISTEMA, SEPARANDOLAS POR PUESTOS(ENFERMERO,TECNICO,PACIENTE)
  private static void ListadoPersonal() {
    int num;
    int blancos;
    //IF PARA CHEQUEAR QUE HAYA AL MENOS UNA PERSONA DADA DE ALTA EN EL SISTEMA
    if (Apersona.size() > 0) {
      System.out.println("······Listado de Enfermeros······\n\n");
      //IF PARA CHEQUEAR SI HAY ALGUN ENFERMERO DADO DE ALTO EN EL SISTEMA
      if (Aenfermero.size() > 0) {
        //FOR PARA IMPRIMIR ENFERMEROS
        for (int i = 0; i < Aenfermero.size(); i++) {
          num = i + 1;
          blancos = 20 - (Aenfermero.get(i).getNombre().length() + Aenfermero.get(i).getApellido().length() + 1);
          System.out.print(num + " Nombre: " + Aenfermero.get(i).getNombre() + " " + Aenfermero.get(i).getApellido());
          for (int k = 0; k < blancos; k++) {
            System.out.print(" ");
          }
          System.out.println(" Edad: " + Aenfermero.get(i).getEdad() + " DNI: " + Aenfermero.get(i).getDNI());
        }
        System.out.println("\n");
      } else {
        System.out.println("No hay enfermeros registrados.\n\n");
      }

      System.out.println("······Listado de Tecnicos·······\n\n");
      //IF PARA CHEQUEAR SI HAY ALGUN TECNICO DADO DE ALTO EN EL SISTEMA
      if (Atecnico.size() > 0) {
        //FOR PARA IMPRIMIR TECNICOS
        for (int i = 0; i < Atecnico.size(); i++) {
          num = i + 1;
          blancos = 20 - (Atecnico.get(i).getNombre().length() + Atecnico.get(i).getApellido().length() + 1);
          System.out.print(num + " Nombre: " + Atecnico.get(i).getNombre() + " " + Atecnico.get(i).getApellido());
          for (int k = 0; k < blancos; k++) {
            System.out.print(" ");
          }
          System.out.println(" Edad: " + Atecnico.get(i).getEdad() + " DNI: " + Atecnico.get(i).getDNI());
        }
        System.out.println("\n");
      } else {
        System.out.println("No hay tecnicos registrados.\n\n");
      }

      System.out.println("······Listado de Pacientes······\n\n");
      //IF PARA CHEQUEAR SI HAY ALGUN PACIENTE DADO DE ALTO EN EL SISTEMA
      if (Apaciente.size() > 0) {
        //FOR PARA IMPRIMIR PACIENTES
        for (int i = 0; i < Apaciente.size(); i++) {
          num = i + 1;
          blancos = 20 - (Apaciente.get(i).getNombre().length() + Apaciente.get(i).getApellido().length() + 1);
          System.out.print(num + " Nombre: " + Apaciente.get(i).getNombre() + " " + Apaciente.get(i).getApellido());
          for (int k = 0; k < blancos; k++) {
            System.out.print(" ");
          }
          System.out.println(" Edad: " + Apaciente.get(i).getEdad() + " DNI: " + Apaciente.get(i).getDNI());
        }
        System.out.println("\n");

      } else {
        System.out.println("No hay pacientes registrados.\n\n");
      }
      System.out.println("\nRedireccionando al manú principal..\n\n");
      MenuAdmin();
    } else {
      System.out.println("\n\nTodavía no hay personal dado de alta en la base de datos.\n\n");
      System.out.println("Redireccionando al manú principal..\n\n");
      MenuAdmin();
    }
  }
  //FUNCION PARA ASIGNAR UNA PRUEBA A UNA PERSONA DANDOLE UN ENFERMERO, UN TECNICO, UNA FECHA Y UN TIPO DE PRUEBA
  private static void AdminAsignacionPrueba() {
    int numero, index, año, mes, dia, tope, check, blancos, meterfecha;
    meterfecha = 0;
    LocalDate fecha, ultimasero;
    String nomb, ap, recibidor, enfermero, tecnico, tipo, dnitecnico, dnienfermero, palabra, fecha1;
    Scanner sc = new Scanner(System.in);
    int checkk = 0;
    Prueba prueba;
    PCR pcr;
    int meterfecha2;
    Antigenos antigenos;
    SEROLOGICA serologica;
    //IF PARA CHEQUEAR QUE HAYA AL MENOS UNA PERSONA DADA DE ALTA EN EL SISTEMA
    if(Apersona.size() > 0){
    tope = 0;
    System.out.println("········LISTA DE PERSONAS PARA ESCOGER···········\n\n");
    //BUCLE FOR PARA IMPRIMIR LAS PERSONAS REGISTRADAS EN EL SISTEMA
    for (int i = 0; i < Apersona.size(); i++) {
      numero = i + 1;
      blancos = 20 - (Apersona.get(i).getNombre().length() + Apersona.get(i).getApellido().length() + 1);
      System.out.print("\n" + numero + " - " + "Nombre: " + Apersona.get(i).getNombre() + " " + Apersona.get(i).getApellido());
      for (int h = 0; h < blancos; h++) {
        System.out.print(" ");
      }
      System.out.println(" DNI: " + Apersona.get(i).getDNI() + " Edad: " + Apersona.get(i).getEdad() + "\n");
      tope++;
    }
    check = 0;
    index = 0;
    //DO-WHILE PARA ESCOGER UNA PERSONA DE LA LISTA
    do {
      if (check == 1) {
        try {
          System.out.println("\n\nIntroduzca un numero que salga en la lista. Pulse 0 para salir.\n");
          sc = new Scanner(System.in);
          index = sc.nextInt();
        } catch (InputMismatchException e) {
          System.out.println("\n\nIntroduzca un número entero válido.");
        }
        if (index == 0) {
          check = 2;
        }
      }
      if (check == 0) {
        try {
          System.out.println("\n\nA quien deseas asignarle una prueba diagnóstica\n");
          sc = new Scanner(System.in);
          index = sc.nextInt();
          check = 1;
        } catch (InputMismatchException e) {
          System.out.println("\n\nIntroduzca un número entero válido.");
        }
      }
      if (check == 2) {
        System.out.println("\nRedireccionando a menú principal..\n");
        MenuAdmin();
      }
    } while (index < 1 || index > tope);

    System.out.println("\nRealizar prueba a " + Apersona.get(index - 1).getNombre() + " " + Apersona.get(index - 1).getApellido() + "?(Si/No)\n");
    sc = new Scanner(System.in);
    palabra = sc.nextLine();
    //WHILE PARA CHEQUEAR RESPUESTA A LA PREGUNTA
    while (!palabra.equals("S") && !palabra.equals("s") && !palabra.equals("Si") && !palabra.equals("si") && !palabra.equals("N") && !palabra.equals("n") && !palabra.equals("No") && !palabra.equals("no")) {
      System.out.println("Debes de responder Si o No\n");
      sc = new Scanner(System.in);
      palabra = sc.nextLine();
    }
    //IF PARA VER SI QUEREMOS O NO REALIZAR PRUEBA
    if (palabra.equals("S") || palabra.equals("s") || palabra.equals("Si") || palabra.equals("si")) {
      recibidor = Apersona.get(index - 1).getDNI();
      nomb = Apersona.get(index - 1).getApellido();
      ap = Apersona.get(index - 1).getNombre();
      check = 0;
      numero = 4;
      //DO WHILE PARA INDICAR EL TIPO DE PRUEBA A REALIZAR
      do {
        try {
          if (check == 1) {
            System.out.println("\nQue prueba quieres realizarle?(Indique un valor entre el 1 y el 3): \n\n    1-PCR\n\n    2-ANTIGENOS\n\n    3-SEROLOGICA  \n\nPulse 0 para salir.\n");
            sc = new Scanner(System.in);
            numero = sc.nextInt();
            if (numero == 0) {
              System.out.println("\nRedireccionando a menú principal..\n");
              MenuAdmin();
            }
          }
          if (check == 0) {
            System.out.println("\nQue prueba quieres realizarle?: \n\n    1-PCR\n\n    2-ANTIGENOS\n\n    3-SEROLOGICA\n");
            sc = new Scanner(System.in);
            numero = sc.nextInt();
            check = 1;
          }
        } catch (InputMismatchException e) {
          System.out.println("\nDebes introducir un numero entero.\n");
        }
      } while (numero != 1 && numero != 2 && numero != 3);

      switch (numero) {
      //CASE 1: PARA REALIZAR UNA PCR
      case 1:
        //CON ESTE CONDICIONAL VERIFICAMOS QUE HAN PASADO AL MENOS 15 DIAS DESDE LA ULTIMA PCR
        if (ChronoUnit.DAYS.between(Apersona.get(index - 1).getUltimaPCR(), LocalDate.now()) < 15) {
          System.out.println("Este paciente no se puede someter a una PCR, ya que deben de transcurrir 15 dias desde la ultima\n");
          MenuAdmin();
        }

        System.out.println("          ------ASIGNACION DE PCR------\n");

        System.out.println("········LISTA DE ENFERMEROS PARA ESCOGER···········\n\n");

        numero = 0;
        fecha = LocalDate.now();
        checkk = 0;
        check = 0;
        tope = 0;
        int[] lista = new int[15];
        //BUCLE FOR QUE VERIFICA QUE HAYA ENFERMEROS DISPONIBLES PARA HACER LA PRUEBA
        for (int i = 0; i < Aenfermero.size(); i++) {
          for (int h = 0; h < 5; h++) {
            if (Aenfermero.get(i).getFecha(h) == null) {
              check = 1;
            } else if (ChronoUnit.DAYS.between(LocalDate.now(), Aenfermero.get(i).getFecha(h)) < 0) {
              check = 1;
            }

          }
          //IF PARA IMPRIMIR
          if (check == 1) {
            checkk = 1;
            lista[numero] = i;
            numero++;
            System.out.print("\n" + numero + " - " + "Nombre: " + Aenfermero.get(i).getNombre() + " " + Aenfermero.get(i).getApellido() + " DNI: " + Aenfermero.get(i).getDNI() + "\n");
            tope++;
            check = 0;
          }
        }

        if (checkk == 0) {
          System.out.println("\nNo hay enfermeros disponibles para las proximas fechas.\n\n");
          System.out.println("\nRedireccionando a menú principal..\n");
          MenuAdmin();
        }
        //DO WHILE PARA ESCOGER ENFERMERO
        do {
          do {
            try {

              System.out.println("\n\nEscoja el enfermero segun su numero de indice.\n");
              sc = new Scanner(System.in);
              check = sc.nextInt();
            } catch (InputMismatchException e) {
              System.out.println("\nIntroduzca un numero enter válido.\n");
            }
          } while (check < 1 || check > tope);

          dnienfermero = Aenfermero.get(lista[check - 1]).getDNI();

          for (int i = 0; i < Aenfermero.size(); i++) {
            if (Aenfermero.get(i).getDNI().equals(dnienfermero)) {
              numero = 2;
              break;
            }
          }
        } while (numero != 2);
        //DO WHILE PARA ASIGNARLE FECHAS AL ENFERMERO EN EL SITIO CORRECTO DEL ARRAY
        for (int i = 0; i < Aenfermero.size(); i++) {
          if (Aenfermero.get(i).getDNI().equals(dnienfermero)) {
            for (int h = 0; h < 5; h++) {
              if (Aenfermero.get(i).getFecha(h) == null) {
                if (h == 0) {
                  fecha = LocalDate.now().plusDays(1);
                  Aenfermero.get(i).MeterFecha(h, fecha);
                  break;
                } else {
                  fecha = Aenfermero.get(i).getFecha(h - 1).plusDays(1);
                  Aenfermero.get(i).MeterFecha(h, fecha);
                  break;
                }

              }
            }
          }
        }

        System.out.println("········LISTA DE TECNICOS PARA ESCOGER···········\n\n");

        checkk = 0;
        check = 0;
        numero = 0;
        tope = 0;
        int[] lista1 = new int[15];
        //FOR PARA VER SI HAY TECNICOS DISPONIBLES PARA REALIZAR PRUEBAS
        for (int i = 0; i < Atecnico.size(); i++) {
          for (int h = 0; h < 4; h++) {
            if (Atecnico.get(i).getFecha(h) == null) {
              check = 1;
            } else if (ChronoUnit.DAYS.between(LocalDate.now(), Atecnico.get(i).getFecha(h)) < 0) {
              check = 1;
            }

          }
          //CONDICIONAL PARA IMPRIMIR LOS TECNICOS DISPONIBLES
          if (check == 1) {
            checkk = 1;
            lista1[numero] = i;
            numero++;
            System.out.print("\n" + numero + " - " + "Nombre: " + Atecnico.get(i).getNombre() + " " + Atecnico.get(i).getApellido() + " DNI: " + Atecnico.get(i).getDNI() + "\n");
            tope++;
            check = 0;
          }
        }

        if (checkk == 0) {
          System.out.println("\nNo hay técnicos disponibles para las proximas fechas.\n\n");
          System.out.println("\nRedireccionando a menú principal..\n");
          MenuAdmin();
        }
        //DO-WHILE PARA ESCOGER UN TECNICO
        do {
          do {
            try {
              System.out.println("\nEscoja el técnico segun su numero de indice.\n");
              sc = new Scanner(System.in);
              check = sc.nextInt();
            } catch (InputMismatchException e) {
              System.out.println("\nIntroduzca un numero entero válido.\n");
            }
          } while (check < 1 || check > tope);

          dnitecnico = Atecnico.get(lista1[check - 1]).getDNI();

          for (int i = 0; i < Atecnico.size(); i++) {
            if (Atecnico.get(i).getDNI().equals(dnitecnico)) {
              numero = 2;
              break;
            }
          }
        } while (numero != 2);
        //INTRODUCIR FECHA EN EL ARRAY DEL TECNICO PARA VER SI ESTA DISPONIBLE O NO
        for (int i = 0; i < Atecnico.size(); i++) {
          if (Atecnico.get(i).getDNI().equals(dnitecnico)) {
            for (int h = 0; h < 4; h++) {
              if (Atecnico.get(i).getFecha(h) == null) {
                if (h == 0) {
                  Atecnico.get(i).MeterFecha(h, fecha);
                  break;
                } else {
                  Atecnico.get(i).MeterFecha(h, fecha);
                  break;
                }

              }
            }
          }
        }
        //CREAMOS LA PRUEBA CON TODOS LOS DATOS RECOGIDOS ANTERIORMENTE
        prueba = new Prueba(recibidor, dnienfermero, dnitecnico, fecha, "PCR");
        Aprueba.add(prueba);
        Apersona.get(index - 1).setUltimaPCR(fecha);
        pcr = new PCR(recibidor, dnienfermero, dnitecnico, fecha, false);
        Apcr.add(pcr);
        System.out.println("\nPrueba para " + nomb + " " + ap + " puesta para el dia " + fecha + "\n\n");
        System.out.println("Redireccionando a menú principal..\n");

        MenuAdmin();
        break;

      case 2:

        System.out.println("     ------ASIGNACION DE PRUEBA ANTIGENOS------\n\n");

        System.out.println("········LISTA DE ENFERMEROS PARA ESCOGER···········\n\n");

        numero = 0;
        fecha = LocalDate.now();
        checkk = 0;
        check = 0;
        lista = new int[15];
        for (int i = 0; i < Aenfermero.size(); i++) {
          for (int h = 0; h < 5; h++) {
            if (Aenfermero.get(i).getFecha(h) == null) {
              check = 1;
            } else if (ChronoUnit.DAYS.between(LocalDate.now(), Aenfermero.get(i).getFecha(h)) < 0) {
              check = 1;
            }

          }

          if (check == 1) {
            checkk = 1;
            lista[numero] = i;
            numero++;
            System.out.print("\n" + numero + " - " + "Nombre: " + Aenfermero.get(i).getNombre() + " " + Aenfermero.get(i).getApellido() + " DNI: " + Aenfermero.get(i).getDNI() + "\n");
            tope++;
            check = 0;
          }
        }
        if (checkk == 0) {
          System.out.println("\nNo hay enfermeros disponibles para las proximas fechas.\n\n");
          System.out.println("\nRedireccionando a menú principal..\n");
          MenuAdmin();
        }

        do {
          try {
            System.out.println("\nEscoja el enfermero segun su numero de indice.\n");
            sc = new Scanner(System.in);
            check = sc.nextInt();
          } catch (InputMismatchException e) {
            System.out.println("\nIntroduzca un numero enter válido.\n");
          }

          dnienfermero = Aenfermero.get(lista[check - 1]).getDNI();

          for (int i = 0; i < Aenfermero.size(); i++) {
            if (Aenfermero.get(i).getDNI().equals(dnienfermero)) {
              numero = 2;
              break;
            }
          }
        } while (numero != 2);

        for (int i = 0; i < Aenfermero.size(); i++) {
          if (Aenfermero.get(i).getDNI().equals(dnienfermero)) {
            for (int h = 0; h < 5; h++) {
              if (Aenfermero.get(i).getFecha(h) == null) {
                if (h == 0) {
                  fecha = LocalDate.now().plusDays(1);
                  Aenfermero.get(i).MeterFecha(h, fecha);
                  break;
                } else {
                  fecha = Aenfermero.get(i).getFecha(h - 1).plusDays(1);
                  Aenfermero.get(i).MeterFecha(h, fecha);
                  break;
                }

              }
            }
          }
        }

        System.out.println("········LISTA DE TECNICOS PARA ESCOGER···········\n\n");

        checkk = 0;
        check = 0;
        numero = 0;
        lista1 = new int[15];
        for (int i = 0; i < Atecnico.size(); i++) {
          for (int h = 0; h < 4; h++) {
            if (Atecnico.get(i).getFecha(h) == null) {
              check = 1;
            } else if (ChronoUnit.DAYS.between(LocalDate.now(), Atecnico.get(i).getFecha(h)) < 0) {
              check = 1;
            }

          }

          if (check == 1) {
            checkk = 1;
            lista1[numero] = i;
            numero++;
            System.out.print("\n" + numero + " - " + "Nombre: " + Atecnico.get(i).getNombre() + " " + Atecnico.get(i).getApellido() + " DNI: " + Atecnico.get(i).getDNI() + "\n");
            tope++;
            check = 0;
          }
        }

        if (checkk == 0) {
          System.out.println("\nNo hay técnicos disponibles para las proximas fechas.\n\n");
          System.out.println("\nRedireccionando a menú principal..\n");
          MenuAdmin();
        }

        do {
          try {
            System.out.println("\nEscoja el técnico segun su numero de indice.\n");
            sc = new Scanner(System.in);
            check = sc.nextInt();
          } catch (InputMismatchException e) {
            System.out.println("\nIntroduzca un numero enter válido.\n");
          }

          dnitecnico = Atecnico.get(lista1[check - 1]).getDNI();

          for (int i = 0; i < Atecnico.size(); i++) {
            if (Atecnico.get(i).getDNI().equals(dnitecnico)) {
              numero = 2;
              break;
            }
          }
        } while (numero != 2);

        for (int i = 0; i < Atecnico.size(); i++) {
          if (Atecnico.get(i).getDNI().equals(dnitecnico)) {
            for (int h = 0; h < 4; h++) {
              if (Atecnico.get(i).getFecha(h) == null) {
                if (h == 0) {
                  Atecnico.get(i).MeterFecha(h, fecha);
                  break;
                } else {
                  Atecnico.get(i).MeterFecha(h, fecha);
                  break;
                }

              }
            }
          }
        }

        prueba = new Prueba(recibidor, dnienfermero, dnitecnico, fecha, "ANTIGENOS");
        Aprueba.add(prueba);
        antigenos = new Antigenos(recibidor, dnienfermero, dnitecnico, fecha, false);
        Aantigenos.add(antigenos);
        System.out.println("\nPrueba de antigenos para " + nomb + " " + ap + " puesta para el dia " + fecha + "\n\n");
        System.out.println("Redireccionando a menú principal..\n");

        MenuAdmin();

        break;

      case 3:
        if (ChronoUnit.DAYS.between(Apersona.get(index - 1).getUltimaSEROLOGICA(), LocalDate.now()) < 180) {
          System.out.println("Este paciente no se puede someter a una prueba SEROLOGICA, ya que deben de transcurrir 180 dias desde la ultima\n");
          MenuAdmin();
        }
        System.out.println("   ------ASIGNACION DE PRUEBA SEROLÓGICA------\n\n");
        System.out.println("········LISTA DE ENFERMEROS PARA ESCOGER···········\n\n");

        numero = 0;
        fecha = LocalDate.now();
        checkk = 0;
        check = 0;
        lista = new int[15];
        for (int i = 0; i < Aenfermero.size(); i++) {
          for (int h = 0; h < 5; h++) {
            if (Aenfermero.get(i).getFecha(h) == null) {
              check = 1;
            } else if (ChronoUnit.DAYS.between(LocalDate.now(), Aenfermero.get(i).getFecha(h)) < 0) {
              check = 1;
            }

          }

          if (check == 1) {
            checkk = 1;
            lista[numero] = i;
            numero++;
            System.out.print("\n" + numero + " - " + "Nombre: " + Aenfermero.get(i).getNombre() + " " + Aenfermero.get(i).getApellido() + " DNI: " + Aenfermero.get(i).getDNI() + "\n");
            tope++;
            check = 0;
          }
        }
        if (checkk == 0) {
          System.out.println("\nNo hay enfermeros disponibles para las proximas fechas.\n\n");
          System.out.println("\nRedireccionando a menú principal..\n");
          MenuAdmin();
        }

        do {
          try {
            System.out.println("\nEscoja el enfermero segun su numero de indice.\n");
            sc = new Scanner(System.in);
            check = sc.nextInt();
          } catch (InputMismatchException e) {
            System.out.println("\nIntroduzca un numero enter válido.\n");
          }

          dnienfermero = Aenfermero.get(lista[check - 1]).getDNI();

          for (int i = 0; i < Aenfermero.size(); i++) {
            if (Aenfermero.get(i).getDNI().equals(dnienfermero)) {
              numero = 2;
              break;
            }
          }
        } while (numero != 2);

        for (int i = 0; i < Aenfermero.size(); i++) {
          if (Aenfermero.get(i).getDNI().equals(dnienfermero)) {
            for (int h = 0; h < 5; h++) {
              if (Aenfermero.get(i).getFecha(h) == null) {
                if (h == 0) {
                  fecha = LocalDate.now().plusDays(1);
                  Aenfermero.get(i).MeterFecha(h, fecha);
                  break;
                } else {
                  fecha = Aenfermero.get(i).getFecha(h - 1).plusDays(1);
                  Aenfermero.get(i).MeterFecha(h, fecha);
                  break;
                }

              }
            }
          }
        }

        System.out.println("········LISTA DE TECNICOS PARA ESCOGER···········\n\n");

        checkk = 0;
        check = 0;
        numero = 0;
        lista1 = new int[15];
        for (int i = 0; i < Atecnico.size(); i++) {
          for (int h = 0; h < 4; h++) {
            if (Atecnico.get(i).getFecha(h) == null) {
              check = 1;
            } else if (ChronoUnit.DAYS.between(LocalDate.now(), Atecnico.get(i).getFecha(h)) < 0) {
              check = 1;
            }

          }

          if (check == 1) {
            checkk = 1;
            lista1[numero] = i;
            numero++;
            System.out.print("\n" + numero + " - " + "Nombre: " + Atecnico.get(i).getNombre() + " " + Atecnico.get(i).getApellido() + " DNI: " + Atecnico.get(i).getDNI() + "\n");
            tope++;
            check = 0;
          }
        }

        if (checkk == 0) {
          System.out.println("\nNo hay técnicos disponibles para las proximas fechas.\n\n");
          System.out.println("\nRedireccionando a menú principal..\n");
          MenuAdmin();
        }

        do {
          try {
            System.out.println("\nEscoja el técnico segun su numero de indice.\n");
            sc = new Scanner(System.in);
            check = sc.nextInt();
          } catch (InputMismatchException e) {
            System.out.println("\nIntroduzca un numero enter válido.\n");
          }

          dnitecnico = Atecnico.get(lista1[check - 1]).getDNI();

          for (int i = 0; i < Atecnico.size(); i++) {
            if (Atecnico.get(i).getDNI().equals(dnitecnico)) {
              numero = 2;
              break;
            }
          }
        } while (numero != 2);

        for (int i = 0; i < Atecnico.size(); i++) {
          if (Atecnico.get(i).getDNI().equals(dnitecnico)) {
            for (int h = 0; h < 4; h++) {
              if (Atecnico.get(i).getFecha(h) == null) {
                if (h == 0) {
                  Atecnico.get(i).MeterFecha(h, fecha);
                  break;
                } else {
                  Atecnico.get(i).MeterFecha(h, fecha);
                  break;
                }

              }
            }
          }
        }

        prueba = new Prueba(recibidor, dnienfermero, dnitecnico, fecha, "SEROLOGICA");
        Aprueba.add(prueba);
        Apersona.get(index - 1).setUltimaSEROLOGICA(fecha);
        serologica = new SEROLOGICA(recibidor, dnienfermero, dnitecnico, fecha, 0);
        Aserologica.add(serologica);
        System.out.println("\nPrueba para " + nomb + " " + ap + " puesta para el dia " + fecha + "\n\n");
        System.out.println("Redireccionando a menú principal..\n");

        MenuAdmin();
        break;

      }

    } else {

      System.out.println("\nRedireccionando a menú principal..\n");

      MenuAdmin();
    }
    }else{
    System.out.println("\nNo hay personas dadas de alta en el sistema todavia.\n\n");
    System.out.println("Redireccionando a menú principal..\n");
    MenuAdmin();
    }
  }
  //FUNCION PARA ASIGNAR UNA VACUNA A UN PACIENTE MARCANDO SU ENFERMERO, DIA(SI LE TOCA 1 O 2 VACUNACIONES), ETC
  private static void AdminAsignacionVacuna() {
    int numero, dia, mes, año, blancos, tope;
    String DNI, enfermero, fecha1, fecha2, palabra;
    LocalDate fecha, fechaa;
    Scanner sc = new Scanner(System.in);
    boolean grupo1 = false;
    boolean dnivalido = false;
    numero = 0;
    int index = 0;
    tope = 0;
    //IF PARA VER SI HAY ALGUNA DOSIS DISPONIBLE
    if (Amoderna.get(0).getDosis() > 0 || Apfizer.get(0).getDosis() > 0 || Ajohnson.get(0).getDosis() > 0) {
      //IF PARA VER SI HAY PERSONAS REGISTRADAS EN EL SISTEMA
      if (Apersona.size() > 0) {
        //FOR PARA CHEQUEAR SI HAY GENTE MAYOR DE 65 AÑOS EN EL SISTEMA SIN VACUNAR
        for (int i = 0; i < Apersona.size(); i++) {
          if (Apersona.get(i).getEdad() >= 65) {
            for (int h = 0; h < AVacuna.size(); h++) {
              if (Apersona.get(i).getDNI().equals(AVacuna.get(h).getRecibidor()) && AVacuna.get(h).getEstado() == false) {
                grupo1 = true;
              }
            }
          }
        }
        //IF QUE SE EJECUTARA SI HAY AL MENOS UN MAYOR DE 65 AÑOS EN LA BASE DE DATOS
        if (grupo1 == true) {
          System.out.println("Para la asignacion de la vacunacion, priorizamos las personas mayores de 65 años, pertenecientes al primer grupo de vacunacion\n");
          System.out.println("············Lista de 1º Grupo de vacunacion············");
          int[] list = new int[15];
          numero = 0;
          //BUCLE FOR PARA IMPRIMIR A LAS PERSONAS MAYORES DE 65 AÑOS EN UNA LISTA
          for (int i = 0; i < Apersona.size(); i++) {
            if (Apersona.get(i).getEdad() >= 65) {
              list[numero] = numero + 1;
              numero++;
              blancos = 20 - (Apersona.get(i).getNombre().length() + Apersona.get(i).getApellido().length() + 1);
              System.out.print(numero + "-Nombre: " + Apersona.get(i).getNombre() + " " + Apersona.get(i).getApellido());
              tope++;
              for (int h = 0; h < blancos; h++) {
                System.out.print(" ");
              }
              System.out.println(" DNI: " + Apersona.get(i).getDNI());
            }
          }
          //DO-WHILE PARA ESCOGER CUAL PACIENTE VACUNAR
          do {
            do {
              try {
                System.out.println("\nCual de estas personas pertenecientes al grupo 1 quiere usted vacunar?(Indique por indice)\n");
                sc = new Scanner(System.in);
                index = sc.nextInt();
              } catch (InputMismatchException e) {
                System.out.println("\nIntroduzca un numero entero válido\n");
              }
            } while (index < 1 || index > tope);

            DNI = Apersona.get(index - 1).getDNI();

            for (int x = 0; x < Apersona.size(); x++) {
              if (Apersona.get(x).getDNI().equals(DNI)) {
                dnivalido = true;
              }
            }

          } while (dnivalido == false && (index < 1 || index > numero));
          numero = 0;
          //FOR PARA ESCOGER TIPO DE VACUNA
          for (int i = 0; i < Apersona.size(); i++) {
            if (Apersona.get(i).getDNI().equals(DNI)) {
              do {
                try {
                  System.out.println("Con que vacuna quieres vacunarlo?\n\n ·1-Moderna\n ·2-Pfizer\n ·3-Johnson&Johnson\n");
                  sc = new Scanner(System.in);
                  numero = sc.nextInt();
                } catch (InputMismatchException e) {
                  System.out.println("\nIntroduzca un número entero entre el 1 y el 3.\n");
                }
              } while (numero < 1 || numero > 3);
              switch (numero) {
              //CASE 1 - VACUNA MODERNA
              case 1:
                tope = 0;
                //IF PARA VER SI HAY DOSIS
                if (Amoderna.get(0).getDosis() > 0) {
                  System.out.println("\n··········VACUNA MODERNA··········\n");
                  System.out.println("········LISTA DE ENFERMEROS PARA ESCOGER···········\n\n");
                  //FOR PARA IMPRIMIR A LOS ENFERMEROS 
                  for (int j = 0; j < Aenfermero.size(); j++) {
                    numero = j + 1;
                    System.out.print("\n" + numero + " - " + "Nombre: " + Aenfermero.get(j).getNombre() + "   Apellido: " + Aenfermero.get(j).getApellido() + "\n");
                    tope++;
                  }
                  //DO WHILE PARA ESCOGER A ENFERMERO
                  do {
                    try {
                      System.out.println("\nEscoja el enfermero segun su numero de indice\n");
                      sc = new Scanner(System.in);
                      numero = sc.nextInt();
                    } catch (InputMismatchException e) {
                      System.out.println("\nIntroduzca un número entero válido.n");
                    }
                  } while (numero < 1 || numero > tope);
                  //SE CREA LA VACUNA Y TE DIRÁ LAS FECHAS DE VACUNACIONES
                  enfermero = Aenfermero.get(numero - 1).getDNI();
                  fecha = LocalDate.now().plusDays(7);
                  fechaa = fecha.plusDays(21);
                  System.out.println("\nFecha de vacunación aceptada.");
                  System.out.println("\nAl ser la vacuna de la casa Moderna, esta requerirá 2 vacunaciones:\nLa primera fecha de vacunacion será el " + fecha + "\nLa segunda fecha de vacunacion será el " + fecha + "\n");
                  Vacuna vacuna = new Vacuna(enfermero, DNI, fecha, fechaa, "Moderna");
                  AVacuna.add(vacuna);
                  MenuAdmin();

                } else {
                  System.out.println("\nNo hay dosis de esta vacuna disponibles");
                  MenuAdmin();
                }
                break;
              //CASE 2 - PFIZER
              case 2:
                tope = 0;
                //IF PARA VER SI HAY DOSIS DISPONIBLES
                if (Apfizer.get(0).getDosis() > 0) {
                  System.out.println("\n··········VACUNA PFIZER··········\n");
                  System.out.println("········LISTA DE ENFERMEROS PARA ESCOGER···········\n\n");
                  //FOR PARA IMPRIMIR ENFERMEROS
                  for (int j = 0; j < Aenfermero.size(); j++) {
                    numero = j + 1;
                    System.out.print("\n" + numero + " - " + "Nombre: " + Aenfermero.get(j).getNombre() + "   Apellido: " + Aenfermero.get(j).getApellido() + "\n");
                    tope++;
                  }
                  //DO WHILE PARA ESCOGER ENFERMERO
                  do {
                    try {
                      System.out.println("\nEscoja el enfermero segun su numero de indice\n");
                      sc = new Scanner(System.in);
                      numero = sc.nextInt();
                    } catch (InputMismatchException e) {
                      System.out.println("\nIntroduzca un número entero válido.n");
                    }
                  } while (numero < 1 || numero > tope);
                  //SE CREA LA VACUNA Y TE DICE LAS FECHAS DE VACUNACION
                  enfermero = Aenfermero.get(numero - 1).getDNI();
                  fecha = LocalDate.now().plusDays(7);
                  fechaa = fecha.plusDays(21);
                  System.out.println("\nFecha de vacunación aceptada.");
                  System.out.println("\nAl ser la vacuna de la casa Pfizer, esta requerirá 2 vacunaciones:\nLa primera fecha de vacunacion será el " + fecha + "\nLa segunda fecha de vacunacion será el " + fechaa + "\n");
                  Vacuna vacuna = new Vacuna(enfermero, DNI, fecha, fechaa, "Pfizer");
                  AVacuna.add(vacuna);
                  MenuAdmin();
                } else {
                  System.out.println("\nNo hay dosis de esta vacuna disponibles");
                  MenuAdmin();
                }
                break;
              //CASE 3 - JOHNSON&JOHNSON
              case 3:
                tope = 0;
                //IF PARA VER SI HAY DOSIS DISPONIBLES
                if (Ajohnson.get(0).getDosis() > 0) {
                  System.out.println("\n··········VACUNA JOHNSON&JOHNSON··········\n");
                  System.out.println("········LISTA DE ENFERMEROS PARA ESCOGER···········\n\n");
                  //FOR PARA IMPRIMIR ENFERMEROS
                  for (int j = 0; j < Aenfermero.size(); j++) {
                    numero = j + 1;
                    System.out.print("\n" + numero + " - " + "Nombre: " + Aenfermero.get(j).getNombre() + "   Apellido: " + Aenfermero.get(j).getApellido() + "\n");
                    tope++;
                  }
                  //DO WHILE PARA ESCOGER ENFERMERO
                  do {
                    try {
                      System.out.println("\nEscoja el enfermero segun su numero de indice\n");
                      sc = new Scanner(System.in);
                      numero = sc.nextInt();
                    } catch (InputMismatchException e) {
                      System.out.println("\nIntroduzca un número entero válido.n");
                    }
                  } while (numero < 1 || numero > tope);
                  //SE CREA LA VACUNA Y TE IMPRIMIRA LA FECHA DE VACUNACION
                  enfermero = Aenfermero.get(numero - 1).getDNI();
                  fecha = LocalDate.now().plusDays(7);
                  System.out.println("\nFecha de vacunación aceptada.");
                  System.out.println("\nAl ser la vacuna de la casa Johnson&Johnson, esta requerirá 1 vacunacion:\nLa fecha de vacunacion será el " + fecha + "\n");
                  Vacuna vacuna = new Vacuna(enfermero, DNI, fecha, null, "Johnson&Johnson");
                  AVacuna.add(vacuna);
                  MenuAdmin();

                } else {
                  System.out.println("\nNo hay dosis de esta vacuna disponibles");
                  MenuAdmin();
                }
                break;

              }
            }
          }
        } else if (grupo1 == false) {
          
          for (int i = 0; i < Apersona.size(); i++) {
            if (Apersona.get(i).getEdad() < 65) {
              for (int h = 0; h < AVacuna.size(); h++) {
                if (Apersona.get(i).getDNI().equals(AVacuna.get(h).getRecibidor()) && AVacuna.get(h).getEstado() == false) {
                  grupo1 = true;
                }
              }
            }
          }
          tope = 0;
          //SI NO HAY NINGUN MAYOR DE 65 SEGUIRÁ ESTE CODIGO
          if (grupo1 == true) {

            System.out.println("\n\nNo hay personas mayores de 65 años por vacunar, se mostrará en pantalla el grupo de menores de 65 años a vacunar.\n");
            System.out.println("···············LISTA DE PERSONAS MENORES DE 65 AÑOS···············\n\n");
            //BUCLE FOR PARA IMPRIMIR A LAS PERSONAS MENORES DE 65 AÑOS
            for (int i = 0; i < Apersona.size(); i++) {
              if (Apersona.get(i).getEdad() < 65) {
                numero++;
                blancos = 20 - (Apersona.get(i).getNombre().length() + Apersona.get(i).getApellido().length() + 1);
                System.out.print(numero + "-Nombre: " + Apersona.get(i).getNombre() + " " + Apersona.get(i).getApellido());
                tope++;
                for (int h = 0; h < blancos; h++) {
                  System.out.print(" ");
                }
                System.out.println(" DNI: " + Apersona.get(i).getDNI());
              }
            }
            //DO WHILE PARA ESCOGER A LA PERSONA QUE QUEREMOS VACUNAR
            do {
              do {
                try {
                  System.out.println("\nCual de estas personas pertenecientes al grupo 2 quiere usted vacunar?(Indique por indice)\n");
                  sc = new Scanner(System.in);
                  index = sc.nextInt();
                } catch (InputMismatchException e) {
                  System.out.println("\nIntroduzca un numero entero válido\n");
                }
              } while (index < 1 || index > tope);

              DNI = Apersona.get(index - 1).getDNI();

              for (int x = 0; x < Apersona.size(); x++) {
                if (Apersona.get(x).getDNI().equals(DNI)) {
                  dnivalido = true;
                }
              }

            } while (dnivalido == false && (index < 1 || index > numero));
            numero = 0;
            //FOR PARA ESCOGER VACUNA CON LA CUAL VACUNAR
            for (int i = 0; i < Apersona.size(); i++) {
              if (Apersona.get(i).getDNI().equals(DNI)) {
                do {
                  try {
                    System.out.println("\nCon que vacuna quieres vacunarlo?\n\n ·1-Moderna\n ·2-Pfizer\n ·3-Johnson&Johnson\n");
                    sc = new Scanner(System.in);
                    numero = sc.nextInt();
                  } catch (InputMismatchException e) {
                    System.out.println("\nIntroduce un numero entero entre el 1 y el 3. \n");
                  }
                } while (numero < 1 || numero > 3);
                switch (numero) {
                //CASE 1 - MODERNA
                case 1:
                  tope = 0;
                  //CHEQUEA SI HAY DOSIS DISPONIBLES
                  if (Amoderna.get(0).getDosis() > 0) {
                    System.out.println("\n··········VACUNA MODERNA··········\n");
                    System.out.println("········LISTA DE ENFERMEROS PARA ESCOGER···········\n\n");
                    //FOR PARA IMPRIMIR LISTA DE ENFERMEROS
                    for (int j = 0; j < Aenfermero.size(); j++) {
                      numero = j + 1;
                      System.out.print("\n" + numero + " - " + "Nombre: " + Aenfermero.get(j).getNombre() + " " + Aenfermero.get(j).getApellido() + "\n");
                      tope++;
                    }
                    //DO WHILE PARA ESCOGER ENFERMERO
                    do {
                      try {
                        System.out.println("\nEscoja el enfermero segun su numero de indice\n");
                        sc = new Scanner(System.in);
                        numero = sc.nextInt();
                      } catch (InputMismatchException e) {
                        System.out.println("\nIntroduce un numero entero válido.\n");
                      }
                    } while (numero < 1 || numero > tope);
                    //SE CREA LA VACUNA Y NOS IMPRIME SUS FECHAS
                    enfermero = Aenfermero.get(numero - 1).getDNI();
                    fecha = LocalDate.now().plusDays(7);
                    fechaa = fecha.plusDays(21);
                    System.out.println("\nFecha de vacunación aceptada.");
                    System.out.println("\nAl ser la vacuna de la casa Moderna, esta requerirá 2 vacunaciones:\nLa primera fecha de vacunacion será el " + fecha + "\nLa segunda fecha de vacunacion será el " + fechaa + "\n");
                    Vacuna vacuna = new Vacuna(enfermero, DNI, fecha, fechaa, "Moderna");
                    AVacuna.add(vacuna);
                    MenuAdmin();

                  } else {
                    System.out.println("\nNo hay dosis de esta vacuna disponibles");
                    MenuAdmin();
                  }
                  break;
                //CASE 2 - PFIZER
                case 2:
                  tope = 0;
                  //CHEQUEA SI HAY DOSIS DISPONIBLES
                  if (Apfizer.get(0).getDosis() > 0) {
                    System.out.println("\n··········VACUNA PFIZER··········\n");
                    System.out.println("········LISTA DE ENFERMEROS PARA ESCOGER···········\n\n");
                    //FOR PARA IMPRIMIR ENFERMEROS
                    for (int j = 0; j < Aenfermero.size(); j++) {
                      numero = j + 1;
                      System.out.print("\n" + numero + " - " + "Nombre: " + Aenfermero.get(j).getNombre() + "   Apellido: " + Aenfermero.get(j).getApellido() + "\n");
                      tope++;
                    }
                    //DO WHILE PARA ESCOGER ENFERMEROS
                    do {
                      try {
                        System.out.println("\nEscoja el enfermero segun su numero de indice\n");
                        sc = new Scanner(System.in);
                        numero = sc.nextInt();
                      } catch (InputMismatchException e) {
                        System.out.println("\nIntroduce un numero entero válido.\n");
                      }
                    } while (numero < 1 || numero > tope);
                    //CREA VACUNA Y NOS IMPRIME LAS FECHAS DE VACUNACION
                    enfermero = Aenfermero.get(numero - 1).getDNI();
                    fecha = LocalDate.now().plusDays(7);
                    fechaa = fecha.plusDays(21);
                    System.out.println("\nFecha de vacunación aceptada.");
                    System.out.println("\nAl ser la vacuna de la casa Pfizer, esta requerirá 2 vacunaciones:\nLa primera fecha de vacunacion será el " + fecha + "\nLa segunda fecha de vacunacion será el " + fechaa + "\n");
                    Vacuna vacuna = new Vacuna(enfermero, DNI, fecha, fechaa, "Pfizer");
                    AVacuna.add(vacuna);
                    MenuAdmin();

                  } else {
                    System.out.println("\nNo hay dosis de esta vacuna disponibles");
                    MenuAdmin();
                  }
                  break;
                //CASE 3 - JOHNSON&JOHNSON
                case 3:
                  tope = 0;
                  //IF PARA VER SI HAY DOSIS DISPONIBLES
                  if (Ajohnson.get(0).getDosis() > 0) {
                    System.out.println("\n··········VACUNA JOHNSON&JOHNSON··········\n");
                    System.out.println("········LISTA DE ENFERMEROS PARA ESCOGER···········\n\n");
                    //FOR PARA IMPRIMIR ENFERMEROS
                    for (int j = 0; j < Aenfermero.size(); j++) {
                      numero = j + 1;
                      System.out.print("\n" + numero + " - " + "Nombre: " + Aenfermero.get(j).getNombre() + "   Apellido: " + Aenfermero.get(j).getApellido() + "\n");
                      tope++;
                    }
                    //DO WHILE PARA ESCOGER ENFERMERO
                    do {
                      try {
                        System.out.println("\nEscoja el enfermero segun su numero de indice\n");
                        sc = new Scanner(System.in);
                        numero = sc.nextInt();
                      } catch (InputMismatchException e) {
                        System.out.println("\nIntroduce un numero entero válido.\n");
                      }
                    } while (numero < 1 || numero > tope);
                    //CREA VACUNA E IMPRIME LA FECHA DE VACUNACION
                    enfermero = Aenfermero.get(numero - 1).getDNI();
                    fecha = LocalDate.now().plusDays(7);
                    System.out.println("\nFecha de vacunación aceptada.");
                    System.out.println("\nAl ser la vacuna de la casa Johnson&Johnson, esta requerirá 1 vacunacion:\nLa fecha de vacunacion será el " + fecha + "\n");
                    Vacuna vacuna = new Vacuna(enfermero, DNI, fecha, null, "Johnson&Johnson");
                    AVacuna.add(vacuna);
                    MenuAdmin();

                  } else {
                    System.out.println("\nNo hay dosis de esta vacuna disponibles");
                    MenuAdmin();
                  }
                  break;

                }
              }
            }
          } else {
            System.out.println("No hay personas dadas de alta a las cual vacunar todavia\n");
            System.out.println("\nRedireccionando al menú principal..\n");
            MenuAdmin();
          }
        }
      } else {
        System.out.println("No hay personas dadas de alta a las cual vacunar todavia\n");
        System.out.println("\nRedireccionando al menú principal..\n");
        MenuAdmin();
      }
    } else {
      System.out.println("\nNo hay stock de ninguna vacuna ahora mismo disponible. \n");
      System.out.println("\nRedireccionando al menú principal..\n");
      MenuAdmin();
    }
  }
  //FUNCION PARA METER STOCK EN CADA TIPO DE VACUNAS
  private static void AdminStockVacunas() {
    int x, dosis, check;
    Scanner sc = new Scanner(System.in);
    boolean repetir = true;
    dosis = 0;
    //WHILE PARA INTRODUCIR DOSIS DE MODERNA
    while (repetir) {
      System.out.println("\nCuantas vacunas de MODERNA han llegado a la clinica?\n");
      try {
        sc = new Scanner(System.in);
        dosis = sc.nextInt();
        repetir = false;
      } catch (InputMismatchException e) {
        System.out.println("\nDebe introducir un numero entero.\n");

      }

    }
    Amoderna.get(0).añadirDosis(dosis);
    repetir = true;
    //WHILE PARA INTRODUCIR DOSIS DE PFIZER
    while (repetir) {
      System.out.println("\nCuantas vacunas de PFIZER han llegado a la clinica?\n");
      try {
        sc = new Scanner(System.in);
        dosis = sc.nextInt();
        repetir = false;
      } catch (InputMismatchException e) {
        System.out.println("\nDebe introducir un numero entero.\n");
      }
    }
    repetir = true;
    Apfizer.get(0).añadirDosis(dosis);
    //WHILE PARA INTRODUCIR DOSIS DE JOHNSON&JOHNSON
    while (repetir) {
      System.out.println("\nCuantas vacunas de JOHNSON&JOHNSON han llegado a la clinica?\n");
      try {
        sc = new Scanner(System.in);
        dosis = sc.nextInt();
        repetir = false;
      } catch (InputMismatchException e) {
        System.out.println("\nDebe introducir un numero entero.\n");
      }
    }
    Ajohnson.get(0).añadirDosis(dosis);
    System.out.println("\nSe ha realizado el stock correctamente, el stock actual consta de: \n\n ·" + Amoderna.get(0).getDosis() + " Dosis de Moderna\n ·" + Apfizer.get(0).getDosis() + " Dosis de Pfizer\n ·" + Ajohnson.get(0).getDosis() + " Dosis de Johnson&Johnson");
    System.out.println("\nRedireccionando al menú principal..\n");
    MenuAdmin();
  }
  //FUNCION PARA IMPRIMIR UNA LISTA DE ENFERMEROS Y TECNICOS JUNTO A LOS PACIENTES QUE TIENEN ASIGNADOS
  private static void AdminPacientesAsignados() {
    int numero, index, n, n2;
    String palabra, dnipaciente, dnienfermero, dnitecnico;
    Scanner sc = new Scanner(System.in);
    numero = 0;
    n2 = 0;
    boolean tienepaciente = false;
    //IF PARA VER SI HAY ENFERMEROS REGISTRADOS
    if (Aenfermero.size() > 0) {
      System.out.println("\n·····LISTA DE ENFERMEROS·····\n");
      //FOR PARA IMPRIMIR ENFERMERO
      for (int i = 0; i < Aenfermero.size(); i++) {
        n = i + 1;
        System.out.println("\nENFERMERO: " + Aenfermero.get(i).getNombre() + "  " + Aenfermero.get(i).getApellido() + "\n\n");
        dnienfermero = Aenfermero.get(i).getDNI();
        System.out.println("  -Pacientes para vacunar: \n");
        //FOR PARA VER SI ESE ENFERMERO TIENE AL MENOS UN PACIENTE PARA VACUNAR
        for (int k = 0; k < AVacuna.size(); k++) {
          if (AVacuna.get(k).getEnfermero().equals(dnienfermero)) {
            tienepaciente = true;
          }
        }
        //SI TIENE PACIENTE -> IMPRIME LOS PACIENTES QUE TENGA PARA VACUNAR
        if (tienepaciente == true) {
          for (int j = 0; j < AVacuna.size(); j++) {
            if (AVacuna.get(j).getEnfermero().equals(dnienfermero)) {
              n2++;
              dnipaciente = AVacuna.get(j).getRecibidor();
              for (int h = 0; h < Apersona.size(); h++) {
                if (Apersona.get(h).getDNI().equals(dnipaciente)) {
                  System.out.println("         " + n2 + " ·" + Apersona.get(h).getNombre() + "  " + Apersona.get(h).getApellido() + "  con DNI: " + Apersona.get(h).getDNI());
                }
              }
            }
          }
        } else {
          System.out.println("\n         ·No hay pacientes\n");
        }
        n2 = 0;
        tienepaciente = false;
        System.out.println("\n  -Pacientes para Pruebas: \n");
        //FOR PARA VER SI ESE ENFERMERO TIENE AL MENOS UN PACIENTE PARA VACUNAR
        for (int k = 0; k < Aprueba.size(); k++) {
          if (Aprueba.get(k).getEnfermero().equals(dnienfermero)) {
            tienepaciente = true;
          }
        }
        //SI TIENE PACIENTE -> IMPRIME LOS PACIENTES QUE TENGA PARA VACUNAR
        if (tienepaciente == true) {
          for (int j = 0; j < Aprueba.size(); j++) {
            if (Aprueba.get(j).getEnfermero().equals(dnienfermero)) {
              n2++;
              dnipaciente = Aprueba.get(j).getRecibidor();

              for (int h = 0; h < Apersona.size(); h++) {
                if (Apersona.get(h).getDNI().equals(dnipaciente)) {
                  System.out.println("         " + n2 + " ·" + Apersona.get(h).getNombre() + "  " + Apersona.get(h).getApellido() + "  con DNI: " + Apersona.get(h).getDNI());
                }
              }
            }
          }
        } else {
          System.out.println("\n         ·No hay pacientes\n");
        }
      }
    } else {
      System.out.println("\nNo hay enfermeros dados de alta todavía\n\n");
      MenuAdmin();
    }
    //IF PARA VER SI HAY TECNICOS REGISTRADOS
    if (Atecnico.size() > 0) {
      System.out.println("\n\n·····LISTA DE TECNICOS·····\n");
      //FOR PARA IMPRIMIR EL NOMBRE DEL TECNICO DEL CUAL VAMOS A MOSTRAR LOS PACIENTES
      for (int i = 0; i < Atecnico.size(); i++) {
        n = i + 1;
        System.out.println("\nTÉCNICO: " + Atecnico.get(i).getNombre() + "  " + Atecnico.get(i).getApellido() + "\n\n");
        dnitecnico = Atecnico.get(i).getDNI();
        n2 = 0;
        tienepaciente = false;
        System.out.println("  -Pacientes para Pruebas: \n");
        //FOR PARA VER SI HAY ALGUN PACIENTE ASIGNADO A ESE TECNICO
        for (int k = 0; k < Aprueba.size(); k++) {
          if (Aprueba.get(k).getTecnico().equals(dnitecnico)) {
            tienepaciente = true;
          }
        }
        //SI TIENE PACIENTE -> IMPRIME LOS PACIENTES
        if (tienepaciente == true) {
          for (int j = 0; j < Aprueba.size(); j++) {
            if (Aprueba.get(j).getTecnico().equals(dnitecnico)) {
              n2++;
              dnipaciente = Aprueba.get(j).getRecibidor();
              for (int h = 0; h < Apersona.size(); h++) {
                if (Apersona.get(h).getDNI().equals(dnipaciente)) {
                  System.out.println("         " + n2 + " - " + Apersona.get(h).getNombre() + "  " + Apersona.get(h).getApellido() + "  con DNI: " + Apersona.get(h).getDNI());
                }
              }
            }
          }
        } else {
          System.out.println("\n         ·No hay pacientes\n");
        }
      }

    } else {
      System.out.println("\nNo hay tecnicos dados de alta todavía\n\n");
    }
    System.out.println("\nRedireccionando al menú principal..\n");
    MenuAdmin();
  }
  //FUNCION QUE NOS PERMITIRA VER A LAS PERSONAS QUE ESTAN CONFINADAS EN LA ACTUALIDAD
  private static void AdminVisualizarConfinados() {
    int n, n2, blancos;
    n2 = 0;
    //FOR PARA CHEQUEAR SI HAY ALGUNA PERSONA CON EL ATRIBUTO CONFINADO EN TRUE
    for (int i = 0; i < Apersona.size(); i++) {
      if (Apersona.get(i).getConfinado() == true) {
        n2 = 1;
      }
    }
    //SI HAY ALGUNA PERSONA CON EL ATRIBUTO EN TRUE
    if (n2 == 1) {
      System.out.println("········LISTA DE PERSONAS CONFINADAS········\n\n");
      n2 = 0;
      //FOR QUE CHEQUEA QUE ESA PERSONA NO HAYA ACABADO EL CONFINAMIENTO Y LA IMPRIMIR
      for (int i = 0; i < Apersona.size(); i++) {
        if (Apersona.get(i).getConfinado() == true && ChronoUnit.DAYS.between(Apersona.get(i).getFinConfin(), LocalDate.now()) < 0) {
          n2++;
          blancos = 17 - (Apersona.get(i).getNombre().length() + Apersona.get(i).getApellido().length() + 1);
          System.out.print(n2 + " - " + Apersona.get(i).getNombre() + " " + Apersona.get(i).getApellido());
          for (int x = 0; x < blancos; x++) {
            System.out.print(" ");
          }
          System.out.println(" con DNI: " + Apersona.get(i).getDNI() + " confinado desde " + Apersona.get(i).getInicioConfin() + " hasta " + Apersona.get(i).getFinConfin() + "\n");
        }
      }

    } else {

      System.out.println("\nNo hay pacientes confinados\n\n");
      System.out.println("Redireccionando al menú principal..\n\n");
      MenuAdmin();
    }
    System.out.println("\n\n");
    MenuAdmin();
  }
  //FUNCION PARA PONERLE A PACIENTES QUE HAYAN ACABADO EL CONFINAMIENTO UNA PRUEBA SEROLOGICA
  private static void AdminPruebaPostConfinamiento() {
    int num, numm, blancos, tope;
    int[] lista = new int[20];
    Scanner sc = new Scanner(System.in);
    int a = 0;
    num = 0;
    tope = 0;
    String dnienfermero, dnitecnico, nombenfermero, nombtecnico, apenfermero, aptecnico;
    dnienfermero = "";
    dnitecnico = "";
    nombenfermero = "";
    nombtecnico = "";
    apenfermero = "";
    aptecnico = "";
    //FOR PARA COMPROBAR QUE HAY UNA PERSONA QUE TIENE UNA FECHA FIN DE CONFINAMIENTO, COMPRUEBA QUE ESTÁ HAYA ACABADO Y QUE NO TENGA UNA SEROLOGICA HECHA EN LOS ULTIMOS 180 DIAS
    for (int i = 0; i < Apersona.size(); i++) {
      if (Apersona.get(i).getFinConfin() == null) {} else {
        if (ChronoUnit.DAYS.between(Apersona.get(i).getFinConfin(), LocalDate.now()) > 0 && !(ChronoUnit.DAYS.between(Apersona.get(i).getUltimaSEROLOGICA(), LocalDate.now()) < 180)) {
          a++;
        }
      }
    }
    
    //SI HAY AL MENOS UNA PERSONA
    if (a > 0) {
      System.out.println("\n·········LISTA DE PERSONAS CON CONFINAMIENTO TERMINADO············\n\n");
      tope = 0;
      num = 0;
      //FOR PARA IMPRIMIR ESA PERSONA EN UNA LISTA
      for (int i = 0; i < Apersona.size(); i++) {
        if (Apersona.get(i).getFinConfin() == null) {} else {
          if (ChronoUnit.DAYS.between(Apersona.get(i).getFinConfin(), LocalDate.now()) > 0 && !(ChronoUnit.DAYS.between(Apersona.get(i).getUltimaSEROLOGICA(), LocalDate.now()) < 180)) {
            num++;
            tope++;
            lista[num] = i;
            System.out.print(num + "-" + Apersona.get(i).getNombre() + " " + Apersona.get(i).getApellido());
            blancos = 17 - (Apersona.get(i).getNombre().length() + Apersona.get(i).getApellido().length() + 1);
            for (int x = 0; x < blancos; x++) {
              System.out.print(" ");
            }
            System.out.print(" con DNI: " + Apersona.get(i).getDNI() + "  Inicio confinamiento: " + Apersona.get(i).getInicioConfin() + "   Final confinamiento: " + Apersona.get(i).getFinConfin() + "\n\n");
          }
        }
      }
      numm = 0;
      num = 0;
      System.out.println("\nElige segun indice a cual le quieres proponer una prueba serologica\n\n");
      boolean valido = false;
      //WHILE PARA ESCOGER LA PERSONA A LA QUE ASIGNARLE UNA PRUEBA SEROLOGICA
      while (valido == false || numm < 1 || numm > tope) {
        try {
          if (num == 1) {
            System.out.println("\nElige un numero válido.\n");
          }
          sc = new Scanner(System.in);
          numm = sc.nextInt();
          num = 1;
          valido = true;
        } catch (InputMismatchException e) {
          System.out.println("\nElige un numero entero.\n");
          num = 0;
        }
      }
      //BUCLE FOR QUE ANIDA OTROS BUCLES FOR PARA ASIGNARLE UN ENFERMERO Y UN TECNICO SEGUN ESTÉN DISPONIBLES O NO
      for (int i = 0; i < Apersona.size(); i++) {
        if (Apersona.get(i).getDNI().equals(Apersona.get(lista[numm]).getDNI())) {
          if (ChronoUnit.DAYS.between(Apersona.get(i).getUltimaSEROLOGICA(), LocalDate.now()) < 180) {
            System.out.println("\nEsta persona ya se ha realizado una prueba serologica en los ultimos 180 dias.\n\n");
          } else {
            Apersona.get(i).setUltimaSEROLOGICA(LocalDate.now().plusDays(4));
            for (int k = 0; k < Aenfermero.size(); k++) {

              for (int h = 0; h < 5; h++) {
                if (Aenfermero.get(k).getFecha(h) == null) {
                  dnienfermero = Aenfermero.get(k).getDNI();
                  nombenfermero = Aenfermero.get(k).getNombre();
                  apenfermero = Aenfermero.get(k).getApellido();
                } else if (ChronoUnit.DAYS.between(LocalDate.now(), Aenfermero.get(k).getFecha(h)) < 0) {
                  dnienfermero = Aenfermero.get(k).getDNI();
                  nombenfermero = Aenfermero.get(k).getNombre();
                  apenfermero = Aenfermero.get(k).getApellido();
                }
              }
            }

            for (int k = 0; k < Atecnico.size(); k++) {
              for (int h = 0; h < 4; h++) {
                if (Atecnico.get(k).getFecha(h) == null) {
                  dnitecnico = Atecnico.get(k).getDNI();
                  nombtecnico = Atecnico.get(k).getNombre();
                  aptecnico = Atecnico.get(k).getApellido();
                } else if (ChronoUnit.DAYS.between(LocalDate.now(), Atecnico.get(k).getFecha(h)) < 0) {
                  dnitecnico = Atecnico.get(k).getDNI();
                  nombtecnico = Atecnico.get(k).getNombre();
                  aptecnico = Atecnico.get(k).getApellido();
                }
              }
            }
            //CREA LA PRUEBA, TE DICE EL ENFERMERO QUE SE HA ASIGNADO POR DEFECTO, EL TECNICO QUE SE HA ASIGNADO POR DEFECTO Y EL DIA DE LA PRUEBA 
            Prueba prueba = new Prueba(Apersona.get(i).getDNI(), dnienfermero, dnitecnico, Apersona.get(i).getUltimaSEROLOGICA(), "SEROLOGICA");
            Aprueba.add(prueba);
            System.out.println("\nLa prueba serologica se le ha asignado a " + Apersona.get(i).getNombre() + " " + Apersona.get(i).getApellido() + " para el dia " + Apersona.get(i).getUltimaSEROLOGICA() + " con el enfermero: " + nombenfermero + " " + apenfermero + " y con el técnico: " + nombtecnico + " " + aptecnico + "\n\n");
          }
        }
      }

    } else {
      System.out.println("\nNo hay personas que hayan pasado el confinamiento y no se les haya hecho una prueba serologica ya.\n\n");
      System.out.println("\nRedireccionando al menú principal..\n\n");
      MenuAdmin();
    }
    System.out.println("\nRedireccionando al menú principal..\n\n");
    MenuAdmin();
  }
  //ESTA FUNCION NOS MUESTRA EL MENU DE LOS ENFERMEROS
  private static void MenuEnfermero(String login) {
    int n = 0;
    int a = 0;
    Scanner sc = new Scanner(System.in);
    String Login = login;
    System.out.println("·········MENÚ ENFERMERO·········\n|                              |\n| 1-Visualizar Pacientes       |\n| 2-Registro de Pruebas        |\n| 3-Registro de Vacunación     |\n| 4-Log Out                    |\n|                              |\n································");
    //WHILE PARA ESCOGER OPCIÓN EN EL MENÚ
    while (n < 1 || n > 4) {
      try {
        if (a == 1) {
          System.out.println("\nIntroduzca un número entre el 1 y el 4.\n");
        }
        sc = new Scanner(System.in);
        n = sc.nextInt();
        a = 1;
      } catch (InputMismatchException e) {
        System.out.println("\nIntroduzca un numero entero.\n");
      }
    }
    switch (n) {
    case 1:
      EnfermeroVisualizarPacientes(Login);
      break;
    case 2:
      EnfermeroRegistroPruebas(Login);
      break;
    case 3:
      EnfermeroResgistroVacunas(Login);
      break;
    case 4:
      Login();
      break;
    default:
      System.out.println("\nIntroduzca un numero válido");
      MenuEnfermero(Login);
      break;
    }
  }
  //FUNCION QUE TE MUESTRA LOS PACIENTES QUE TIENES ASIGNADOS SI ERES ENFERMERO
  private static void EnfermeroVisualizarPacientes(String login) {
    int n = 0;
    int a = 0;
    int b = 0;
    int numero = 1;
    String dnipaciente = "", dnitecnico;
    String Login = login;
    //FOR PARA METER EN LA VARIABLE N EL Nº DE POSICION QUE TENEMOS EN EL ARRAYLIST
    for (int i = 0; i < Apersona.size(); i++) {
      if (Apersona.get(i).getDNI().equals(Login)) {
        n = i;
      }
    }
    //FOR PARA VER SI TENEMOS A ALGUIEN ASIGNADO PARA VACUNAR
    for (int i = 0; i < AVacuna.size(); i++) {
      if (AVacuna.get(i).getEnfermero().equals(Login)) {
        a++;
      }
    }
    //FOR PARA VER SI TENEMOS A ALGUIEN ASIGNADO PARA REALIZAR UNA PRUEBA
    for (int i = 0; i < Aprueba.size(); i++) {
      if (Aprueba.get(i).getEnfermero().equals(Login)) {
        b++;
      }
    }
    //SI NO HAY NI PARA VACUNAR NI PARA HACER PRUEBA, NOS LO DICE Y NOS DEVUELVE AL MENU
    if (a < 1 && b < 1) {
      System.out.println("\nNo tienes pacientes todavía.\n");
      System.out.println("\nRedireccionando al menú principal..\n\n");
      MenuEnfermero(Login);
    }
    System.out.println("\n·······Listado de pacientes de " + Apersona.get(n).getNombre() + " " + Apersona.get(n).getApellido() + "\n");
    //SI HAY ALMENOS UNA PERSONA PARA VACUNAR
    if (a > 0) {
      System.out.println("\n···Lista en vacunación: \n\n");
      //FOR PARA COGER EL DNI DE LA PERSONA QUE TENEMOS ASIGNADA PARA VACUNAR
      for (int i = 0; i < AVacuna.size(); i++) {
        if (AVacuna.get(i).getEnfermero().equals(Login)) {
          dnipaciente = AVacuna.get(i).getRecibidor();
        }
        //FOR QUE COMPARANDO EL DNI DE LA PERSONA EN LA ARRAYLIST DE PERSONA, CONSIGUE SUS DATOS Y NOS LOS IMPRIME
        for (int k = 0; k < Apersona.size(); k++) {
          if (Apersona.get(k).getDNI().equals(dnipaciente)) {
            System.out.println(numero + " " + Apersona.get(k).getNombre() + " " + Apersona.get(k).getApellido() + " con DNI: " + dnipaciente + "\n");
            numero++;
          }
        }
      }
    }

    numero = 1;
    //SI HAY ALMENOS UNA PERSONA PARA PRUEBAS
    if (b > 0) {
      System.out.println("\n···Lista en pruebas: \n\n");
      //FOR PARA COGER EL DNI DE LA PERSONA QUE TENEMOS ASIGNADA PARA PRUEBAS
      for (int i = 0; i < Aprueba.size(); i++) {
        if (Aprueba.get(i).getEnfermero().equals(Login)) {
          dnipaciente = Aprueba.get(i).getRecibidor();
        }
        //FOR QUE COMPARANDO EL DNI DE LA PERSONA EN LA ARRAYLIST DE PERSONA, CONSIGUE SUS DATOS Y NOS LOS IMPRIME
        for (int k = 0; k < Apersona.size(); k++) {
          if (Apersona.get(k).getDNI().equals(dnipaciente)) {
            System.out.println(numero + " " + Apersona.get(k).getNombre() + " " + Apersona.get(k).getApellido() + " con DNI: " + dnipaciente + "\n");
            numero++;
          }
        }
      }
    }

    MenuEnfermero(Login);
  }
  //FUNCION PARA DAR LAS PRUEBAS POR REALIZADAS Y ENVIARLAS A LOS TECNICOS A ANALIZAR
  private static void EnfermeroRegistroPruebas(String login) {
    String Login = login;
    int b = 0;
    String dnipaciente = "";
    int numero = 1;
    boolean valido = false;
    String dni, palabra;
    int año, mes, dia, index, blancos, tope;
    Scanner sc = new Scanner(System.in);
    LocalDate fecha;

    System.out.println("···········REGISTRO DE PRUEBAS···········\n\n");
    //FOR PARA CHEQUEAR QUE TENEMOS ALGUN PACIENTE AL QUE HACERLE UNA PRUEBA Y TODAVIA NO SE LE HAYA HECHO
    for (int i = 0; i < Aprueba.size(); i++) {
      if (Aprueba.get(i).getEnfermero().equals(Login) && Aprueba.get(i).getEstado() == false) {
        b++;
      }
    }
    int[] lista = new int[15];
    tope = 0;
    numero = 0;
    //SI HAY ALMENOS UN PACIENTE 
    if (b > 0) {
      System.out.println("\nListado de pacientes en pruebas: \n\n");
      //FOR PARA HACER LISTA DE LOS PACIENTES QUE TENEMOS EN PRUEBAS, PRIMERO COGIENDO SU DNI Y DESPUES CON EL USO DE SU DNI EN EL ARRAYLIST PERSONAS COGIENDO SUS DATOS
      for (int i = 0; i < Aprueba.size(); i++) {
        if (Aprueba.get(i).getEnfermero().equals(Login) && Aprueba.get(i).getEstado() == false) {
          dnipaciente = Aprueba.get(i).getRecibidor();
        }
        
        for (int k = 0; k < Apersona.size(); k++) {

          if (Apersona.get(k).getDNI().equals(dnipaciente)) {
            numero++;
            System.out.println(numero + "-" + Apersona.get(k).getNombre() + " " + Apersona.get(k).getApellido() + " con DNI: " + dnipaciente + "\n");
            lista[numero - 1] = k;
            tope++;
          }
        }
      }
      numero = 0;
      index = 0;
      System.out.println("\nCual quieres registrar?(Elige por indice). En caso de querer salir pulse 0.\n");
      //DO WHILE PARA ESCOGER A CUAL REGISTRAR
      do {
        try {
          if (numero == 1) {
            System.out.println("\nIntroduzca un numero válido. En caso de querer salir pulse 0.\n");
          }
          sc = new Scanner(System.in);
          index = sc.nextInt();
          numero = 1;
          if (index == 0) {
            MenuEnfermero(Login);
          }
        } catch (InputMismatchException e) {
          System.out.println("\nIntroduce un número entero válido.\n");
        }
      } while (index < 1 || index > tope);

      dni = Apersona.get(lista[index - 1]).getDNI();
      palabra = "";
      //FOR PARA MARCAR CON UN SI O NO LA PRUEBA, EN CASO DE SI, SU ESTADO SE CAMBIA A TRUE
      for (int i = 0; i < Aprueba.size(); i++) {
        if (Aprueba.get(i).getRecibidor().equals(dnipaciente)) {
          while (!palabra.equals("s") && !palabra.equals("S") && !palabra.equals("Si") && !palabra.equals("si") && !palabra.equals("n") && !palabra.equals("N") && !palabra.equals("No") && !palabra.equals("no")) {
            System.out.println("\nQuieres marcar como realizada esta prueba?(Si/No)\n\n");
            sc = new Scanner(System.in);
            palabra = sc.nextLine();
          }
          if (palabra.equals("s") || palabra.equals("S") || palabra.equals("Si") || palabra.equals("si")) {
            Aprueba.get(i).setEstado(true);
            System.out.println("\nPrueba registrada con éxito. Se pasa la muestra a los técnicos para ver el resultado.\n\n");
          }
          System.out.println("\nRedireccionando al menú principal..\n\n");
          MenuEnfermero(Login);
          break;

        }
      }

    } else {
      System.out.println("\nNo hay ningun paciente que tengas asignado.\n\n");
      System.out.println("\nRedireccionando al menú principal..\n\n");
      MenuEnfermero(Login);
    }
  }
  //FUNCION PARA REGISTRAR A TUS PACIENTES ASIGNADOS COMO VACUNADOS
  private static void EnfermeroResgistroVacunas(String login) {
    String Login = login;
    String dnipaciente, palabra, dni;
    int b, tope, index;
    int numero = 1;
    Scanner sc = new Scanner(System.in);
    int a = 0;
    b = 0;
    //FOR PARA VER SI TENEMOS ALGUN PACIENTE ASIGNADO A VACUNAR Y CON LA VACUNA SIN PONER
    for (int i = 0; i < AVacuna.size(); i++) {
      if (AVacuna.get(i).getEnfermero().equals(Login) && AVacuna.get(i).getEstado() == false) {
        b++;
      }
    }
    //IF PARA VER SI LO HAY
    if (b > 0) {
      System.out.println("···········REGISTRO DE VACUNAS···········\n\n");

      int[] lista = new int[15];
      tope = 0;
      numero = 0;
      dni = "";

      System.out.println("\nListado de mis pacientes en vacunacion: \n\n");
      //FOR PARA HACER UNA LISTA DE LOS PACIENTES QUE TENEMOS PARA VACUNAR, COGIENDO SU DNI Y DESPUES SUS DATOS CON SU DNI PARA IMPRIMIRLOS
      for (int i = 0; i < AVacuna.size(); i++) {
        if (AVacuna.get(i).getEnfermero().equals(Login) && AVacuna.get(i).getEstado() == false) {
          dni = AVacuna.get(i).getRecibidor();
        }
        
        for (int k = 0; k < Apersona.size(); k++) {

          if (Apersona.get(k).getDNI().equals(dni)) {
            numero++;
            System.out.println(numero + "-" + Apersona.get(k).getNombre() + " " + Apersona.get(k).getApellido() + " con DNI: " + dni + "\n");
            lista[numero - 1] = k;
            tope++;
          }
        }
      }
      numero = 0;
      index = 0;
      System.out.println("\nCual quieres registrar como vacunado?(Elige por indice)\n");
      //DO WHILE PARA ESCOGER A CUAL QUEREMOS MARCAR COMO VACUNADO
      do {
        try {
          if (numero == 1) {
            System.out.println("\nElige un número válido.\n");
          }
          sc = new Scanner(System.in);
          index = sc.nextInt();
          numero = 1;
        } catch (InputMismatchException e) {
          System.out.println("\nIntroduce un número entero válido\n");
          numero = 0;
        }
      } while (index < 1 || index > tope);

      dni = Apersona.get(lista[index - 1]).getDNI();
      //FOR PARA VERIFICAR
      for (int i = 0; i < AVacuna.size(); i++) {
        if (AVacuna.get(i).getRecibidor().equals(dni)) {
          System.out.println("\nQuieres marcar a este paciente como vacunado?(Si/No)\n\n");
          index = i;
          sc = new Scanner(System.in);
          palabra = sc.nextLine();
          while (!palabra.equals("s") && !palabra.equals("S") && palabra.equals("Si") && !palabra.equals("si") && !palabra.equals("n") && !palabra.equals("N") && palabra.equals("No") && !palabra.equals("no")) {
            System.out.println("\nPor favor, responda si o no.\n\n");
            sc = new Scanner(System.in);
            palabra = sc.nextLine();
          }
          if (palabra.equals("s") || palabra.equals("S") || palabra.equals("Si") || palabra.equals("si")) {
            //IF QUE CHEQUEA SI NO TIENE FECHA2(SERIA PORQUE ES JOHNSON&JOHNSON Y NO QUEDARÍA COMO VACUNADO YA QUE NO HARIAN FALTA DOS DOSIS) Y BAJARA UNO AL STOCK TOTAL DE JOHNSON&JOHNSON
            if (AVacuna.get(i).getFecha2() == null) {
              AVacuna.get(i).setEstado(true);
              AVacuna.get(i).set1dosis(true);
              Ajohnson.get(0).bajarDosis();
              System.out.println("\nVacuna registrada con éxito. Se marcará a este paciente como vacunado.\n\n");
              //IF PARA VER SI ESTA PUESTA LA PRIMERA DOSIS, EN CASO DE QUE NO, TE DICE QUE ES LA PRIMERA VACUNA, NO CONSTARA COMO VACUNADO Y TE IMPRIMIRA LA FECHA DE LA SEGUNDA VACUNA
            } else if (AVacuna.get(i).get1dosis() == false) {
              AVacuna.get(i).set1dosis(true);
              AVacuna.get(i).set2dosis(false);
              System.out.println("\nEsta es la primera vacuna. Se necesitará la segunda para completar la vacunacion de este paciente.\n");
              System.out.println("\nFecha de la siguiente vacunacion: " + AVacuna.get(i).getFecha2() + "\n");
              //IF PARA VER SI LA PRIMERA DOSIS ESTÁ PUESTA, EN CASO DE QUE LO ESTÉ Y LA SEGUNDA TODAVIA NO, MARCARÁ AL PACIENTE COMO VACUNADO
            } else if (AVacuna.get(i).get1dosis() == true && AVacuna.get(i).get2dosis() == false) {
              AVacuna.get(i).set2dosis(true);
              AVacuna.get(i).setEstado(true);
              //IF PARA CHEQUEAR EL TIPO DE VACUNA Y BAJARLE 1 AL STOCK
              if (AVacuna.get(i).getTipo().equals("Pfizer")) {
                Apfizer.get(0).bajarDosis();
              } else if (AVacuna.get(i).getTipo().equals("Moderna")) {
                Amoderna.get(0).bajarDosis();
              }
              System.out.println("\nSegunda vacuna realizada con éxito. Se marcará a este paciente como vacunado.\n\n");
            }
          }
        }
        System.out.println("\nRedireccionando al menú principal..\n\n");
        MenuEnfermero(Login);
        break;

      }
    } else {
      System.out.println("\nNo hay ningun paciente que tengas asignado.\n\n");
      System.out.println("\nRedireccionando al menú principal..\n\n");
      MenuEnfermero(Login);
    }
  }
  //FUNCION PARA MOSTRAR EL MENU DEL TECNICO
  private static void MenuTecnico(String login) {
    Scanner sc = new Scanner(System.in);
    String Login = login;
    int num = 0;
    int n = 0;
    System.out.println("·······MENÚ TÉCNICO·······\n|                        |\n| 1-Visualizar Pacientes |\n| 2-Registro de Pruebas  |\n| 3-Log Out              |\n|                        |\n··························\n");
    //DO WHILE PARA ESCOGER UNA OPCION DENTRO DEL MENU
    do {
      try {
        if (n == 1) {
          System.out.println("\nTienes que introducir un número entre el 1 y el 3.\n");
          n = 0;
        }
        sc = new Scanner(System.in);
        num = sc.nextInt();
        n = 1;
      } catch (InputMismatchException e) {
        System.out.println("\nTienes que introducir un número entero.\n");
      }
    } while (num < 1 || num > 3);
    switch (num) {
    case 1:
      TecnicoVisualizarPacientes(Login);
      break;
    case 2:
      TecnicoRegistroPruebas(Login);
      break;
    case 3:
      Login();
      break;
    default:
      System.out.println("\nIntroduzca un numero válido");
      MenuTecnico(Login);
      break;
    }
  }
  //FUNCION PARA VISUALIZAR PACIENTES QUE TENGA UN TECNICO ASIGNADO PARA ANALIZARLE PRUEBAS
  private static void TecnicoVisualizarPacientes(String login) {
    int numero = 1;
    String Login = login;
    String palabra, tipo;
    int a, b, blancos, resultadoint, num;
    String dnipaciente = "";
    boolean resultado;
    tipo = "";
    resultado = false;
    a = 0;
    resultadoint = 0;
    Scanner sc = new Scanner(System.in);
    //FOR PARA VER SI HAY ALMENOS UNA PERSONA ASIGNADA A NOSOTROS
    for (int i = 0; i < Aprueba.size(); i++) {
      if (Aprueba.get(i).getTecnico().equals(Login)) {
        dnipaciente = Aprueba.get(i).getRecibidor();
        a = 1;
      }
    }
    num = 0;
    //EN CASO DE HABER ALMENOS UNA SE EJECUTA
    if (a == 1) {
      System.out.println("\n···········LISTADO DE TUS PACIENTES···········\n\n");
      //FOR PARA HACER UNA LISTA DE LOS PACIENTES QUE TENEMOS ASIGNADOS, COGIENDO SU DNI Y DESPUES SUS DATOS CON SU DNI EN ARRAYLIST PERSONAS PARA IMPRIMIRLOS
      for (int i = 0; i < Aprueba.size(); i++) {
        if (Aprueba.get(i).getTecnico().equals(Login)) {
          dnipaciente = Aprueba.get(i).getRecibidor();
          a = 1;
        }
        //FOR PARA IMPRIMIR NOMBRE, APELLIDO, DNI, TIPO DE PRUEBA Y RESULTADO DE LA PRUEBA
        for (int k = 0; k < Apersona.size(); k++) {
          if (Apersona.get(k).getDNI().equals(dnipaciente)) {
            num++;
            tipo = Aprueba.get(i).getTipo();
            blancos = 17 - (Apersona.get(k).getNombre().length() + Apersona.get(k).getApellido().length() + 1);
            System.out.print(num + "-" + Apersona.get(k).getNombre() + " " + Apersona.get(k).getApellido());

            for (int x = 0; x < blancos; x++) {
              System.out.print(" ");
            }
            System.out.print(" con DNI: " + Apersona.get(k).getDNI() + "    Tipo de prueba: " + Aprueba.get(i).getTipo());
            blancos = 14 - (tipo.length() + 1);

            for (int x = 0; x < blancos; x++) {
              System.out.print(" ");
            }
            System.out.print(" Resultado: ");
            //BUCLE IF MEDIANTE EL CUAL IMPRIME EL RESULTADO DE LA PRUEBA, MIRANDO EL TIPO DE PRUEBA YA QUE LAS SEROLOGICAS REPORTAN UN VALOR ENTERO Y NO UN BOOLEANO, Y TAMBIEN MIRANDO SI ESTÁ LA PRUEBA YA ANALIZADA O NO
            if (tipo == "PCR" && Aprueba.get(i).getRealizado() == true) {
              System.out.print(Aprueba.get(i).getResultado() + "\n\n");

            } else if (tipo == "PCR" && Aprueba.get(i).getRealizado() == false) {
              System.out.print("Sin resultados todavia");
            } else if (tipo == "ANTIGENOS" && Aprueba.get(i).getRealizado() == true) {
              System.out.print(Aprueba.get(i).getResultado() + "\n\n");
            } else if (tipo == "ANTIGENOS" && Aprueba.get(i).getRealizado() == false) {
              System.out.print("Sin resultados todavia");
            } else if (tipo == "SEROLOGICA" && Aprueba.get(i).getRealizado() == true) {
              System.out.print(Aprueba.get(i).getResultadoInt() + "\n\n");
            } else if (tipo == "SEROLOGICA" && Aprueba.get(i).getRealizado() == false) {
              System.out.print("Sin resultados todavia");
            }
            System.out.println("\n");
          }
        }

      }
    } else {
      System.out.println("\nNo tienes pacientes asignados para pruebas.\n\n");
      System.out.println("\nRedireccionando al menú principal..\n\n");
      MenuTecnico(Login);
    }
    System.out.println("\n\n");
    MenuTecnico(Login);

  }
  //FUNCION PARA QUE LOS TECNICOS MARQUEN UN RESULTADO A LAS PRUEBAS ANALIZADAS DE SUS PACIENTES ASIGNADOS
  private static void TecnicoRegistroPruebas(String login) {
    int numero = 1;
    String Login = login;
    String palabra, tipo;
    int a, b, blancos, resultadoint, num, tope, numm, n;
    String dnipaciente = "";
    boolean resultado;
    tipo = "";
    resultado = false;
    a = 0;
    tope = 0;
    resultadoint = 0;
    Scanner sc = new Scanner(System.in);
    //FOR PARA VER SI TENEMOS ALMENOS UN PACIENTE EL CUAL HAYA SIDO REALIZADO LA PRUEBA Y TODAVIA NO HAYA SIDO LA PRUEBA ANALIZADA
    for (int i = 0; i < Aprueba.size(); i++) {
      if (Aprueba.get(i).getTecnico().equals(Login) && Aprueba.get(i).getEstado() == true && Aprueba.get(i).getRealizado() == false) {
        dnipaciente = Aprueba.get(i).getRecibidor();
        a = 1;
      }
    }
    num = 0;
    int[] list = new int[20];
    //SI HAY ALGUNO
    if (a == 1) {
      System.out.println("\n·········LISTADO DE PACIENTES··············\n");
      //FOR PARA CONSEGUIR LISTA DE PACIENTES CON SUS DNI, NOMBRE Y APELLIDOS
      for (int i = 0; i < Aprueba.size(); i++) {
        if (Aprueba.get(i).getTecnico().equals(Login) && Aprueba.get(i).getEstado() == true && Aprueba.get(i).getRealizado() == false) {
          dnipaciente = Aprueba.get(i).getRecibidor();
        }
        //CON SU DNI IMPRIMIMOS SUS DATOS
        for (int h = 0; h < Apersona.size(); h++) {
          if (Apersona.get(h).getDNI().equals(dnipaciente) && Aprueba.get(i).getRealizado() == false) {

            num++;
            list[num] = h;
            blancos = 17 - (Apersona.get(h).getNombre().length() + Apersona.get(h).getApellido().length() + 1);
            System.out.print(num + "-" + Apersona.get(h).getNombre() + " " + Apersona.get(h).getApellido());
            tope++;
            for (int x = 0; x < blancos; x++) {
              System.out.print(" ");
            }
            System.out.print("con DNI: " + Apersona.get(h).getDNI() + "\n\n");
          }
        }
      }

      n = 0;
      //DO WHILE PARA ESCOGER PERSONA
      do {
        try {
          System.out.println("\nEscoge una persona segun indice\n");
          sc = new Scanner(System.in);
          n = sc.nextInt();
        } catch (InputMismatchException e) {
          System.out.println("\nTiene que ser un numero entero válido.\n");
        }
      } while (n < 1 || n > tope);
      //BUCLE FOR EN DONDE CHEQUEAMOS EL TIPO DE PRUEBA QUE ES PARA SABER SI TENEMOS QUE DAR UN VALOR POSITIVO, NEGATIVO O DEL 0 AL 10.
      for (int i = 0; i < Aprueba.size(); i++) {
        if (Aprueba.get(i).getRecibidor().equals(Apersona.get(list[num]).getDNI())) {
          System.out.print("\nLa prueba elegida es una prueba " + Aprueba.get(i).getTipo() + ", que resultado tiene?");
          //SI ES UNA PCR O UNA ANTIGENOS, NOS PREGUNTARÁ POR UN RESULTADO BOOLEANO
          if (Aprueba.get(i).getTipo().equals("PCR") || Aprueba.get(i).getTipo().equals("ANTIGENOS")) {
            System.out.print(": \n\n   1-Positivo\n\n   2-Negativo\n\n");
            sc = new Scanner(System.in);
            numm = sc.nextInt();
            //SEGUN LOS RESULTADOS QUE DEMOS, EL PACIENTE PASARÁ A CONFINAMIENTO Y NOS MOSTRARA SUS FECHAS DE INICIO Y FIN DE CONFINAMIENTO
            if (numm == 1) {
              Aprueba.get(i).setResultado(true);
              System.out.println("\nEl paciente todavia ha dado positivo en COVID-19 y le vamos a poner en cuarentena 10 dias.\n");
              Aprueba.get(i).setRealizado(true);
              Apersona.get(list[num]).setConfinado(true);
              Apersona.get(list[num]).setInicioConfin(LocalDate.now());
              Apersona.get(list[num]).setFinConfin(LocalDate.now().plusDays(10));
              System.out.println("\nEl inicio de su confinamiento comienza hoy dia " + Apersona.get(list[num]).getInicioConfin() + " y termina el dia " + Apersona.get(list[num]).getFinConfin());
              System.out.println("\nRedireccionando al menú principal..\n\n");
              MenuTecnico(Login);
            } else if (numm == 2) {
              Aprueba.get(i).setResultado(false);
              Aprueba.get(i).setRealizado(true);
              System.out.println("\nEl paciente todavia no ha dado positivo en COVID-19 y no se le someterá a confinamiento.\n");
              System.out.println("\nRedireccionando al menú principal..\n\n");
              MenuTecnico(Login);
            }
            //SI ES SEROLOGICA, NOS PREGUNTARÁ POR UN RESULTADO NUMERICO DEL 0 AL 10
          } else if (Aprueba.get(i).getTipo().equals("SEROLOGICA")) {
            numm = 0;
            do {
              try {
                System.out.print(". Indique un numero del 1 al 10.\n\n");
                sc = new Scanner(System.in);
                numm = sc.nextInt();
              } catch (InputMismatchException e) {}
            } while (numm < 1 || numm > 10);

            Aprueba.get(i).setResultadoInt(numm);
            //SEGUN LOS RESULTADOS QUE DEMOS, EL PACIENTE PASARÁ A CONFINAMIENTO Y NOS MOSTRARA SUS FECHAS DE INICIO Y FIN DE CONFINAMIENTO
            if (numm > 2) {
              System.out.println("\nEl paciente ha pasado la infeccion y no será sometido a confinamiento.\n");
              Aprueba.get(i).setRealizado(true);
              System.out.println("\nRedireccionando al menú principal..\n\n");
              MenuTecnico(Login);
            } else {
              System.out.println("\nEl paciente todavia no ha pasado la infección y le vamos a poner en cuarentena 10 dias.\n");
              Aprueba.get(i).setRealizado(true);
              Apersona.get(list[num]).setInicioConfin(LocalDate.now());
              Apersona.get(list[num]).setFinConfin(LocalDate.now().plusDays(10));
              Apersona.get(list[num]).setConfinado(true);
              System.out.println("\nEl inicio de su confinamiento comienza hoy dia " + Apersona.get(list[num]).getInicioConfin() + " y termina el dia " + Apersona.get(list[num]).getFinConfin());
              System.out.println("\nRedireccionando al menú principal..\n\n");
              MenuTecnico(Login);
            }

          }

        }
      }

    } else {
      System.out.println("\nNo tienes pacientes con pruebas para analizar.\n\n");
      System.out.println("\nRedireccionando al menú principal..\n\n");
      MenuTecnico(Login);
    }

  }
  //FUNCION PARA VER SI EL DNI ES VALIDO O NO
  private static boolean validardni(String dni) {
    String letraMayuscula = "";
    //IF PARA VER QUE TENGA UNA LONGITUD DE 9 Y QUE SU ULTIMO CARACTER SEA UNA LETRA
    if (dni.length() != 9 || Character.isLetter(dni.charAt(8)) == false) {
      return false;
    }
    letraMayuscula = (dni.substring(8)).toUpperCase();
    //IF PARA VER SI ES VALIDO O NO
    if (soloNumeros(dni) == true && letraDNI(dni).equals(letraMayuscula)) {
      return true;
    } else {
      return false;
    }
  }
  //FUNCION PARA VER SI HAY ALGUNA LETRA ENTRE LOS 8 PRIMEROS NUMEROS DEL DNI
  private static boolean soloNumeros(String dni) {

    int i, j = 0;
    String numero = ""; // Es el número que se comprueba uno a uno por si hay alguna letra entre los 8 primeros dígitos
    String miDNI = ""; // Guardamos en una cadena los números para después calcular la letra
    String[] unoNueve = {
      "0",
      "1",
      "2",
      "3",
      "4",
      "5",
      "6",
      "7",
      "8",
      "9"
    };

    for (i = 0; i < dni.length() - 1; i++) {
      numero = dni.substring(i, i + 1);

      for (j = 0; j < unoNueve.length; j++) {
        if (numero.equals(unoNueve[j])) {
          miDNI += unoNueve[j];
        }
      }
    }

    if (miDNI.length() != 8) {
      return false;
    } else {
      return true;
    }
  }
  //FUNCION PARA VER SI LA LETRA DE MI DNI CONCUERDA CON LA QUE TIENE QUE SER SEGUN LOS NUMEROS DEL DNI
  private static String letraDNI(String dni) {
    // El método es privado porque lo voy a usar internamente en esta clase, no se necesita fuera de ella

    // pasar miNumero a integer
    int miDNI = Integer.parseInt(dni.substring(0, 8));
    int resto = 0;
    String miLetra = "";
    String[] asignacionLetra = {
      "T",
      "R",
      "W",
      "A",
      "G",
      "M",
      "Y",
      "F",
      "P",
      "D",
      "X",
      "B",
      "N",
      "J",
      "Z",
      "S",
      "Q",
      "V",
      "H",
      "L",
      "C",
      "K",
      "E"
    };

    resto = miDNI % 23;

    miLetra = asignacionLetra[resto];

    return miLetra;
  }
  //FUNCIÓN SECRETA DEL ADMINISTRADOR PARA REALIZAR PRUEBAS MAS FACIL Y RAPIDO
  private static void Prueba() {
    Paciente paciente = new Paciente("Pepe", "Rodriguez", "32718179N", 23);
    Enfermero enfermero = new Enfermero("Julia", "Pazos", "82347392B", 27, "julia", "Enfermero");
    Tecnico tecnico = new Tecnico("Steve", "Maister", "74937162S", 43, "steve", "Tecnico");

    Moderna moderna = new Moderna("82347392B", "74937162S", LocalDate.of(2020, 12, 12), LocalDate.of(2020, 12, 12), "moderna");
    Prueba prueba = new Prueba("32718179N", "82347392B", "74937162S", LocalDate.of(2020, 12, 11), "PCR");
    Aprueba.add(prueba);

    AVacuna.add(moderna);

    Apersona.add(paciente);
    Apersona.add(enfermero);
    Apersona.add(tecnico);
    Apaciente.add(paciente);
    Aenfermero.add(enfermero);
    Atecnico.add(tecnico);

    paciente = new Paciente("Jorge", "Nuñez", "32321579N", 33);
    enfermero = new Enfermero("Blas", "Pazos", "82917392B", 27, "blas", "Enfermero");
    tecnico = new Tecnico("Alvaro", "Bazan", "74381162S", 75, "alvaro", "Tecnico");

    Apersona.add(paciente);
    Apersona.add(enfermero);
    Apersona.add(tecnico);
    Apaciente.add(paciente);
    Aenfermero.add(enfermero);
    Atecnico.add(tecnico);
    Apersona.get(3).setFinConfin(LocalDate.of(2020, 1, 21));
    Apersona.get(4).setFinConfin(LocalDate.of(2020, 12, 11));
    Apersona.get(3).setInicioConfin(LocalDate.of(2020, 1, 11));
    Apersona.get(4).setInicioConfin(LocalDate.of(2020, 12, 1));

    System.out.println("\nFuncion secreta correctamente establecida\n");
    secret = 1;
    MenuAdmin();
  }
}