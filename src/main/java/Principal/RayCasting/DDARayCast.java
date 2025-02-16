package Principal.RayCasting;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import static java.lang.Math.sqrt;

import Entidades.Entidade;
import Principal.Janela;
import Principal.TileManager;

public class DDARayCast {
    public Graphics2D g2;
    public TileManager tm;
    public Janela j;
    public Rectangle ray;

    public DDARayCast(Janela j) {
        this.j = j;
    }

    public void rayCast(Entidade entidade, Graphics2D g2) {
        g2.setColor(Color.PINK);
        g2.drawLine(entidade.worldX, entidade.worldY, j.player[j.playerIndex].worldX, j.player[j.playerIndex].worldY);

        double rayStartX = j.player[j.playerIndex].worldX;
        double rayStartY = j.player[j.playerIndex].worldY;
        double rayEndX = entidade.worldX - j.player[j.playerIndex].worldX;
        double rayEndY = entidade.worldY - j.player[j.playerIndex].worldY;
        double rayUnitStepSize[] = { sqrt(1 + (rayEndY * rayEndY) / (rayEndX * rayEndX)), sqrt(1 + (rayEndX * rayEndX) / (rayEndY * rayEndY)) };

        int mapCheckX = (int) (rayStartX / j.tileSize);
        int mapCheckY = (int) (rayStartY / j.tileSize);

        double rayLength1D[] = { 0, 0 };

        int stepX;
        int stepY;

        if (rayEndX < 0) {
            stepX = -1;
            rayLength1D[0] = (rayStartX - mapCheckX * j.tileSize) * rayUnitStepSize[0];
        } else {
            stepX = 1;
            rayLength1D[0] = ((mapCheckX + 1) * j.tileSize - rayStartX) * rayUnitStepSize[0];
        }
        if (rayEndY < 0) {
            stepY = -1;
            rayLength1D[1] = (rayStartY - mapCheckY * j.tileSize) * rayUnitStepSize[1];
        } else {
            stepY = 1;
            rayLength1D[1] = ((mapCheckY + 1) * j.tileSize - rayStartY) * rayUnitStepSize[1];
        }

        boolean tileFound = false;
        double maxDistance = 5;
        double distance = 0;
        while (!tileFound && distance < maxDistance) {
            if (rayLength1D[0] < rayLength1D[1]) {
                mapCheckX += stepX;
                distance = rayLength1D[0];
                rayLength1D[0] += rayUnitStepSize[0];
            } else {
                mapCheckY += stepY;
                distance = rayLength1D[1];
                rayLength1D[1] += rayUnitStepSize[1];
            }

            // Ensure mapCheckX and mapCheckY are within bounds
            if (mapCheckX >= 0 && mapCheckX < j.maxWorldCol && mapCheckY >= 0 && mapCheckY < j.maxWorldRow) {
                // Check if the current tile is solid

                if (j.tm.tile[j.tm.mapTileNum[(int)mapCheckX][(int)mapCheckY]].collision) {
                    tileFound = true;
                    System.out.println("Tile found");
                }
            } else {
                break; // Out of bounds
            }
        }
        System.out.println(j.tm.mapTileNum[(int)mapCheckX][(int)mapCheckY] +"  " + entidade.currentTile +" " + j.player[j.playerIndex].currentTile);
        double intersectionX;
        double intersectionY;
        if (tileFound == true) {
            intersectionX = rayStartX + rayEndX * distance;
            intersectionY = rayStartY + rayEndY * distance;

            g2.drawArc((int) intersectionX, (int) intersectionY, 4, 4, 0, 360);
        }
    }
}