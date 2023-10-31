package org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;

public class TurnCommand extends CommandBase {
    private DriveSubsystem drive;
    private int distance;
    private double speed;
    private int direction; // 1 right, 2 left
    private ElapsedTime time;
    private double stop;

    public TurnCommand(int inches, double speed, DriveSubsystem drive, int direction, ElapsedTime time,
                       double stop) {
        distance = inches;
        this.speed = speed;
        this.drive = drive;
        this.direction = direction;
        this.time = time;
        this.stop = stop;
    }
    @Override
    public void initialize() {
        time.reset();
        if(direction == 1) {
            drive.resetEncoders();
            drive.rightAmt(distance, speed);
        }
        else {
            drive.resetEncoders();
            drive.leftAmt(distance, speed);
        }
    }
    @Override
    public boolean isFinished() {
        return time.seconds() >= stop;
    }
    @Override
    public void end(boolean interupted) {
        drive.stopDrive();
    }
}
