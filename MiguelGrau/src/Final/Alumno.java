package Final;

public class Alumno {

    int id;
    String nombre;
    String apellido;
    NombreSeccion seccion;
    boolean asistencia;
    NotaCurso[] notaCursos;


    String nombreCompleto()
    {
        return this.nombre + " " + this.apellido;
    }

    public Alumno(int id,String nombre,String apellido,NombreSeccion seccion,boolean asistencia,NotaCurso[] notaCursos)
    {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.seccion = seccion;
        this.asistencia = asistencia;
        this.notaCursos = notaCursos;
    }

}
