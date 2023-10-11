package org.firstinspires.ftc.teamcode.FTCLib.subsystems;


import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SimpleServo;

public class ClawSubsystem extends SubsystemBase {

    private SimpleServo claw, rotateServo;

    public ClawSubsystem(SimpleServo claw, SimpleServo rotateServo) {
        this.rotateServo = rotateServo;
        this.claw = claw;
    }

    // rework this idea to have a incremental movement instead of a toggle
    public void rotateClaw() {
        rotateServo.setPosition(10.0); // placeholder number
    }

    public void openClaw() {
        claw.setPosition(10.0); // placeholder number
    }

    public void closeClaw() {
        claw.setPosition(10.0); // placeholder number
    }
}
