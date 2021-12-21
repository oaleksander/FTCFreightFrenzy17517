package org.firstinspires.ftc.teamcode.opmodes.test;

import org.firstinspires.ftc.teamcode.opmodes.BaseOpMode;
import org.firstinspires.ftc.teamcode.robot.Bucket;

public class BucketTest extends BaseOpMode {

    @Override
    public void startLoop() {
        telemetry.addData("Test", "Bucket will stay still and eject 5 seconds after Start button has been pressed.");
        telemetry.update();
    }

    @Override
    public void main() {
        robot.bucket.setBucketPosition(Bucket.BucketPosition.COLLECT);
        robot.timer.delay(5);
        while (!robot.timer.actionIsCompleted() && opModeIsActive()) {
            telemetry.addData("Test", "Running...");
            telemetry.addData("Time before ejection", robot.timer.getTimeLeft());
            telemetry.addData("Freight detected", robot.bucket.isFreightDetected());
            telemetry.update();
        }
        robot.bucket.setBucketPosition(Bucket.BucketPosition.EJECT);
        while (!robot.bucket.actionIsCompleted() && opModeIsActive()) {
            telemetry.addData("Test", "Running...");
            telemetry.addData("Freight detected", robot.bucket.isFreightDetected());
            telemetry.update();
        }
        robot.bucket.setBucketPosition(Bucket.BucketPosition.COLLECT);
        while (!robot.bucket.actionIsCompleted() && opModeIsActive()) {
            telemetry.addData("Test", "Running...");
            telemetry.addData("Freight detected", robot.bucket.isFreightDetected());
            telemetry.update();
        }
    }
}
