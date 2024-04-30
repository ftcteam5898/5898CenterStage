package org.firstinspires.ftc.teamcode.FTCLib;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.command.WaitUntilCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.internal.system.Deadline;
import org.firstinspires.ftc.teamcode.FTCLib.commands.BetaBotStuff.CRIntakeCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.BetaBotStuff.ClimbCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.BetaBotStuff.GrabberCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.BetaBotStuff.PickupCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.BetaBotStuff.SwingCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.LiftCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands.DriveCommand;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.BetaBotSubsystems.CRIntakeSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.BetaBotSubsystems.ClimbSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.BetaBotSubsystems.ScoreSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.LiftSubsystem;

import java.util.concurrent.TimeUnit;

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
    private ElapsedTime time;
    private Blinkin blinkin;

    private final static int LED_PERIOD = 10;

    /*
     * Rate limit gamepad button presses to every 500ms.
     */
    private final static int GAMEPAD_LOCKOUT = 500;

    RevBlinkinLedDriver blinkinLedDriver;
    RevBlinkinLedDriver.BlinkinPattern pattern;

    Telemetry.Item patternName;
    Telemetry.Item display;
    Blinkin.DisplayKind displayKind;
    Deadline ledCycleDeadline;
    Deadline gamepadRateLimit;

    protected enum DisplayKind {
        MANUAL,
        AUTO
    }

    @Override
    public void initialize() {

        // led stuff
        displayKind = Blinkin.DisplayKind.AUTO;

        blinkinLedDriver = hardwareMap.get(RevBlinkinLedDriver.class, "blinkin");
        pattern = RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_LAVA_PALETTE; // color pattern
        blinkinLedDriver.setPattern(pattern);

        display = telemetry.addData("Display Kind: ", displayKind.toString());
        patternName = telemetry.addData("Pattern: ", pattern.toString());

        ledCycleDeadline = new Deadline(LED_PERIOD, TimeUnit.SECONDS);
        gamepadRateLimit = new Deadline(GAMEPAD_LOCKOUT, TimeUnit.MILLISECONDS);
        ledCycleDeadline.startTime();

        time = new ElapsedTime();
        time.reset();


        // naming gamepads after drivers to make things simpler
        Adam = new GamepadEx(gamepad1);
        Scott = new GamepadEx(gamepad2);
        // miles said scott has been doing robotics for 11 years in the portfolio what a bozo
        // hardware declarations
        revIMU = new RevIMU(hardwareMap);
        revIMU.init();

        RevBlinkinLedDriver blinkinLedDriver;
        RevBlinkinLedDriver.BlinkinPattern pattern;


        time = new ElapsedTime();

        lb = new Motor(hardwareMap, "lb", Motor.GoBILDA.RPM_435);
        lf = new Motor(hardwareMap, "lf", Motor.GoBILDA.RPM_435);
        rb = new Motor(hardwareMap, "rb", Motor.GoBILDA.RPM_435);
        rf = new Motor(hardwareMap, "rf", Motor.GoBILDA.RPM_435);
        lf.setInverted(false);

        leftLift = new Motor(hardwareMap, "left");
        rightLift = new Motor(hardwareMap, "right");

        climbLeft = new Motor(hardwareMap, "lscrew");
        climbRight = new Motor(hardwareMap, "rscrew");

        intake = new CRServo(hardwareMap, "intake");
        arm = new SimpleServo(hardwareMap, "arm", -90.0,90.0);
        joint = new SimpleServo(hardwareMap, "joint", -360.0, 90.0);
        grabber = new CRServo(hardwareMap, "grabber");

        //subsystem declarations
        liftSubsystem = new LiftSubsystem(leftLift, rightLift);
        driveSubsystem = new DriveSubsystem(lf, rf, lb, rb);
        climbSubsystem = new ClimbSubsystem(climbLeft, climbRight);
        intakeSubsystem = new CRIntakeSubsystem(intake);
        scoreSubsystem = new ScoreSubsystem(arm, joint, grabber);

        //led
        blinkin = new Blinkin();

        // drive command doo doo
        driveCommand = new DriveCommand(driveSubsystem, Adam::getLeftX, Adam::getLeftY,
                Adam::getRightX);

        RevIMU imu = new RevIMU(hardwareMap);
        imu.init();
                new RevHubOrientationOnRobot(
                        RevHubOrientationOnRobot.LogoFacingDirection.UP,
                        RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
                );

        //slides
        Scott.getGamepadButton(GamepadKeys.Button.A)
                .whenHeld(new LiftCommand(liftSubsystem, 1));
        Scott.getGamepadButton(GamepadKeys.Button.B)
                .whenHeld(new LiftCommand(liftSubsystem, 2));
        //upya
        Adam.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                        .whenHeld(new ClimbCommand(climbSubsystem, 2));
        Adam.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
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
        //grabber
        Scott.getGamepadButton(GamepadKeys.Button.DPAD_UP)
                        .whenHeld(new GrabberCommand(scoreSubsystem, 1));
        Scott.getGamepadButton(GamepadKeys.Button.DPAD_DOWN)
                .whenHeld(new GrabberCommand(scoreSubsystem, 2));
        Scott.getGamepadButton(GamepadKeys.Button.Y)
                        .whenPressed(new InstantCommand(() -> scoreSubsystem.scoreJoint()));
        Scott.getGamepadButton(GamepadKeys.Button.X)
                .whenPressed(new InstantCommand(() -> scoreSubsystem.resetJoint()));
        Scott.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                        .toggleWhenPressed(new PickupCommand(scoreSubsystem),
                                new SwingCommand(scoreSubsystem, 1));


        register(driveSubsystem);
        driveSubsystem.setDefaultCommand(driveCommand);


    }
}
