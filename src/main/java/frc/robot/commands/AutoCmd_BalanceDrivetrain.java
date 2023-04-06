package frc.robot.commands;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.ADIS16470_IMU;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Sub_Claw;
import frc.robot.subsystems.Sub_Drivetrain;

public class AutoCmd_BalanceDrivetrain extends CommandBase {

    private final Sub_Drivetrain m_sub_Drivetrain;
    public static final ADIS16470_IMU imu = new ADIS16470_IMU();
    public PIDController pidBalance;

    public AutoCmd_BalanceDrivetrain(Sub_Drivetrain subsystem) {

        pidBalance = new PIDController(.5, 0.1, 0.75);
        
        m_sub_Drivetrain = subsystem;
        addRequirements(m_sub_Drivetrain);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double error = imu.getAccelX();
        SmartDashboard.putNumber("IMU", error);
        SmartDashboard.putNumber("PID Balance Output", -pidBalance.calculate(error, 0));

        m_sub_Drivetrain.DrivingNow(0, -pidBalance.calculate(error, 0));
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_sub_Drivetrain.DrivingNow(0, 0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
