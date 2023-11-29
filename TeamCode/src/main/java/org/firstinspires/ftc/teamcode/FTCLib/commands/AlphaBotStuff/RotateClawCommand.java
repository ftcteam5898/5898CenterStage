package org.firstinspires.ftc.teamcode.FTCLib.commands.AlphaBotStuff;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.ClawSubsystem;

public class RotateClawCommand extends CommandBase {

    private ClawSubsystem clawSubsystem;

    public RotateClawCommand(ClawSubsystem clawSubsystem)  {
        this.clawSubsystem = clawSubsystem;

    }
    @Override
    public void initialize() {
        clawSubsystem.rotateClaw();
    }
}
