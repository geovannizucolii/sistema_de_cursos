public class CursoEAD extends Curso{
    public CursoEAD(String nome, int cargaHoraria, Nivel nivel) {
        super(nome, cargaHoraria, nivel);
    }

    @Override
    public void iniciar() {
        System.out.println("Curso iniciado!");
        System.out.println("O acesso desse curso será feito pela plataforma virtual.");
    }
}
