package Wolf_IV.magmabeo;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import Wolf_IV.magmabeo.MagmaFluid;


public class BucketEvent {

	//@SubscribeEvent
	//public void onBucketFill (FillBucketEvent event) {
		//ItemStack result = fillBucket(event.world, event.target, null, result);
		//if (result == null) return;
		//event.result = result;
		//event.setResult(Result.ALLOW);
		
	//}

	  public ItemStack fillBucket(World world, MovingObjectPosition position, EntityPlayer player, ItemStack stack) {
		  int x = position.blockX;
          int y = position.blockY;
          int z = position.blockZ;

		  Block material = world.getBlock(x, y, z);
		  int l= world.getBlockMetadata(x, y, z);
         
          if (material == magmabeo.MagmaFluid &&  l == 0)
          {
                 world.setBlockToAir(x,y,z);
                  return this.func(stack, player, magmabeo.Magma_Bucket);
          }
          return this.func(stack, player, magmabeo.Magma_Bucket);
          
	}

	private ItemStack func(ItemStack stack, EntityPlayer player, Item magmaBucket) {

		 if (player.capabilities.isCreativeMode)
	        {
	            return stack;
	        }
	        else if (--stack.stackSize <= 0)
	        {
	            return new ItemStack(magmaBucket);
	        }
	        else
	        {
	            if (!player.inventory.addItemStackToInventory(new ItemStack(magmaBucket)))
	            {
	            	player.dropPlayerItemWithRandomChoice(new ItemStack(magmaBucket, 1, 0), false);
	            }

	            return this.func(stack, player, magmabeo.Magma_Bucket);
	}
	
	
	
	
	
	
}}
