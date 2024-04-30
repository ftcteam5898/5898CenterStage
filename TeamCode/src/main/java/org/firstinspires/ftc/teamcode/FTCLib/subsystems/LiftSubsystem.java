package org.firstinspires.ftc.teamcode.FTCLib.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class LiftSubsystem extends SubsystemBase {

    private Motor leftLift;
    private Motor rightLift;

    public LiftSubsystem(Motor leftLift, Motor rightLift) {
        this.leftLift = leftLift;
        this.rightLift = rightLift;
        int leftPos = leftLift.getCurrentPosition();
        double leftVel = leftLift.getCorrectedVelocity();
        Motor.Encoder leftEncoder = leftLift.encoder;
        double leftRevolutions = leftEncoder.getRevolutions();
        leftEncoder.setDistancePerPulse(2.0);
        double leftDistance = leftEncoder.getDistance();
        int rightPos = rightLift.getCurrentPosition();
        double rightVel = rightLift.getCorrectedVelocity();
        Motor.Encoder rightEncoder = rightLift.encoder;
        double rightRevolutions = rightEncoder.getRevolutions();
        rightEncoder.setDistancePerPulse(2.0);
        double rightDistance = rightEncoder.getDistance();
        leftLift.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        rightLift.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
    }
    public Motor getLeftMotor() {
        return leftLift;
    }
    public Motor getRightMotor() {
        return rightLift;
    }

    public void motorsUp() {
        leftLift.set(-0.6);
        leftLift.setTargetPosition(leftLift.getCurrentPosition() + 10);
        rightLift.set(0.6);
        rightLift.setTargetPosition(rightLift.getCurrentPosition() - 10);
    }
    public void motorsDown() {
        leftLift.set(0.6);
        leftLift.setTargetPosition(leftLift.getCurrentPosition() - 10);
        rightLift.set(-0.6);
        rightLift.setTargetPosition(rightLift.getCurrentPosition() + 10);
    }
    public void motorsStop() {
        leftLift.stopMotor();
        rightLift.stopMotor();
    }
    public void motorHold() {
        if (leftLift.getCurrentPosition() <= -1000) {
            leftLift.set(-0.009);
            rightLift.set(0.009);
        }
        else if (leftLift.getCurrentPosition() <= -2000) {
            leftLift.set(-0.009);
            rightLift.set(0.009);
        }
    }
}