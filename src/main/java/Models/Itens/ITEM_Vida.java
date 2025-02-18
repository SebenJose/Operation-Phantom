package Models.Itens;

import Views.Janela;

public class ITEM_Vida extends Item {

    Janela j;

    public ITEM_Vida(Janela j) {
        
        this.j = j;

        nome = "Vida";
        image = setup("/UIsrc/BarraVida/UI_tres_de_vida", j.tileSize, j.tileSize);
        image2 = setup("/UIsrc/BarraVida/UI_tres_de_vida_dano", j.tileSize, j.tileSize);
        image3 = setup("/UIsrc/BarraVida/UI_dois_de_vida", j.tileSize, j.tileSize);
        image4 = setup("/UIsrc/BarraVida/UI_dois_de_vida_dano", j.tileSize, j.tileSize);
        image5 = setup("/UIsrc/BarraVida/UI_um_de_vida", j.tileSize, j.tileSize);
        image6 = setup("/UIsrc/BarraVida/UI_um_de_vida_dano", j.tileSize, j.tileSize);
        image7 = setup("/UIsrc/BarraVida/UI_vida_vazia", j.tileSize, j.tileSize);
        image8 = setup("/UIsrc/BarraVida/UI_vida_", j.tileSize, j.tileSize);

    }

    
}