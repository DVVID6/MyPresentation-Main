package myPresentation;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    //atributos
    private JButton myPhoto, myHobby, myExpectations;
    private JPanel containerButtons, containerImage;
    private Listener listener;
    private Title title;
    private JLabel imageLabel;
    private JTextArea expectativesText;

    //metodos
    public Main(){
        initGUI();
        this.setTitle("My Presentation");
        this.setSize(200, 100);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Definir container y Layout del JFrame
        //Crear objetos Escucha y Control
        //Configurar JComponents
        title = new Title("A little more about me", Color.BLACK);
        myPhoto = new JButton("This is me");
        myHobby = new JButton("This is my passion");
        myExpectations = new JButton("What I expected");
        containerButtons = new JPanel();
        containerImage = new JPanel();
        listener = new Listener();
        imageLabel = new JLabel();
        expectativesText = new JTextArea(12, 12);

        containerImage.setBorder(BorderFactory.createTitledBorder(null, "About me", TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION, new Font(Font.SANS_SERIF,Font.PLAIN,20), Color.BLACK));
        containerImage.add(imageLabel);

        containerButtons.add(myPhoto);
        containerButtons.add(myHobby);
        containerButtons.add(myExpectations);

        //se agregan los listener (mouse,key) a los botones
        myPhoto.addActionListener(listener);
        myHobby.addActionListener(listener);
        myExpectations.addActionListener(listener);
        myHobby.addMouseListener(listener);
        myExpectations.addMouseListener(listener);
        myPhoto.addMouseListener(listener);
        myPhoto.addKeyListener(listener);
        myHobby.addKeyListener(listener);
        myExpectations.addKeyListener(listener);

        this.add(title, BorderLayout.NORTH);
        this.add(containerButtons, BorderLayout.SOUTH);
        this.add(containerImage, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() { Main myGui = new Main();
            }
        });
    }
    // aqui agregue los eventos que se van a implementar ActionListener, MouseListener y KeyListener.
    private class Listener implements ActionListener, MouseListener, KeyListener {
        private ImageIcon image;
        @Override
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(null, "Press button");


            if (e.getSource() == myPhoto) {
                containerImage.remove(expectativesText);
                imageLabel.setIcon(null);
                this.image = new ImageIcon(getClass().getResource("/resources/Me.jpg"));
                imageLabel.setIcon(image);
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == myHobby && e.getClickCount() == 2) {
                containerImage.remove(expectativesText);
                imageLabel.setIcon(null);
                this.image = new ImageIcon(getClass().getResource("/resources/Hobby.jpeg"));
                imageLabel.setIcon(image);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 77) {
                imageLabel.setIcon(null);
                expectativesText.setText("I hope to learn enough to have the teacher's salary\n");
                expectativesText.setBackground(null);
                expectativesText.setForeground(Color.BLACK);
                containerImage.add(expectativesText);
            }
            revalidate();
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
