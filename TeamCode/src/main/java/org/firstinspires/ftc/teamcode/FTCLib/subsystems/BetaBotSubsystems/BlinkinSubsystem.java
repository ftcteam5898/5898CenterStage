package org.firstinspires.ftc.teamcode.FTCLib.subsystems.BetaBotSubsystems;

import android.telephony.SubscriptionPlan;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import java.util.concurrent.TimeUnit;

import com.arcrobotics.ftclib.command.SubsystemBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.internal.system.Deadline;
import org.firstinspires.ftc.teamcode.FTCLib.Blinkin;

public class BlinkinSubsystem extends SubsystemBase {
    /*
     * Change the pattern every 10 seconds in AUTO mode.
     */
    private final static int LED_PERIOD = 10;

    /*
     * Rate limit gamepad button presses to every 500ms.
     */
    private final static int GAMEPAD_LOCKOUT = 500;

    RevBlinkinLedDriver blinkinLedDriver;
    RevBlinkinLedDriver.BlinkinPattern pattern;

    Telemetry.Item patternName;
    Telemetry.Item display;
    DisplayKind displayKind;
    Deadline ledCycleDeadline;
    Deadline gamepadRateLimit;

    protected enum DisplayKind {
        MANUAL,
        AUTO
    }
    public BlinkinSubsystem() {

    }

    public void blink() {

    }


}
