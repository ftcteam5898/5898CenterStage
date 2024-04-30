package org.firstinspires.ftc.teamcode.FTCLib.Starter;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.WaitUntilCommand;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.FTCLib.commands.AutoShortCommandGroup;

@Autonomous(name = "AutoStarter", group = "starter") // you have to use @Autonomous or it wont be an auto
// the name you put in is what will appear on the driver hub
// you can also add a group to group them together on the driver hub I recommend this as it keeps
// code organized
public class AutoStarter extends CommandOpMode {
    // extend commandOpMode or it wont work
    private SubsystemStarter subsystemStarter;
    private Motor sampleMotor;
    private SimpleServo sampleServo;
    // declare all subsystems/motors/servos you will be using in the autonomous
    // also declare any timers or other variables you need


    @Override
    public void initialize() {

        sampleServo = new SimpleServo(hardwareMap, "servo", -90.0, 90.0);
        sampleMotor = new Motor(hardwareMap, "motor", Motor.GoBILDA.RPM_435);
        subsystemStarter = new SubsystemStarter(sampleMotor, sampleServo);
        // initialize all your motors/servos/subsystems


        // you have to schedule whatever you want to run or NOTHING WILL HAPPEN
        schedule(new WaitUntilCommand(this::isStarted)
                .andThen(new CommandStarter(subsystemStarter)));
    }
}
// for teleOp see my old code