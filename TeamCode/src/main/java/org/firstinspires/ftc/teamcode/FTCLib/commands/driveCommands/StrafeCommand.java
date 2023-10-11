package org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;

public class StrafeCommand extends CommandBase {

    private DriveSubsystem drive;
    private int distance;
    private double speed;

    public StrafeCommand(int inches, double speed, DriveSubsystem drive) {
        distance = inches;
        this.speed = speed;
        this.drive = drive;
    }
    @Override
    public void initialize() {
        drive.resetEncoders();
        drive.strafe(distance, speed);

    }

}
