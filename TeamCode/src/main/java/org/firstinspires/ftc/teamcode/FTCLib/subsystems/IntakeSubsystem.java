package org.firstinspires.ftc.teamcode.FTCLib.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.DcMotor;

public class IntakeSubsystem extends SubsystemBase {

    private Motor intake;
    private Motor rotate;

    public IntakeSubsystem(Motor intake, Motor rotate) {
        this.intake = intake;
        this.rotate = rotate;
        intake.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        rotate.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
    }

    public void rotateIn() {
        intake.set(0.5);
        }
    public void rotateOut() {
        intake.set(-0.45);
    }
    public void stopIntake() {
        intake.set(0.0);
    }
    public void turnUp() {
        rotate.set(0.2);
    }
    public void turnDown() {
        rotate.set(-0.2);
    }
    public void stopTurn() {
        rotate.set(0.0);
    }
    public void brakeRotate() {
        rotate.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
    }

    }


