package Final;

public class NotaCurso {

    Curso curso;
    int examenOral;
    int revisionCuaderno;
    int trabajoGrupalesDeTrimestre;
    int examenTrimestral;

    public NotaCurso(Curso curso, int examenOral,int revisionCuaderno,int trabajoGrupalesDeTrimestre,int examenTrimestral)
    {
        this.curso = curso;
        this.examenOral = examenOral;
        this.revisionCuaderno = revisionCuaderno;
        this.trabajoGrupalesDeTrimestre = trabajoGrupalesDeTrimestre;
        this.examenTrimestral = examenTrimestral;
    }

}
