import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Practice implements ActionListener {
    RandomProblem newProblem; // the current problem

    // Creates frame
    JFrame frame = new JFrame("CJ Physics Tutorial - Practice");

    // Creates panels
    JPanel megaPanel = new JPanel();
    JPanel panel = new JPanel(); // title panel
    JPanel panel2 = new JPanel(); // problem panel
    JPanel panel3 = new JPanel(); // diagram / hint panel
    JPanel panel4 = new JPanel(); // solution panel
    JPanel panel5 = new JPanel(); // answer panel (where user enters answer)
    JPanel space = new JPanel(); // whitespace panel (used as a space holder)

    // Creates labels
    JLabel title = new JLabel("Practice");
    JLabel problem = new JLabel();
    JLabel solution = new JLabel("");

    // Creates components of answer panel
    JLabel ansLabel = new JLabel("Answer:");
    JTextField answerBox = new JTextField(); // answer box where user types in their answer
    JButton check = new JButton("Check"); // check button where user can check their answer
    JLabel note = new JLabel(); // side note
    JLabel correct = new JLabel(); // label that displays telling user if they got it right or wrong

    // Creates buttons
    JButton hint = new JButton("View Hint"); // hint button allows user to see a FBD diagram to help them do the
                                             // question
    JButton solu = new JButton("View Solution"); // solution button displays user the full solution
    JButton menu = new JButton("Menu"); // goes to menu
    JButton next = new JButton("Next Problem"); // goes to next problem

    // Color of buttons (normal + hover)
    Color buttonColor = Main.color2;
    Color hoverColor = Main.color3;

    Practice() {
        // Sets label fonts
        title.setFont(new Font("Helvetica Neue", Font.PLAIN, 36));
        problem.setFont(new Font("Helvetica Neue", Font.PLAIN, 28));
        solution.setFont(new Font("Helvetica Neue", Font.PLAIN, 22));

        // Sets answer components
        ansLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 28));
        ansLabel.setPreferredSize(new Dimension(100, 40));
        answerBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
        answerBox.setPreferredSize(new Dimension(160, 40));
        answerBox.setLocation(0, 120);
        check.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
        check.setPreferredSize(new Dimension(120, 40));
        check.setFocusable(false);
        check.setBackground(buttonColor);
        check.addActionListener((ActionListener) this);
        check.addMouseListener(mouseHover());
        note.setFont(new Font("Helvetica Neue", Font.ITALIC, 16));
        note.setPreferredSize(new Dimension(450, 40));
        correct.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
        correct.setPreferredSize(new Dimension(450, 40));

        // Creates border
        Border b = BorderFactory.createLineBorder(Color.black, 1);

        // Set panels (location, size, layout, etc.) and add components to each
        megaPanel.setBounds(Main.screenWidth / 2 - 700, Main.screenHeight / 2 - 460, 1400, 800);
        megaPanel.setLayout(null);

        panel.setBounds(0, 0, 1400, 75);
        panel.setBorder(b);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
        panel.setBackground(Main.color1);
        panel.add(title);

        panel2.setBounds(0, 75, 900, 250);
        panel2.setBorder(b);
        panel2.setBackground(Main.color1);
        panel2.setLayout(new FlowLayout(FlowLayout.LEADING, 25, 30));
        panel2.add(problem);

        panel5.setBounds(900, 75, 500, 250);
        panel5.setBorder(b);
        panel5.setBackground(Main.color1);
        panel5.setLayout(new FlowLayout(FlowLayout.LEADING, 25, 30));
        panel5.add(ansLabel);
        panel5.add(answerBox);
        panel5.add(check);
        panel5.add(note);
        panel5.add(correct);

        panel3.setBounds(0, 325, 700, 475);
        panel3.setBorder(b);
        panel3.setBackground(Main.color1);
        panel3.setLayout(new FlowLayout(FlowLayout.LEADING, 25, 15));
        panel3.add(hint);

        panel4.setBounds(700, 325, 700, 475);
        panel4.setBorder(b);
        panel4.setBorder(b);
        panel4.setBackground(Main.color1);
        panel4.setLayout(new FlowLayout(FlowLayout.LEADING, 25, 15));
        panel4.add(solu);
        panel4.add(solution);

        space.setPreferredSize(new Dimension(100, 30));
        space.setBackground(Main.color1);

        // Sets buttons
        hint.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        hint.setPreferredSize(new Dimension(200, 30));
        hint.setFocusable(false);
        hint.setBackground(buttonColor);
        hint.addActionListener((ActionListener) this);
        hint.addMouseListener(mouseHover());

        solu.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        solu.setPreferredSize(new Dimension(200, 30));
        solu.setFocusable(false);
        solu.setBackground(buttonColor);
        solu.addActionListener((ActionListener) this);
        solu.addMouseListener(mouseHover());

        next.setBounds(Main.screenWidth / 2 + 400, 900, 300, 50);
        next.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
        next.setFocusable(false);
        next.setBackground(buttonColor);
        next.addActionListener((ActionListener) this);
        next.addMouseListener(mouseHover());

        menu.setBounds(Main.screenWidth - 140, 30, 110, 30);
        menu.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
        menu.setFocusable(false);
        menu.setBackground(buttonColor);
        menu.addActionListener((ActionListener) this);
        menu.addMouseListener(mouseHover());

        // Sets frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(Main.color4);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);

        // Add panels to mega panel
        megaPanel.add(panel);
        megaPanel.add(panel2);
        megaPanel.add(panel3);
        megaPanel.add(panel4);
        megaPanel.add(panel5);

        // Adds mega panel and buttons to frame
        frame.add(megaPanel);
        frame.add(next);
        frame.add(menu);

        // Sets the first problem
        setProblem();
    }

    // Set problem function; called at the start and every time user clicks "next
    // problem"
    public void setProblem() {
        // Chooses a random problem by creating an instance of the RandomProblem class
        Random rand = new Random();
        newProblem = new RandomProblem(rand.nextInt(5));
        // Set the problem text
        problem.setText(
                "<html><body><div style = 'width: 650px'>"
                        + "Problem <br>"
                        + newProblem.getProblem()
                        + "</div></body></html>");
        // Sets the answerbox to default
        answerBox.setText("");
        answerBox.setBorder(null);
        answerBox.setEditable(true);
        // Hides the correct label
        correct.setText("");
        // Sets the note depending on the problem type
        if (newProblem.getType() == Problem.STARTING_FRICTION) {
            note.setText("*Enter yes (object will move) or no (object will not move)");
        } else {
            note.setText("*Marked as correct if within 0.5% of actual answer");
        }
        // Sets the solution and diagram panel to default
        solution.setText("");
        panel3.removeAll();
        panel3.add(hint);
        panel3.add(space);
        panel3.repaint();

        // Enables and disables certain buttons
        next.setEnabled(false);
        hint.setEnabled(true);
        solu.setEnabled(false);
        check.setEnabled(true);
    }

    public void check() throws InterruptedException {
        // Gets box text
        String boxText = answerBox.getText();
        double userAnswer;

        // Waits a little before showing if answer is correct
        Thread.sleep(200);

        // For yes or no problem
        if (newProblem.getType() == Problem.STARTING_FRICTION) {
            // Checks if box text is valid (yes or no)
            if (boxText.equalsIgnoreCase("yes") || boxText.equalsIgnoreCase("no")) {
                // Checks if user answer is correct
                if (newProblem.checkAns(boxText.equalsIgnoreCase("yes"))) {
                    // The following occurs if it is
                    answerBox.setBorder(BorderFactory.createLineBorder(Color.green, 2));
                    correct.setForeground(Color.green);
                    correct.setText("Correct!");
                    check.setEnabled(false);
                    answerBox.setEditable(false);
                } else {
                    // The following occurs if it is not
                    answerBox.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                    correct.setForeground(new Color(255, 70, 0));
                    correct.setText("Try again, view solution, or move on");
                }
                next.setEnabled(true);
                if (solution.getText() == "") {
                    solu.setEnabled(true);
                }
                // If box text is invalid, send an error message
            } else {
                JOptionPane.showMessageDialog(null, "Please enter yes or no", "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else { // For number answer problem
            // Trys converting box text to double (if it is able to, the box text is valid)
            try {
                userAnswer = Double.parseDouble(boxText);
                // Check if user answer is correct
                if (newProblem.checkAnswer(userAnswer)) {
                    // The following occurs if it is
                    answerBox.setBorder(BorderFactory.createLineBorder(Color.green, 2));
                    correct.setForeground(Color.green);
                    correct.setText("Correct!");
                    check.setEnabled(false);
                    answerBox.setEditable(false);
                } else {
                    // The following occurs if it is not
                    answerBox.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                    correct.setForeground(new Color(255, 70, 0));
                    correct.setText("Try again, view solution, or move on");
                }
                next.setEnabled(true);
                if (solution.getText() == "") {
                    solu.setEnabled(true);
                }
                // If box text is invalid, send error message
            } catch (Exception NumberFormatException) {
                JOptionPane.showMessageDialog(null, "Please enter a number", "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void viewHint() {
        // Method called when user presses hint button (also called when user presses
        // solution button)
        // Show the diagram
        panel3.add(hint);
        panel3.add(space);
        panel3.add(newProblem.getFbd());
        panel3.revalidate();
        panel3.repaint();
        hint.setEnabled(false);
    }

    public void viewSolution() {
        // Method called when user presses solution button
        // Show the diagram by calling viewHint()
        // Set the solution text
        viewHint();
        solution.setText("<html><body><div style = 'width: 525px'>"
                + "Solution <br>"
                + newProblem.getSolution()
                + "</div></body></html>");
        solu.setEnabled(false);
        check.setEnabled(false);
        answerBox.setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
         * Occurs when user presses buttons
         * Next --> go to next problem
         * Check --> checks answer
         * Hint --> views hint
         * Solu --> views solution
         */

        if (e.getSource() == next) {
            setProblem();
        }

        else if (e.getSource() == check) {
            try {
                check();
            } catch (InterruptedException e1) {
                Thread.currentThread().interrupt();
            }
        }

        else if (e.getSource() == hint) {
            viewHint();
        }

        else if (e.getSource() == solu) {
            viewSolution();
        }

        else if (e.getSource() == menu) {
            frame.dispose();
            new Homepage();
        }

        ((JButton) e.getSource()).setBackground(buttonColor);
    }

    // Set hover effects for buttons
    private MouseListener mouseHover() {
        return new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
                if (((JButton) e.getSource()).isEnabled()) {
                    ((JButton) e.getSource()).setBackground(hoverColor);
                }
            }

            public void mouseExited(MouseEvent e) {
                ((JButton) e.getSource()).setBackground(buttonColor);
            }
        };
    }

    public static void main(String[] args) {
        new Practice();
    }
}
