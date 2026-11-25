import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Catalogo<Curso> catalogo= new Catalogo<>();

        while (catalogo.getElementos().size()<3){
            int numero_ordenado = catalogo.getElementos().size() + 1;
            System.out.println("\n=== Curso " + numero_ordenado + " de 3===");

            try{
                System.out.print("Curso (ead/presencial): ");
                String curso = scanner.nextLine().trim().toLowerCase();

                if (!curso.equals("ead") && !curso.equals("presencial")){
                    throw new IllegalArgumentException("Curso inválido. Digite ead ou presencial.");
                }

                System.out.print("Nome: ");
                String nome = scanner.nextLine();

                System.out.print("Carga Horária(horas): ");
                int carga = Integer.parseInt(scanner.nextLine());

                System.out.print("Nível (basico/avancado): ");
                Nivel nivel = lerNivel(scanner.nextLine());

                Curso c;
                if (curso.equals("ead")){
                    c = new CursoEAD(nome, carga, nivel);
                } else{
                    c = new CursoPresencial(nome, carga, nivel);
                }

                catalogo.adicionar(c);
                System.out.println("Curso cadastrado com sucesso no catálogo!");
            } catch (IllegalArgumentException e){
                System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
            }
        }


        List<Curso> cursos = catalogo.getElementos();

        System.out.println("\n=== Cursos do Catálogo ===");
        for(Curso curso : cursos){
            curso.exibirDados();
            curso.iniciar();
        }

        List<String> cursosAvancados = cursos.stream()
                    .filter(c -> c.getNivel() == Nivel.AVANCADO)
                    .map(c -> c.getNome())
                    .toList();

        if (cursosAvancados.isEmpty()){
            System.out.println("\n=== Não tem nenhum Curso Avançado ===");
        } else {
            System.out.println("\n=== Cursos Avançados ===");
            cursosAvancados.forEach(nome -> System.out.println("- " + nome));

        }
        long totalEAD = cursos.stream().filter(c -> c instanceof CursoEAD).count();
        long totalPresencial = cursos.stream().filter(c -> c instanceof CursoPresencial).count();
        long totalCursos = totalEAD + totalPresencial;

        System.out.println("\nTotal de Cursos EAD: " + totalEAD);
        System.out.println("Total de Cursos Presencias: " + totalPresencial);
        System.out.println("Total de Cursos: " + totalCursos);



        scanner.close();
    }

    private static Nivel lerNivel(String texto){
        try {
            return Nivel.valueOf(texto.trim().toUpperCase());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Nível inválido. Digite basico ou avancado.");
        }
    }
}