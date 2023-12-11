package org.firstinspires.ftc.teamcode.FTCLib.subsystems.AlphaBotSubsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.Servo;

public class DroneSubsystem extends SubsystemBase {

    private SimpleServo drone;

    public DroneSubsystem(SimpleServo drone) {
        this.drone = drone;
    }
    public void initDrone() {
        drone.setPosition(1.0);
    }
    public void shootDrone() {
        drone.setPosition(0.5);
    }

}
