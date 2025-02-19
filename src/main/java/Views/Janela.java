package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Controller.AssetSetter;
import Controller.Audio;
import Controller.CollisionChecker;
import Controller.DDARayCast;
import Controller.EventHandler;
import Controller.KeyHandler;
import Models.Entidades.CobradeAluminio;
import Models.Entidades.DuroDuro;
import Models.Entidades.Entidade;
import Models.Entidades.Player;
import Models.Entidades.Projetil;
import Models.Entidades.Tempestade;
import Models.Itens.Item;

public class Janela extends JPanel implements Runnable {
    // CONFIG TELA DE TAMANHO 1024x576
    final int originalTileSize = 32; // 32 x 32
    final int scale = 2; // 2x32 = 64

    public final int tileSize = originalTileSize * scale; // 64x64
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 9;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    // FPS
    int FPS = 60;

    // CONFIG MUNDO
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    // base do jogo
    public TileManager tm = new TileManager(this);
    Audio audio = new Audio();
    Audio msc = new Audio();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public KeyHandler keyH = new KeyHandler(this);
    public EventHandler eHandler = new EventHandler(this);
    public DDARayCast rc = new DDARayCast(this);
    public UI ui = new UI(this);
    Thread gameThread;

    // ENTIDADE E OBJETO
    public  Player  player[] = new Player[3];
    public Item item[] = new Item[10];
    public Entidade npc[] = new Entidade[10];
    public Entidade inimigo[] = new Entidade[10];
    public Projetil proj[] = new Projetil[30];
    public int  playerIndex = 0;
    
    
    
    // GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;	
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public int selectedCharacter = 0;
    public final int creditState = 4;
    public final int gameOverState = 5;

    // construtor
    public Janela() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(keyH);
    }
    
    public void setupGame() {
        
        switch (selectedCharacter) {
            case 0:
            player[0] = new CobradeAluminio(this, keyH);
            playerIndex = 0;
            break;
            
            case 1:
            player[1] = new DuroDuro(this, keyH);
            playerIndex = 1;
            break;
            
            case 2:
            player[2] = new Tempestade(this, keyH);
            playerIndex = 2;
            break;
        }
        
        aSetter.setItem();
        aSetter.setNPC();
        aSetter.setInimigo();
        iniciarMsc(6);
        pararMsc(6);
        gameState = titleState;
        
    }
    
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        
        // game loop
        while (gameThread != null) {
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            
            timer += currentTime - lastTime;

            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            
            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    
    public void update() {
        if(player[playerIndex].hasCafe==1){
            tm.loadMap("/Mapas/map3.txt");
        }
        Graphics2D g2d = (Graphics2D) getGraphics();
        if (gameState == playState) {
            //  PLAYER[playerIndex]
            player[playerIndex].update();
            if (player[playerIndex].life <= 0) {
                gameState = gameOverState;
            }
            // NPC
            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
                    npc[i].update();
                    rc.rayCast(npc[i], g2d);
                }
            }
            for (int i = 0; i < inimigo.length; i++) {
                if (inimigo[i] != null) {
                    if (inimigo[i].alive == true && inimigo[i].dying == false) {
                        inimigo[i].update();
                        rc.rayCast(inimigo[i], g2d);
                    }
                    if(inimigo[i].alive == false){
                        inimigo[i].dying = true;
                        inimigo[i] = null;
                        
                    }
                }
            }
            for (int i = 0; i < proj.length; i++) {
                if (proj[i] != null) {
                    if (proj[i].alive == true) {
                        proj[i].update();
                    }
                    if(proj[i].alive == false){
                        proj[i] = null;
                        
                    }
                }
            }
            if (gameState == pauseState) {
                // pause
            }
        }
    
}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        
        //TELA DE LOBBY
        if (gameState == titleState) {
            ui.draw(g2d);
        }
        
        //OUTROS
        else {
            // TILE
            tm.draw(g2d);

        
              // ITEM
            for(int i = 0; i<item.length; i++){
                if(item[i] != null){
                item[i].draw(g2d, this);
                }
            }

            // NPC
            for(int i = 0; i < npc.length; i++){
                if(npc[i] != null){
                    npc[i].draw(g2d);
                }
            }
            
            for(int i = 0; i < inimigo.length; i++){
                if(inimigo[i] != null){
                    inimigo[i].draw(g2d);
                }
            }
            for (int i = 0; i < proj.length; i++) {
                if (proj[i] != null) {
                    proj[i].draw(g2d);
                }
            }
            
            
            
            //  PLAYER[playerIndex]
            player[playerIndex].draw(g2d);
            
            //dl.ddaLine(player[playerIndex].worldX, player[playerIndex].worldY, inimigo[0].worldX, inimigo[0].worldY, g2d);
            
            ui.draw(g2d);
            
            g2d.dispose();
        }

        }

       


    public void iniciarMsc(int i) {
        msc.setFile(i);
        msc.play();
        msc.loop();
    }
    public void pararMsc(int i) {
        msc.stop();
    }

    // tocar efeitos sonoros
    public void playSE(int i) {
        audio.setFile(i);
        audio.play();
    }

    public void iniciarGameThread() {
        if (gameThread == null) {
            gameThread = new Thread(this);
            gameThread.start();
        }
    }
}