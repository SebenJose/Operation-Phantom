package Models.Itens;

import Views.Janela;

public class ITEM_PeDeCabra extends Item {

    public ITEM_PeDeCabra(Janela j) {
        nome = "Pe de Cabra";
        image = setup("/Sprites/Itens/ITEM_PeDeCabra", j.tileSize, j.tileSize);
            
            
    }
}