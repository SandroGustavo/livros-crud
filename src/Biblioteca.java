import java.util.ArrayList;
import  java.util.List;

public class Biblioteca {
    // ArrayList: é como uma lista mágica que cresce sozinha
    // Ela vai guardar todos os livros que adicionarmos
    // List<Livro> = "uma lista de objetos do tipo Livro"

    private List<Livro> livros;

    // CONSTRUTOR: quando a biblioteca nasce, ela começa vazia
    public Biblioteca() {
        this.livros = new ArrayList<>();
    }
    // ADICIONAR LIVRO
    // Recebe um livro novo e coloca na lista
    public void adicionarLivro(Livro livro) {
        if (livro ==null) {
            System.out.println("Erro livro não pode ser null!!");
            return;
        }
        livros.add(livro);
        System.out.println("✓ Livro'" + livro.getTitulo() + "' adicionado com sucesso!");
    }

    // LISTAR TODOS OS LIVROS
    // Mostra todos os livros que estão na biblioteca
    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("A biblioteca está vazia!!");
            return;
        }

        System.out.println("\n========== LIVROS NA BIBLIOTECA ==========");
        for (int i = 0; i < livros.size(); i++) {
            Livro livro = livros.get(i);
            System.out.println((i + 1) + ". " + livro.getTitulo() + " - " + livro.getAutor() + " (" + livro.getAno() + ")");
        }

        System.out.println("==========================================\n");
    }
    // BUSCAR LIVRO PELO TÍTULO
    // Procura um livro na lista pelo nome
    public Livro buscarPorTitulo(String titulo) {
        // for-each: percorre cada livro da lista
        for (Livro livro : livros) {
            // equalsIgnoreCase: compara ignorando maiúsculas/minúsculas
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro; // achei! retorno ele
            }
        }
        return null; // não achei

    }

    // DELETAR LIVRO
    // Remove um livro da lista pelo título
    public boolean deletarLivro(String titulo) {
        // procura o livro
        Livro livro = buscarPorTitulo(titulo);

        if (livro == null) {
            System.out.println("Livro não encontrado!");
            return false; // não conseguiu deletar
        }

        livros.remove(livro); // remove da lista
        System.out.println("✓ Livro '" + titulo + "' removido!");
        return true; // conseguiu deletar
    }

    // ATUALIZAR LIVRO
    // Muda as informações de um livro
    public boolean atualizarLivro(String tituloAntigo, String novoTitulo, String novoAutor, int novoAno) {
        // Procura o livro antigo
        Livro livro = buscarPorTitulo(tituloAntigo);

        if (livro == null) {
            System.out.println("Livro não encontrado!");
            return false;
        }

        // Atualiza as informações usando os setters
        livro.setTitulo(novoTitulo);
        livro.setAutor(novoAutor);
        livro.setAno(novoAno);

        System.out.println("✓ Livro atualizado com sucesso!");
        return true;
    }



}
