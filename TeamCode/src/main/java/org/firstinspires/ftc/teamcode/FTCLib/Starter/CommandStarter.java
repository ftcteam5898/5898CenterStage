package org.firstinspires.ftc.teamcode.FTCLib.Starter;

import com.arcrobotics.ftclib.command.CommandBase;

public class CommandStarter extends CommandBase {
    // all commands should extend commandbase or it will not work

    private SubsystemStarter subsystem;
    // declare your subsystem so you can call its methods

    public CommandStarter(SubsystemStarter subsystem) {
        this.subsystem = subsystem;
    }
    // create your constructor for your command and put your subsystem in as an object

    @Override
    public void initialize() {
        subsystem.moveMotor();
    }
    // you have to override the initialzie method
    // from there you have to call your methods from your subsystem
    // in the initialize method you are running what you want to happen upon calling this command
    @Override
    public void end(boolean interupted) {
        subsystem.moveServo();
    }
    // now you override the end method to finish the command
    // whatever you run in the end method is what will happen when the command stops
    // usually this is used to hold a position or just stop a motor/servo
}
