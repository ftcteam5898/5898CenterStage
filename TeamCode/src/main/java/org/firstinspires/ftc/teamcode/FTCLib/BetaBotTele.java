package org.firstinspires.ftc.teamcode.FTCLib;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.FTCLib.commands.BetaBotStuff.CRIntakeCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.BetaBotStuff.ClimbCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.BetaBotStuff.GrabberCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.BetaBotStuff.SwingCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.LiftCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands.DriveCommand;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.BetaBotSubsystems.CRIntakeSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.BetaBotSubsystems.ClimbSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.BetaBotSubsystems.ScoreSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.LiftSubsystem;

@TeleOp(name = "MikhailLovell", group = "tele")
public class BetaBotTele extends CommandOpMode {

    private GamepadEx Adam, Scott;
    private GamepadKeys.Trigger left, right;
    private RevIMU revIMU;
    private Motor lb, lf, rb, rf;
    private Motor leftLift, rightLift;
    private Motor climbLeft, climbRight;
    private CRServo intake, grabber;
    private SimpleServo arm, joint;
    private DriveSubsystem driveSubsystem;
    private LiftSubsystem liftSubsystem;
    private ClimbSubsystem climbSubsystem;
    private CRIntakeSubsystem intakeSubsystem;
    private ScoreSubsystem scoreSubsystem;
    private DriveCommand driveCommand;

    @Override
    public void initialize() {

        // naming gamepads after drivers to make things simpler
        Adam = new GamepadEx(gamepad1);
        Scott = new GamepadEx(gamepad2);
        // miles said scott has been doing robotics for 11 years in the portfolio what a bozo
        // hardware declarations
        revIMU = new RevIMU(hardwareMap);
        revIMU.init();

        lb = new Motor(hardwareMap, "lb", Motor.GoBILDA.RPM_435);
        lf = new Motor(hardwareMap, "lf", Motor.GoBILDA.RPM_435);
        rb = new Motor(hardwareMap, "rb", Motor.GoBILDA.RPM_435);
        rf = new Motor(hardwareMap, "rf", Motor.GoBILDA.RPM_435);
        rf.setInverted(true);

        leftLift = new Motor(hardwareMap, "left");
        rightLift = new Motor(hardwareMap, "right");

        climbLeft = new Motor(hardwareMap, "lscrew");
        climbRight = new Motor(hardwareMap, "rscrew");

        intake = new CRServo(hardwareMap, "intake");
        arm = new SimpleServo(hardwareMap, "arm", -90.0,90.0);
        joint = new SimpleServo(hardwareMap, "joint", -90.0, 90.0);
        grabber = new CRServo(hardwareMap, "grabber");

        //subsystem declarations
        liftSubsystem = new LiftSubsystem(leftLift, rightLift);
        driveSubsystem = new DriveSubsystem(lf, rf, lb, rb, revIMU);
        climbSubsystem = new ClimbSubsystem(climbLeft, climbRight);
        intakeSubsystem = new CRIntakeSubsystem(intake);
        scoreSubsystem = new ScoreSubsystem(arm, joint, grabber);

        // drive command doo doo
        driveCommand = new DriveCommand(driveSubsystem, Adam::getLeftX, Adam::getLeftY,
                Adam::getRightX);

        RevIMU imu = new RevIMU(hardwareMap);
        imu.init();

        //slides
        Scott.getGamepadButton(GamepadKeys.Button.A)
                .whenHeld(new LiftCommand(liftSubsystem, 1));
        Scott.getGamepadButton(GamepadKeys.Button.B)
                .whenHeld(new LiftCommand(liftSubsystem, 2));
        //upya
        Scott.getGamepadButton(GamepadKeys.Button.DPAD_UP)
                        .whenHeld(new ClimbCommand(climbSubsystem, 2));
        Scott.getGamepadButton(GamepadKeys.Button.DPAD_DOWN)
                        .whenHeld(new ClimbCommand(climbSubsystem, 1));
        //intake
        Scott.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT)
                        .whenHeld(new CRIntakeCommand(intakeSubsystem, 2));
        Scott.getGamepadButton(GamepadKeys.Button.DPAD_LEFT)
                .whenHeld(new CRIntakeCommand(intakeSubsystem, 1));
        //swing
        Scott.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .toggleWhenPressed(new SwingCommand(scoreSubsystem, 1), new SwingCommand(
                        scoreSubsystem, 2));
        //testing
        Scott.getGamepadButton(GamepadKeys.Button.Y)
                        .whenHeld(new GrabberCommand(scoreSubsystem, 1));
        Scott.getGamepadButton(GamepadKeys.Button.X)
                .whenHeld(new GrabberCommand(scoreSubsystem, 2));

        register(driveSubsystem);
        driveSubsystem.setDefaultCommand(driveCommand);
    }
}
