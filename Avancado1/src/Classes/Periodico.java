package Classes;

import Exceptions.ItemNaoDisponivelException;

public class Periodico extends ItemBiblioteca{
    private boolean emprestado;
    public Periodico(String titulo, String autor, boolean disponivel) {
        super(titulo, autor, disponivel);
    }

    public void setEmprestado() {
        this.emprestado = false;
    }

    @Override
    public void emprestar() throws ItemNaoDisponivelException {
        if(this.disponivel){
            this.emprestado = true;
            System.out.println("Periodico emprestado");
        }else{
            throw new ItemNaoDisponivelException("Periodico indisponivel na biblioteca");

        }
    }

    @Override
    public void devolver() {
        if(!this.emprestado){
            this.emprestado = true;
            System.out.println("Periodico devolvido");
        }
    }
}
