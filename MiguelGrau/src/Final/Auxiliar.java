package Final;

import java.time.LocalDate;
import java.util.Scanner;

public class Auxiliar {
    String nombre,apellido,email,contrasenia;
    Seccion[] secciones;
    String[] opciones = {"Registro de Alumnos", "Consolidado de notas por curso", "Consolidado de notas", "Consulta de asistencia"};

    String nombreCompleto() {
        return this.nombre + " " + this.apellido;
    }

    public Auxiliar() {
    }

    public Auxiliar(String nombre,String apellido,String email,String contrasenia,Seccion[] secciones) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasenia = contrasenia;
        this.secciones = secciones;
    }

    void seleccionarSeccion(Scanner sc, int opcionMenu) {
        int salir = secciones.length + 1;
        int numero = 1;
        while (numero != salir) {
            System.out.println();
            System.out.println("Ingrese la seccion: ");
            System.out.println("------------------------------");
            for (int i = 0; i < secciones.length ; i++) {
                System.out.println( (i+1) + ". Seccion " + secciones[i].nombre);
            }
            System.out.println(salir + ". Salir");
            System.out.print("Ingrese una opcion para la seccion por favor: ");
            try {
                numero = sc.nextInt();
                if (numero >= 1 && numero <= secciones.length) {
                    menuOpciones(sc,secciones[numero-1],opcionMenu);
                }
            }
            catch (Exception ex) {
                System.out.print("Por favor ingrese un numero entre 1 y " + salir);
                sc.next();
            }
        }
    }

    void menuOpciones(Scanner sc, Seccion seccion, int opcion) {
        switch (opcion) {
            case 1:
// registro de alumnos
                break;
            case 2:
                ConsolidadoNotasPorCurso(seccion);
                break;
            case 3:
                ConsolidadoNotas(seccion);
                break;
            case 4:
                //Consulta de asistencia
                ConsolidadoAsistencia(seccion);
                break;
        }
    }

    private void imprimirNotasPorCurso(String curso, Seccion seccion) {
        imprimirSubCabeceraConsolidadoPorCurso(curso, seccion);
        for (Alumno alumno : seccion.alumnos) {
            //* Si no hay alumno en la posicion iterada de la coleccion entonces pasa a la siguiente.
            if (alumno == null)
                continue;
            //* Pintamos el alumno iterado.
            System.out.print("│" + padRightCell(alumno.nombreCompleto()));
            //* Flag que nos permite saber si el alumno cuenta con el curso especificado como argumento.
            boolean cursoEncontrado = false;
            for (NotaCurso notaCurso : alumno.notaCursos) {
                if (notaCurso.curso.name().equals(curso)) {
                    cursoEncontrado = true;
                    //* Pintamos las notas iteradas.
                    imprimirNota(notaCurso.examenOral);
                    imprimirNota(notaCurso.revisionCuaderno);
                    imprimirNota(notaCurso.trabajoGrupalesDeTrimestre);
                    imprimirNota(notaCurso.examenTrimestral);
                    imprimirNotaPromedio(notaCurso.promedio);
                }
            }
            //* Definimos el terminador de la fila de notas.
            imprimirFinFilaConsolidadoPorCurso(cursoEncontrado);
        }
    }

    private void imprimirNotas(Seccion seccion) {
        imprimirSubCabeceraConsolidadoNota(seccion);
        for (Alumno alumno : seccion.alumnos) {
            //* Si no hay alumno en la posicion iterada de la coleccion entonces pasa a la siguiente.
            if (alumno == null)
                continue;
            //* Pintamos el alumno iterado.
            System.out.print("│" + padRightCell(alumno.nombreCompleto()));
            int promedio = obtenerPromedioCurso(Curso.Matematica.name(), alumno.notaCursos);
            imprimirNota(promedio);
            promedio = obtenerPromedioCurso(Curso.Comunicacion.name(), alumno.notaCursos);
            imprimirNota(promedio);
            promedio = obtenerPromedioCurso(Curso.Historia.name(), alumno.notaCursos);
            imprimirNota(promedio);
            //* Definimos el terminador de la fila de notas.
            imprimirFinFilaConsolidadoNota(alumno.notaCursos != null);
        }
    }

    private int obtenerPromedioCurso(String curso, NotaCurso[] notas) {
        for (NotaCurso nota : notas) {
            if (nota.curso.name().equals(curso)) {
                return nota.promedio;
            }
        }
        return 0;
    }

    private void imprimirNota(int nota) {
        if (nota<= 10) {
            System.out.printf("│%s%s%s", ConsoleColors.RED, padLeftCell(nota), ConsoleColors.RESET);
        } else {
            System.out.printf("│%s", padLeftCell(nota));
        }
    }

    private void imprimirNotaPromedio(int nota) {
        String emoji;
        if (nota == 20) {
            emoji = new String(Character.toChars(0x1F9D0));
        } else if (nota >= 10) {
            emoji = new String(Character.toChars(0x1F642));
        } else {
            emoji = new String(Character.toChars(0x1F976));
        }
        if (nota<= 10) {
            System.out.printf("│%s%s%s %s", ConsoleColors.RED, padLeftCell(nota, 17), ConsoleColors.RESET, emoji);
        } else {
            System.out.printf("│%s %s", padLeftCell(nota, 17), emoji);
        }
    }

    private void imprimirSubCabeceraConsolidadoPorCurso(String curso, Seccion seccion){
        System.out.printf("│%s│\n", padRight("Curso: " + ConsoleColors.CYAN_UNDERLINED + curso + ConsoleColors.RESET + "  ->  Seccion: " + seccion.nombre.name(), 136));
        System.out.printf("│     Alumno         │     Examen Oral    │ Revision Cuaderno  │   Trabajo Grupal   │  Examen Trimestral │      Promedio      │\n");
        System.out.printf("├─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤\n");
    }

    private void imprimirSubCabeceraConsolidadoNota(Seccion seccion){
        System.out.printf("│%s│\n", padRight("Seccion: " + seccion.nombre.name(), 83));
        System.out.printf("│     Alumno         │    Matematica " + new String(Character.toChars(0x1F522)) + "   │    Comunicacion  " + new String(Character.toChars(0x1F4D7)) + "  │    Historia " + new String(Character.toChars(0x1F4CC))+ "   │\n");
        System.out.printf("├───────────────────────────────────────────────────────────────────────────────────┤\n");
    }

    private void imprimirFinFilaConsolidadoPorCurso(boolean cursoEncontrado) {
        if (cursoEncontrado) {
            System.out.println("│");
        } else {
            //* Si el alumno no tiene el curso actual entonces toda la fila estara en blanco.
            System.out.printf("│%s│\n", padRight(" ",104));
        }
    }

    private void imprimirFinFilaConsolidadoNota(boolean cursoEncontrado) {
        if (cursoEncontrado) {
            System.out.println("│");
        } else {
            //* Si el alumno no tiene el curso actual entonces toda la fila estara en blanco.
            System.out.printf("│%s│\n", padRight(" ",104));
        }
    }

    private String padRight(String value, int lenght) {
        return String.format("%1$-" + lenght  + "s" , value);
    }

    private String padRightCell(String value) {
        return String.format("%1$-" + 20   + "s" , value);
    }

    private String padLeftCell(int value) {
        if (value < 10) {
            return String.format("%1$" + 20 + "s", "0" + value);
        } else {
            return String.format("%1$" + 20 + "s", value);
        }
    }

    private String padLeftCell(int value, int lenght) {
        if (value < 10) {
            return String.format("%1$" + lenght + "s", "0" + value);
        } else {
            return String.format("%1$" + lenght + "s", value);
        }
    }
    private void ConsolidadoNotasPorCurso(Seccion seccion) {
        System.out.println("");
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.print("│                                                ");
        System.out.print(ConsoleColors.BANANA_YELLOW_BACKGROUND + ConsoleColors.BLACK_BOLD_BRIGHT + "CONSOLIDADO DE NOTAS POR CURSO" + ConsoleColors.RESET);
        System.out.println("                                               │");
        System.out.println("├─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤");
        imprimirNotasPorCurso(Curso.Matematica.name(), seccion);
        System.out.println("├─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤");
        imprimirNotasPorCurso(Curso.Comunicacion.name(), seccion);
        System.out.println("├─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┤");
        imprimirNotasPorCurso(Curso.Historia.name(), seccion);
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
    }

    private void ConsolidadoNotas(Seccion seccion) {
        System.out.println("");
        System.out.println("┌───────────────────────────────────────────────────────────────────────────────────┐");
        System.out.print("│                                ");
        System.out.print(ConsoleColors.BANANA_YELLOW_BACKGROUND + ConsoleColors.BLACK_BOLD_BRIGHT + "CONSOLIDADO DE NOTAS" + ConsoleColors.RESET);
        System.out.println("                               │");
        System.out.println("├───────────────────────────────────────────────────────────────────────────────────┤");
        imprimirNotas(seccion);
        System.out.println("└───────────────────────────────────────────────────────────────────────────────────┘");
    }

    private void ConsolidadoAsistencia(Seccion seccion, int mes, int dia) {
        System.out.println("");
        System.out.println("┌───────────────────────────────────────────────────────────────────────────────────┐");
        System.out.print("│                             ");
        System.out.print(ConsoleColors.ROSY_PINK_BACKGROUND + ConsoleColors.BLACK_BOLD + "CONSOLIDADO DE ASISTENCIA" + ConsoleColors.RESET);
        System.out.println("                             │");
        System.out.println("├───────────────────────────────────────────────────────────────────────────────────┤");
        //imprimirNotas(seccion);
        System.out.println("└───────────────────────────────────────────────────────────────────────────────────┘");
        /*
        int[] surrogates = {0xD83D, 0xDC7D};
        String alienEmojiString = new String(surrogates, 0, surrogates.length);
        System.out.println(alienEmojiString);
        System.out.println("\uD83D\uDC7D"); // alternative way
        */
        //System.out.println(new String(Character.toChars(0x1F31F)));
    }

    private void ConsolidadoAsistencia(Seccion seccion) {
        LocalDate today = LocalDate.now();
        ConsolidadoAsistencia(seccion, today.getMonthValue(), today.getDayOfMonth());
    }
}
