import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame {

    public CSServer server;

    public MyFrame() {

    }

    public void setCServer(CSServer server) {
        this.server = server;
    }

    public void init() {

        this.setSize(300,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addKeyListener(new MyKeyListener());

    }

    class MyKeyListener implements java.awt.event.KeyListener {


        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {




        }

        @Override
        public void keyReleased(KeyEvent e) {

            System.out.println("=====");

            System.out.println("=====");

            System.out.println("=====");

            if(e.getKeyCode() == KeyEvent.VK_KP_DOWN) {

                System.out.println("=====");

                server.move( "down");



            }

            if(e.getKeyCode() == KeyEvent.VK_KP_UP) {



            }

        }
    }




}
