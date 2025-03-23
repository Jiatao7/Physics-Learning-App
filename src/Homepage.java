import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Homepage implements ActionListener {
    // Create frame and title
    JFrame frame = new JFrame("CJ Physics Tutorial - Homepage");
    JLabel title = new JLabel();

    // Create homepage buttons (links to other pages)
    JButton resourcesBtn = new JButton("Resources");
    JButton practiceBtn = new JButton("Practice");
    JButton quizBtn = new JButton("Quiz");

    // Set the button colors (normal + on hover)
    Color buttonColor = Main.color2;
    Color hoverColor = Main.color3;

    Homepage() {
        // Set title
        title.setText("Welcome to CJ Physics Tutorial");
        title.setBounds(Main.screenWidth / 2 - 500, Main.screenHeight / 2 - 100, 1000, 100);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setForeground(Color.white);
        title.setFont(new Font("Helvetica Neue", Font.PLAIN, 60));
        title.setBackground(Main.color4);
        title.setOpaque(true);

        // Set the buttons (set location, font, background color + add action & mouse
        // listener)
        resourcesBtn.setBounds(300, Main.screenHeight - 240, 300, 60);
        resourcesBtn.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
        resourcesBtn.setFocusable(false);
        resourcesBtn.setBackground(buttonColor);
        resourcesBtn.addActionListener((ActionListener) this);
        resourcesBtn.addMouseListener(mouseHover());

        practiceBtn.setBounds(Main.screenWidth / 2 - 150, Main.screenHeight - 240, 300, 60);
        practiceBtn.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
        practiceBtn.setFocusable(false);
        practiceBtn.setBackground(buttonColor);
        practiceBtn.addActionListener((ActionListener) this);
        practiceBtn.addMouseListener(mouseHover());

        quizBtn.setBounds(Main.screenWidth - 600, Main.screenHeight - 240, 300, 60);
        quizBtn.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
        quizBtn.setFocusable(false);
        quizBtn.setBackground(buttonColor);
        quizBtn.addActionListener((ActionListener) this);
        quizBtn.addMouseListener(mouseHover());

        // Set the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(Main.color4);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);

        // Add the components (title and buttons) to the frame
        frame.add(title);
        frame.add(resourcesBtn);
        frame.add(practiceBtn);
        frame.add(quizBtn);
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

            // Occurs when mouse enters (hovers over) a button
            public void mouseEntered(MouseEvent e) {
                ((JButton) e.getSource()).setBackground(hoverColor);
            }

            // Occurs when mouse exits (stops hovering over) a button
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
         * Then, it makes a new page (resources, practice, quiz),
         * depending on which button user clicked
         */
        frame.dispose();
        if (e.getSource() == resourcesBtn) {
            new Resources();
        } else if (e.getSource() == practiceBtn) {
            new Practice();
        } else if (e.getSource() == quizBtn) {
            new Quiz();
        }
    }
}