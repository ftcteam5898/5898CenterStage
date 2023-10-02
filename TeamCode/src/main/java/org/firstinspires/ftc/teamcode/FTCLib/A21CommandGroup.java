package org.firstinspires.ftc.teamcode.FTCLib;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SelectCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.MecanumDriveSubsystem;

import java.util.HashMap;
import java.util.function.IntSupplier;


public class A21CommandGroup extends SequentialCommandGroup {

    private final Pose2d startPos = new Pose2d(60.0, -35.0, 180.0);
    private ElapsedTime timer = new ElapsedTime();

    public A21CommandGroup(MecanumDriveSubsystem mecanumDriveSubsystem, LiftSubsystem liftSubsystem,
                           IntakeSubsystem intakeSubsystem) {

        mecanumDriveSubsystem.setPoseEstimate(startPos);
        Trajectory traj1 = mecanumDriveSubsystem.trajectoryBuilder(startPos)
                .forward(10.0)
                .build();
    }
    // start of trajectories cause im lazy and dont wanna do anything else
    /*
     .lineTo(new Vector2d(35.38, -35.60))
     .lineTo(new Vector2d(34.70, -61.38))
     .lineTo(new Vector2d(34.25, 56.40))
     .lineTo(new Vector2d(58.66, 56.18))
     */

}
