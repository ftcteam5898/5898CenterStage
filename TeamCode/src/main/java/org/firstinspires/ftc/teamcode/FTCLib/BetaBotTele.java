package org.firstinspires.ftc.teamcode.FTCLib;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.FTCLib.commands.LiftCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands.DriveCommand;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.LiftSubsystem;

@TeleOp(name = "MikhailLovell", group = "tele")
public class BetaBotTele extends CommandOpMode {

    private GamepadEx Adam, Scott;
    private GamepadKeys.Trigger left, right;
    private RevIMU revIMU;
    private Motor lb, lf, rb, rf;
    private Motor leftLift, rightLift;
    private DriveSubsystem driveSubsystem;
    private LiftSubsystem liftSubsystem;
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

        leftLift = new Motor(hardwareMap, "left");
        rightLift = new Motor(hardwareMap, "right");

        //subsystem declarations
        liftSubsystem = new LiftSubsystem(leftLift, rightLift);
        driveSubsystem = new DriveSubsystem(lf, rf, lb, rb, revIMU);

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

        register(driveSubsystem);
        driveSubsystem.setDefaultCommand(driveCommand);
    }
}
