/* 
This is the problem class, it stores the problem (text), fbd, answer, fullSolution, and type of the problem

5 different types of problems (each is an unique subclass that inherits from the problem class):
1. Kinetic Friction
2. Slowing Down
3. Single Object
4. Starting Friction
5. Wall Friction 

Variable meanings
csf - coefficient of static friction
ckf - coeffiicent of kinetic friction
*/

public class Problem {
    public static final double gStrength = 9.8; // gravitational field strength

    // Sets class variables (different integer for each type of problem)
    public static final int KINETIC_FRICTION = 0;
    public static final int SLOWING_DOWN = 1;
    public static final int SINGLE_OBJECT = 2;
    public static final int STARTING_FRICTION = 3;
    public static final int WALL_FRICTION = 4;

    // Sets instance variables
    String problem;
    Fbd fbd;
    double answer;
    String fullSolution;
    int type;

    // Constructor
    Problem(int type) {
        this.type = type;
    }

    // Setter methods (called by subclasses to change variables)
    public void setProblem(String p) {
        problem = p;
    }

    public void setFbd(double l, double r, double t, double b) {
        fbd = new Fbd(l, r, t, b);
    }

    public void setFbd(double l, double r, double t, double b, String lf, String rf, String tf, String bf) {
        fbd = new Fbd(l, r, t, b, lf, rf, tf, bf);
    }

    public void setAnswer(double a) {
        answer = a;
    }

    public void setFullSolution(String fs) {
        fullSolution = fs;
    }

    // Getter methods (returns value of variables)
    public String getProblem() {
        return problem;
    }

    public Fbd getFbd() {
        return fbd;
    }

    public double getAnswer() {
        return answer;
    }

    public String getSolution() {
        return fullSolution;
    }

    // Checking methods
    public boolean checkAnswer(double userAnswer) {
        // Checks if user answer is within 0.5% of actual anwswer; if it is, returns
        // true
        if (userAnswer <= 1.005 * answer && userAnswer >= 0.995 * answer) {
            return true;
        }
        return false;
    }

    // Special methods (used only for starting friction type problems since it is
    // yes or no answer)
    // These methods will be shadowed by the methods in StartingFrictionProblem.java
    // They are only here so code will not error
    public boolean getAns() {
        return false;
    }

    public String getStringAns() {
        return "";
    }

    public boolean checkAns(boolean userAnswer) {
        return false;
    }
}
