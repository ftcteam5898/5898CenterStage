package org.firstinspires.ftc.teamcode.FTCLib.commands.AlphaBotStuff;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.AlphaBotSubsystems.DroneSubsystem;

public class DroneCommand extends CommandBase {

    private DroneSubsystem subsystem;

    public DroneCommand(DroneSubsystem subsystem) {
        this.subsystem = subsystem;
    }

    @Override
    public void initialize() {
        subsystem.shootDrone();
    }
}
