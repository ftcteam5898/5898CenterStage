package org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;

public class TurnCommand extends CommandBase {
    private DriveSubsystem drive;
    private int distance;
    private double speed;
    private int direction; // 1 right, 2 left

    public TurnCommand(int inches, double speed, DriveSubsystem drive, int direction) {
        distance = inches;
        this.speed = speed;
        this.drive = drive;
        this.direction = direction;
    }
    @Override
    public void initialize() {
        if(direction == 1) {
            drive.resetEncoders();
            drive.rightAmt(distance, speed);
        }
        else {
            drive.resetEncoders();
            drive.leftAmt(distance, speed);
        }

    }
}
