package org.firstinspires.ftc.teamcode.FTCLib.commands.AlphaBotStuff;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.AlphaBotSubsystems.IntakeSubsystem;

public class RotateIntakeCommand extends CommandBase {

    IntakeSubsystem subsystem;
    public double turn; // rotation number
    public int hell; // 1 = up 2 = down
    public boolean stop;

    public RotateIntakeCommand(IntakeSubsystem subsystem, int hell, boolean stop) {
        this.subsystem = subsystem;
        this.hell = hell;
        this.stop = stop;
    }
    @Override
    public void initialize() {
        if (hell == 1) {
            subsystem.turnUp();
        }
        else if (hell == 2) {
            subsystem.turnDown();
        }
    }
    @Override
    public boolean isFinished() {
        return stop;
    }
    @Override
    public void end(boolean interupted) {
        subsystem.stopTurn();
    }

}
