//The Fbd class uses java graphics to draw on a panel

import javax.swing.*;
import java.awt.*;

public class Fbd extends JPanel {
    // Class variables
    public static String FA = "Fₐ";
    public static String FK = "Fₖ";
    public static String FS = "Fₛ";
    public static String FG = "F₉";
    public static String FN = "Fₙ";

    // Instance variables
    // Length of each arrow
    private int left;
    private int right;
    private int top;
    private int bottom;

    // Types of force
    private JLabel label = new JLabel("FBD");
    private JLabel lForce = new JLabel();
    private JLabel rForce = new JLabel();
    private JLabel tForce = new JLabel();
    private JLabel bForce = new JLabel();

    // xfactor and yfactor that the vectors are multiplied by (are adjusted to fit
    // the diagram in the panel)
    private double xfactor = 1;
    private double yfactor = 1;

    // Default Fbd constructor (used for most problems); assumes that forces (left,
    // right, top, bottom) are frictional force, applied force, normal force,
    // gravitatinoal force respectively
    Fbd(double l, double r, double t, double b) {
        // Changes x and y factors so the arrows do not go out of panel
        if (l > 100) {
            xfactor *= 100 / l;
            yfactor *= 100 / l;
        }
        // Changes y factor so that y arrows are no more than 1.6 times bigger than the
        // left arrow (this is done to make the diagram look nicer)
        if (t > l * 1.6 || b > l * 1.6) {
            yfactor *= 1.6 / (double) t * (double) l;
        }

        // Multiply by x and y factors to get length of each arrow
        left = (int) (l * xfactor);
        right = (int) (r * xfactor);
        top = (int) (t * yfactor);
        bottom = (int) (b * yfactor);

        // Makes the panel 400 by 400
        this.setPreferredSize(new Dimension(400, 400));
        this.setLayout(null);

        // Set components
        label.setBounds(20, 20, 50, 20);
        label.setFont(new Font("Helvetica Neue", Font.CENTER_BASELINE, 22));
        this.add(label);

        // Adds labels
        if (left > 0) {
            lForce.setText(FK);
            lForce.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
            lForce.setBounds(185 - left, 205, 20, 20);
            this.add(lForce);
        }

        if (right > 0) {
            rForce.setText(FA);
            rForce.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
            rForce.setBounds(200 + right, 205, 20, 20);
            this.add(rForce);
        }

        if (top > 0) {
            tForce.setText(FN);
            tForce.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
            tForce.setBounds(210, 180 - top, 30, 30);
            this.add(tForce);
        }

        if (bottom > 0) {
            bForce.setText(FG);
            bForce.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
            bForce.setBounds(210, 200 + bottom, 30, 30);
            this.add(bForce);
        }
    }

    // Special Fbd Constructor (used for certain problems)
    // Exact same as default constructor, except that the forces are not the default
    // This changes the label names
    Fbd(double l, double r, double t, double b, String lf, String rf, String tf, String bf) {
        if (l > 100 || r > 100) {
            xfactor *= 100 / l;
            yfactor *= 100 / l;
        } else if (l < 20 && r < 20) {
            xfactor *= 3;
            yfactor *= 3;
        } else if (l < 40 && r < 40) {
            xfactor *= 2;
            yfactor *= 2;
        }

        if (t > l * 1.6 || b > l * 1.6 || t > r * 1.6 || t > r * 1.6) {
            yfactor *= 1.6 / (double) t * (double) l;
        }

        left = (int) (l * xfactor);
        right = (int) (r * xfactor);
        top = (int) (t * yfactor);
        bottom = (int) (b * yfactor);

        this.setPreferredSize(new Dimension(400, 400));
        this.setLayout(null);

        label.setBounds(20, 20, 50, 20);
        label.setFont(new Font("Helvetica Neue", Font.CENTER_BASELINE, 22));
        this.add(label);

        if (left > 0) {
            lForce.setText(lf);
            lForce.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
            lForce.setBounds(185 - left, 205, 20, 20);
            this.add(lForce);
        }

        if (right > 0) {
            rForce.setText(rf);
            rForce.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
            rForce.setBounds(200 + right, 205, 20, 20);
            this.add(rForce);
        }

        if (top > 0) {
            tForce.setText(tf);
            tForce.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
            tForce.setBounds(210, 180 - top, 30, 30);
            this.add(tForce);
        }

        if (bottom > 0) {
            bForce.setText(bf);
            bForce.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
            bForce.setBounds(210, 200 + bottom, 30, 30);
            this.add(bForce);
        }
    }

    // Method that paints on the panel
    @Override
    public void paintComponent(Graphics g) {
        // Creates instance of Graphics2D
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Sets stroke width and color
        g2.setStroke(new BasicStroke(3));
        g2.setPaint(Color.black);

        // Draws a box in the middle of the panel (the size depends on the length of the
        // arrows)
        if ((left < 35 && left > 0) || (top < 35)) {
            g2.drawRect(185, 185, 30, 30);
        } else if ((left < 55 && left > 0) || (top < 60)) {
            g2.drawRect(170, 170, 60, 60);
        } else {
            g2.drawRect(150, 150, 100, 100);
        }
        // Draws a dot in the middle of the box
        g2.fillOval(195, 195, 10, 10);

        // Draws each arrow (line + triangle)
        if (left > 0) {
            g2.drawLine(200, 200, 200 - left, 200);
            int[] xPoints = { 200 - left, 200 - left, 190 - left };
            int[] yPoints = { 205, 195, 200 };
            g2.fillPolygon(xPoints, yPoints, 3);
        }
        if (right > 0) {
            g2.drawLine(200, 200, 200 + right, 200);
            int[] xPoints = { 200 + right, 200 + right, 210 + right };
            int[] yPoints = { 205, 195, 200 };
            g2.fillPolygon(xPoints, yPoints, 3);
        }
        if (top > 0) {
            g2.drawLine(200, 200, 200, 200 - top);
            int[] xPoints = { 205, 195, 200 };
            int[] yPoints = { 200 - top, 200 - top, 190 - top };
            g2.fillPolygon(xPoints, yPoints, 3);
        }
        if (bottom > 0) {
            g2.drawLine(200, 200, 200, 200 + bottom);
            int[] xPoints = { 205, 195, 200 };
            int[] yPoints = { 200 + bottom, 200 + bottom, 210 + bottom };
            g2.fillPolygon(xPoints, yPoints, 3);
        }
    }
}