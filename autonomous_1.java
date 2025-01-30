
private void avancer(double puissance) {
    rouedroite.setPower(puissance);
    rouegauche.setPower(puissance);
}

private void reculer(double puissance) {
    rouedroite.setPower(-puissance);
    rouegauche.setPower(-puissance);
}

private void tourner_droite(double puissance) {
    rouedroite.setPower(puissance);
    rouegauche.setPower(-puissance);
}
private void tourner_gauche(double puissance){
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
        tourner(0.5);
        sleep(2000); //tourner pendant 2 secondes
        // Arrêter le robot
        rouedroite.setPower(0);
        rouegauche.setPower(0);
        
        // Ajoutez d'autres logiques ou conditions si nécessaire
    }
}
