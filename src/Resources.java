import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Resources implements ActionListener {
    // Create frame and title
    JFrame frame = new JFrame("CJ Friction Tutorial - Resources");
    JLabel title = new JLabel();

    // Create resources buttons (links to other pages)
    JButton materialBtn = new JButton("Material");
    JButton samplesBtn = new JButton("Samples");
    JButton simulationBtn = new JButton("Simulation");

    // Create menu button (goes back to homepage)
    JButton menu = new JButton("Menu");

    // Set the button colors (normal + on hover)
    Color buttonColor = Main.color2;
    Color hoverColor = Main.color3;

    Resources() {
        // Set title
        title.setText("Resources");
        title.setBounds(Main.screenWidth / 2 - 500, Main.screenHeight / 2 - 100, 1000, 100);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setForeground(Color.white);
        title.setFont(new Font("Helvetica Neue", Font.PLAIN, 60));
        title.setBackground(Main.color4);
        title.setOpaque(true);

        // Set the buttons (set location, font, background color + add action & mouse
        // listener)
        materialBtn.setBounds(300, 750, 300, 60);
        materialBtn.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
        materialBtn.setFocusable(false);
        materialBtn.setBackground(buttonColor);
        materialBtn.addActionListener((ActionListener) this);
        materialBtn.addMouseListener(mouseHover());

        samplesBtn.setBounds(Main.screenWidth / 2 - 150, 750, 300, 60);
        samplesBtn.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
        samplesBtn.setFocusable(false);
        samplesBtn.setBackground(buttonColor);
        samplesBtn.addActionListener((ActionListener) this);
        samplesBtn.addMouseListener(mouseHover());

        simulationBtn.setBounds(Main.screenWidth - 600, 750, 300, 60);
        simulationBtn.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
        simulationBtn.setFocusable(false);
        simulationBtn.setBackground(buttonColor);
        simulationBtn.addActionListener((ActionListener) this);
        simulationBtn.addMouseListener(mouseHover());

        menu.setBounds(Main.screenWidth - 140, 30, 110, 30);
        menu.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        menu.setFocusable(false);
        menu.setBackground(buttonColor);
        menu.addActionListener((ActionListener) this);
        menu.addMouseListener(mouseHover());

        // Set the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(Main.color4);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);

        // Add the components (title and buttons) to the frame
        frame.add(title);
        frame.add(materialBtn);
        frame.add(samplesBtn);
        frame.add(simulationBtn);
        frame.add(menu);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
         * Function is called when a button is clicked
         * First, it disposes the current frame
         * Then, it makes a new page (material, samples, simulation),
         * depending on which button user clicked
         */
        frame.dispose();
        if (e.getSource() == materialBtn) {
            new Material();
        } else if (e.getSource() == samplesBtn) {
            new Samples();
        } else if (e.getSource() == simulationBtn) {
            new Simulation();
        } else if (e.getSource() == menu) {
            new Homepage();
        }
    }
}