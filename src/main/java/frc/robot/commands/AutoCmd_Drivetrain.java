package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Sub_Claw;
import frc.robot.subsystems.Sub_Drivetrain;

public class AutoCmd_Drivetrain extends CommandBase {

    private final Sub_Drivetrain m_sub_Drivetrain;
    private final double m_ForwardSpeed;
    private final double m_RotationSpeed;

    public AutoCmd_Drivetrain(Sub_Drivetrain subsystem, double ForwardSpeed, double RotationSpeed) {

        m_ForwardSpeed =ForwardSpeed;
        m_RotationSpeed = RotationSpeed;

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
        m_sub_Drivetrain.DrivingNow(m_ForwardSpeed, m_RotationSpeed);
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
