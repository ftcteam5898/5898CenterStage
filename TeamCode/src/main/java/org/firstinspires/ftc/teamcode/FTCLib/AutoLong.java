package org.firstinspires.ftc.teamcode.FTCLib;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.WaitUntilCommand;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.FTCLib.commands.MonkeCommandGroup;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.AlphaBotSubsystems.ClawSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.AlphaBotSubsystems.DroneSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.AlphaBotSubsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.RoadRunner.drive.SampleMecanumDrive;

@Autonomous(name = "AutoLong")
public class AutoLong extends CommandOpMode {

    private DriveSubsystem driveSubsystem;
    private LiftSubsystem liftSubsystem;
    private IntakeSubsystem intakeSubsystem;
    private ClawSubsystem clawSubsystem;
    private DroneSubsystem droneSubsystem;
    private MecanumDriveSubsystem mecanumDriveSubsystem;
    private Motor rightLift, leftLift;
    private Motor lb, rb, rf, lf;
    private Motor intake, rotate;
    private SimpleServo claw, rotateClaw, drone;
    private ElapsedTime time;

    @Override
    public void initialize() {

        //rightLift = new Motor(hardwareMap, "rightLift");
        //leftLift = new Motor(hardwareMap, "leftLift");

        time = new ElapsedTime();

        lb = new Motor(hardwareMap, "lb", Motor.GoBILDA.RPM_435); //
        lf = new Motor(hardwareMap, "lf", Motor.GoBILDA.RPM_435); //
        rb = new Motor(hardwareMap, "rb", Motor.GoBILDA.RPM_435); //
        rf = new Motor(hardwareMap, "rf", Motor.GoBILDA.RPM_435); //

        intake = new Motor(hardwareMap, "intake");
        rotate = new Motor(hardwareMap, "rotate");

        claw = new SimpleServo(hardwareMap, "claw", -90, 90);
        drone = new SimpleServo(hardwareMap, "drone", -90, 90);

        rf.setInverted(true);
        lf.setInverted(true);

        driveSubsystem = new DriveSubsystem(lf, rf, lb, rb, true);
        clawSubsystem = new ClawSubsystem(claw, rotateClaw);
        intakeSubsystem = new IntakeSubsystem(intake, rotate);
        droneSubsystem = new DroneSubsystem(drone);
        mecanumDriveSubsystem = new MecanumDriveSubsystem(new SampleMecanumDrive(hardwareMap), false);


        //schedule(new InstantCommand(() -> intakeSubsystem.turnDown()));
        schedule(new InstantCommand(() -> intakeSubsystem.brakeRotate()));
        schedule(new InstantCommand(() -> droneSubsystem.initDrone()));


        schedule(new WaitUntilCommand(this :: isStarted)
                .andThen(new InstantCommand(() -> driveSubsystem.forwardAmt(10, 0.2)))
                .andThen(new MonkeCommandGroup(mecanumDriveSubsystem)));

    }
    }

