package frc.robot.subsystems;
import frc.robot.commands.*;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;


public class Sub_Shoulder extends SubsystemBase {
    // private WPI_TalonSRX leftShoulder;
    // private WPI_TalonSRX rightShoulder;
    private MotorControllerGroup shoulderMotorGroup;

    
    private CANSparkMax leftShoulder;
    private CANSparkMax rightShoulder;

    static DutyCycleEncoder static_shoulderEncoder;
    private static CANSparkMax static_leftShoulder;
    private static CANSparkMax static_rightShoulder;
    static boolean alreadyCreated = false; 
    
    DutyCycleEncoder shoulderEncoder;
    public PIDController pidShoulder;
    public PIDController pidShoulder2;
    public double zero;

    public Sub_Shoulder() {
        // implement singleton pattern so that the encoder and the shoulder's do not create multiple objects
        if (Sub_Shoulder.alreadyCreated == false)
        {
            // instantiate for the first time and set alreadyCreated flag to true
            Sub_Shoulder.alreadyCreated = true;
            Sub_Shoulder.static_shoulderEncoder = new DutyCycleEncoder(0);
            Sub_Shoulder.static_leftShoulder = new CANSparkMax(Constants.leftShoulderPort, MotorType.kBrushless);
            Sub_Shoulder.static_rightShoulder = new CANSparkMax(Constants.rightShoulderPort, MotorType.kBrushless);
        }
        // now set the instance data members to the static ones
        leftShoulder = Sub_Shoulder.static_leftShoulder;
        rightShoulder = Sub_Shoulder.static_rightShoulder;
        shoulderEncoder = Sub_Shoulder.static_shoulderEncoder;
        pidShoulder = new PIDController(3, 0.25, 1.5);
        pidShoulder2 = new PIDController(4.5, 0.75, 1.5);
        zero = ((double) shoulderEncoder.get())*1;
    }
    public void Shoulder_Out() {
        leftShoulder.set(1);
        rightShoulder.set(1);
    }
    public void Shoulder_In() {
        leftShoulder.set(-1);
        rightShoulder.set(-1);
    }
    public void Shoulder_Stop() {
        leftShoulder.set(0);
        rightShoulder.set(0);
        pidShoulder = new PIDController(3, 0.25, 1.5);
    }
    public void Shoulder_Custom(double i) {
        leftShoulder.set(i);
        rightShoulder.set(i);
    }

    public void Shoulder_PID_GroundPickup() {
        zero = 0.600394215009855;
        double error = ((double) shoulderEncoder.get());
        double pidOut = pidShoulder.calculate(error, zero);
        SmartDashboard.putNumber("Shoulder Zero", zero);
        SmartDashboard.putNumber("PID Shoulder Output", pidOut);
        Shoulder_Custom(pidOut);
    }

    public void Shoulder_PID_MidNode() {
        zero = 0.5076309129;
        double error = ((double) shoulderEncoder.get());
        double pidOut = pidShoulder.calculate(error, zero);
        SmartDashboard.putNumber("Shoulder Zero", zero);
        SmartDashboard.putNumber("PID Shoulder Output", pidOut);
        Shoulder_Custom(pidOut);
    }

    public void Shoulder_PID_SubPickup() {
        zero = 0.478925411973135;
        double error = ((double) shoulderEncoder.get());
        double pidOut = pidShoulder2.calculate(error, zero);
        SmartDashboard.putNumber("Shoulder Zero", zero);
        SmartDashboard.putNumber("PID Shoulder Output", pidOut);
        Shoulder_Custom(pidOut);
    }
    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        double error = ((double) shoulderEncoder.get());
        // double pidOut = -pidShoulder.calculate(error, zero);
        // SmartDashboard.putNumber("Zero", zero);
        SmartDashboard.putNumber("Shoulder Encoder", error);
        // SmartDashboard.putNumber("PID Move Output", pidOut);
        // shoulderMotorGroup.set(pidOut);
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}
