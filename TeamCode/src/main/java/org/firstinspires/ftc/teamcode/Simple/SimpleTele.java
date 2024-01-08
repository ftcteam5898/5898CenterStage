package org.firstinspires.ftc.teamcode.Simple;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

    @TeleOp(name="Simple Tele Op", group="Tele")
    public class SimpleTele extends LinearOpMode {

        @Override
        public void runOpMode() {
            // Declare our motors
            // Make sure your ID's match your configuration
            DcMotor motorFrontLeft = hardwareMap.dcMotor.get("lf");
            DcMotor motorBackLeft = hardwareMap.dcMotor.get("lb");
            DcMotor motorFrontRight = hardwareMap.dcMotor.get("rf");
            DcMotor motorBackRight = hardwareMap.dcMotor.get("rb");

            DcMotor leftslide = hardwareMap.dcMotor.get("lslide");
            DcMotor rightslide = hardwareMap.dcMotor.get("rslide");
            rightslide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            leftslide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            DcMotor leftIntake = hardwareMap.dcMotor.get("lscrew");
            DcMotor rightIntake = hardwareMap.dcMotor.get("rscrew");

            //Declare servos
            Servo arm = hardwareMap.servo.get("arm");
            Servo intake = hardwareMap.servo.get("intake");
            Servo joint = hardwareMap.servo.get("joint");
            Servo grabber = hardwareMap.servo.get("grabber");



            // Reverse one side of the motors
            // If it goes in reverse, reverse the other side.
            motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
            motorFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);



            waitForStart();


            //Set starting positions of wrist & claw


            if (isStopRequested()) return;
            while (opModeIsActive()) {

                double y = 0;
                double x = 0;
                if (gamepad1.left_stick_y != 0 || gamepad1.left_stick_x != 0)
                {
                    y = -gamepad1.left_stick_y; // Remember, this is reversed!
                    x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
                }
                else if (gamepad1.right_stick_y != 0 || gamepad1.right_stick_x != 0)
                {
                    y = gamepad1.right_stick_y;
                    x = gamepad1.right_stick_x * 1.1;
                }

                double rx = 0;
                if (gamepad1.left_trigger >= 0.1)
                {
                    rx = gamepad1.left_trigger;
                }
                else if (gamepad1.right_trigger >= 0.1)
                {
                    rx = gamepad1.right_trigger * -1;
                }




                // Denominator is the largest motor power (absolute value) or 1
                // This ensures all the powers maintain the same ratio, but only when
                // at least one is out of the range [-1, 1]
                double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
                double frontLeftPower = (y + x + rx) / denominator;
                double backLeftPower = (y - x + rx) / denominator;
                double frontRightPower = (y - x - rx) / denominator;
                double backRightPower = (y + x - rx) / denominator;

                motorFrontLeft.setPower(frontLeftPower);
                motorBackLeft.setPower(backLeftPower);
                motorFrontRight.setPower(frontRightPower);
                motorBackRight.setPower(backRightPower);

                // SLIDES


                // INTAKE & OUTTAKE
            }
        }

}
