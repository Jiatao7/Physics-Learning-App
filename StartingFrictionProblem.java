/*
 * StartingFrictionProblem class
 * User is given mass, applied force, and coefficient of static friction
 * They have to find whether object will move or not
 */

public class StartingFrictionProblem extends Problem {
    public static String FA = "Fₐ";
    public static String FK = "Fₖ";
    public static String FS = "Fₛ";
    public static String FG = "F₉";
    public static String FN = "Fₙ";

    // ans variable that stores whether or not object will move
    private boolean ans;

    // Constructor that takes in known variables
    StartingFrictionProblem(String object, double mass, double appliedForce, double csf) {
        super(Problem.STARTING_FRICTION);

        // Sets problem statement
        String problem = "If a " + mass + "kg " + object + " experiences an applied force of " + appliedForce
                + "N, and the coefficient of static friction is " + csf + ", will the object start moving?";

        // Calculates frictional force using known variables
        double gravitationalForce = mass * gStrength;
        double normalForce = gravitationalForce;
        double frictionalForce = Math.round(csf * gravitationalForce * 100.0) / 100.0;

        // Sets ans (true if frictional force is greater than applied force, false
        // otherwise)
        String res = "";
        if (appliedForce > frictionalForce) {
            res = appliedForce + "N > " + frictionalForce + "N so Fₐ > Fₛ <br>"
                    + "Since the applied force is greater than the starting friction, the object will move.";
            ans = true;
        } else {
            res = appliedForce + "N &#60 " + frictionalForce + "N so Fₐ &#60 Fₛ <br>"
                    + "Since the applied force is less than the starting friction, the object will not move.";
            ans = false;
        }

        String fullSolution = "m = " + mass + "kg, Fₐ = " + appliedForce + "N, μₛ = " + csf + ", Fₛ = ? <br><br>"
                + "Fₛ = μₛFₙ <br>"
                + "= μₛF₉ <br>"
                + "= μₛmg <br>"
                + "= (" + csf + ")(" + mass + "kg)(9.8N/kg) <br>"
                + "= " + frictionalForce + "N <br><br>"
                + res;

        // Set parent variables
        setProblem(problem);
        setFbd(frictionalForce, appliedForce, normalForce, gravitationalForce, FS, FA, FN, FG);
        setFullSolution(fullSolution);
    }

    // Special methods
    public boolean getAns() {
        // Returns answer (as boolean)
        return ans;
    }

    public String getStringAns() {
        // Returns answer (as yes or no)
        if (ans) {
            return "yes";
        }
        return "no";
    }

    public boolean checkAns(boolean userAnswer) {
        // Checks user answer and returns if they are right or wrong
        return ans == userAnswer;
    }
}