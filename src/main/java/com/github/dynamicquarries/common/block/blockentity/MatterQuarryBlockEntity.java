package com.github.dynamicquarries.common.block.blockentity;

import com.github.dynamicquarries.common.registry.RegistryHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MatterQuarryBlockEntity extends BlockEntity {

    public MatterQuarryBlockEntity(BlockPos pos, BlockState state) {
        super(RegistryHandler.MATTER_QUARRY_BLOCK_ENTITY.get(), pos, state);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, MatterQuarryBlockEntity blockEntity) {

    }
}
