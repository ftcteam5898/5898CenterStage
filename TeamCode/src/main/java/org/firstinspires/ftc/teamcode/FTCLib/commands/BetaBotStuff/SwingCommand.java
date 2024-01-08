package org.firstinspires.ftc.teamcode.FTCLib.commands.BetaBotStuff;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.BetaBotSubsystems.ScoreSubsystem;

public class SwingCommand extends CommandBase {
    private ScoreSubsystem subsystem;
    private int hell; // 1 score 2 reset

    public SwingCommand(ScoreSubsystem subsystem, int hell) {
        this.subsystem = subsystem;
        this.hell = hell;
    }
    @Override
    public void initialize() {
        if (hell == 1) {
            subsystem.scoreArm();
        }
        else {
            subsystem.resetArm();
        }
    }
    @Override
    public void end(boolean interupted) {
        subsystem.stopArm();
    }
}
