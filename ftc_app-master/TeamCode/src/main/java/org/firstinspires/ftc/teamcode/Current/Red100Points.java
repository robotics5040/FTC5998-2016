package org.firstinspires.ftc.teamcode.Current;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Ethan Schaffer on 1/25/2017.
 */
@Autonomous(name = "R Diagonal", group = "aaMain")
public class Red100Points extends LinearOpMode {
    Robot robot = new Robot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.initialize(Red100Points.this, hardwareMap, telemetry, true);
        while(!isStarted() && !isStopRequested()){
            robot.sensorsInfo();
        }
        waitForStart();
        robot.ShootSmart();
        robot.Move(65, 1.0);
        robot.EnableShot(250, 1);
        robot.StopShooter();
        robot.DiagonalForwardsLeft(25, 1);
        sleep(100);
        robot.AlignToWithin(.5, .05);
        robot.LineSearch(2, .15);
        sleep(100);
        robot.LineSearch(2, - .05);
        robot.StrafeToWall(10, .08);
        robot.StrafeToWall(9, .07);
        robot.PressBeacon(Robot.team.Red);

        robot.StrafeFromWall(13, 1.0);
        robot.AlignToWithin(1, .05);
        robot.Move(130, -1.0);

        robot.AlignToWithin(1, .05);

        robot.LineSearch(2, -.15);
        sleep(100);
        robot.StrafeToWall(10, .08);
        robot.StrafeToWall(9, .07);
        robot.LineSearch(2, .05);
        robot.PressBeacon(Robot.team.Red);
        robot.StrafeFromWall(25, .75);
        robot.AlignToWithin(1.5, .05);
        robot.Move(115, -1.0);
        robot.Move(25, -0.25);

    }
}
