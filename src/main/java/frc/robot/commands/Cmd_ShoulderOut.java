package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Sub_Shoulder;

public class Cmd_ShoulderOut extends CommandBase {

    private final Sub_Shoulder m_sub_Shoulder;

    public Cmd_ShoulderOut(Sub_Shoulder subsystem) {

        m_sub_Shoulder = subsystem;
        addRequirements(m_sub_Shoulder);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_sub_Shoulder.Shoulder_Out();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
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
