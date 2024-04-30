package org.firstinspires.ftc.teamcode.FTCLib;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.ButtonReader;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands.DriveCommand;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.AlphaBotSubsystems.ClawSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.AlphaBotSubsystems.IntakeSubsystem;

import java.util.function.DoubleSupplier;
@Disabled
@TeleOp (name = "Meet1TeleNONO", group = "tele")
public class Meet1Tele extends CommandOpMode {

    private GamepadEx Adam, Scott;
    private GamepadKeys.Trigger left, right;
    private RevIMU revIMU;

    private DriveSubsystem driveSubsystem;
    private ClawSubsystem clawSubsystem;
    private IntakeSubsystem intakeSubsystem;

    private DriveCommand driveCommand;

    private Motor lb, lf, rb, rf;
    private Motor intake, rotate;

    @Override
    public void initialize() {

        lb = new Motor(hardwareMap, "lb");
        lf = new Motor(hardwareMap, "lf");
        rb = new Motor(hardwareMap, "rb");
        rf = new Motor(hardwareMap, "rf");
        //intake = new Motor(hardwareMap, "intake");
        revIMU = new RevIMU(hardwareMap);
        revIMU.init();

        lb.motor.setDirection(DcMotor.Direction.FORWARD);
        lf.motor.setDirection(DcMotor.Direction.FORWARD);

        driveSubsystem = new DriveSubsystem(lf, rf, lb, rb, revIMU);
        intakeSubsystem = new IntakeSubsystem(intake, rotate);

        Adam = new GamepadEx(gamepad1);
        Scott = new GamepadEx(gamepad2);

        double turn  = 0;
        if (Adam.getRightX() != 0) turn = Adam.getRightX();
        else turn = -1 * Adam.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) +
                Adam.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER);

        final double turnVal = turn;
        DoubleSupplier rightX = () -> turnVal;

        driveCommand = new DriveCommand(driveSubsystem, Adam::getLeftX, Adam::getLeftY,
                rightX);

        ButtonReader breader = new ButtonReader(Scott, GamepadKeys.Button.B);
/*
        Scott.getGamepadButton(GamepadKeys.Button.B)
                        .whenHeld(new IntakeCommand(intakeSubsystem,
                                1, breader.wasJustReleased()));

 */

        register(driveSubsystem);
        driveSubsystem.setDefaultCommand(driveCommand);
    }
}
