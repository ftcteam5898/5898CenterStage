package org.firstinspires.ftc.teamcode.FTCLib.commands.driveCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;

public class StrafeCommand extends CommandBase {

    private DriveSubsystem drive;
    private int distance;
    private double speed;
    private ElapsedTime time;
    private double stop;
    private boolean hell; // true for right false for left

    public StrafeCommand(int inches, double speed, DriveSubsystem drive, ElapsedTime time, double stop, boolean hell) {
        distance = inches;
        this.speed = speed;
        this.drive = drive;
        this.time = time;
        this.stop = stop;
        this.hell = hell;
    }
    @Override
    public void initialize() {
        time.reset();
        drive.resetEncoders();
        if (!hell) {
            drive.lStrafe(distance, speed);
        }
        drive.strafe(distance, speed);
    }
    @Override
    public boolean isFinished() {
        return time.seconds() >= stop;
    }
    @Override
    public void end(boolean interupted) {
        drive.stopRobot();
    }

}
