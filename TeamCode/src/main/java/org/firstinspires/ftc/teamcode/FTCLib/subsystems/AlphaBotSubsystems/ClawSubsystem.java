package org.firstinspires.ftc.teamcode.FTCLib.subsystems.AlphaBotSubsystems;


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
        claw.setPosition(1.0);
    }
    public void bumpUp() {
        claw.setPosition(0.7);
    }
    public void bumpDown() {
        claw.setPosition(0.5);
    }

    public void closeClaw() {
        claw.setPosition(0.5); // placeholder number
    }
}
