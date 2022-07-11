package Final;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MiguelGrau {

    static Scanner sc = new Scanner(System.in);

    static Usuario[] usuarios = {
            new Usuario("marco@miguel_grau.com", "123456", Perfil.Profesor),
            new Usuario("andres@miguel_grau.com", "654321", Perfil.Profesor),
            new Usuario("hector@miguel_grau.com", "456789", Perfil.Profesor),
            new Usuario("sofia@miguel_grau.com", "123456", Perfil.Auxiliar),
            new Usuario("martha@miguel_grau.com", "654321", Perfil.Auxiliar),
            new Usuario("maria@miguel_grau.com", "456789", Perfil.Auxiliar),
    };

    static Alumno[] alumnosA = new Alumno[15];

    static Alumno[] alumnosB = {
            new Alumno(6,"Natanael","Figueroa",NombreSeccion.B,false,new NotaCurso[]{
                    new NotaCurso(Curso.Matematica,0,0,0,0),
                    new NotaCurso(Curso.Comunicacion,0,0,0,0),
            }),
            new Alumno(7,"Pedro","Sedano",NombreSeccion.B,false,new NotaCurso[]{
                    new NotaCurso(Curso.Matematica,0,0,0,0),
                    new NotaCurso(Curso.Comunicacion,0,0,0,0),
            }),
            new Alumno(8,"Hector","Aspillaga",NombreSeccion.B,false,new NotaCurso[]{
                    new NotaCurso(Curso.Matematica,0,0,0,0),
                    new NotaCurso(Curso.Comunicacion,0,0,0,0),
            }),
            new Alumno(9,"Bryan","Condor",NombreSeccion.B,false,new NotaCurso[]{
                    new NotaCurso(Curso.Matematica,0,0,0,0),
                    new NotaCurso(Curso.Comunicacion,0,0,0,0),
            }),
            new Alumno(10,"Pierina","Alvarado",NombreSeccion.B,false,new NotaCurso[]{
                    new NotaCurso(Curso.Matematica,0,0,0,0),
                    new NotaCurso(Curso.Comunicacion,0,0,0,0),
            }),
    };

    static Alumno[] alumnosC = {
            new Alumno(11,"Horacio","Quevedo",NombreSeccion.C,false,new NotaCurso[]{
                    new NotaCurso(Curso.Comunicacion,0,0,0,0),
                    new NotaCurso(Curso.Historia,0,0,0,0),
            }),
            new Alumno(12,"Karla","Eslava",NombreSeccion.C,false,new NotaCurso[]{
                    new NotaCurso(Curso.Comunicacion,0,0,0,0),
                    new NotaCurso(Curso.Historia,0,0,0,0),
            }),
            new Alumno(13,"Pamela","Lopez",NombreSeccion.C,false,new NotaCurso[]{
                    new NotaCurso(Curso.Comunicacion,0,0,0,0),
                    new NotaCurso(Curso.Historia,0,0,0,0),
            }),
            new Alumno(14,"Paul","Carrasco",NombreSeccion.C,false,new NotaCurso[]{
                    new NotaCurso(Curso.Comunicacion,0,0,0,0),
                    new NotaCurso(Curso.Historia,0,0,0,0),
            }),
            new Alumno(15,"Tania","Leon",NombreSeccion.C,false,new NotaCurso[]{
                    new NotaCurso(Curso.Comunicacion,0,0,0,0),
                    new NotaCurso(Curso.Historia,0,0,0,0),
            }),
    };

    static Seccion seccionA = new Seccion(NombreSeccion.A,alumnosA);
    static Seccion seccionB = new Seccion(NombreSeccion.B,alumnosB);
    static Seccion seccionC = new Seccion(NombreSeccion.C,alumnosC);


    static Profesor[] profesores = {
            new Profesor("Marco", "Lopez", "marco@miguel_grau.com", "123456",Curso.Matematica,new Seccion[]{seccionA, seccionB}),
            new Profesor("Andres", "Cordero", "andres@miguel_grau.com", "654321",Curso.Comunicacion,new Seccion[]{seccionB, seccionC}),
            new Profesor("Hector", "Cardenas", "hector@miguel_grau.com", "456789",Curso.Historia,new Seccion[]{seccionA, seccionC}),
    };

    static Auxiliar[] auxiliares = {
            new Auxiliar("Sofia", "Rosa", "sofia@miguel_grau.com", "123456",new Seccion[]{seccionA, seccionB,seccionC}),
            new Auxiliar("Martha", "Corrales", "martha@miguel_grau.com", "654321",new Seccion[]{seccionA, seccionB,seccionC}),
            new Auxiliar("Maria", "Diaz", "maria@miguel_grau.com", "456789",new Seccion[]{seccionA, seccionB,seccionC}),
    };

    static Profesor profesor = new Profesor();
    static Auxiliar auxiliar = new Auxiliar();


    public static void main(String[] args) {

        configurarAlumnos();
        iniciarSesion();
    }

    static void configurarAlumnos()
    {
        alumnosA[0] = new Alumno(1,"Natalie","Miranda",NombreSeccion.A,false,new NotaCurso[]{
                new NotaCurso(Curso.Matematica,0,0,0,0),
                new NotaCurso(Curso.Historia,0,0,0,0),
        });


        alumnosA[1] =  new Alumno(2,"Alejandra","Rivero",NombreSeccion.A,false,new NotaCurso[]{
                new NotaCurso(Curso.Matematica,0,0,0,0),
                new NotaCurso(Curso.Historia,0,0,0,0),
        });

        alumnosA[2] =  new Alumno(4,"Percy","Pajuelo",NombreSeccion.A,false,new NotaCurso[]{
                new NotaCurso(Curso.Matematica,0,0,0,0),
                new NotaCurso(Curso.Historia,0,0,0,0),
        });

        alumnosA[3] =  new Alumno(3,"Milton David","Malca",NombreSeccion.A,false,new NotaCurso[]{
                new NotaCurso(Curso.Matematica,0,0,0,0),
                new NotaCurso(Curso.Historia,0,0,0,0),
        });

        alumnosA[4] = new Alumno(5,"Rusmell","Mejia",NombreSeccion.A,false,new NotaCurso[]{
                new NotaCurso(Curso.Matematica,0,0,0,0),
                new NotaCurso(Curso.Historia,0,0,0,0),
        });


    }

    static void iniciarSesion() {
        System.out.println("Institucion educativa Miguel Grau");
        System.out.println("-----------------------------------");

        String email = "";
        String contrasenia = "";
        boolean errorLogin = true;

        while (errorLogin) {
            System.out.print("Ingrese su email: ");
            email = sc.nextLine();

            System.out.print("Ingrese su contrasenia: ");
            contrasenia = sc.nextLine();

            errorLogin = verificarUsuario(email, contrasenia);
        }

        //System.out.println("Estas dentro del programa :)");
        Usuario usuario = usuarioLogueado(email, contrasenia);
        configurarMenuOpciones(usuario);

    }

    public static boolean verificarUsuario(String email,String contrasenia)
    {
        for (Usuario usuario : usuarios) {
            if (usuario.email.equals(email) && usuario.contrasenia.equals(contrasenia)) return false;
        }

        System.out.println("Las credenciales no estan registradas .Por favor, ingrese otro");
        return true;
    }


    static Usuario usuarioLogueado(String email, String contrasenia) {
        for (Usuario usuario : usuarios) {
            if (usuario.email.equals(email) && usuario.contrasenia.equals(contrasenia)) return usuario;
        }

        return new Usuario();
    }

    static void configurarMenuOpciones(Usuario usuario) {

        switch (usuario.perfil) {
            case Profesor:

                for (Profesor prof : profesores) {
                    if (prof.email.equals(usuario.email) && prof.contrasenia.equals(usuario.contrasenia))
                    {
                        profesor = prof;
                        break;
                    }
                }

                menuOpciones(profesor.nombreCompletoYMateria(),Perfil.Profesor, profesor.opciones);

                break;
            case Auxiliar:

                for (Auxiliar aux : auxiliares) {
                    if (aux.email.equals(usuario.email) && aux.contrasenia.equals(usuario.contrasenia))
                    {
                        auxiliar = aux;
                        break;
                    }
                }

                menuOpciones(auxiliar.nombreCompleto(),Perfil.Auxiliar, auxiliar.opciones);

                break;
        }

    }

    static void menuOpciones(String nombre,Perfil perfil,String[] opciones)
    {
        int cerrarSesion = opciones.length + 1;
        int salir = opciones.length + 2;
        int opcion = 1;

        while ( opcion != salir && opcion != cerrarSesion ){

            System.out.println();
            System.out.println("Bienvenido(a) " + perfil.name() + " " + nombre);
            System.out.println("-----------------------------");
            System.out.println("Que accion quieres realizar? ");

            for (int i = 0; i < opciones.length ; i++) {
                System.out.println( (i+1) + ". " + opciones[i]);
            }

            System.out.println(cerrarSesion + ". Cerrar sesion");
            System.out.println(salir + ". Salir");


            System.out.print("Ingrese una opcion porfavor: ");

            try {
                opcion = sc.nextInt();

                if (opcion >= 1 && opcion <= opciones.length)
                {
                    switch (perfil)
                    {
                        case Profesor:
                            profesor.seleccionarSeccion(sc,opcion);
                            break;
                        case Auxiliar:
                            auxiliar.seleccionarSeccion(sc,opcion);
                            break;
                    }
                }


            }
            catch (Exception ex){
                System.out.println("Por favor ingrese un numero entre 1 y " + salir);
                sc.next();
            }

        }

        if (opcion == cerrarSesion)
        {
            System.out.println();
            sc.nextLine();
            iniciarSesion();
        }

    }



}
