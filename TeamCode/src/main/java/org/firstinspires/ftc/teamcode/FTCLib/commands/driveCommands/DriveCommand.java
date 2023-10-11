package org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands;

import com.acmerobotics.roadrunner.drive.Drive;
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;
import java.util.function.DoubleSupplier;

public class DriveCommand extends CommandBase {

    private final DriveSubsystem driveSubsystem;
    private final DoubleSupplier strafe, forward, turn;
    private final double mult;

    public DriveCommand(DriveSubsystem subsystem, DoubleSupplier Dstrafe, DoubleSupplier Dforward,
                        DoubleSupplier Dturn, double multiplier) {
        driveSubsystem = subsystem;
        strafe = Dstrafe;
        forward = Dforward;
        turn = Dturn;
        mult = multiplier;

        addRequirements(subsystem);
    }
    public DriveCommand(DriveSubsystem subsystem, DoubleSupplier Dstrafe, DoubleSupplier Dforward,
                        DoubleSupplier Dturn) {
        driveSubsystem = subsystem;
        strafe = Dstrafe;
        forward = Dforward;
        turn = Dturn;
        mult = 1.0;

        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        driveSubsystem.drive(strafe.getAsDouble() * mult,
                forward.getAsDouble() * mult,
                turn.getAsDouble() * 0.92 * mult);
    }

}
