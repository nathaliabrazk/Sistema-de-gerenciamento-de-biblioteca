import java.util.ArrayList;
import java.util.Scanner;

class Livro {
    String titulo;
    String autor;
    boolean disponivel;

    Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

}

class Biblioteca {
    ArrayList<Livro> livros = new ArrayList<>();

    void cadastrarLivro(String titulo, String autor) {
        Livro livro = new Livro(titulo, autor);
        livros.add(livro);
        System.out.println("O livro \"" + titulo + "\" foi cadastrado.");
    }

    void listarLivros() {
        System.out.println("Lista de Livros:");
        for (Livro livro : livros) {
            String status = livro.disponivel ? "Disponível" : "Indisponível";
            System.out.println("Título: "+livro.titulo + " Autor: " + livro.autor + " - " + status);
        }
    }

    void realizarEmprestimo(String titulo) {
        for (Livro livro : livros) {
            if (livro.titulo.equals(titulo) && livro.disponivel) {
                livro.disponivel = false;
                System.out.println("O livro \"" + titulo + "\" foi emprestado com sucesso.");
                return;
            }
        }
        System.out.println("O livro \"" + titulo + "\" não está disponível para empréstimo.");
    }

    void realizarDevolucao(String titulo) {
        for (Livro livro : livros) {
            if (livro.titulo.equals(titulo) && !livro.disponivel) {
                livro.disponivel = true;
                System.out.println("O livro \"" + titulo + "\" foi devolvido com sucesso.");
                return;
            }
        }
        System.out.println("O livro \"" + titulo + "\" não está registrado como emprestado.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        while (true) {
            System.out.println("\n==== Menu ====");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Realizar Empréstimo");
            System.out.println("4. Realizar Devolução");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String tituloLivro = scanner.nextLine();
                    System.out.print("Digite o nome do autor: ");
                    String autorLivro = scanner.nextLine();
                    biblioteca.cadastrarLivro(tituloLivro, autorLivro);
                    break;

                case 2:
                    biblioteca.listarLivros();
                    break;

                case 3:
                    System.out.print("Digite o título do livro para empréstimo: ");
                    String tituloEmprestimo = scanner.nextLine();
                    biblioteca.realizarEmprestimo(tituloEmprestimo);
                    break;

                case 4:
                    System.out.print("Digite o título do livro para devolução: ");
                    String tituloDevolucao = scanner.nextLine();
                    biblioteca.realizarDevolucao(tituloDevolucao);
                    break;

                case 5:
                    System.out.println("Saindo do sistema. Até mais!");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
