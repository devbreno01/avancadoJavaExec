package Classes;

import Exceptions.ItemNaoDisponivelException;

abstract class ItemBiblioteca {
     String titulo;
     String autor;
     boolean disponivel;

    public ItemBiblioteca(String titulo, String autor, boolean disponivel)  {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public abstract void emprestar();
    public abstract void  devolver();

}
