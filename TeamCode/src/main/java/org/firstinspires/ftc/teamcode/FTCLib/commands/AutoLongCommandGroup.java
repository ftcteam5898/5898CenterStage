package org.firstinspires.ftc.teamcode.FTCLib.commands;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands.ForwardCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands.StrafeCommand;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;

public class AutoLongCommandGroup extends SequentialCommandGroup {

    private ElapsedTime time;
    DriveSubsystem driveSubsystem;
    private boolean hell;


public AutoLongCommandGroup(DriveSubsystem driveSubsystem, ElapsedTime time) {
    this.driveSubsystem = driveSubsystem;
    this.time = time;

    addCommands(
            new ForwardCommand(10, 0.2, driveSubsystem, time, 0.5),
            new StrafeCommand(10, 0.5, driveSubsystem, time,3.5, true)

    );

}
}
