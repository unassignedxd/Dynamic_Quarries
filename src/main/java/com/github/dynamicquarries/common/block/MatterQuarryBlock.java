package com.github.dynamicquarries.common.block;

import com.github.dynamicquarries.common.block.blockentity.MatterQuarryBlockEntity;
import com.github.dynamicquarries.common.registry.RegistryHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class MatterQuarryBlock extends BaseEntityBlock {

    public MatterQuarryBlock() {
        super(BlockBehaviour.Properties.of(Material.METAL).strength(2f));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MatterQuarryBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, RegistryHandler.MATTER_QUARRY_BLOCK_ENTITY.get(), MatterQuarryBlockEntity::tick);
    }
}
