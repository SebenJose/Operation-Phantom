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
    }
    public void getImage(){
        image = setup("/Sprites/Projetil", 64, 64);
    }
    


}
