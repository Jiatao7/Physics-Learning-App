import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.io.*;

public class Material implements ActionListener {
        // Creates components
        JFrame frame = new JFrame("CJ Physics Tutorial - Material");
        // bigBox is the panel that holds all the other small boxes
        JPanel bigBox = new JPanel(new FlowLayout(FlowLayout.CENTER, 160, 40));
        // box1, box2, and box3 hold information on static friction, kinetic friction,
        // and coefficient of friction respectively
        JPanel box1 = new JPanel();
        JPanel box2 = new JPanel();
        JPanel box3 = new JPanel();
        // boxD1, boxD2, and boxD3 contain the diagrams to support the information
        JPanel boxD1 = new JPanel();
        JPanel boxD2 = new JPanel();
        JPanel boxD3 = new JPanel();
        // Each box contains a header and text label; each diagram box contains a
        // diagram label
        JLabel box1Header = new JLabel();
        JLabel box1Text = new JLabel();
        JLabel box1Diagram = new JLabel();
        JLabel box2Header = new JLabel();
        JLabel box2Text = new JLabel();
        JLabel box2Diagram = new JLabel();
        JLabel box3Header = new JLabel();
        JLabel box3Text = new JLabel();
        JLabel box3Diagram = new JLabel();
        // Buttons to go back to other pages
        JButton menu = new JButton("Menu");
        JButton resources = new JButton("Resources");
        // Set the button colors (normal + on hover)
        Color buttonColor = Main.color2;
        Color hoverColor = Main.color3;
        // Set the fonts (header and text)
        Font headerFont = new Font("Helvetica Neue", Font.BOLD, 22);
        Font textFont = new Font("Helvetica Neue", Font.PLAIN, 16);

