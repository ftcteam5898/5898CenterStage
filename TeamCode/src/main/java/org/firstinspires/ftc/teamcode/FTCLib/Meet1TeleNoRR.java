package org.firstinspires.ftc.teamcode.FTCLib;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Meet1Tele", group = "tele")
public class Meet1TeleNoRR extends LinearOpMode {

    static final boolean fieldCentric = true;

    private GamepadEx Adam, Scott;
    private GamepadKeys.Trigger left, right;
    private RevIMU revIMU;
    private Motor lb, lf, rb, rf;

    @Override
    public void runOpMode() throws InterruptedException {

        lb = new Motor(hardwareMap, "lb", Motor.GoBILDA.RPM_435);
        lf = new Motor(hardwareMap, "lf", Motor.GoBILDA.RPM_435);
        rb = new Motor(hardwareMap, "rb", Motor.GoBILDA.RPM_435);
        rf = new Motor(hardwareMap, "rf", Motor.GoBILDA.RPM_435);

        MecanumDrive drive = new MecanumDrive(lf, rf, lb, rb);

        lb.motor.setDirection(DcMotor.Direction.FORWARD);
        lf.motor.setDirection(DcMotor.Direction.FORWARD);

        RevIMU imu = new RevIMU(hardwareMap);
        imu.init();

        GamepadEx Adam = new GamepadEx(gamepad1);

        waitForStart();

        while (!isStopRequested()) {


            if (!fieldCentric) {
                drive.driveRobotCentric(
                        Adam.getLeftX(),
                        Adam.getLeftY(),
                        Adam.getRightX(),
                        false
                );
            }
            else {
                drive.driveFieldCentric(
                        Adam.getLeftX(),
                        Adam.getLeftY(),
                        Adam.getRightX(),
                        imu.getRotation2d().getDegrees(),   // gyro value passed in here must be in degrees
                        false
                );
            }
        }
    }
}
