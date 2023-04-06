// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoCmd_Autonomouse extends SequentialCommandGroup {
  /** Creates a new CmdGroup_Autonomouse. */
  public AutoCmd_Autonomouse() {
    

    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    final int AUTO_BASIC_DRIVE = 0;
    final int AUTO_BALANCE = 1;
    final int CUBE_MID = 2;
    final int CONE_MID = 3;
  
    int AUTOSELECT = CUBE_MID;

    switch (AUTOSELECT) {
      case AUTO_BASIC_DRIVE:
      {
        addCommands(
      
        // drive out of Community 
        new AutoCmd_DeployUntilTimeout(.1),
        new WaitCommand(3),
        new AutoCmd_DriveUntilTimeout(2,.75)

        );
        break;
      }
      case AUTO_BALANCE:
      {
        addCommands (
          //new AutoCmd_DriveUntilTimeout(2,.75),
          new AutoCmd_BalanceDrivetrain(new Sub_Drivetrain())
          
        );
        break;
      }
      case CUBE_MID: {
        addCommands (
          new AutoCmd_DeployUntilTimeout(3),
          new AutoCmd_Mid_UntilTimeout(2),
          new AutoCmd_SpitOutCube(1),
          new AutoCmd_DriveUntilTimeout(2,.75)
        );
        break;
      }
      case CONE_MID: {
        addCommands (
          new AutoCmd_DeployUntilTimeout(3),
          new AutoCmd_SpitOutCube(1)
        );
        break;
      }
    }
  }
}
