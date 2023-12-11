package org.firstinspires.ftc.teamcode.FTCLib.commands;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands.StrafeCommand;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;

public class AutoShortCommandGroup extends SequentialCommandGroup {

    private ElapsedTime time;
    DriveSubsystem driveSubsystem;
    private boolean hell;


    public AutoShortCommandGroup(DriveSubsystem driveSubsystem, ElapsedTime time) {
        this.driveSubsystem = driveSubsystem;
        this.time = time;

        addCommands(
                new StrafeCommand(10, 0.5, driveSubsystem, time, 2.0, true)

        );
    }
}
