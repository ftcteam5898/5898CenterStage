package org.firstinspires.ftc.teamcode.FTCLib.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;

public class AutoDriveCommand extends CommandBase {

    private DriveSubsystem drive;
    private double distance;
    private double speed;

    public AutoDriveCommand(double inches, double speed, DriveSubsystem drive) {
        distance = inches;
        this.speed = speed;
        this.drive = drive;
    }

    @Override
    public void initialize() {
        drive.resetEncoders();
    }
}
