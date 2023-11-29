package org.firstinspires.ftc.teamcode.FTCLib.commands.AlphaBotStuff;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DroneSubsystem;

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
