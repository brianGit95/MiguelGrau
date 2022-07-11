package Final;

public class NotaCurso {

    Curso curso;
    int examenOral;
    int revisionCuaderno;
    int trabajoGrupalesDeTrimestre;
    int examenTrimestral;
    int promedio;

    public NotaCurso(Curso curso, int examenOral,int revisionCuaderno,int trabajoGrupalesDeTrimestre,int examenTrimestral)
    {
        this.curso = curso;
        this.examenOral = examenOral;
        this.revisionCuaderno = revisionCuaderno;
        this.trabajoGrupalesDeTrimestre = trabajoGrupalesDeTrimestre;
        this.examenTrimestral = examenTrimestral;
        this.promedio = (examenOral + revisionCuaderno + trabajoGrupalesDeTrimestre + examenTrimestral) / 4;
    }
}
