package Final;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Profesor
{
    String nombre;
    String apellido;
    String email;
    String contrasenia;
    Seccion[] secciones;
    String[] opciones = {"Registro de asistencia","Registro de notas","Consulta Asistencia","Consulta Notas"};
    String[] notas = {"Examen oral","Revision de cuaderno","Trabajos grupales de trimestre","Examen trimestral"};
    Curso curso;

    String nombreCompleto()
    {
        return this.nombre + " " + this.apellido;
    }

    String nombreCompletoYMateria()
    {
        return this.nombre + " " + this.apellido + "   Materia :" + curso.name();
    }

    public Profesor()
    {

    }

    public Profesor(String nombre,String apellido,String email,String contrasenia,Curso curso,Seccion[] secciones)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasenia = contrasenia;
        this.secciones = secciones;
        this.curso = curso;
    }

    void seleccionarSeccion(Scanner sc,int opcionMenu)
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
                System.out.println(ex.getMessage());
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
                //Registro asistencia
                registrarAsistencia(sc,seccion);
                break;
            case 2:
            case 4:
                //Registro notas
                //Consulta notas
                conceptoNotas(sc,seccion,opcion);
                break;
            case 3:
                //Consulta asistencia
                consultarAsistencia(seccion);
                break;
        }

        //seleccionarSeccion(sc,opcion);
    }

    void conceptoNotas(Scanner sc, Seccion seccion,int opcionMenuNota)
    {
        int salir = notas.length + 1;
        int numero = 1;

        while (numero != salir){

            System.out.println();
            System.out.println("Ingrese el concepto de la Nota : ");
            System.out.println("------------------------------");

            for (int i = 0; i < notas.length ; i++) {
                System.out.println( (i+1) + ". " + notas[i]);
            }

            System.out.println(salir + ". Salir");


            System.out.print("Ingrese una opcion para la nota porfavor: ");

            try {
                numero = sc.nextInt();

                if (numero >= 1 && numero <= notas.length)
                {
                    switch (opcionMenuNota)
                    {
                        case 2:
                            registrarNota(sc,seccion,numero);
                            break;
                        case 4:
                            consultaNotas(sc,seccion,numero);
                            break;

                    }
                }

            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
                System.out.print("Por favor ingrese un numero entre 1 y " + salir);
                sc.next();
            }
        }

    }

    void registrarNota(Scanner sc,Seccion seccion,int opcionNota)
    {
        System.out.println();
        System.out.println("Curso : " + curso.name());
        System.out.println(notas[opcionNota-1]);
        System.out.println("Ingrese la nota para cada alumno (del 0 al 20).");
        System.out.println("------------------------------------------");

        for (Alumno alumno : seccion.alumnos) {

            if (alumno == null) continue;

            for (NotaCurso notaCurso : alumno.notaCursos) {

                if (notaCurso.curso.name().equals(this.curso.name())) {

                    String seatNum;

                    while (true) {

                        System.out.print(alumno.nombreCompleto()+ ":");
                        seatNum = sc.next();

                        if (seatNum.matches("^(\\d|1[0123456789]|20)$"))
                        {
                            break; // makes sure user enter a number also between the range
                        } else System.out.println("Entre 0 y 20 porfavor");

                    }

                    int notaIngresada = Integer.parseInt(seatNum);

                    switch (opcionNota) {
                        case 1 ->
                            //Examen oral
                                notaCurso.examenOral = notaIngresada;
                        case 2 ->
                            //Revision de cuaderno
                                notaCurso.revisionCuaderno = notaIngresada;
                        case 3 ->
                            //Trabajos grupales de trimestre
                                notaCurso.trabajoGrupalesDeTrimestre = notaIngresada;
                        case 4 ->
                            //Examen trimestral
                                notaCurso.examenTrimestral = notaIngresada;
                    }

                }

            }
        }

        System.out.println();
        System.out.println("Las notas de los alumnos fueron registradas.");

    }

    void consultaNotas(Scanner sc,Seccion seccion,int opcionNota)
    {
        System.out.println();
        System.out.println("Curso : " + curso.name());
        System.out.println(notas[opcionNota-1] + " - " + "Notas de la Seccion " + seccion.nombre.name());
        System.out.println("-----------------------------------------------");

        for (Alumno alumno : seccion.alumnos) {

            if (alumno == null) continue;

            for (NotaCurso notaCurso : alumno.notaCursos) {

                if (notaCurso.curso.name().equals(this.curso.name()))
                {
                    int notaAMostrar = 0;

                    switch (opcionNota)
                    {
                        case 1:
                            //Examen oral
                            notaAMostrar = notaCurso.examenOral;
                            break;
                        case 2:
                            //Revision de cuaderno
                            notaAMostrar = notaCurso.revisionCuaderno;
                            break;
                        case 3:
                            //Trabajos grupales de trimestre
                            notaAMostrar = notaCurso.trabajoGrupalesDeTrimestre;
                            break;
                        case 4:
                            //Examen trimestral
                            notaAMostrar = notaCurso.examenTrimestral;
                            break;
                    }

                    System.out.println(alumno.nombreCompleto() +" -> "+notaAMostrar);

                }
            }
        }

    }


    void registrarAsistencia(Scanner sc,Seccion seccion)
    {
        System.out.println();
        System.out.println("Registrar asistencia - Seccion " + seccion.nombre.name());
        System.out.println("--------------------------------------------");

        System.out.println("Ingrese una a si el alumno asistio.Caso contrario cualquier otra tecla.");

        for (Alumno alumno : seccion.alumnos) {

            if (alumno == null) continue;

            System.out.print(alumno.nombreCompleto() + " : ");
            String asistencia = sc.next();

            alumno.asistencia = asistencia.equals("a");
        }

        //System.out.println();
        System.out.println("Las asistencias de los alumnos fueron registradas.");

    }

    void consultarAsistencia(Seccion seccion)
    {
        System.out.println("Asistencia de la Seccion " + seccion.nombre.name());
        System.out.println("-------------------------------------------------");

        for (Alumno alumno : seccion.alumnos) {

            if (alumno == null) continue;

            String asistencia = alumno.asistencia ? "Asistio" : "No asistio";
            System.out.println(alumno.nombreCompleto() + " -> " + asistencia);
        }

    }

}

