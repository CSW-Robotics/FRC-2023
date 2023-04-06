package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.commands.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Sub_Claw extends SubsystemBase {
    //private CANSparkMax clawMotor;
    private static boolean isSparkMaxDefined = false;
    private static CANSparkMax static_clawMotor;
    private CANSparkMax clawMotor;
    
    public Sub_Claw() {
        // Initialize the static_clawMotor the first time this is called
        // then set the instance clawMotor to be the static_clawMotor.
        if (!Sub_Claw.isSparkMaxDefined)
        {
            Sub_Claw.isSparkMaxDefined = true;
            Sub_Claw.static_clawMotor = new CANSparkMax(Constants.clawMotorPort, MotorType.kBrushless);
        }
        clawMotor = Sub_Claw.static_clawMotor;
    }

    public void Claw_Cone() {
        clawMotor.set(0.75);
    }
    public void Claw_Cube() {
        clawMotor.set(-0.75);
    }
    public void Claw_ConeStop() {
        clawMotor.set(0.1);
    }
    public void Claw_CubeStop() {
        clawMotor.set(0);
    }
    public void Claw_Stop() {
        clawMotor.set(0);
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

