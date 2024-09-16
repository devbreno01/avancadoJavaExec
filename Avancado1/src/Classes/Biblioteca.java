package Classes;
import java.util.ArrayList;
import Classes.Livro;
import Classes.Periodico;
import Classes.MidiaDigital;
import Exceptions.ItemNaoEncontradoException;

public class Biblioteca implements Gerenciavel {
    ArrayList<ItemBiblioteca> itens = new ArrayList<>();

    public static void main(String[] args) {
        Livro livro1 = new Livro("Hora das estrelas", "John Carpfield", true);
        livro1.setLivroEmprestado();

        Livro livro2 = new Livro("A minha pele", "Reymond Luis", true);
        livro2.setLivroEmprestado();

        Periodico periodico1 = new Periodico("Periodico2", "Chico", true);
        periodico1.setEmprestado();
        Periodico periodico2 = new Periodico("Periodico 2", "Kauan Brino", true);
        periodico2.setEmprestado();

        MidiaDigital midia1 = new MidiaDigital("Capitães de Areia", "Jorge Amado", true);
        midia1.setEmprestado();
        MidiaDigital midia2 = new MidiaDigital("Bingo", "Arlindo Barreto", true);
        midia2.setEmprestado();
        MidiaDigital midia3 = new MidiaDigital("Homem Aranha 2", "Tom Holland", false);
        midia3.setEmprestado();

        Biblioteca biblioteca1 = new Biblioteca();
        biblioteca1.adicionarItem(livro1);
        biblioteca1.adicionarItem(livro2);
        biblioteca1.adicionarItem(periodico1);
        biblioteca1.adicionarItem(periodico2);
        biblioteca1.adicionarItem(midia1);
        biblioteca1.adicionarItem(midia2);
        biblioteca1.buscarItem("Hora das estrelas");
        System.out.println("==================================");
        biblioteca1.removerItem(livro1);
        //biblioteca1.buscarItem("Hora das estrelas");

        midia3.emprestar();


    }

    @Override
    public void adicionarItem(ItemBiblioteca item) {
        this.itens.add(item);
    }

    @Override
    public void removerItem(ItemBiblioteca item) {
        this.itens.remove(item);
    }

    @Override
    public ItemBiblioteca buscarItem(String titulo) throws ItemNaoEncontradoException {
        for (ItemBiblioteca item : this.itens) {
            if (item.getTitulo().equals(titulo)) {
                System.out.println(item.getTitulo() + " Encontrado");
                return item;
            }
        }
        throw new ItemNaoEncontradoException("Item não encontrado");
    }

}
