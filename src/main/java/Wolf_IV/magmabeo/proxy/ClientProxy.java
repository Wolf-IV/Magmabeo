package Wolf_IV.magmabeo.proxy;



import org.lwjgl.input.Keyboard;

import Wolf_IV.magmabeo.magmabeo;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy{

	private boolean ultimateIsPressed;
	private KeyBinding ultimatePressed;
	@Override
	public void registerRenders(){
		
	}
	public ClientProxy() {
		FMLCommonHandler.instance().bus().register(this);
		ultimatePressed = new KeyBinding("Ultimate", Keyboard.KEY_W, "key.categories.gameplay");
		ClientRegistry.registerKeyBinding(ultimatePressed);
		
	}
	
	
	@SubscribeEvent
	public void onEvent(KeyInputEvent event) {
		magmabeo.Ulty=false;
		if(ultimatePressed.isPressed())
		{ 	
			magmabeo.Ulty=true;
			keyPressed();
			
			
		}
		
	}
	private void keyPressed() {
  // Minecraft.getMinecraft().thePlayer.addExperience(150);
		
	}
	
	
	}
	
	


