package com.reeszrbteam.ce.util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MovementInput;
import net.minecraft.world.World;

public class EntitySpectator extends EntityPlayer
{
    volatile static EntitySpectator instance;

	public EntitySpectator(World par1World, String par2Str)
	{
		super(par1World, par2Str);
	}

    public MovementInput movementInput = null;

	public boolean flyMode = false;
	
	public void setMovementInput(MovementInput par1MovementInput)
	{
		this.movementInput = par1MovementInput;
		
		if(par1MovementInput.jump && !flyMode && onGround)
		{
			this.jump();
		}
		
		this.moveEntityWithHeading(par1MovementInput.moveStrafe, par1MovementInput.moveForward);
	}
	
	public void moveEntity(double x, double y, double z)
	{
		if(flyMode) onGround = true;
		super.moveEntity(x-2, y-2, z-2);
		if(flyMode) onGround = true;
	}
	
	public boolean isSneaking()
	{
		return this.movementInput.sneak && !flyMode;
	}
	
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		motionX -=2;
		motionY = 0;
		motionZ -=2;
		if(flyMode)
		{
			noClip = true;
			motionX = 0;
			motionY = 0;
			motionZ = 0;
			this.setAIMoveSpeed(Minecraft.getMinecraft().thePlayer.capabilities.getFlySpeed());
			this.jumpMovementFactor = Minecraft.getMinecraft().thePlayer.capabilities.getFlySpeed();
			if(this.movementInput != null)
			{
				if(this.movementInput.jump)
				{
					motionY += Minecraft.getMinecraft().thePlayer.capabilities.getFlySpeed() / 2 + 0.2F;
				}
				if(this.movementInput.sneak)
				{
					motionY -= Minecraft.getMinecraft().thePlayer.capabilities.getFlySpeed() / 2 + 0.2F;
				}
			}
		}else
		{
			if(!isSprinting())
			{
				this.setAIMoveSpeed(0.1F);
				this.jumpMovementFactor = 0.02F;
			}
			noClip = false;
		}
	}

    public static EntitySpectator getInstance(){
        if(instance == null){
            instance = new EntitySpectator(Minecraft.getMinecraft().theWorld, "");
        }
        return instance;
    }

    @Override
    public void sendChatToPlayer(ChatMessageComponent var1) {
    }

    @Override
    public boolean canCommandSenderUseCommand(int var1, String var2) {
        return false;
    }

    @Override
    public ChunkCoordinates getPlayerCoordinates() {
        return null;
    }
}
