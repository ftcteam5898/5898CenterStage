package org.firstinspires.ftc.teamcode.FTCLib.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.FTCLib.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.RoadRunner.util.Encoder;

public class DriveSubsystem extends SubsystemBase {

    private MecanumDrive drive;
    private Motor lb, lf, rb, rf;
    private RevIMU imu;
    private Telemetry telemetry;
    private boolean isFieldCentric = false;
    private Encoder lbe, lfe, rbe, rfe;
    private GamepadEx Adam;

    private double wheelDiameter  = 3.6;
    private int pulses;

    public DriveSubsystem(Motor frontLeft, Motor frontRight, Motor backLeft, Motor backRight) {
        rf = frontRight;
        lf = frontLeft;
        lb = backLeft;
        rb = backRight;
        isFieldCentric = false;
        drive = new MecanumDrive(lf, rf, lb, rb);
    }
    public DriveSubsystem(Motor frontLeft, Motor frontRight, Motor backLeft, Motor backRight, RevIMU rev) {
        rf = frontRight;
        lf = frontLeft;
        lb = backLeft;
        rb = backRight;
        isFieldCentric = true;
        drive = new MecanumDrive(lf, rf, lb, rb);
        imu = rev;
    }
    public DriveSubsystem(Motor frontLeft, Motor frontRight, Motor backLeft, Motor backRight, boolean auto) {
        rf = frontRight;
        lf = frontLeft;
        lb = backLeft;
        rb = backRight;
    }
    public void resetEncoders() {
        lb.resetEncoder();
        lf.resetEncoder();
        rb.resetEncoder();
        rf.resetEncoder();
    }
    public void strafe(int amt, double power) {
        rf.setTargetPosition(rf.getCurrentPosition() - amt);
        rb.setTargetPosition(rb.getCurrentPosition() + amt);
        lf.setTargetPosition(lf.getCurrentPosition() + amt);
        lb.setTargetPosition(lb.getCurrentPosition() - amt);
        allPower(power);
    }
    public void lStrafe(int amt, double power) {
        rf.setTargetPosition(rf.getCurrentPosition() - amt);
        rb.setTargetPosition(rb.getCurrentPosition() + amt);
        lf.setTargetPosition(lf.getCurrentPosition() + amt);
        lb.setTargetPosition(lb.getCurrentPosition() - amt);
        allPower(power);
        rf.setInverted(true);
        rb.setInverted(true);
        lf.setInverted(true);
        lb.setInverted(true);
    }
    public void leftAmt(int amt, double power) {
        rf.setTargetPosition(rf.getCurrentPosition() + amt);
        rb.setTargetPosition(rb.getCurrentPosition() + amt);
        lf.setTargetPosition(lf.getCurrentPosition() - amt);
        lb.setTargetPosition(lb.getCurrentPosition() - amt);
        allPower(power);
    }
    public void rightAmt(int amt, double power) {
        rf.setTargetPosition(rf.getCurrentPosition() - amt);
        rb.setTargetPosition(rb.getCurrentPosition() - amt);
        lf.setTargetPosition(lf.getCurrentPosition() + amt);
        lb.setTargetPosition(lb.getCurrentPosition() + amt);
        allPower(power);
    }
    public void backAmt(int amt, double power) {
        rf.setTargetPosition(rf.getCurrentPosition() - amt);
        rb.setTargetPosition(rb.getCurrentPosition() - amt);
        lf.setTargetPosition(lf.getCurrentPosition() - amt);
        lb.setTargetPosition(lb.getCurrentPosition() - amt);

        allPower(power);
    }
    public void forwardAmt(int amt, double power) {
        rf.setTargetPosition(rf.getCurrentPosition() + amt);
        rb.setTargetPosition(rb.getCurrentPosition() + amt);
        lf.setTargetPosition(lf.getCurrentPosition() + amt);
        lb.setTargetPosition(lb.getCurrentPosition() + amt);

        allPower(power);
    }
    public void stopRobot() {
        rf.set(0);
        lf.set(0);
        rb.set(0);
        lb.set(0);
    }
     public void allPower(double power) {
         rf.set(power);
         rb.set(power);
         lf.set(power);
         lb.set(power);

    }
        public void drive(double strafeSpeed, double forwardSpeed, double turnSpeed) {
        if (isFieldCentric) {
            drive.driveFieldCentric(-strafeSpeed, -forwardSpeed, -turnSpeed, imu.getHeading(), true);
        }
        else {
            drive.driveRobotCentric(-strafeSpeed, -forwardSpeed, -turnSpeed, true);
        }
    }
    public void stopDrive() {
        drive.stop();
    }

}
