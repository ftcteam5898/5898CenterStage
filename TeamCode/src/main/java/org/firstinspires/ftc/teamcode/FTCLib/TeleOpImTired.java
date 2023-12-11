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

import org.firstinspires.ftc.teamcode.FTCLib.commands.AlphaBotStuff.BumpCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.AlphaBotStuff.DroneCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.AlphaBotStuff.IntakeCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.AlphaBotStuff.ClawCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.LiftCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.AlphaBotStuff.RotateIntakeCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands.DriveCommand;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.AlphaBotSubsystems.ClawSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.AlphaBotSubsystems.DroneSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.AlphaBotSubsystems.IntakeSubsystem;
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
    private DroneSubsystem droneSubsystem;
    private DriveSubsystem driveSubsystem;
    private MecanumDrive drive;
    private DriveCommand driveCommand;
    private SimpleServo claw, rotateClaw;
    private SimpleServo drone;

    @Override
    public void initialize() {

        Adam = new GamepadEx(gamepad1);
        Scott = new GamepadEx(gamepad2);
        revIMU = new RevIMU(hardwareMap);
        revIMU.init();

        //schedule(new InstantCommand(() -> droneSubsystem.initDrone()));
        lb = new Motor(hardwareMap, "lb", Motor.GoBILDA.RPM_435);
        lf = new Motor(hardwareMap, "lf", Motor.GoBILDA.RPM_435);
        rb = new Motor(hardwareMap, "rb", Motor.GoBILDA.RPM_435);
        rf = new Motor(hardwareMap, "rf", Motor.GoBILDA.RPM_435);

        leftLift = new Motor(hardwareMap, "left");
        rightLift = new Motor(hardwareMap, "right");

        intake = new Motor(hardwareMap, "intake");
        rotate = new Motor(hardwareMap, "rotate");

        claw = new SimpleServo(hardwareMap, "claw", -90, 90);
        //rotateClaw = new SimpleServo(hardwareMap, "rotateClaw", -90, 90);
        drone = new SimpleServo(hardwareMap, "drone", -90, 90);

        //drive = new MecanumDrive(lf, rf, lb, rb);
        intakeSubsystem = new IntakeSubsystem(intake, rotate);
        clawSubsystem = new ClawSubsystem(claw, rotateClaw);
        liftSubsystem = new LiftSubsystem(leftLift, rightLift);
        droneSubsystem = new DroneSubsystem(drone);
        driveSubsystem = new DriveSubsystem(lf, rf, lb, rb, revIMU);

        driveCommand = new DriveCommand(driveSubsystem, Adam::getLeftX, Adam::getLeftY,
                Adam::getRightX);

        RevIMU imu = new RevIMU(hardwareMap);
        imu.init();

        //intake
        ButtonReader xreader = new ButtonReader(Scott, GamepadKeys.Button.X);
        Scott.getGamepadButton(GamepadKeys.Button.X)
                        .whenHeld(new IntakeCommand(intakeSubsystem,
                                1, xreader.wasJustReleased()));
        ButtonReader yreader = new ButtonReader(Scott, GamepadKeys.Button.Y);
        Scott.getGamepadButton(GamepadKeys.Button.Y)
                .whenHeld(new IntakeCommand(intakeSubsystem,
                        2, yreader.wasJustReleased()));
        //rotate intake
        ButtonReader upreader = new ButtonReader(Scott, GamepadKeys.Button.DPAD_UP);
        Scott.getGamepadButton(GamepadKeys.Button.DPAD_UP)
                        .whenHeld(new RotateIntakeCommand(intakeSubsystem,
                                1, upreader.wasJustReleased()));
        ButtonReader downreader = new ButtonReader(Scott, GamepadKeys.Button.DPAD_DOWN);
        Scott.getGamepadButton(GamepadKeys.Button.DPAD_DOWN)
                .whenHeld(new RotateIntakeCommand(intakeSubsystem,
                        2, downreader.wasJustReleased()));
        //bucket
        Scott.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .toggleWhenPressed(new ClawCommand(clawSubsystem, true),
                        new ClawCommand(clawSubsystem, false));
        Scott.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                        .toggleWhenPressed(new BumpCommand(clawSubsystem, true),
                                new BumpCommand(clawSubsystem, false));
        //slides
        Scott.getGamepadButton(GamepadKeys.Button.A)
                .whenHeld(new LiftCommand(liftSubsystem, 1));
        Scott.getGamepadButton(GamepadKeys.Button.B)
                .whenHeld(new LiftCommand(liftSubsystem, 2));
        //plane
        Adam.getGamepadButton(GamepadKeys.Button.X)
            .whenPressed(new DroneCommand(droneSubsystem));
        Adam.getGamepadButton(GamepadKeys.Button.Y)
                .whenPressed(() -> droneSubsystem.initDrone());

        register(driveSubsystem);
        driveSubsystem.setDefaultCommand(driveCommand);
    }

}
