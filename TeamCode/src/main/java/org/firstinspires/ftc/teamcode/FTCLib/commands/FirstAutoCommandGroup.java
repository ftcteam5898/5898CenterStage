package org.firstinspires.ftc.teamcode.FTCLib.commands;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands.ForwardCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands.StrafeCommand;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.BetaBotSubsystems.ScoreSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.MecanumDriveSubsystem;

import java.util.function.IntSupplier;

public class FirstAutoCommandGroup extends SequentialCommandGroup {

    private ElapsedTime time = new ElapsedTime();
    private MecanumDriveSubsystem mecanumDriveSubsystem;
    private LiftSubsystem liftSubsystem;
    private ScoreSubsystem scoreSubsystem;
    private IntSupplier sugma;
    private boolean hell;
    private final Pose2d startPos = new Pose2d(58.44, -35.83, 180.0);


public FirstAutoCommandGroup(MecanumDriveSubsystem mecanumDriveSubsystem, LiftSubsystem liftSubsystem,
                             ScoreSubsystem scoreSubsystem, ElapsedTime time, IntSupplier sugma) {
    mecanumDriveSubsystem.setPoseEstimate(startPos);

    Trajectory traj1 = mecanumDriveSubsystem.trajectoryBuilder(startPos)
            .lineToSplineHeading(new Pose2d(58.0, -35.83, Math.toRadians(180.0)))
            .build();
    Trajectory traj2 = mecanumDriveSubsystem.trajectoryBuilder(traj1.end())
            .lineToSplineHeading(new Pose2d(31.31, -35.38, Math.toRadians(180.0)))
                    .build();
    Trajectory traj3 = mecanumDriveSubsystem.trajectoryBuilder(traj2.end())
            .splineTo(new Vector2d(11.87, 58.66), Math.toRadians(90.0))
                    .build();

    /*
    TrajectorySequence untitled0 = drive.trajectorySequenceBuilder(new Pose2d(58.44, -35.83, Math.toRadians(180.00)))
.splineTo(new Vector2d(31.31, -35.38), Math.toRadians(179.05))
.lineTo(new Vector2d(35.15, 55.05))
.splineTo(new Vector2d(11.87, 58.66), Math.toRadians(171.17))
.build();

     */

    addCommands(


    );

}
}
