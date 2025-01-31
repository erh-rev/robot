package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "OpMode_21403_2025012810 (Blocks to Java)")
public class OpMode_21403_2025012810 extends LinearOpMode {

  private DcMotor pantographe;
  private DcMotor brastéléscopique;
  private DcMotor treuil;
  private Servo pivotpince;
  private DcMotor rouedroite;
  private DcMotor rouegauche;
  private Servo aideaudémarrage;
  private Servo pince;

  /**
   * This sample contains the bare minimum Blocks for any regular OpMode. The 3 blue
   * Comment Blocks show where to place Initialization code (runs once, after touching the
   * DS INIT button, and before touching the DS Start arrow), Run code (runs once, after
   * touching Start), and Loop code (runs repeatedly while the OpMode is active, namely not
   * Stopped).
   */
  @Override
  public void runOpMode() {
    int aide__C3_A0_la_mont_C3_A9e;
    String position_pivot_pince;

    pantographe = hardwareMap.get(DcMotor.class, "pantographe");
    brastéléscopique = hardwareMap.get(DcMotor.class, "bras téléscopique");
    treuil = hardwareMap.get(DcMotor.class, "treuil");
    pivotpince = hardwareMap.get(Servo.class, "pivot pince");
    rouedroite = hardwareMap.get(DcMotor.class, "roue droite");
    rouegauche = hardwareMap.get(DcMotor.class, "roue gauche");
    aideaudémarrage = hardwareMap.get(Servo.class, "aide au démarrage");
    pince = hardwareMap.get(Servo.class, "pince");

    // Put initialization blocks here.
    waitForStart();
    aide__C3_A0_la_mont_C3_A9e = 0;
    pantographe.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    pantographe.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    brastéléscopique.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    brastéléscopique.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    treuil.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    treuil.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    pivotpince.setPosition(0.12);
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        if (gamepad1.left_stick_y != 0) {
          if (pantographe.getCurrentPosition() < 1000) {
            if (gamepad1.left_stick_y < 0) {
              pantographe.setPower(-(gamepad1.left_stick_y / 2));
            }
          }
          if (pantographe.getCurrentPosition() > 0) {
            if (gamepad1.left_stick_y > 0) {
              pantographe.setPower(-(gamepad1.left_stick_y / 2));
            }
          }
        } else {
          pantographe.setPower(0);
          pantographe.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        if (gamepad2.left_stick_y != 0 || gamepad2.right_stick_x != 0) {
          rouedroite.setPower(gamepad2.left_stick_y / 1.5 + gamepad2.right_stick_x / -2.5);
          rouegauche.setPower(gamepad2.left_stick_y / -1.5 + gamepad2.right_stick_x / -2.5);
        } else {
          rouedroite.setPower(0);
          rouegauche.setPower(0);
          rouedroite.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
          rouegauche.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        if (gamepad1.left_stick_y > 0 && aide__C3_A0_la_mont_C3_A9e == 1) {
          aideaudémarrage.setPosition(70);
          aide__C3_A0_la_mont_C3_A9e = 0;
        } else if (gamepad1.left_stick_y < 0 && aide__C3_A0_la_mont_C3_A9e == 0) {
          aideaudémarrage.setPosition(-100);
          aide__C3_A0_la_mont_C3_A9e = 1;
        }
        if (gamepad2.x) {
          pince.setPosition(1);
        } else if (gamepad2.y) {
          pince.setPosition(0.75);
        }
        if (gamepad1.right_stick_y != 0) {
          brastéléscopique.setPower(gamepad1.right_stick_y / 2.5);
        } else {
          brastéléscopique.setPower(0);
          brastéléscopique.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        if (brastéléscopique.getCurrentPosition() > -100) {
          pivotpince.setPosition(0.12);
          position_pivot_pince = "repos";
        }
        if (brastéléscopique.getCurrentPosition() <= -100) {
          if (gamepad1.a) {
            pivotpince.setPosition(0.12);
            position_pivot_pince = "repos";
          } else if (gamepad1.y) {
            pivotpince.setPosition(0.93);
            position_pivot_pince = "attraper";
          } else if (gamepad1.b) {
            pivotpince.setPosition(0.42);
            position_pivot_pince = "suspend";
          } else if (gamepad1.x) {
            pivotpince.setPosition(0.75);
            position_pivot_pince = "transport";
          }
        }
        if (gamepad2.b) {
          treuil.setPower(1);
        } else if (gamepad2.a) {
          treuil.setPower(-1);
        } else {
          treuil.setPower(0);
          treuil.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        telemetry.addData("panto", pantographe.getCurrentPosition());
        telemetry.addData("position pivot pince", position_pivot_pince);
        telemetry.update();
      }
    }
  }
}
