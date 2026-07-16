public class Livro {

    // Variáveis da Classe (atributos)
    // Cada Livro vai ter essas informações
    private String titulo;
    private String autor;
    private int ano;

    // CONSTRUTOR: método que cria um novo livro
    // Quando você faz: new livro ("Harry Potter", "J,K., 1997)
    // O construtor recebe esses dados e guarda
    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    // GETTERS: métodos que RETORNAM o valor das variáveis
    // Você pede o titulo de um livro com: Livro.getTitulo()
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }
     // SETTERS: métodos que MUDAM o valor das variáveis
     // Você muda o título com: livro.setTitulo("novo titulo")
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    // toString: método que transforma o titulo em texto legive
    // Quando você faz: System.out.println(livro)
    // Ele chama esse método e mostra isso na tela
    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ano=" + ano +
                '}';

    }




}
