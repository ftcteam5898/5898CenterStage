package org.firstinspires.ftc.teamcode.FTCLib.commands;

import com.acmerobotics.roadrunner.followers.TrajectoryFollower;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.FTCLib.TrajectoryFollowerCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands.StrafeCommand;
import org.firstinspires.ftc.teamcode.FTCLib.drive.MecanumDrive;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.MecanumDriveSubsystem;

public class AutoShortBLueCommandGroup extends SequentialCommandGroup {

    private ElapsedTime time;
    DriveSubsystem driveSubsystem;
    private boolean hell;
    private final Pose2d startPos = new Pose2d(-63.0, 36.0, 0.0);


    public AutoShortBLueCommandGroup(DriveSubsystem driveSubsystem, ElapsedTime time) {
        this.driveSubsystem = driveSubsystem;
        this.time = time;

    }
}

