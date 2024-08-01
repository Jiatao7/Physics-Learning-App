import java.awt.*;

public class Main {
    // Get and store the height and width of user's screen (used to center elements)
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int screenWidth = (int) screenSize.getWidth();
    public static int screenHeight = (int) screenSize.getHeight();

    /*
     * Set main colours of program
     * Color 1 - light gray (panel background)
     * Color 2 - light blue (buttons)
     * Color 3 - dark blue (buttons on hover)
     * Color 4 - black (frame background)
     */
    public static Color color1 = new Color(0xD4D9D8);
    public static Color color2 = new Color(0x93EFF1);
    public static Color color3 = new Color(0x3077D9);
    public static Color color4 = new Color(0x0F0F0F);

    // Main method; begins the program by making a new homepage
    public static void main(String[] args) {
        new Homepage();
    }
}
