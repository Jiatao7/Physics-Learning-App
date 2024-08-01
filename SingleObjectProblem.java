/*
 * SingleObjectProblem class
 * User is given mass, acceleration, and coefficient of friction
 * They have to find the applied force
 */

public class SingleObjectProblem extends Problem {
    // Constructor, takes in all the known variables
    SingleObjectProblem(String object, double mass, double acceleration, double ckf) {
        super(Problem.SINGLE_OBJECT);
        // Sets problem statement
        String problem = "A " + mass + "kg " + object + " is pushed along the ground at " + acceleration
                + "m/s². If the coefficient of kinetic friction is " + ckf
                + ", what is the applied force that the object experiences?";

        // Using the known variables, it calculates applied force
        double netForce = Math.round(mass * acceleration * 100.0) / 100.0;
        double gravitationalForce = mass * gStrength;
        double normalForce = gravitationalForce;
        double frictionalForce = Math.round(ckf * normalForce * 100.0) / 100.0;
        double appliedForce = Math.round(netForce + frictionalForce * 100.0) / 100.0;

        // Sets full solution
        String fullSolution = "m = " + mass + "kg, a = " + acceleration + "m/s², μₖ = " + ckf + ", Fₐ = ? <br><br>"
                + "Fₙₑₜ = ma = " + mass + "kg x " + acceleration + "m/s² = " + frictionalForce + "N <br>"
                + "Fₖ = μₖFₙ <br>"
                + "= μₖF₉ <br>"
                + "= μₖmg <br>"
                + "= (" + ckf + ")(" + mass + "kg)(9.8N/kg) <br>"
                + "= " + frictionalForce + "N <br>"
                + "Fₐ = Fₙₑₜ - Fₖ = " + netForce + "N - " + frictionalForce + "N = " + appliedForce + "N <br><br>"
                + "Therefore, the applied force is " + appliedForce + "N";

        // Calls the setter methods in the parent method to set the variables there
        setProblem(problem);
        setFbd(frictionalForce, appliedForce, normalForce, gravitationalForce);
        setAnswer(appliedForce);
        setFullSolution(fullSolution);
    }
}