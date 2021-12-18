package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.R;
import org.firstinspires.ftc.teamcode.opencv.ArucoDetect;

import java.util.Arrays;

public class RobotModules {
    private static LinearOpMode linearOpMode;
    public static Duck duck;
    public static Elevator elevator;
    public static Movement movement;
    public static Brush brush;
    public static ArucoDetect arucoDetect;

    private final RobotModule[] allModules;
    private final RobotModule[] allModulesTeleop;
    public Brush intake;

    public RobotModules(LinearOpMode linearOpMode) {
        RobotModules.linearOpMode = linearOpMode;
        duck = new Duck(linearOpMode);
        elevator = new Elevator(linearOpMode);
        movement = new Movement(linearOpMode);
        brush = new Brush(linearOpMode);
        arucoDetect = new ArucoDetect();

        allModules = new RobotModule[]{
                duck,
                elevator,
                brush,
                movement,

        };
        allModulesTeleop = new RobotModule[]{
                brush,
                duck,
                elevator
        };
    }
    public void updateForTeleop(){
        for(int i=0;i < allModules.length-1;i++){
            allModules[i].update();
        }
    }

    public void init() {
        for (RobotModule robotModule : allModules)
            robotModule.init();
    }
    public void updateForTeleop() {
        for (RobotModule robotModule : allModulesTeleop)
            robotModule.update();
    }

    public void update() {
        if(brush.distance.getDistance(DistanceUnit.CM) < 8) brush.ledMotor.setPower(1);
        for (RobotModule robotModule : allModules)
            robotModule.update();
    }

    public boolean line() {
        return Arrays.stream(allModules).allMatch(RobotModule::line);
    }
}
