package org.firstinspires.ftc.teamcode.FTCLib.subsystems.BetaBotSubsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.CRServo;

public class CRIntakeSubsystem extends SubsystemBase {

    private CRServo intake;

    public CRIntakeSubsystem(CRServo intake) {
        this.intake = intake;
    }

    public void intakeIn() {
        intake.set(0.2);
    }
    public void intakeOut() {
        intake.set(-0.2);
    }
    public void intakeStop() {
        intake.set(0.0);
    }

}
