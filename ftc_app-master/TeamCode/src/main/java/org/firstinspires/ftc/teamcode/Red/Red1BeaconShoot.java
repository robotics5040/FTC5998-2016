package org.firstinspires.ftc.teamcode.Red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by Ethan Schaffer on 1/11/2017.
 */
@Autonomous(group = "Red", name = "R_1B Shoot")
public class Red1BeaconShoot  extends LinearOpMode{
    Robot robot = new Robot();
    @Override
    public void runOpMode() throws InterruptedException {
        robot.initialize(Red1BeaconShoot.this, hardwareMap, telemetry, true);
        waitForStart();

        robot.ShootAtPower(1, .80);
        robot.Move(80, 1.00);
        robot.EnableShot(750, 1.00);
        robot.infeed.setPower(0);
        robot.shoot1.setPower(0);
        robot.shoot2.setPower(0);
        robot.TurnLeft(35, 0.15);
        robot.Move(240, 1.00);
        robot.AlignToWithin(3, 0.05);
        //Line up with the wall
        robot.StrafeToWall(15, 0.10);

        robot.AlignToWithin(2.5, 0.05);
        robot.AlignToWithin(2.5, 0.05);
        robot.LineSearch(2, - 0.10);
        robot.LineSearch(2,   0.05);
        robot.StrafeToWall(9, 0.10);

        robot.LineSearch(2,   0.10);
        robot.LineSearch(2, - 0.05);

        robot.PressBeacon(Robot.team.Red );
        //Press the first beacon
        robot.StrafeFromWall(15, 1.0);
        robot.TurnLeft(45, .05);
        robot.Move(70, -1.0);
        robot.TurnRight(45, .05);
        robot.Move(70, -0.25);
    }
}
