package org.firstinspires.ftc.teamcode.FTCLib.commands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands.BackCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands.ForwardCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands.StrafeCommand;
import org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands.TurnCommand;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.LiftSubsystem;

public class AutoTestCommandGroup extends SequentialCommandGroup {


public AutoTestCommandGroup(DriveSubsystem driveSubsystem) {

    addCommands(
            new ForwardCommand(10, 0.5, driveSubsystem),
            new TurnCommand(10, 0.5, driveSubsystem, 1),
            new TurnCommand(10, 0.5, driveSubsystem, 2),
            new StrafeCommand(10, 0.5, driveSubsystem),
            new BackCommand(5, 0.5, driveSubsystem)
    );

}
}
