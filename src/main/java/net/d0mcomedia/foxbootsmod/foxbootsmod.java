package net.d0mcomedia.foxbootsmod;

import net.d0mcomedia.foxbootsmod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class foxbootsmod implements ModInitializer {
	public static final String MOD_ID = "foxbootsmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();

	}
}
