package org.firstinspires.ftc.teamcode.FTCLib.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.FTCLib.drive.MecanumDrive;

public class DriveSubsystem extends SubsystemBase {

    private MecanumDrive drive;
    private Motor lb, lf, rb, rf;
    private RevIMU imu;
    private Telemetry telemetry;
    private boolean isFieldCentric = false;

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
