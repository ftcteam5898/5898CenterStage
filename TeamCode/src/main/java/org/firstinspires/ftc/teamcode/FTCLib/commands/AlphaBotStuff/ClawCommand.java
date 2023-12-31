package org.firstinspires.ftc.teamcode.FTCLib.commands.AlphaBotStuff;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.AlphaBotSubsystems.ClawSubsystem;

public class ClawCommand extends CommandBase {

    private ClawSubsystem clawSubsystem;
    boolean hell;

    public ClawCommand(ClawSubsystem clawSubsystem, boolean hell) {
        addRequirements(this.clawSubsystem);
        this.clawSubsystem = clawSubsystem;
        this.hell = hell;

    }
    @Override
    public void initialize() {
        if (hell) {
            clawSubsystem.openClaw();
        }
        else {
            clawSubsystem.closeClaw();
        }
    }


}
