package org.firstinspires.ftc.teamcode.FTCLib.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.ClawSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.commands.RotateClawCommand;

import java.util.Timer;

public class ClawCommand extends CommandBase {

    private ClawSubsystem clawSubsystem;
    boolean hell;

    public ClawCommand(ClawSubsystem clawSubsystem, boolean hell) {
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
