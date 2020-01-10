package Wolf_IV.magmabeo.tool;

import cpw.mods.fml.common.eventhandler.Event.Result;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class Key extends Item{

	
	
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int var, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (!player.canPlayerEdit(x, y, z, var, stack))
        {
            return false;
        }
        else
        {
            UseHoeEvent event = new UseHoeEvent(player, stack, world, x, y, z);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return false;
            }

            if (event.getResult() == Result.ALLOW)
            {
              
                return true;
            }

            Block block = world.getBlock(x, y, z);

            if (block == Blocks.coal_block )
            {
                Block block1 = Blocks.diamond_block;
                world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (world.isRemote)
                {
                    return true;
                }
                else
                {
                    world.setBlock(x, y, z, block1);
                    
                    return true;
                }
            }else {if(block == Blocks.diamond_block ) {
            	  Block block1 = Blocks.coal_block;
                  world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                  if (world.isRemote)
                  {
                      return true;
                  }
                  else
                  {
                      world.setBlock(x, y, z, block1);
                      
                      return true;
            }
            } else
            {
                return false;
            }
           
        }
    }
        
    }
}
