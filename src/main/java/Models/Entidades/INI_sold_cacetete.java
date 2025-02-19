package Models.Entidades;

import java.util.Random;

import Views.Janela;

public class INI_sold_cacetete extends Entidade {

    Janela j;  

    public INI_sold_cacetete(Janela j) {
        super(j);

        this.j = j;

        type = 2;
        nome = "soldado de cacetete";
        speed = 2;
        maxLife = 1;
        life = maxLife;
        direction = "down";

        getImage();
        getAttackImage();

    }   
    public void getImage() { 
        up1 = setup("/Sprites/Inimigos/sold_melee/sold_cacete_up_1",j.tileSize, j.tileSize);
        up2 = setup("/Sprites/Inimigos/sold_melee/sold_cacete_up_2",j.tileSize, j.tileSize);
        down1 = setup("/Sprites/Inimigos/sold_melee/sold_cacete_1",j.tileSize, j.tileSize);
        down2 = setup("/Sprites/Inimigos/sold_melee/sold_cacete_2",j.tileSize, j.tileSize);
        left1 = setup("/Sprites/Inimigos/sold_melee/sold_cacete_left_1",j.tileSize, j.tileSize);
        left2 = setup("/Sprites/Inimigos/sold_melee/sold_cacete_left_2",j.tileSize, j.tileSize);
        right1 = setup("/Sprites/Inimigos/sold_melee/sold_cacete_right_1",j.tileSize, j.tileSize);
        right2 = setup("/Sprites/Inimigos/sold_melee/sold_cacete_right_2",j.tileSize, j.tileSize);
        

    }
    public void getAttackImage() { 
        attackUp1 = setup("/Sprites/Inimigos/sold_melee/atk/sold_cacete_atk_up",j.tileSize, j.tileSize);
        attackUp2 = setup("/Sprites/Inimigos/sold_melee/atk/sold_cacete_atk_up",j.tileSize, j.tileSize);
        attackDown1 = setup("/Sprites/Inimigos/sold_melee/atk/sold_cacete_atk_down",j.tileSize, j.tileSize);
        attackDown2 = setup("/Sprites/Inimigos/sold_melee/atk/sold_cacete_atk_down",j.tileSize, j.tileSize);
        attackLeft1 = setup("/Sprites/Inimigos/sold_melee/atk/sold_cacete_atk_left",j.tileSize, j.tileSize);
        attackLeft2 = setup("/Sprites/Inimigos/sold_melee/atk/sold_cacete_atk_left",j.tileSize, j.tileSize);
        attackRight1 = setup("/Sprites/Inimigos/sold_melee/atk/sold_cacete_atk_right",j.tileSize, j.tileSize);
        attackRight2 = setup("/Sprites/Inimigos/sold_melee/atk/sold_cacete_atk_right",j.tileSize, j.tileSize);
        
}
        public void setAction() {

        actionLockCounter++;

        if (actionLockCounter == 120){
            Random random = new Random();
            int i = random.nextInt(100)+1;

            if(j.rc.tileFound == false){
                if(i <= 25){
                    direction = "up";
                }else if(i <= 50){
                    direction = "down";
                }else if(i <= 75){
                    direction = "left";
                }else if(i <= 100){
                    direction = "right";
                }
            }
            else{
                if (Math.abs(worldX - j.player[j.playerIndex].worldX) > Math.abs(worldY - j.player[j.playerIndex].worldY)) {
                    if (worldX < j.player[j.playerIndex].worldX) {
                        direction = "right";
                    } else {
                        direction = "left";
                    }
                } else {
                    if (worldY < j.player[j.playerIndex].worldY) {
                        direction = "down";
                    } else {
                        direction = "up";
                    }
                }
            }
            actionLockCounter = 0;
         }
        
    }
    
}
