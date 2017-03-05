package org.firstinspires.ftc.teamcode.Current;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Ethan Schaffer on 1/25/2017.
 */
@Autonomous(name = "B 100", group = "New")
public class _Blue100New extends LinearOpMode {
    Robot robot = new Robot();

    @Override
    public void runOpMode() throws InterruptedException {
        String LEFTPUSHNAME = "lp";//MO Port 1
        String RIGHTPUSHNAME = "rp";//MO Port 2
        Servo leftButtonPusher = hardwareMap.servo.get(LEFTPUSHNAME);
        Servo rightButtonPusher = hardwareMap.servo.get(RIGHTPUSHNAME);
        robot.initialize(_Blue100New.this, hardwareMap, telemetry, true);
        while(!isStarted() && !isStopRequested()){
            robot.sensorsInfo();
        }
        waitForStart(); //Should be unecessary, as isStarted() is only true when the start button is hit
        robot.MoveCoast(20, -1.0);
        robot.DiagonalBackwardsLeftCoast(80, 1);
        robot.DiagonalBackwardsLeft(25, .75, 1);
        robot.AlignToWithin(1.5, .05);
        robot.StrafeToWall(10, .10);
        robot.AlignToWithinOf(2, .5, .05);

        int threshold = 2;
        if(robot.colorSensorOnSide.red() > threshold || robot.colorSensorOnSide.blue() > threshold){
            while(robot.colorSensorOnSide.red() > threshold || robot.colorSensorOnSide.blue() > threshold){
                robot.SetDrivePower(-.15);
            }
            sleep(100);
            robot.SetDrivePower(0);
        }

        robot.FindAndPressSquareToBeacon(Robot.team.Blue, .10);
        leftButtonPusher.setPosition(.3);
        rightButtonPusher.setPosition(.3);
        robot.CheckBeacon(Robot.team.Blue);
        leftButtonPusher.setPosition(.3);
        rightButtonPusher.setPosition(.3);

        robot.Move(85, -1.0);
        robot.StrafeFromWall(9, .10);
        robot.AlignToWithinOf(-2, .5, .05);
        robot.FindAndPressSquareToBeacon(Robot.team.Blue, -.10);
        leftButtonPusher.setPosition(.3);
        rightButtonPusher.setPosition(.3);
        robot.CheckBeacon(Robot.team.Blue);
        leftButtonPusher.setPosition(.3);
        rightButtonPusher.setPosition(.3);

        robot.ShootByVoltage();
        robot.ArcadeToAngleRight(0, .25, .40, 20);
        robot.AlignToWithinOf(40, 1, .05);
        robot.ForwardsPLoop(135, 1.0);
        robot.AlignToWithinOf(43, 1, .05);
        robot.EnableShot();robot.StopShooter();
        robot.Move(90, 1.0);
    }
}
