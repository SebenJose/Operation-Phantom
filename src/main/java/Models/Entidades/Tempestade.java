package Models.Entidades;

import Controller.KeyHandler;
import Views.Janela;

public class Tempestade extends Player {
    public Tempestade(Janela j, KeyHandler keyH) {
        super(j, keyH);
    }
    
    public void setDefaultValues() {

        super.setDefaultValues();


        type = 0;

        worldX = j.tileSize * 4;
        worldY = j.tileSize * 4;

        speed = 6;

    
        maxLife = 2;
        life = maxLife;
        }
        public void getPlayerImage() {
        
            up1 = setup("/Sprites/Player/temp/mov/temp_up_1",j.tileSize, j.tileSize);
            up2 = setup("/Sprites/Player/temp/mov/temp_up_2",j.tileSize, j.tileSize);
            down1 = setup("/Sprites/Player/temp/mov/temp_down_1",j.tileSize, j.tileSize);
            down2 = setup("/Sprites/Player/temp/mov/temp_down_2",j.tileSize, j.tileSize);
            left1 = setup("/Sprites/Player/temp/mov/temp_left_1",j.tileSize, j.tileSize);
            left2 = setup("/Sprites/Player/temp/mov/temp_left_2",j.tileSize, j.tileSize);
            right1 = setup("/Sprites/Player/temp/mov/temp_right_1",j.tileSize, j.tileSize);
            right2 = setup("/Sprites/Player/temp/mov/temp_right_2",j.tileSize, j.tileSize);
        
    }
        public void getAttackImage(){
            attackUp1 = setup("/Sprites/Player/temp/atk/temp_up_atk",j.tileSize, j.tileSize);
            attackUp2 = setup("/Sprites/Player/temp/atk/temp_up_atk",j.tileSize, j.tileSize);
            attackDown1 = setup("/Sprites/Player/temp/atk/temp_down_atk",j.tileSize, j.tileSize);
            attackDown2 = setup("/Sprites/Player/temp/atk/temp_down_atk",j.tileSize, j.tileSize);
            attackLeft1 = setup("/Sprites/Player/temp/atk/temp_left_atk",j.tileSize, j.tileSize);
            attackLeft2 = setup("/Sprites/Player/temp/atk/temp_left_atk",j.tileSize, j.tileSize);
            attackRight1 = setup("/Sprites/Player/temp/atk/temp_right_atk",j.tileSize, j.tileSize);
            attackRight2 = setup("/Sprites/Player/temp/atk/temp_right_atk",j.tileSize, j.tileSize);
        }
        public void interactNPC(int i) {

            if (i != 999) {
              if (keyH.ePressed) {
                    j.gameState = j.dialogueState;
                    j.npc[i].speak();
            }
        }
    }
}


