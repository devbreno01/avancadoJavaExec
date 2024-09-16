package Classes;

import Exceptions.ItemNaoDisponivelException;

public class MidiaDigital extends ItemBiblioteca{
    private boolean emprestado;
    public MidiaDigital(String titulo, String autor, boolean disponivel) {
        super(titulo, autor, disponivel);
    }

    public void setEmprestado() {
        this.emprestado = false;
    }

    @Override
    public void emprestar() throws ItemNaoDisponivelException {
        if(this.disponivel){
            this.emprestado = true;
            System.out.println("Midia Digital emprestado");
        } else {
                throw new ItemNaoDisponivelException("Midia indisponivel na biblioteca");

        }
    }

    @Override
    public void devolver() {
        if(!this.emprestado){
            this.emprestado = true;
            System.out.println("Midia devolvida");
        }
    }
}
