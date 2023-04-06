package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be
 * declared globally (i.e. public static). Do not put anything functional in
 * this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {
    /**
     * public static final class DriveConstants {
     * public static final int kLeftMotor1Port = 0;
     * public static final int kLeftMotor2Port = 1;
     * public static final int kRightMotor1Port = 2;
     * public static final int kRightMotor2Port = 3;
     * }
     */

    public static int leftFrontDrivePort = 1;
    public static int leftBackDrivePort = 0;
    public static int rightFrontDrivePort = 5;
    public static int rightBackDrivePort = 4;

    public static int leftShoulderPort = 14;
    public static int rightShoulderPort = 15;

    public static int clawMotorPort = 13;

    public static final int leftElbowPort = 11;
    //public static final int rightElbowPort = 12;

    public static final int controllerPort = 0;
    public static final int joystickPort = 0;
}