        Material() {
                // Sets buttons and places them on top right
                menu.setBounds(Main.screenWidth - 140, 30, 110, 30);
                menu.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
                menu.setFocusable(false);
                menu.setBackground(buttonColor);
                menu.addActionListener((ActionListener) this);
                menu.addMouseListener(mouseHover());
                resources.setBounds(Main.screenWidth - 140, 70, 110, 30);
                resources.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
                resources.setFocusable(false);
                resources.setBackground(buttonColor);
                resources.addActionListener((ActionListener) this);
                resources.addMouseListener(mouseHover());

                // Sets design of box1 and boxD1
                box1.setPreferredSize(new Dimension(700, 230));
                box1.setBackground(Color.BLACK);
                box1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                box1.setLayout(new BorderLayout());

                boxD1.setPreferredSize(new Dimension(520, 230));
                boxD1.setBackground(Color.BLACK);
                boxD1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                boxD1.setLayout(new BorderLayout());

                // Sets design of box2 and boxD2
                box2.setPreferredSize(new Dimension(700, 230));
                box2.setBackground(Color.BLACK);
                box2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                box2.setLayout(new BorderLayout());

                boxD2.setPreferredSize(new Dimension(520, 230));
                boxD2.setBackground(Color.BLACK);
                boxD2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                boxD2.setLayout(new BorderLayout());

                // Sets design of box3 and boxD3
                box3.setPreferredSize(new Dimension(700, 230));
                box3.setBackground(Color.BLACK);
                box3.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                box3.setLayout(new BorderLayout());

                boxD3.setPreferredSize(new Dimension(520, 230));
                boxD3.setBackground(Color.BLACK);
                boxD3.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                boxD3.setLayout(new BorderLayout());

                // Setting text output for the boxes, by reading from material.txt (text file)
                String text1 = "<html><body style='width: 450px'><ul>";
                String text2 = "<html><body style='width: 450px'><ul>";
                String text3 = "<html><body style='width: 450px'><ul>";

                try {
                        BufferedReader reader = new BufferedReader(new FileReader("resources/text/material.txt"));
                        for (int i = 0; i < 6; i++) {
                                text1 = text1 + "<li style='padding-left: 20px'>" + reader.readLine() + "</li>";
                        }
                        text1 = text1 + "</ul></body></html>";
                        for (int i = 0; i < 5; i++) {
                                text2 = text2 + "<li style='padding-left: 20px'>" + reader.readLine() + "</li>";
                        }
                        text2 = text2 + "</ul></body></html>";
                        for (int i = 0; i < 5; i++) {
                                text3 = text3 + "<li style='padding-left: 20px'>" + reader.readLine() + "</li>";
                        }
                        text3 = text3 + "</ul></body></html>";
                        reader.close();
                } catch (Exception e) {

                }

                // Sets text for box1
                box1Header.setText("<html><body style='width: 200px'>Static Friction (Fs)</body></html>");
                box1Header.setForeground(Main.color2);
                box1Header.setFont(headerFont);
                box1Header.setBorder(BorderFactory.createEmptyBorder(2, 10, 0, 0));
                box1Header.setOpaque(true);
                box1Header.setBackground(Color.BLACK);
                box1.add(box1Header, BorderLayout.NORTH);

                box1Text.setText(text1);
                box1Text.setForeground(Color.WHITE);
                box1Text.setFont(textFont);
                box1Text.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
                box1Text.setOpaque(true);
                box1Text.setBackground(Color.BLACK); // Set background color
                box1.add(box1Text, BorderLayout.CENTER);

                // Sets text for box2
                box2Header.setText("<html><body style='width: 200px'>Kinetic Friction (Fk)</body></html>");
                box2Header.setForeground(Main.color2);
                box2Header.setFont(headerFont);
                box2Header.setBorder(BorderFactory.createEmptyBorder(2, 10, 0, 0));
                box2Header.setOpaque(true);
                box2Header.setBackground(Color.BLACK);
                box2.add(box2Header, BorderLayout.NORTH);

                box2Text.setText(text2);
                box2Text.setForeground(Color.WHITE);
                box2Text.setFont(textFont);
                box2Text.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
                box2Text.setOpaque(true);
                box2Text.setBackground(Color.BLACK);
                box2.add(box2Text, BorderLayout.CENTER);

                // Sets text for box3
                box3Header.setText("<html><body style='width: 200px'>Coefficient of Friction</body></html>");
                box3Header.setForeground(Main.color2);
                box3Header.setFont(headerFont);
                box3Header.setBorder(BorderFactory.createEmptyBorder(2, 10, 0, 0));
                box3Header.setOpaque(true);
                box3Header.setBackground(Color.BLACK);
                box3.add(box3Header, BorderLayout.NORTH);

                box3Text.setText(text3);
                box3Text.setForeground(Color.WHITE);
                box3Text.setFont(textFont);
                box3Text.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
                box3Text.setOpaque(true);
                box3Text.setBackground(Color.BLACK);
                box3.add(box3Text, BorderLayout.CENTER);

                // Sets image for boxD1
                ImageIcon imageIcon1 = new ImageIcon("resources/images/Static_Friction.png");
                Image image1 = imageIcon1.getImage().getScaledInstance(520, 230, Image.SCALE_SMOOTH);
                box1Diagram.setIcon(new ImageIcon(image1));
                boxD1.add(box1Diagram);

                // Sets image for boxD2
                ImageIcon imageIcon2 = new ImageIcon("resources/images/Kinetic_Friction.png");
                Image image2 = imageIcon2.getImage().getScaledInstance(520, 230, Image.SCALE_SMOOTH);
                box2Diagram.setIcon(new ImageIcon(image2));
                boxD2.add(box2Diagram);

                // Sets image for boxD3
                ImageIcon imageIcon3 = new ImageIcon("resources/images/Coefficient_of_friction.png");
                Image image3 = imageIcon3.getImage().getScaledInstance(520, 230, Image.SCALE_SMOOTH);
                box3Diagram.setIcon(new ImageIcon(image3));
                boxD3.add(box3Diagram);

                // Add the 6 boxes to bigbox
                bigBox.add(box1);
                bigBox.add(boxD1);
                bigBox.add(box2);
                bigBox.add(boxD2);
                bigBox.add(box3);
                bigBox.add(boxD3);
                // Set bigBox
                bigBox.setBounds(Main.screenWidth / 2 - 800, Main.screenHeight / 2 - 450, 1600, 900);
                bigBox.setBackground(Color.BLACK);

                // Add components to frame
                frame.add(bigBox);
                frame.add(menu);
                frame.add(resources);

                // Sets frame
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(null);
                frame.getContentPane().setBackground(Color.BLACK);
                frame.setVisible(true);
                frame.setResizable(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                /*
                 * Function is called when a button is clicked
                 * First, it disposes the current frame
                 * Then, it makes a new page (menu, resources),
                 * depending on which button user clicked
                 */
                frame.dispose();
                if (e.getSource() == menu) {
                        new Homepage();
                } else if (e.getSource() == resources) {
                        new Resources();
                }
        }

        private MouseListener mouseHover() {
                // Mouse listener added to the buttons
                // Mouse listener detects when mouse enters/exits a component
                return new MouseListener() {
                        public void mouseClicked(MouseEvent e) {
                        }

                        public void mousePressed(MouseEvent e) {
                        }

                        public void mouseReleased(MouseEvent e) {
                        }

                        public void mouseEntered(MouseEvent e) {
                                ((JButton) e.getSource()).setBackground(hoverColor);
                        }

                        public void mouseExited(MouseEvent e) {
                                ((JButton) e.getSource()).setBackground(buttonColor);
                        }
                };
        }

        public static void main(String[] args) {
                new Material();
        }
}