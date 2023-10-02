package org.firstinspires.ftc.teamcode.FTCLib;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.ButtonReader;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.FTCLib.commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.IntakeSubsystem;

@TeleOp(name = "SleepyTime", group = "tele")
public class TeleOpImTired extends CommandOpMode {

    private GamepadEx Adam, Scott;
    private GamepadKeys.Trigger left, right;
    private RevIMU revIMU;
    private Motor lb, lf, rb, rf;
    private Motor intake;
    private IntakeSubsystem intakeSubsystem;
    private MecanumDrive drive;

    @Override
    public void initialize() {

        Adam = new GamepadEx(gamepad1);
        Scott = new GamepadEx(gamepad2);

        lb = new Motor(hardwareMap, "lb", Motor.GoBILDA.RPM_435);
        lf = new Motor(hardwareMap, "lf", Motor.GoBILDA.RPM_435);
        rb = new Motor(hardwareMap, "rb", Motor.GoBILDA.RPM_435);
        rf = new Motor(hardwareMap, "rf", Motor.GoBILDA.RPM_435);

        drive = new MecanumDrive(lf, rf, lb, rb);
        intakeSubsystem = new IntakeSubsystem(intake);

        rf.setInverted(true);
        lf.setInverted(true);

        RevIMU imu = new RevIMU(hardwareMap);
        imu.init();

        drive.driveFieldCentric(
                Adam.getLeftX(),
                Adam.getLeftY(),
                Adam.getRightX(),
                imu.getRotation2d().getDegrees(),   // gyro value passed in here must be in degrees
                false
        );
        ButtonReader breader = new ButtonReader(Scott, GamepadKeys.Button.B);
        Scott.getGamepadButton(GamepadKeys.Button.B)
                        .whenHeld(new IntakeCommand(intakeSubsystem,
                                1, breader.wasJustReleased()));
    }

}
