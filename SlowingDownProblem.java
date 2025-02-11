/*
 * SlowingDownProblem class
 * User is given mass, initial velocity, final velocity, distance
 * They have to find the coefficient of friction
 */

public class SlowingDownProblem extends Problem {
    // Constructor that takes in all known variables
    SlowingDownProblem(String object, double mass, double initVelocity, double finalVelocity, double distance) {
        super(Problem.SLOWING_DOWN);
        // Sets problem statement (the problem statement is different depending on if
        // final velocity is 0 or not)
        String problem;
        if (finalVelocity == 0) {
            problem = "A " + mass + "kg " + object + " with an initial velocity of " + initVelocity + "m/s travels "
                    + distance + "m before coming to a stop. "
                    + "What is the coefficient of friction?";
        } else {
            problem = "A " + mass + "kg " + object + " initially has a velocity of " + initVelocity + "m/s. "
                    + "After travelling for " + distance + "m, it slows down to " + finalVelocity + "m/s. "
                    + "What is the coefficient of friction?";
        }

        // Calculates coefficent of friction using known variables
        double gravitationalForce = mass * gStrength;
        double normalForce = gravitationalForce;
        double acceleration = Math.abs((finalVelocity * finalVelocity - initVelocity * initVelocity) / 2.0 / distance);
        acceleration = Math.round(acceleration * 100.0) / 100.0;
        double frictionalForce = mass * acceleration;
        frictionalForce = Math.round(frictionalForce * 100.0) / 100.0;
        double ckf = frictionalForce / gravitationalForce;
        ckf = Math.round(ckf * 100.0) / 100.0;

        // Sets full solution
        String fullSolution = "m = " + mass + "kg, v₀ = " + initVelocity + "m/s, v = " + finalVelocity + "m/s, Δd = "
                + distance + "m, μₖ = ? <br><br>"
                + "a = (v² - v₀²) / 2Δd = " + acceleration + "m/s² <br>"
                + "Fₖ = Fₙₑₜ = ma = " + mass + "kg x " + acceleration + "m/s² = " + frictionalForce + "N <br>"
                + "μₖ = Fₖ / Fₙ <br>"
                + "= Fₖ / F₉ <br>"
                + "= Fₖ / mg <br>"
                + "= (" + frictionalForce + "N) / (" + mass + "kg)(9.8N/kg) <br>"
                + "= " + ckf + "<br><br>"
                + "Therefore, the coefficient of friction is " + ckf;

        // Sets variables in parent class
        setProblem(problem);
        setFbd(frictionalForce, 0, normalForce, gravitationalForce);
        setAnswer(ckf);
        setFullSolution(fullSolution);
    }
}