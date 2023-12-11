package org.firstinspires.ftc.teamcode.FTCLib.subsystems.BetaBotSubsystems;

import android.media.MediaDrm;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.CRServo;

public class BetaIntakeSubsystem extends SubsystemBase {

    private CRServo sillyguy;

    public BetaIntakeSubsystem(CRServo sillyguy) {
        this.sillyguy = sillyguy;
    }
    
}
