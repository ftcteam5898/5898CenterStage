package org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.robocol.Command;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;

public class BackCommand extends CommandBase {

    private DriveSubsystem drive;
    private int distance;
    private double speed;
    private ElapsedTime time;
    private double stop;

    public BackCommand(int inches, double speed, DriveSubsystem drive, ElapsedTime time, double stop) {
        distance = inches;
        this.speed = speed;
        this.drive = drive;
        this.time = time;
        this.stop = stop;
    }
    @Override
    public void initialize() {
        time.reset();
        drive.resetEncoders();
        drive.backAmt(distance, speed);
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
