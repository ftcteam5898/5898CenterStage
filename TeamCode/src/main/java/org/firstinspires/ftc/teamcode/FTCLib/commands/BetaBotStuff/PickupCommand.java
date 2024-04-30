package org.firstinspires.ftc.teamcode.FTCLib.commands.BetaBotStuff;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.BetaBotSubsystems.ScoreSubsystem;

public class PickupCommand extends CommandBase {

    private ScoreSubsystem subsystem;

    public PickupCommand(ScoreSubsystem subsystem) {
        this.subsystem = subsystem;

    }

    @Override
    public void initialize() {
        subsystem.pickUpJoint();
        subsystem.pickUpArm();
    }
    @Override
    public void end(boolean interupted) {
        subsystem.stopArm();
        subsystem.stopJoint();
    }
}
