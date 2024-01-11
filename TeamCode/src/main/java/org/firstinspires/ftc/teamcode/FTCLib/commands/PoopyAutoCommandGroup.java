package org.firstinspires.ftc.teamcode.FTCLib.commands;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.BetaBotSubsystems.ScoreSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.MecanumDriveSubsystem;

import java.util.function.IntSupplier;

public class PoopyAutoCommandGroup extends SequentialCommandGroup {

    private ElapsedTime time = new ElapsedTime();
    private MecanumDriveSubsystem mecanumDriveSubsystem;
    private LiftSubsystem liftSubsystem;
    private ScoreSubsystem scoreSubsystem;
    private IntSupplier sugma;
    private boolean hell;
    private final Pose2d startPos = new Pose2d(-60.24, 11.87, 0.0);

    public PoopyAutoCommandGroup(MecanumDriveSubsystem mecanumDriveSubsystem, LiftSubsystem liftSubsystem,
                                 ScoreSubsystem scoreSubsystem, ElapsedTime time, IntSupplier sugma) {
        mecanumDriveSubsystem.setPoseEstimate(startPos);

        Trajectory traj1 = mecanumDriveSubsystem.trajectoryBuilder(startPos)
                .lineToSplineHeading(new Pose2d(-36.73, 12.77, Math.toRadians(0.0)))
                .build();
        Trajectory traj2 = mecanumDriveSubsystem.trajectoryBuilder(traj1.end())
                .lineToSplineHeading(new Pose2d(-36.73, 53.01, Math.toRadians(90.0)))
                .build();
        Trajectory traj3 = mecanumDriveSubsystem.trajectoryBuilder(traj2.end())
                .splineTo(new Vector2d(-57.98, 56.18), Math.toRadians(270.0))
                .build();


        addCommands(


        );
    }

    /*
    TrajectorySequence untitled0 = drive.trajectorySequenceBuilder(new Pose2d(-60.24, 11.87, Math.toRadians(0.00)))
.splineTo(new Vector2d(-36.73, 12.77), Math.toRadians(2.20))
.lineToSplineHeading(new Pose2d(-36.73, 53.01, Math.toRadians(90.00)))
.splineTo(new Vector2d(-57.98, 56.18), Math.toRadians(171.53))
.build();

     */
}
