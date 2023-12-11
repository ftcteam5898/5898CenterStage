package org.firstinspires.ftc.teamcode.FTCLib.commands.BetaBotStuff;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.BetaBotSubsystems.ClimbSubsystem;
import org.firstinspires.ftc.teamcode.FTCLib.subsystems.LiftSubsystem;

public class ClimbCommand extends CommandBase {

    private ClimbSubsystem climbSubsystem;
    private int hell; //1 = up 2 = down
    private Motor leftClimb, rightClimb;


    public ClimbCommand(ClimbSubsystem climbSubsystem, int hell) {
        this.climbSubsystem = climbSubsystem;
        this.hell = hell;
        leftClimb = climbSubsystem.getLeftClimb();
    }
    @Override
    public void initialize() {
        if (hell == 1) {
            climbSubsystem.motorsUp();
        }
        else if (hell == 2){
            climbSubsystem.motorsDown();
        }
    }
    @Override
    public boolean isFinished() {
        return leftClimb.getCurrentPosition() <= -1000;
    }
    @Override
    public void end(boolean interupted) {
        climbSubsystem.motorsStop();
    }
}

