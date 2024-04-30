package org.firstinspires.ftc.teamcode.FTCLib.Starter;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.Servo;

public class SubsystemStarter extends SubsystemBase {
    // make sure any subsystem extends the subsystem base or it will not work

    private Motor sampleMotor;
    private SimpleServo sampleServo;
    // declare all your hardware you would like to control with this subsystem

    public SubsystemStarter(Motor sampleMotor, SimpleServo sampleServo) {
        this.sampleMotor = sampleMotor;
        this.sampleServo = sampleServo;
    }
    // create your constructor

    public void moveMotor() {
        sampleMotor.set(0.6);
    }
    public void moveServo() {
        sampleServo.setPosition(1.0);
    }
    // create all methods needed for your command

}
