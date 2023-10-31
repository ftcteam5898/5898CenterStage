package org.firstinspires.ftc.teamcode.FTCLib.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.ClawSubsystem;

public class BumpCommand extends CommandBase {

    private ClawSubsystem subsystem;
    private boolean hell;

    public BumpCommand(ClawSubsystem subsystem, boolean hell) {
        this.subsystem = subsystem;
        this.hell = hell;
    }

    @Override
    public void initialize() {
        if (hell) {
            subsystem.bumpUp();
        }
        else {
            subsystem.bumpDown();
        }


    }

}
