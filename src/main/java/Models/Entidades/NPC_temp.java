package Models.Entidades;

import Views.Janela;


public class NPC_temp extends Entidade {

    public NPC_temp(Janela j) {
        super(j);

        type = 1;

        direction = "down";
        speed = 0;

        getImage();
        setDialogue();
    }

    public void setDialogue(){
        dialogue[0] = "Coronel: Olá, eu sou o coronel...\nO que achou do teste? ";
        dialogue[1] = "Você: Teste??? isso era um teste?";
        dialogue[2] = "Coronel: Não era óbvio? era claramente um programam em java...\n Mas enfim, quem você acha que é a death machine afinal?\n VOCÊ";
        dialogue[3] = "Você: O QUE?";
        dialogue[4] = "Coronel: Só um cara tão bom poderia ter passado\n por um programa desses vivo! Parabéns!";
        dialogue[5] = "Você: Obrigado... Eu acho...";
        dialogue[6] = "Coronel: Agora vá, o mundo precisa de você! \nO MUNDO PRECISA DE DEMOCRACIA!";
    }

    public void setAction() {

        
         
        
    }
    public void speak(){

        super.speak();

    }
    
        public void getImage() {

            down2 = setup("/Sprites/coronel",j.tileSize, j.tileSize);
            down1 = setup("/Sprites/coronel",j.tileSize, j.tileSize);
        

    }
    
    
}
