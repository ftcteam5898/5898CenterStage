package org.firstinspires.ftc.teamcode.FTCLib;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.FTCLib.subsystems.DriveSubsystem;

public class AutoTest extends CommandOpMode {

    private DriveSubsystem driveSubsystem;
    private Motor liftMotor;

    @Override
    public void initialize() {

        liftMotor = new Motor(hardwareMap, "liftMotor");


    }


}
