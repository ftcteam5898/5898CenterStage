package org.firstinspires.ftc.teamcode.FTCLib.commands;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.FTCLib.TrajectoryFollowerCommand;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.MecanumDriveSubsystem;

public class MonkeCommandGroup extends SequentialCommandGroup {
    private final Pose2d startPos = new Pose2d(60.47, -35.6, 0.0);
    public ElapsedTime timer = new ElapsedTime();

    public MonkeCommandGroup(MecanumDriveSubsystem mecanumDriveSubsystem) {
        Trajectory traj1 = mecanumDriveSubsystem.trajectoryBuilder(startPos)
                .lineTo(new Vector2d(27.92, -35.38))
                .build();
        Trajectory traj2 = mecanumDriveSubsystem.trajectoryBuilder(traj1.end())
                .splineTo(new Vector2d(36.96, -35.15), Math.toRadians(1.43))
                .build();
        Trajectory traj3 = mecanumDriveSubsystem.trajectoryBuilder(traj2.end())
                .splineTo(new Vector2d(35.60, 36.96), Math.toRadians(91.08))
                .build();
        Trajectory traj4 = mecanumDriveSubsystem.trajectoryBuilder(traj3.end())
                .splineTo(new Vector2d(60.02, 31.31), Math.toRadians(-13.03))
                .build();
        Trajectory traj5 = mecanumDriveSubsystem.trajectoryBuilder(traj4.end())
                .lineTo(new Vector2d(59.57, 60.24))
                .build();

        addCommands(
                new TrajectoryFollowerCommand(mecanumDriveSubsystem, traj1),
                new TrajectoryFollowerCommand(mecanumDriveSubsystem, traj2),
                new TrajectoryFollowerCommand(mecanumDriveSubsystem, traj3),
                new TrajectoryFollowerCommand(mecanumDriveSubsystem, traj4),
                new TrajectoryFollowerCommand(mecanumDriveSubsystem, traj5)
        );
    }


}
