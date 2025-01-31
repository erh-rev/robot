package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "autonome (Blocks to Java)")
public class autonome extends LinearOpMode {

  private DcMotor moâ;
  private DcMotor pantographe;
  private DcMotor roue1;
  private DcMotor roue2;
  private DcMotor superman;

  /**
   * Phase autonome: penser à renomer les moteurs en recopiant
   * le blocks sur un pc avec la dernière version du javablocks,
   * Penser à ajouter l'aide à la montée.
   */
  @Override
  public void runOpMode() {
    ElapsedTime runtime;

    moâ = hardwareMap.get(DcMotor.class, "moâ");
    pantographe = hardwareMap.get(DcMotor.class, "pantographe");
    roue1 = hardwareMap.get(DcMotor.class, "roue 1");
    roue2 = hardwareMap.get(DcMotor.class, "roue 2");
    superman = hardwareMap.get(DcMotor.class, "superman");

    // Put initialization blocks here.
    moâ.setPower(0);
    pantographe.setPower(0);
    roue1.setPower(0);
    roue2.setPower(0);
    superman.setPower(0);
    runtime = new ElapsedTime();
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
        runtime.reset();
        while (runtime.seconds() < 2) {
          roue1.setPower(1);
          roue2.setPower(-1);
          telemetry.addData("avancer :", "oui (2secondes)");
          telemetry.update();
        }
        roue1.setPower(0);
        roue2.setPower(0);
        runtime.reset();
        while (runtime.seconds() < 2) {
          roue1.setPower(-1);
          roue2.setPower(1);
          telemetry.addData("reculer :", "oui (2secondes)");
          telemetry.update();
        }
        roue1.setPower(0);
        roue2.setPower(0);
        runtime.reset();
        while (runtime.seconds() < 2) {
          roue1.setPower(1);
          roue2.setPower(1);
          telemetry.addData("tourner_gauche :", "oui (2secondes)");
          telemetry.update();
        }
        roue1.setPower(0);
        roue1.setPower(0);
        runtime.reset();
        while (runtime.seconds() < 2) {
          roue1.setPower(-1);
          roue2.setPower(-1);
          telemetry.addData("tourner_droite :", "oui (2secondes)");
          telemetry.update();
        }
        roue1.setPower(0);
        roue2.setPower(0);
        telemetry.update();
      }
    }
  }
}
