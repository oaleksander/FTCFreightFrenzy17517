package org.firstinspires.ftc.teamcode.opmodes;

import static org.firstinspires.ftc.teamcode.VariablesDashboard.Elevator.bucketServoDelay;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.Bucket;

@Autonomous
public class AutonomTest extends BaseAutonomous {

    Runnable[] test = {
            () -> robot.bucket.setBucketPosition(Bucket.BucketPosition.EJECT),
            () -> robot.timer.delay(30)
    };

    @Override
    public void main(){
        execute(test);
    }

}