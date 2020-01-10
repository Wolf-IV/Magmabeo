package Wolf_IV.magmabeo.creative;

import Wolf_IV.magmabeo.magmabeo;
import cpw.mods.fml.common.eventhandler.Event.Result;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class Bedrock_ extends Item{
	public Bedrock_(){
		this.setMaxStackSize(1);
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (!player.canPlayerEdit(x, y, z, p_77648_7_, stack))
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

            

            	Block block = null;
                Block block1 = Blocks.bedrock;
                boolean h=false;
                int b;
                for(b=0;h==false;b=b+1) {
                	
                	block = world.getBlock(x, y+b, z);
                	if(block==Blocks.bedrock) {
                		
                	}else {
                		h=true;
                	}
                }
                
                world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);

                if (world.isRemote)
                {
                    return true;
                }
                else
                {	if(block==Blocks.air||block==Blocks.water||block==Blocks.lava||block==magmabeo.MagmaFluid) {
                    world.setBlock(x, y+b-1, z, block1);
                }else {if(b==1) {world.setBlock(x, y, z, block1);}}
                    return true;
                }
            
           
        }
    }/**///truc pour posé de la bedrock
}
