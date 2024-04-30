package org.firstinspires.ftc.teamcode.FTCLib.subsystems.BetaBotSubsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.CRServo;

public class ScoreSubsystem extends SubsystemBase {

    private SimpleServo arm, joint;
    private CRServo grabber;

    public ScoreSubsystem(SimpleServo arm, SimpleServo joint, CRServo grabber) {
        this.arm = arm;
        this.joint = joint;
        this.grabber = grabber;
    }

    public void scoreJoint() {
        joint.turnToAngle(-360.0);
    }
    public void resetJoint() {
        joint.turnToAngle(-35.0);
    }
    public void scoreArm() {
        arm.turnToAngle(-43.0);
    }
    public void pickUpArm() {
        arm.turnToAngle(5.0);
    }
    public void pickUpJoint() {
        joint.turnToAngle(5.0);
    }
    public void resetArm() {
        arm.turnToAngle(-8.0);
    }
    public void scoreGrabber() {
        grabber.set(0.2);
    }
    public void resetGrabber() {
        grabber.set(-0.2);
    }
    public void stopGrabber() {
        grabber.set(0.0);
    }
    public void stopArm() {
        arm.disable();
    }
    public void stopJoint() {
        joint.disable();
    }

}
