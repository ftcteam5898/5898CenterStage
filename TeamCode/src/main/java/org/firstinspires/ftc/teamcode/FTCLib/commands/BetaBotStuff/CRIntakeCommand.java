package org.firstinspires.ftc.teamcode.FTCLib.commands.BetaBotStuff;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.BetaBotSubsystems.CRIntakeSubsystem;

public class CRIntakeCommand extends CommandBase {

    private CRIntakeSubsystem subsystem;
    private int uhhh; // 1 in 2 out

    public CRIntakeCommand(CRIntakeSubsystem subsystem, int uhhh) {
        this.uhhh = uhhh;
        this.subsystem = subsystem;
    }
    @Override
    public void initialize() {
        if (uhhh ==1 ) {
            subsystem.intakeIn();
        }
        else {
            subsystem.intakeOut();
        }
    }
    @Override
    public void end(boolean interupted) {
        subsystem.intakeStop();
    }
}
