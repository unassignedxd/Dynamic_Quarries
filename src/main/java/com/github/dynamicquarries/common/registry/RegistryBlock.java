package com.github.dynamicquarries.common.registry;

import com.github.dynamicquarries.common.block.MatterQuarryBlock;
import com.github.dynamicquarries.common.block.blockentity.MatterQuarryBlockEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class RegistryBlock {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "dynamicquarries");
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, "dynamicquarries");

    //BLOCKS
    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)));
    public static final RegistryObject<Block> MATTER_QUARRY_BLOCK = registerBlock("matter_quarry_block", MatterQuarryBlock::new);

    //BLOCK ENTITIES
    public static final RegistryObject<BlockEntityType<MatterQuarryBlockEntity>> MATTER_QUARRY_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("matter_quarry_block_entity", () ->
                    BlockEntityType.Builder.of(MatterQuarryBlockEntity::new, MATTER_QUARRY_BLOCK.get()).build(null));

    //HELPER FUNCS

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> sup) {
        RegistryObject<T> ret = BLOCKS.register(name, sup);
        registerBlockItem(name, ret);
        return ret;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        RegistryItem.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
