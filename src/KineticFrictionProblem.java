/*
 * KineticFrictionProblem class
 * User is given mass and coefficient of friction
 * They have to find the kinetic friction
 */
public class KineticFrictionProblem extends Problem {
    // Constructor, takes in all the known variables
    KineticFrictionProblem(String object, double mass, double ckf) {
        super(Problem.KINETIC_FRICTION);
        // Sets problem statement
        String problem = "A " + mass + "kg " + object
                + " slides across a surface. If the coefficient of kinetic friction is "
                + ckf + ", what is the frictional force the object experiences?";

        // Calculates kinetic friction using known variables
        double gravitationalForce = mass * gStrength;
        double normalForce = gravitationalForce;
        double frictionalForce = normalForce * ckf;
        frictionalForce = Math.round(frictionalForce * 100.0) / 100.0;

        // Sets full solution
        String fullSolution = "m = " + mass + "kg, μₖ = " + ckf + ", Fₖ = ? <br><br>"
                + "Fₖ = μₖFₙ <br>"
                + "= μₖF₉ <br>"
                + "= μₖmg <br>"
                + "= (" + ckf + ")(" + mass + "kg)(9.8N/kg) <br>"
                + "= " + frictionalForce + "N <br><br>"
                + "Therefore, the frictional force is " + frictionalForce + "N";

        // Sets variables in parent class
        setProblem(problem);
        setFbd(frictionalForce, 0, normalForce, gravitationalForce);
        setAnswer(frictionalForce);
        setFullSolution(fullSolution);
    }
}