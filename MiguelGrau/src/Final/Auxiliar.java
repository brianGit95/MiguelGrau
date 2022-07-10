package Final;

import java.util.Scanner;

public class Auxiliar {

    String nombre,apellido,email,contrasenia;
    Seccion[] secciones;
    String[] opciones = {"Consolidado de notas","Consulta de asistencia"};

    String nombreCompleto()
    {
        return this.nombre + " " + this.apellido;
    }

    public Auxiliar()
    {

    }

    public Auxiliar(String nombre,String apellido,String email,String contrasenia,Seccion[] secciones)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasenia = contrasenia;
        this.secciones = secciones;
    }

    void seleccionarSeccion(Scanner sc, int opcionMenu)
    {
        int salir = secciones.length + 1;
        int numero = 1;

        while (numero != salir){

            System.out.println();
            System.out.println("Ingrese la seccion : ");
            System.out.println("------------------------------");

            for (int i = 0; i < secciones.length ; i++) {
                System.out.println( (i+1) + ". Seccion " + secciones[i].nombre);
            }

            System.out.println(salir + ". Salir");

            System.out.print("Ingrese una opcion para la seccion porfavor: ");

            try {
                numero = sc.nextInt();

                if (numero >= 1 && numero <= secciones.length)
                {
                    menuOpciones(sc,secciones[numero-1],opcionMenu);
                }

            }
            catch (Exception ex){
                System.out.print("Por favor ingrese un numero entre 1 y " + salir);
                sc.next();
            }
        }
    }

    void menuOpciones(Scanner sc, Seccion seccion, int opcion)
    {
        switch (opcion)
        {
            case 1:
                //Consolidado de notas

                break;
            case 2:
                //Consulta de asistencia

                break;
        }


    }



}
