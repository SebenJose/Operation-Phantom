package Models.Itens;

import Views.Janela;

public class ITEM_Arma extends Item {
    Janela j;

    public ITEM_Arma(Janela j) {
        nome = "M16";
        image = setup("/Sprites/Itens/ITEM_M16", j.tileSize, j.tileSize);
            
            
    }
    
}
