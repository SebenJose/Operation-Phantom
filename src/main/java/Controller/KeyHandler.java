package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Views.Janela;


/**
 *
 * @author caiom
 */
public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, escPressed, ePressed, enterPressed;
    Janela j;


    public KeyHandler(Janela j){
        this.j = j;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        
            
            // MENU
            if(j.gameState == j.titleState){
                
                if(j.ui.titleScreenState == 0){
                    
                    if (code == KeyEvent.VK_W ||  code == KeyEvent.VK_UP) {
                    j.ui.comandNum--;
                    if(j.ui.comandNum < 0){
                        j.ui.comandNum = 2;
                    }
                }
    
                if (code == KeyEvent.VK_S ||   code == KeyEvent.VK_DOWN) {
                    j.ui.comandNum++;
                    if(j.ui.comandNum > 2){
                        j.ui.comandNum = 0;
                    }
                }
    
                if (code == KeyEvent.VK_ENTER){
                    if(j.ui.comandNum == 0){
                        j.ui.titleScreenState = 1;
                    }
                    else if(j.ui.comandNum == 1){
                        j.ui.titleScreenState = 2;
                         // vai ser os creditos
                    }
                    else if(j.ui.comandNum == 2){ //sai, assim eu espero.
                        System.exit(0);
                    }
                }  
            }else if (j.ui.titleScreenState == 1){ //SELECIONAR PERSONAGEM
                
                    if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                    j.ui.comandNum--;
                    if(j.ui.comandNum < 0){
                        j.ui.comandNum = 3;
                    }
                }
    
                if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
                    j.ui.comandNum++;
                    if(j.ui.comandNum > 3){
                        j.ui.comandNum = 0;
                    }
                }
    
                if (code == KeyEvent.VK_ENTER){
                    if(j.ui.comandNum == 0){
                        j.selectedCharacter = 0;
                        j.setupGame();
                        j.gameState = j.playState;
                    }
                    else if(j.ui.comandNum == 1){
                        j.selectedCharacter = 1;
                        j.setupGame();
                        j.gameState = j.playState;
                    }
                    else if(j.ui.comandNum == 2){
                        j.selectedCharacter = 2;
                        j.setupGame();
                        j.gameState = j.playState;
                    }
                    else if(j.ui.comandNum == 3){
                        //voltar
                        j.ui.titleScreenState = 0;	
                }  
            }
            
            
        }
        
        // Credit State
        else if(j.ui.titleScreenState == 2){
            if(code == KeyEvent.VK_ENTER){
                if(j.ui.comandNum == 1){
                    j.ui.titleScreenState = 0;
                }
            }
        }
    }
        // Play State
        else if(j.gameState == j.playState){

            if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                upPressed = true;
            }

            if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
                downPressed = true;
            }

            if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
                leftPressed = true;
            }

            if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
                rightPressed = true;
            }
            if (code == KeyEvent.VK_E) {
                ePressed = true;
            }
            if (code == KeyEvent.VK_ENTER) {
                enterPressed = true; 

            }
            if (code == KeyEvent.VK_ESCAPE) {
                j.gameState = j.pauseState; 
                
        }
    }   
        if(j.gameState == j.gameOverState){
            if(code == KeyEvent.VK_ENTER){
                j.gameState = j.titleState;
                j.ui.titleScreenState = 0;
            }
        }
        // Pause State
        else if (j.gameState == j.pauseState) {
            if (code == KeyEvent.VK_ESCAPE) 
                j.gameState = j.playState; 
         
         if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            j.ui.comandNum--;
            if(j.ui.comandNum < 0){
                j.ui.comandNum = 1;
            }
        }

        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            j.ui.comandNum++;
            if(j.ui.comandNum > 1){
                j.ui.comandNum = 0;
            }
        }
            if (code == KeyEvent.VK_ENTER){
                if(j.ui.comandNum == 0){
                    j.selectedCharacter = 0;
                    j.setupGame();
                    j.gameState = j.playState;
                }
                else if(j.ui.comandNum == 1){
                    j.selectedCharacter = 1;
                    j.setupGame();
                    j.gameState = j.titleState;
                    j.ui.titleScreenState = 0;
                }
                
                if (code == KeyEvent.VK_ESCAPE) {
                    j.gameState = j.playState; 
                }
        }
        }
    
            
        // Dialogue State
        else if (j.gameState == j.dialogueState){
            if(code == KeyEvent.VK_ENTER){
                j.gameState = j.playState;
            }
         }

        
        
    
        }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            upPressed = false;
        }

        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }

        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }

        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        if (code == KeyEvent.VK_E) {
            ePressed = false;
        }
        
        
}

}
