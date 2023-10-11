package org.firstinspires.ftc.teamcode.FTCLib;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.ButtonReader;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.FTCLib.commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.ClawCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.LiftCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.RotateIntakeCommand;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.ClawSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.LiftSubsystem;

@TeleOp(name = "SleepyTime", group = "tele")
public class TeleOpImTired extends CommandOpMode {

    private GamepadEx Adam, Scott;
    private GamepadKeys.Trigger left, right;
    private RevIMU revIMU;
    private Motor lb, lf, rb, rf;
    private Motor intake, rotate, leftLift, rightLift;
    private IntakeSubsystem intakeSubsystem;
    private ClawSubsystem clawSubsystem;
    private LiftSubsystem liftSubsystem;
    private MecanumDrive drive;
    private SimpleServo claw, rotateClaw;

    @Override
    public void initialize() {

        Adam = new GamepadEx(gamepad1);
        Scott = new GamepadEx(gamepad2);

        lb = new Motor(hardwareMap, "lb", Motor.GoBILDA.RPM_435);
        lf = new Motor(hardwareMap, "lf", Motor.GoBILDA.RPM_435);
        rb = new Motor(hardwareMap, "rb", Motor.GoBILDA.RPM_435);
        rf = new Motor(hardwareMap, "rf", Motor.GoBILDA.RPM_435);

        leftLift = new Motor(hardwareMap, "left");
        rightLift = new Motor(hardwareMap, "right");

        claw = new SimpleServo(hardwareMap, "claw", -90, 90);
        rotateClaw = new SimpleServo(hardwareMap, "rotateClaw", -90, 90);

        drive = new MecanumDrive(lf, rf, lb, rb);
        intakeSubsystem = new IntakeSubsystem(intake, rotate);
        clawSubsystem = new ClawSubsystem(claw, rotateClaw);
        liftSubsystem = new LiftSubsystem(leftLift, rightLift);

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
        ButtonReader xreader = new ButtonReader(Scott, GamepadKeys.Button.X);
        Scott.getGamepadButton(GamepadKeys.Button.X)
                        .whenHeld(new IntakeCommand(intakeSubsystem,
                                1, xreader.wasJustReleased()));

        ButtonReader yreader = new ButtonReader(Scott, GamepadKeys.Button.Y);
        Scott.getGamepadButton(GamepadKeys.Button.Y)
                .whenHeld(new IntakeCommand(intakeSubsystem,
                        2, yreader.wasJustReleased()));

        ButtonReader upreader = new ButtonReader(Scott, GamepadKeys.Button.DPAD_UP);
        Scott.getGamepadButton(GamepadKeys.Button.DPAD_UP)
                        .whenHeld(new RotateIntakeCommand(intakeSubsystem,
                                1, upreader.wasJustReleased()));

        ButtonReader downreader = new ButtonReader(Scott, GamepadKeys.Button.DPAD_DOWN);
        Scott.getGamepadButton(GamepadKeys.Button.DPAD_DOWN)
                .whenHeld(new RotateIntakeCommand(intakeSubsystem,
                        1, downreader.wasJustReleased()));

        Scott.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .toggleWhenPressed(new ClawCommand(clawSubsystem, true),
                        new ClawCommand(clawSubsystem, false));

        Scott.getGamepadButton(GamepadKeys.Button.A)
                .whenHeld(new LiftCommand(liftSubsystem, 1));
        Scott.getGamepadButton(GamepadKeys.Button.A)
                .whenHeld(new LiftCommand(liftSubsystem, 2));


    }

}
