package org.firstinspires.ftc.teamcode.FTCLib.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.DcMotor;

public class IntakeSubsystem extends SubsystemBase {

    private Motor intake;

    public IntakeSubsystem(Motor intake) {
        this.intake = intake;
    }

    public void rotateIn() {
        intake.set(10.0);
        }
    public void rotateOut() {
        intake.set(-10.0);
    }
    public void stopIntake() {
        intake.set(0.0);
    }
    }


