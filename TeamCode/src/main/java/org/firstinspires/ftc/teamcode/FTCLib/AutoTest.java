package org.firstinspires.ftc.teamcode.FTCLib;

import com.acmerobotics.roadrunner.drive.Drive;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitUntilCommand;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.FTCLib.commands.AutoTestCommandGroup;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.ClawSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.LiftSubsystem;

@Autonomous(name = "TestAuto")
public class AutoTest extends CommandOpMode {

    private DriveSubsystem driveSubsystem;
    private LiftSubsystem liftSubsystem;
    private IntakeSubsystem intakeSubsystem;
    private ClawSubsystem clawSubsystem;
    private Motor rightLift, leftLift;
    private Motor lb, rb, rf, lf;
    private Motor intake, rotate;
    private SimpleServo claw, rotateClaw;


    @Override
    public void initialize() {

        //rightLift = new Motor(hardwareMap, "rightLift");
        //leftLift = new Motor(hardwareMap, "leftLift");

        lb = new Motor(hardwareMap, "lb", Motor.GoBILDA.RPM_435); //
        lf = new Motor(hardwareMap, "lf", Motor.GoBILDA.RPM_435); //
        rb = new Motor(hardwareMap, "rb", Motor.GoBILDA.RPM_435); //
        rf = new Motor(hardwareMap, "rf", Motor.GoBILDA.RPM_435); //

        claw = new SimpleServo(hardwareMap, "claw", -90, 90);

        rf.setInverted(true);
        lf.setInverted(true);

        driveSubsystem = new DriveSubsystem(lf, rf, lb, rb, true);
        clawSubsystem = new ClawSubsystem(claw, rotateClaw);


        //schedule(new InstantCommand(() -> intakeSubsystem.turnDown()));


        schedule(new WaitUntilCommand(this :: isStarted)
                .andThen(new InstantCommand(() -> driveSubsystem.forwardAmt(10, 0.2)))
                .andThen(new AutoTestCommandGroup(driveSubsystem)));

    }







    }

