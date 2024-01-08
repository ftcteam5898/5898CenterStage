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
        joint.rotateByAngle(-1.5);
    }
    public void resetJoint() {
        joint.rotateBy(1.0);
    }
    public void scoreArm() {
        arm.turnToAngle(-24.0);
    }
    public void resetArm() {
        arm.turnToAngle(0.0);
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

}
