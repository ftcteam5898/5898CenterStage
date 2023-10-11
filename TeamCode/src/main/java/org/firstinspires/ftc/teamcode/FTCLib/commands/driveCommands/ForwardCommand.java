package org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;

public class ForwardCommand extends CommandBase {

    private DriveSubsystem drive;
    private int distance;
    private double speed;

    public ForwardCommand(int inches, double speed, DriveSubsystem drive) {
        distance = inches;
        this.speed = speed;
        this.drive = drive;
    }

    @Override
    public void initialize() {
        drive.resetEncoders();
        drive.forwardAmt(distance, speed);

    }
}
