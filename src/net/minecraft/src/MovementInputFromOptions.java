package net.minecraft.src;

public class MovementInputFromOptions extends MovementInput
{
    private GameSettings gameSettings;

    public MovementInputFromOptions(GameSettings par1GameSettings)
    {
        this.gameSettings = par1GameSettings;
    }

    public void updatePlayerMoveState()
    {
        this.moveStrafe = 0.0F;
        this.moveForward = 0.0F;

        if (this.gameSettings.keyBindForward.pressed || herobrine.world.Controller.forward)
        {
            ++this.moveForward;
        }

        if (this.gameSettings.keyBindBack.pressed || herobrine.world.Controller.backwards)
        {
            --this.moveForward;
        }

        if (this.gameSettings.keyBindLeft.pressed || herobrine.world.Controller.left)
        {
            ++this.moveStrafe;
        }

        if (this.gameSettings.keyBindRight.pressed || herobrine.world.Controller.right)
        {
            --this.moveStrafe;
        }

        this.jump = this.gameSettings.keyBindJump.pressed || herobrine.world.Controller.jump;
        this.sneak = this.gameSettings.keyBindSneak.pressed || herobrine.world.Controller.sneak;

        if (this.sneak)
        {
            this.moveStrafe = (float)((double)this.moveStrafe * 0.3D);
            this.moveForward = (float)((double)this.moveForward * 0.3D);
        }
    }
}
