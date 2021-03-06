package net.slayer5934.chococraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.slayer5934.chococraft.client.gui.GuiChocoboBook;
import net.slayer5934.chococraft.client.gui.GuiChocoboInfo;
import net.slayer5934.chococraft.common.CommonProxy;
import net.slayer5934.chococraft.common.entities.EntityChocobo;

@SuppressWarnings("ALL")
public class ClientProxy extends CommonProxy {
	@Override
	public void openChocoboInfoGui(EntityChocobo chocobo, EntityPlayer player) {
		super.openChocoboInfoGui(chocobo, player);
		Minecraft.getMinecraft().displayGuiScreen(new GuiChocoboInfo(chocobo, player));
	}

	@Override
	public void openChocoBook(EntityPlayer player) {
		super.openChocoBook(player);
		Minecraft.getMinecraft().displayGuiScreen(new GuiChocoboBook(player));
	}
}
