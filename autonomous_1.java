
static void avancer(double puissance) {
    rouedroite.setPower(puissance);
    rouegauche.setPower(puissance);
}

static void reculer(double puissance) {
    rouedroite.setPower(-puissance);
    rouegauche.setPower(-puissance);
}

static void tourner_droite(double puissance) {
    rouedroite.setPower(puissance);
    rouegauche.setPower(-puissance);
}
static void tourner_gauche(double puissance){
    rouedroite.setPower(-puissance);
    rouegauche.setPower(puissance);
}
@Override
public void runOpMode() {
    // Initialisation des moteurs et servos comme précédemment

    waitForStart();

    // Exemple d'utilisation des fonctions
    while (opModeIsActive()) {
        // Avancer pendant 2 secondes
        avancer(0.5);
        sleep(2000); // Avancer pendant 2000 ms (2 secondes)

        // Reculer pendant 2 secondes
        reculer(0.5);
        sleep(2000); // Reculer pendant 2000 ms (2 secondes)

        // Tourner pendant 2 secondes
        tourner_gauche(0.5);
        sleep(2000); //tourner pendant 2 secondes
        // Arrêter le robot
        rouedroite.setPower(0);
        rouegauche.setPower(0);
        
        // Tourner pendant 2 secondes
        tourner_droite(0.5);
        sleep(2000); //tourner pendant 2 secondes
        // Arrêter le robot
        rouedroite.setPower(0);
        rouegauche.setPower(0);        
    }
}
