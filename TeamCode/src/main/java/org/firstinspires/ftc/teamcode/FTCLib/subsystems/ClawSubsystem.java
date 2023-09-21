package org.firstinspires.ftc.teamcode.FTCLib.subsystems;


import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SimpleServo;

public class ClawSubsystem extends SubsystemBase {

    private SimpleServo claw1Servo;
    private SimpleServo claw2Servo;
    private SimpleServo rotateServo;
    private SimpleServo liftServo;

    public ClawSubsystem(SimpleServo claw1Servo,SimpleServo claw2Servo,
                         SimpleServo rotateServo, SimpleServo liftServo) {
        this.claw1Servo = claw1Servo;
        this.claw2Servo = claw2Servo;
        this.rotateServo = rotateServo;
        this.liftServo = liftServo;
    }
    // rework this idea to have a incremental movement instead of a toggle
    public void rotateClaw() {
        rotateServo.setPosition(10.0); // placeholder number
    }
    public void liftClaw() {
        liftServo.setPosition(10.0); // placeholder number
    }
    public void openClaw1() {
        claw1Servo.setPosition(10.0); // placeholder number
    }
    public void openClaw2() {
        claw2Servo.setPosition(10.0); // placehodler number
    }
    public void openClaws() {
        claw1Servo.setPosition(10.0); //placeholder number
        claw2Servo.setPosition(10.0); //placeholder number
    }
    public void closeClaw1() {
        claw1Servo.setPosition(10.0); // placeholder number
    }
    public void closeClaw2() {
        claw2Servo.setPosition(10.0); // placeholder number
    }
    public void closeClaws() {
        claw1Servo.setPosition(10.0); //placeholder number
        claw2Servo.setPosition(10.0); //placeholder number
    }
}
