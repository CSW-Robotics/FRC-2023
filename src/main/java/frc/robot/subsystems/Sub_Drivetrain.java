package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.ADIS16470_IMU;

public class Sub_Drivetrain extends SubsystemBase {
    private WPI_TalonSRX leftFrontDrive;
    private WPI_TalonSRX leftBackDrive;
    private MotorControllerGroup leftMotorGroup;
    private WPI_TalonSRX rightFrontDrive;
    private WPI_TalonSRX rightBackDrive;
    private MotorControllerGroup rightMotorGroup;
    private DifferentialDrive differentialDrive1;

    public Sub_Drivetrain() {
        leftFrontDrive = new WPI_TalonSRX(Constants.leftFrontDrivePort);
        addChild("LeftFrontDrive", leftFrontDrive);
        leftFrontDrive.setNeutralMode(NeutralMode.Brake);
        leftFrontDrive.setInverted(false);

        leftBackDrive = new WPI_TalonSRX(Constants.leftBackDrivePort);
        addChild("LeftBackDrive", leftBackDrive);
        leftBackDrive.setNeutralMode(NeutralMode.Brake);
        leftBackDrive.setInverted(false);

        leftMotorGroup = new MotorControllerGroup(leftFrontDrive, leftBackDrive);
        addChild("LeftMotorGroup", leftMotorGroup);

        rightFrontDrive = new WPI_TalonSRX(Constants.rightFrontDrivePort);
        addChild("RightFrontDrive", rightFrontDrive);
        rightFrontDrive.setNeutralMode(NeutralMode.Brake);
        rightFrontDrive.setInverted(false);

        rightBackDrive = new WPI_TalonSRX(Constants.rightBackDrivePort);
        addChild("RightBackDrive", rightBackDrive);
        rightBackDrive.setNeutralMode(NeutralMode.Brake);
        rightBackDrive.setInverted(false);

        rightMotorGroup = new MotorControllerGroup(rightFrontDrive, rightBackDrive);
        addChild("RightMotorGroup", rightMotorGroup);

        differentialDrive1 = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
        addChild("Differential Drive 1", differentialDrive1);
        differentialDrive1.setSafetyEnabled(false);
        differentialDrive1.setExpiration(0.1);
        differentialDrive1.setMaxOutput(1.0);

    }

    public void DrivingNow(double ForwardSpeed, double RotationSpeed){
        differentialDrive1.arcadeDrive(ForwardSpeed,RotationSpeed);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}
