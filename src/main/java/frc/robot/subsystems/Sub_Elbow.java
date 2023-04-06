package frc.robot.subsystems;


import frc.robot.commands.*;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Sub_Elbow extends SubsystemBase {

    private static Sub_Elbow myInstance; // the only instance of the class
    private CANSparkMax leftElbow;
    
    DutyCycleEncoder elbowEncoder;
    static boolean alreadyCreated = false;

    public PIDController pidElbow;
    public double zero;
    
    public Sub_Elbow() {
    // singleton pattern
    if (Sub_Elbow.alreadyCreated == false)
    {
        // allocate the one instance
        Sub_Elbow.alreadyCreated = true;
        elbowEncoder = new DutyCycleEncoder(1);
        leftElbow = new CANSparkMax(Constants.leftElbowPort, MotorType.kBrushless);    
        pidElbow = new PIDController(2, 0.1, 0.05);
        // set the only instance
        Sub_Elbow.myInstance = this;
    }

}

    public static Sub_Elbow getInstance()
    {
        // return the single instance
        if (Sub_Elbow.alreadyCreated)
        {
            return Sub_Elbow.myInstance;
        }
        else 
        {
            return new Sub_Elbow();
        }
    }

    public void Elbow_Out(){
        leftElbow.set(1);
        //rightElbow.set(1);
    }

    public void Elbow_In(){
        leftElbow.set(-1);
        //rightElbow.set(-1);
    }

    public void Elbow_Stop() {
        leftElbow.set(0);
        //rightElbow.set(0);
        pidElbow = new PIDController(2, 0.1, 0.05);
    }

    public void Elbow_Custom(double i) {
        leftElbow.set(-i);
        //rightElbow.set(i);
    }

    public void Elbow_PID_Auto() {
        zero = 0.694915692372892;
        double error = ((double) elbowEncoder.get());
        double pidOut = pidElbow.calculate(error, zero);
        SmartDashboard.putNumber("Elbow Zero", zero);
        SmartDashboard.putNumber("PID Elbow Output", pidOut);
        Elbow_Custom(pidOut);
    }

    public void Elbow_PID_GroundPickup() {
        zero = 0.579084639227116;
        double error = ((double) elbowEncoder.get());
        double pidOut = pidElbow.calculate(error, zero);
        SmartDashboard.putNumber("Elbow Zero", zero);
        SmartDashboard.putNumber("PID Elbow Output", pidOut);
        Elbow_Custom(pidOut);
    }

    public void Elbow_PID_Target() {
        zero = 0.459084639227116;
        double error = ((double) elbowEncoder.get());
        double pidOut = pidElbow.calculate(error, zero);
        SmartDashboard.putNumber("Elbow Zero", zero);
        SmartDashboard.putNumber("PID Elbow Output", pidOut);
        Elbow_Custom(pidOut);
    }

    public void Elbow_PID_MidNode() {
        zero = 0.405633111140828;
        double error = ((double) elbowEncoder.get());
        double pidOut = pidElbow.calculate(error, zero);
        SmartDashboard.putNumber("Elbow Zero", zero);
        SmartDashboard.putNumber("PID Elbow Output", pidOut);
        Elbow_Custom(pidOut);
    }

    public void Elbow_PID_SubPickup() {
        zero = 0.47053401176335;
        double error = ((double) elbowEncoder.get());
        double pidOut = pidElbow.calculate(error, zero);
        SmartDashboard.putNumber("Elbow Zero", zero);
        SmartDashboard.putNumber("PID Elbow Output", pidOut);
        Elbow_Custom(pidOut);
    }

    @Override
    public void periodic() {
        double error = ((double) elbowEncoder.get());
        SmartDashboard.putNumber("Elbow Encoder", error);
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

}

