
import javax.swing.JFrame;

import Views.Janela;

public class OpPhantom {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Operation Phantom");

        Janela j = new Janela();
        frame.add(j);

        frame.pack();

        // esse comentario é só pro github reconhecer q estou fazendo um commit pq ele é
        // tonto e n me deixa fazer as coisas - gabriel
        // frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza a janela
        // frame.setUndecorated(true); // Remove bordas da janela
        frame.setVisible(true);

        j.setupGame();
        j.iniciarGameThread();
    }
}