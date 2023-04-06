package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Sub_Elbow;
import frc.robot.subsystems.Sub_Shoulder;

public class Cmd_PID_Target extends CommandBase {

    private final Sub_Elbow m_sub_Elbow;
    private final Sub_Shoulder m_sub_Shoulder;

    public Cmd_PID_Target(Sub_Elbow elbowSubsystem, Sub_Shoulder shoulderSubsystem) {

        m_sub_Elbow = elbowSubsystem;
        m_sub_Shoulder = shoulderSubsystem;
        addRequirements(m_sub_Elbow);
        addRequirements(m_sub_Shoulder);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_sub_Elbow.Elbow_PID_Target();
        m_sub_Shoulder.Shoulder_PID_GroundPickup();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_sub_Elbow.Elbow_Stop();
        m_sub_Shoulder.Shoulder_Stop();
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
