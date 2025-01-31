# Tutoriel : Programmation du Mode Autonome avec REV Robotics Expansion Hub

## 1. Introduction

Ce guide explique comment programmer un robot autonome utilisant le **REV Robotics Expansion Hub** dans le cadre de la compétition **FIRST Tech Challenge (FTC)**. Nous allons coder en **Java** via **Android Studio** et utiliser le **FTC SDK**.

---

## 2. Prérequis

- **Matériel** :
  - Robot équipé du **REV Expansion Hub**
  - Moteurs DC et servomoteurs compatibles
  - Capteurs (gyroscope, capteurs de distance, caméra, etc.)
- **Logiciel** :
  - **Android Studio**
  - **SDK FTC**

### Installation

1. Téléchargez et installez **Android Studio**.
2. Clonez le dépôt officiel **FTC SDK** depuis GitHub.
3. Ouvrez le projet dans **Android Studio**.
4. Connectez votre robot et testez la communication.

---

## 3. Création d’un OpMode Autonome

Dans Android Studio, créez une nouvelle classe Java pour votre mode autonome.

### Exemple de Code Basique

```java
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Autonomous Mode Example")
public class AutonomousExample extends LinearOpMode {

	private DcMotor leftMotor;
	private DcMotor rightMotor;

	@Override
	public void runOpMode() {
    	// Initialisation des moteurs
    	leftMotor = hardwareMap.get(DcMotor.class, "left_drive");
    	rightMotor = hardwareMap.get(DcMotor.class, "right_drive");
   	 
    	// Attente du signal de départ
    	waitForStart();
   	 
    	// Avancer pendant 2 secondes
    	leftMotor.setPower(0.5);
    	rightMotor.setPower(0.5);
    	sleep(2000);
   	 
    	// Arrêt
    	leftMotor.setPower(0);
    	rightMotor.setPower(0);
	}
}
```

---

## 4. Amélioration avec les Capteurs

### Utilisation du Gyroscope (IMU)

L’IMU permet au robot de tourner avec précision.

```java
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

private BNO055IMU imu;

// Initialisation
imu = hardwareMap.get(BNO055IMU.class, "imu");

// Exemple de correction d’orientation
double angle = imu.getAngularOrientation().firstAngle;
if (angle < 0) {
	leftMotor.setPower(0.5);
	rightMotor.setPower(-0.5);
}
```

### Utilisation des Capteurs de Distance

```java
import com.qualcomm.robotcore.hardware.DistanceSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

private DistanceSensor sensor;

// Initialisation
sensor = hardwareMap.get(DistanceSensor.class, "distance_sensor");

double distance = sensor.getDistance(DistanceUnit.CM);
if (distance < 10) {
	leftMotor.setPower(0);
	rightMotor.setPower(0);
}
```

---

## 5. Autres Exemples et Techniques

### Utilisation des Encodeurs pour un Déplacement Précis

Les encodeurs permettent d'avoir des distances précises au lieu de dépendre du `sleep()`.

```java
leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

leftMotor.setTargetPosition(1000);
rightMotor.setTargetPosition(1000);

leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

leftMotor.setPower(0.5);
rightMotor.setPower(0.5);

while (leftMotor.isBusy() && rightMotor.isBusy()) {
	idle();
}

leftMotor.setPower(0);
rightMotor.setPower(0);
```

### Gestion des Erreurs et Débogage

1. **Vérifiez les connexions matérielles** : Assurez-vous que tous les composants sont bien connectés et déclarés correctement dans le code.
2. **Utilisez **`` pour afficher des informations en temps réel dans la console.
3. **Évitez les blocages** : N’utilisez pas trop de `sleep()`, préférez `while` avec une condition d'arrêt.
4. **Gérez les exceptions** : Enveloppez les parties critiques dans des blocs `try-catch` pour éviter les plantages.

Exemple de debug avec `telemetry` :

```java
telemetry.addData("Position Left Motor:", leftMotor.getCurrentPosition());
telemetry.addData("Position Right Motor:", rightMotor.getCurrentPosition());
telemetry.update();
```

---

## 6. Optimisation

- **Utilisation des Encoders** pour des déplacements précis
- **Fusion des capteurs** pour plus de précision
- **Planification de trajectoires** avec des courbes et ralentissements progressifs

---

## 7. Test et Débogage

- **Vérifiez les connexions matérielles**
- **Affichez des logs** avec `telemetry.addData()`
- **Testez sur le terrain** pour ajuster les valeurs

---

## 8. Conclusion

Ce tutoriel donne une base pour programmer un robot autonome en FTC. Il peut être enrichi avec la vision par ordinateur et des algorithmes plus avancés ! 🚀



