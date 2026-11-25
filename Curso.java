public abstract class Curso implements Iniciavel{
    private String nome;
    private int cargaHoraria;
    private Nivel nivel;

    public Curso(String nome, int cargaHoraria, Nivel nivel) {
        if (nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("O nome está vazio.");
        }

        if (cargaHoraria <= 0){
            throw new IllegalArgumentException("Carga horária inválida.");
        }

        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void exibirDados(){
        System.out.println("-----------Curso-----------");
        System.out.println("Nome: " + getNome());
        System.out.println("Caga horária: " + getCargaHoraria());
        System.out.println("Nível: " + getNivel());
    }
}
