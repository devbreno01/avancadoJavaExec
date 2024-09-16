package Classes;
import Exceptions.ItemNaoDisponivelException;

import java.util.ArrayList;

public class Livro extends ItemBiblioteca{
    private boolean livroEmprestado;
    public Livro(String titulo, String autor, boolean disponivel) {
        super(titulo, autor, disponivel);
    }

    public void setLivroEmprestado() {
        this.livroEmprestado = false;
    }

    public boolean isLivroEmprestado() {
        return livroEmprestado;
    }

    @Override
    public void emprestar() throws ItemNaoDisponivelException {
        if(this.disponivel){
            this.livroEmprestado = true;
            System.out.println("Livro emprestado");
        }else {
            throw new ItemNaoDisponivelException("Livro indisponivel na biblioteca");

        }
    }

    @Override
    public void devolver() {
        if(this.livroEmprestado){
            this.livroEmprestado = false;
            System.out.println("Livro devolvido");
        }
    }
}
