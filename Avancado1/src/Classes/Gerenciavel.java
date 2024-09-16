package Classes;
import Classes.ItemBiblioteca;
public interface Gerenciavel {

    void adicionarItem(ItemBiblioteca item);
    void removerItem(ItemBiblioteca item);
    ItemBiblioteca buscarItem(String titulo);

}
