package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "autonome (Blocks to Java)")
public class autonome extends LinearOpMode {
  private DcMotor pantographe;
  private DcMotor brastéléscopique;
  private DcMotor rouedroite;
  private DcMotor rouegauche;
  private Servo aideaudémarrage;
  private Servo pince;
  private Servo pivotpince;
  private DcMotor treuil;

  /**
   * Phase autonome: penser à renomer les moteurs en recopiant
   * le blocks sur un pc avec la dernière version du javablocks,
   * Penser à ajouter l'aide à la montée.
   */
  @Override
  public void runOpMode() {
    ElapsedTime runtime;
    //à verifier: roue1 == rouedroite
    //roue 2 == rouegauche
    //môa == trueil
    //pivotpince== pivotpince
    //je ne suis pas sur que ce qoit bien ça, pensez à verifier.
    pantographe = hardwareMap.get(DcMotor.class, "pantographe");
    brastéléscopique = hardwareMap.get(DcMotor.class, "bras téléscopique");
    treuil = hardwareMap.get(DcMotor.class, "treuil");
    pivotpince = hardwareMap.get(Servo.class, "pivot pince");
    rouedroite = hardwareMap.get(DcMotor.class, "roue droite");
    rouegauche = hardwareMap.get(DcMotor.class, "roue gauche");
    aideaudémarrage = hardwareMap.get(Servo.class, "aide au démarrage");
    pince = hardwareMap.get(Servo.class, "pince");
    treuil.setPower(0);
    pantographe.setPower(0);
    rouedroite.setPower(0);
    rouegauche.setPower(0);
    pivotpince.setPower(0);
    runtime = new ElapsedTime();
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
        runtime.reset();
        while (runtime.seconds() < 2) {
          rouedroite.setPower(1);
          rouegauche.setPower(-1);
          telemetry.addData("avancer :", "oui (2secondes)");
          telemetry.update();
        }
        rouedroite.setPower(0);
        rouegauche.setPower(0);
        rouedroite.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rouegauche.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        runtime.reset();
        while (runtime.seconds() < 2) {
          rouedroite.setPower(-1);
          rouegauche.setPower(1);
          telemetry.addData("reculer :", "oui (2secondes)");
          telemetry.update();
        }
        rouedroite.setPower(0);
        rouegauche.setPower(0);
        rouedroite.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rouegauche.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        runtime.reset();
        while (runtime.seconds() < 2) {
          rouedroite.setPower(1);
          rouegauche.setPower(1);
          telemetry.addData("tourner_gauche :", "oui (2secondes)");
          telemetry.update();
        }
        rouedroite.setPower(0);
        rouedroite.setPower(0);
        rouedroite.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rouegauche.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        runtime.reset();
        while (runtime.seconds() < 2) {
          rouedroite.setPower(-1);
          rouegauche.setPower(-1);
          telemetry.addData("tourner_droite :", "oui (2secondes)");
          telemetry.update();
        }
        rouedroite.setPower(0);
        rouegauche.setPower(0);
        rouedroite.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rouegauche.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        runtime.reset();
        while (runtime.second() < 2){
          brastéléscopique.setpower(1);
        }
        telemetry.update();
      }
    }
  }
}
