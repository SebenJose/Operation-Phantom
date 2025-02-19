package Models.Entidades;

import Controller.KeyHandler;
import Views.Janela;

public class DuroDuro extends Player {
    public DuroDuro(Janela j, KeyHandler keyH) {
        super(j, keyH);
    }
    
        public void setDefaultValues() {
            
            super.setDefaultValues();

            type = 0;

            worldX = j.tileSize * 4;
            worldY = j.tileSize * 4;
            speed = 3;
            direction = "down";
    
            maxLife = 5;
            life = maxLife;
        }
        public void getPlayerImage() {
        if (attacking == false){
        if(peDeCabraEquipped){
            up1 = setup("/Sprites/Player/drdr/cabra/dr_up_cabra_1",j.tileSize, j.tileSize);
            up2 = setup("/Sprites/Player/drdr/cabra/dr_up_cabra_2",j.tileSize, j.tileSize);
            down1 = setup("/Sprites/Player/drdr/cabra/dr_down_cabra_1",j.tileSize, j.tileSize);
            down2 = setup("/Sprites/Player/drdr/cabra/dr_down_cabra_2",j.tileSize, j.tileSize);
            left1 = setup("/Sprites/Player/drdr/cabra/dr_left_cabra_1",j.tileSize, j.tileSize);
            left2 = setup("/Sprites/Player/drdr/cabra/dr_left_cabra_2",j.tileSize, j.tileSize);
            right1 = setup("/Sprites/Player/drdr/cabra/dr_right_cabra_1",j.tileSize, j.tileSize);
            right2 = setup("/Sprites/Player/drdr/cabra/dr_right_cabra_2",j.tileSize, j.tileSize);
        }
        else if(armaEquipped){
            up1 = setup("/Sprites/Player/drdr/mov/dr_up_M16_1",j.tileSize, j.tileSize);
            up2 = setup("/Sprites/Player/drdr/mov/dr_up_M16_2",j.tileSize, j.tileSize);
            down1 = setup("/Sprites/Player/drdr/mov/dr_down_M16_1",j.tileSize, j.tileSize);
            down2 = setup("/Sprites/Player/drdr/mov/dr_down_M16_2",j.tileSize, j.tileSize);
            left1 = setup("/Sprites/Player/drdr/mov/dr_left_M16_1",j.tileSize, j.tileSize);
            left2 = setup("/Sprites/Player/drdr/mov/dr_left_M16_2",j.tileSize, j.tileSize);
            right1 = setup("/Sprites/Player/drdr/mov/dr_right_M16_1",j.tileSize, j.tileSize);
            right2 = setup("/Sprites/Player/drdr/mov/dr_right_M16_2",j.tileSize, j.tileSize);
        }
        else{
            up1 = setup("/Sprites/Player/drdr/mov/dr_up_1",j.tileSize, j.tileSize);
            up2 = setup("/Sprites/Player/drdr/mov/dr_up_2",j.tileSize, j.tileSize);
            down1 = setup("/Sprites/Player/drdr/mov/dr_down_1",j.tileSize, j.tileSize);
            down2 = setup("/Sprites/Player/drdr/mov/dr_down_2",j.tileSize, j.tileSize);
            left1 = setup("/Sprites/Player/drdr/mov/dr_left_1",j.tileSize, j.tileSize);
            left2 = setup("/Sprites/Player/drdr/mov/dr_left_2",j.tileSize, j.tileSize);
            right1 = setup("/Sprites/Player/drdr/mov/dr_right_1",j.tileSize, j.tileSize);
            right2 = setup("/Sprites/Player/drdr/mov/dr_right_2",j.tileSize, j.tileSize);
            
        }
    }
}
   
    public void getAttackImage(){

        if(peDeCabraEquipped){
            attackUp1 = setup("/Sprites/Player/drdr/cabra/dr_up_cabra_atk",j.tileSize, j.tileSize);
            attackUp2 = setup("/Sprites/Player/drdr/cabra/dr_up_cabra_atk",j.tileSize, j.tileSize);
            attackDown1 = setup("/Sprites/Player/drdr/cabra/dr_down_cabra_atk",j.tileSize, j.tileSize);
            attackDown2 = setup("/Sprites/Player/drdr/cabra/dr_down_cabra_atk",j.tileSize, j.tileSize);
            attackLeft1 = setup("/Sprites/Player/drdr/cabra/dr_left_cabra_atk",j.tileSize, j.tileSize);
            attackLeft2 = setup("/Sprites/Player/drdr/cabra/dr_left_cabra_atk",j.tileSize, j.tileSize);
            attackRight1 = setup("/Sprites/Player/drdr/cabra/dr_right_cabra_atk",j.tileSize, j.tileSize);
            attackRight2 = setup("/Sprites/Player/drdr/cabra/dr_right_cabra_atk",j.tileSize, j.tileSize);
        }
        else if(armaEquipped){
            attackUp1 = setup("/Sprites/Player/drdr/mov/dr_up_M16_atk",j.tileSize, j.tileSize);
            attackUp2 = setup("/Sprites/Player/drdr/mov/dr_up_M16_atk",j.tileSize, j.tileSize);
            attackDown1 = setup("/Sprites/Player/drdr/mov/dr_down_M16_atk",j.tileSize, j.tileSize);
            attackDown2 = setup("/Sprites/Player/drdr/mov/dr_down_M16_atk",j.tileSize, j.tileSize);
            attackLeft1 = setup("/Sprites/Player/drdr/mov/dr_left_1_M16_atk",j.tileSize, j.tileSize);
            attackLeft2 = setup("/Sprites/Player/drdr/mov/dr_left_M16_atk",j.tileSize, j.tileSize);
            attackRight1 = setup("/Sprites/Player/drdr/mov/dr_right_M16_atk",j.tileSize, j.tileSize);
            attackRight2 = setup("/Sprites/Player/drdr/mov/dr_right_M16_atk",j.tileSize, j.tileSize);
        }
        else{
            attackUp1 = setup("/Sprites/Player/drdr/mov/dr_up_1",j.tileSize, j.tileSize);
            attackUp2 = setup("/Sprites/Player/drdr/mov/dr_up_2",j.tileSize, j.tileSize);
            attackDown1 = setup("/Sprites/Player/drdr/mov/dr_down_1",j.tileSize, j.tileSize);
            attackDown2 = setup("/Sprites/Player/drdr/mov/dr_down_2",j.tileSize, j.tileSize);
            attackLeft1 = setup("/Sprites/Player/drdr/mov/dr_left_1",j.tileSize, j.tileSize);
            attackLeft2 = setup("/Sprites/Player/drdr/mov/dr_left_2",j.tileSize, j.tileSize);
            attackRight1 = setup("/Sprites/Player/drdr/mov/dr_right_1",j.tileSize, j.tileSize);
            attackRight2 = setup("/Sprites/Player/drdr/mov/dr_right_2",j.tileSize, j.tileSize);
        }

    }
    public void interactNPC(int i) {

        if (i != 999) {
            if (keyH.ePressed) {
                j.gameState = j.dialogueState;
                j.npc[i].speak();
                //keyH.ePressed = false;
            }
        }
    }
}


