package org.firstinspires.ftc.teamcode.FTCLib.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.ClawSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.commands.RotateClawCommand;

import java.util.Timer;

public class OpenClawsCommand extends CommandBase {

    private ClawSubsystem clawSubsystem;

    public OpenClawsCommand(ClawSubsystem clawSubsystem) {
        this.clawSubsystem = clawSubsystem;

    }
    @Override
    public void initialize() {
        clawSubsystem.openClaws();
    }


}
