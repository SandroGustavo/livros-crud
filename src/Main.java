import java.util.Scanner;

public class Main {

    // Scanner: ferramenta para ler o que o usuário digita no terminal
    private static Scanner scanner = new Scanner(System.in);

    // Biblioteca: a instância que vamos usar
    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║     BEM-VINDO À BIBLIOTECA         ║");
        System.out.println("╚════════════════════════════════════╝\n");

        // Loop infinito: o menu fica rodando até o usuário escolher "sair"
        boolean rodando = true;
        while (rodando) {
            exibirMenu();
            int opcao = lerInteiro("Escolha uma opção: ");

            // Switch: se a opção é 1, faz isso; se é 2, faz aquilo...
            switch (opcao) {
                case 1:
                    adicionarLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    atualizarLivro();
                    break;
                case 4:
                    deletarLivro();
                    break;
                case 5:
                    System.out.println("Até logo!");
                    rodando = false; // sai do loop
                    break;
                default:
                    System.out.println("❌ Opção inválida! Digite 1-5.\n");
            }
        }

        scanner.close(); // fecha o scanner ao sair
    }

    // MÉTODO 1: Mostra o menu
    private static void exibirMenu() {
        System.out.println("\n========== MENU ==========");
        System.out.println("1 - Adicionar livro");
        System.out.println("2 - Listar livros");
        System.out.println("3 - Atualizar livro");
        System.out.println("4 - Deletar livro");
        System.out.println("5 - Sair");
        System.out.println("=========================");
    }

    // MÉTODO 2: Adicionar um novo livro
    private static void adicionarLivro() {
        System.out.println("\n--- ADICIONAR LIVRO ---");

        String titulo = lerTexto("Título: ");
        String autor = lerTexto("Autor: ");
        int ano = lerInteiro("Ano: ");

        // Cria um novo livro com os dados que o usuário digitou
        Livro novoLivro = new Livro(titulo, autor, ano);

        // Adiciona à biblioteca
        biblioteca.adicionarLivro(novoLivro);
    }

    // MÉTODO 3: Listar todos os livros
    private static void listarLivros() {
        biblioteca.listarLivros();
    }

    // MÉTODO 4: Atualizar um livro existente
    private static void atualizarLivro() {
        System.out.println("\n--- ATUALIZAR LIVRO ---");

        // Primeiro, lista os livros pra você ver qual atualizar
        biblioteca.listarLivros();

        String tituloAntigo = lerTexto("Digite o título do livro a atualizar: ");

        // Verifica se o livro existe
        if (biblioteca.buscarPorTitulo(tituloAntigo) == null) {
            System.out.println("❌ Livro não encontrado!");
            return;
        }

        // Se existe, pede os novos dados
        String novoTitulo = lerTexto("Novo título: ");
        String novoAutor = lerTexto("Novo autor: ");
        int novoAno = lerInteiro("Novo ano: ");

        // Atualiza
        biblioteca.atualizarLivro(tituloAntigo, novoTitulo, novoAutor, novoAno);
    }

    // MÉTODO 5: Deletar um livro
    private static void deletarLivro() {
        System.out.println("\n--- DELETAR LIVRO ---");

        // Lista os livros primeiro
        biblioteca.listarLivros();

        String titulo = lerTexto("Digite o título do livro a deletar: ");

        // Deleta
        biblioteca.deletarLivro(titulo);
    }

    // MÉTODO AUXILIAR: ler um texto do usuário
    private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    // MÉTODO AUXILIAR: ler um número inteiro do usuário
    private static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        int numero = scanner.nextInt();
        scanner.nextLine(); // limpa o buffer (importante!)
        return numero;
    }
}