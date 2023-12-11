package org.firstinspires.ftc.teamcode.FTCLib.subsystems.BetaBotSubsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class ClimbSubsystem extends SubsystemBase {

    private Motor leftClimb, rightClimb;
    // i copied the entire lift subsystem cause i am not coding this

    public ClimbSubsystem(Motor leftClimb, Motor rightClimb) {
        this.leftClimb = leftClimb;
        this.rightClimb = rightClimb;
        int leftPos = leftClimb.getCurrentPosition();
        double leftVel = leftClimb.getCorrectedVelocity();
        Motor.Encoder leftEncoder = leftClimb.encoder;
        double leftRevolutions = leftEncoder.getRevolutions();
        leftEncoder.setDistancePerPulse(2.0);
        double leftDistance = leftEncoder.getDistance();
        int rightPos = rightClimb.getCurrentPosition();
        double rightVel = rightClimb.getCorrectedVelocity();
        Motor.Encoder rightEncoder = rightClimb.encoder;
        double rightRevolutions = rightEncoder.getRevolutions();
        rightEncoder.setDistancePerPulse(2.0);
        double rightDistance = rightEncoder.getDistance();
        leftClimb.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        rightClimb.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
    }
    public Motor getLeftClimb() {
        return leftClimb;
    }
    public Motor getRightClimb() {
        return rightClimb;
    }
    public void motorsUp() {
        leftClimb.set(-0.7);
        leftClimb.setTargetPosition(leftClimb.getCurrentPosition() + 10);
        rightClimb.set(-0.7);
        rightClimb.setTargetPosition(rightClimb.getCurrentPosition() + 10);
    }
    public void motorsDown() {
        leftClimb.set(0.7);
        leftClimb.setTargetPosition(leftClimb.getCurrentPosition() - 10);
        rightClimb.set(0.7);
        rightClimb.setTargetPosition(rightClimb.getCurrentPosition() - 10);
    }
    public void motorsStop() {
        leftClimb.stopMotor();
        rightClimb.stopMotor();
    }
}
