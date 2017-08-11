package net.xalcon.chococraft.common;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.xalcon.chococraft.Chococraft;

//@Config(modid = Chococraft.MODID)
@Mod.EventBusSubscriber(modid = Chococraft.MODID)
@Config(modid = Chococraft.MODID)
public class ChocoConfig
{
    @Config.Comment({ "World generation related configuration" })
    @Config.Name("world")
    public static WorldConfig world = new WorldConfig();
    @Config.Name("chocobo")
    public static ChocoboConfig chocobo = new ChocoboConfig();

    public static class WorldConfig
    {
        @Config.RangeInt(min = 0, max = 99999)
        @Config.Comment("Controls the weight compared to other world gen")
        @Config.RequiresMcRestart
        public int gysahlGreenSpawnWeight = 3;

        @Config.RangeInt(min = 0, max = 128)
        public int gysahlGreenPatchSize = 64;

        @Config.RangeDouble(min = 0, max = 1)
        public double gysahlGreenSpawnChance = 0.1;

        @Config.RangeInt(min = 0, max = 99999)
        @Config.RequiresMcRestart
        public int chocoboSpawnWeight = 10;

        @Config.RangeInt(min = 0, max = 100)
        @Config.RequiresMcRestart
        public int chocoboPackSizeMin = 1;

        @Config.RangeInt(min = 0, max = 100)
        @Config.RequiresMcRestart
        public int chocoboPackSizeMax = 3;

        @Config.RequiresMcRestart
        public int retrogenId = 1;
    }

    public static class ChocoboConfig
    {
        @Config.RangeDouble(min = 0, max = 1)
        public double tameChance = 0.15;
    }


    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equals(Chococraft.MODID))
        {
            if(world.chocoboPackSizeMin > world.chocoboPackSizeMax)
            {
                int t = world.chocoboPackSizeMax;
                world.chocoboPackSizeMax = world.chocoboPackSizeMin;
                world.chocoboPackSizeMin = t;
            }
            ConfigManager.sync(Chococraft.MODID, Config.Type.INSTANCE);
        }
    }
}