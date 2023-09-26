package org.firstinspires.ftc.teamcode.FTCLib.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {

    public int move; // 1 = in 2 = out
    public boolean stop;
    IntakeSubsystem subsystem;

    public IntakeCommand(IntakeSubsystem subsystem, int move, boolean stop) {
        this.subsystem = subsystem;
        this.move = move;
        this.stop = stop;
    }

    @Override
    public void initialize() {
        if (move == 1) {
            subsystem.rotateIn();
        }
        else if (move == 2) {
            subsystem.rotateOut();
        }
    }
    @Override
    public boolean isFinished() {
        return stop;
    }
    @Override
    public void end(boolean interupted) {
        subsystem.stopIntake();
    }
}
