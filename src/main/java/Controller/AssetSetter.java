package Controller;

import Models.Entidades.INI_sold_cacetete;
import Models.Entidades.NPC_temp;
import Models.Itens.CON_cafe;
import Models.Itens.ITEM_PeDeCabra;
import Views.Janela;

public class AssetSetter {
    Janela j;

    public AssetSetter(Janela j) {
        this.j = j;
    }

    public void setItem() {
        if(j.player[j.playerIndex].hasCafe == 0){

        j.item[0] = new ITEM_PeDeCabra(j);
        j.item[0].worldX = 7 * j.tileSize;
        j.item[0].worldY = 4 * j.tileSize;

        j.item[1] = new CON_cafe(j);
        j.item[1].worldX = 22 * j.tileSize;
        j.item[1].worldY = 47 * j.tileSize;

        }
        else if (j.player[j.playerIndex].hasCafe == 1){
            for(int i = 0; i < j.item.length; i++){
                j.item[i] = null;
            }
            

        }
        else{

        }
    }
    public void setNPC() {
        if(j.player[j.playerIndex].hasCafe == 0){
            
        }
        else if (j.player[j.playerIndex].hasCafe == 1){
            for(int i = 0; i < j.npc.length; i++){
                j.npc[i] = null;
            }
        }
        else{
            j.npc[0] = new NPC_temp(j);
            j.npc[0].worldX = 10 * j.tileSize;
            j.npc[0].worldY = 5 * j.tileSize;
        }
    }
    public void setInimigo() {
        if(j.player[j.playerIndex].hasCafe == 0){
            j.inimigo[0] = new INI_sold_cacetete(j);
            j.inimigo[0].worldX = 13 * j.tileSize;
            j.inimigo[0].worldY = 25 * j.tileSize;

            j.inimigo[1] = new INI_sold_cacetete(j);
            j.inimigo[1].worldX = 13 * j.tileSize;
            j.inimigo[1].worldY = 26 * j.tileSize;

            j.inimigo[2] = new INI_sold_cacetete(j);
            j.inimigo[2].worldX = 10 * j.tileSize;
            j.inimigo[2].worldY = 10 * j.tileSize;

            j.inimigo[3] = new INI_sold_cacetete(j);
            j.inimigo[3].worldX = 10 * j.tileSize;
            j.inimigo[3].worldY = 11 * j.tileSize;
        }
        else if (j.player[j.playerIndex].hasCafe == 1){
            for(int i = 0; i < j.inimigo.length; i++){
                j.inimigo[i] = null;
            }
        }
        else if (j.player[j.playerIndex].hasCafe == 2){
            for(int i = 0; i < j.inimigo.length; i++){
                j.inimigo[i] = null;
            }
            j.inimigo[0] = new INI_sold_cacetete(j);
            j.inimigo[0].worldX = 5 * j.tileSize;
            j.inimigo[0].worldY = 6 * j.tileSize;

            j.inimigo[1] = new INI_sold_cacetete(j);
            j.inimigo[1].worldX = 5 * j.tileSize;
            j.inimigo[1].worldY = 7 * j.tileSize;
        }
        
    }
}