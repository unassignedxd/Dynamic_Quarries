package com.github.dynamicquarries.common.registry;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


public class RegistryHandler {

    public static void register() {
        RegistryBlock.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        RegistryItem.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        RegistryBlock.BLOCK_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
