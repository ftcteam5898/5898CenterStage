package org.firstinspires.ftc.teamcode.FTCLib.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.LiftSubsystem;

public class LiftCommand extends CommandBase {

    private LiftSubsystem liftSubsystem;
    private int hell; //1 = up 2 = down
    private Motor leftLift, rightLift;


    public LiftCommand(LiftSubsystem liftSubsystem, int hell) {
        this.liftSubsystem = liftSubsystem;
        this.hell = hell;
        leftLift = liftSubsystem.getLeftMotor();
    }
    @Override
    public void initialize() {
        if (hell == 1) {
            liftSubsystem.motorsUp();
        }
        else if (hell == 2){
            liftSubsystem.motorsDown();
        }
    }
    @Override
    public boolean isFinished() {
        return leftLift.getCurrentPosition() <= -3000;
    }
    @Override
    public void end(boolean interupted) {
        liftSubsystem.motorsStop();
    }
}
