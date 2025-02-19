package Models.Entidades;


import Views.Janela;

public class PRJ_Tiro extends Projetil{

    Janela j;

    public PRJ_Tiro(Janela j) {
        super(j);
        this.j = j;

        nome = "Tiro";
        speed = 5;
        maxLife = 50;
        life = maxLife;
        attack = 1;
        alive = false;

        getImage();
    }
    public void getImage(){
        up1 = setup("/Sprites/projetil/Projetil_1", 64, 64);
        up2 = setup("/Sprites/projetil/Projetil_1", 64, 64);
        down1 = setup("/Sprites/projetil/Projetil_1", 64, 64);
        down2 = setup("/Sprites/projetil/Projetil_1", 64, 64);
        left1 = setup("/Sprites/projetil/Projetil_1", 64, 64);
        left2 = setup("/Sprites/projetil/Projetil_1", 64, 64);
        right1 = setup("/Sprites/projetil/Projetil_1", 64, 64);
        right2 = setup("/Sprites/projetil/Projetil_1", 64, 64);
    }
    


}
