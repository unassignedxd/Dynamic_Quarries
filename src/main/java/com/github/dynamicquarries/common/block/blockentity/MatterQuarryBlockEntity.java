package com.github.dynamicquarries.common.block.blockentity;

import com.github.dynamicquarries.common.capability.quarrydata.CapabilityQuarryData;
import com.github.dynamicquarries.common.capability.quarrydata.IQuarryData;
import com.github.dynamicquarries.common.capability.quarrydata.QuarryData;
import com.github.dynamicquarries.common.registry.RegistryBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class MatterQuarryBlockEntity extends BlockEntity {

    private final QuarryData quarryData = new QuarryData(new ArrayList<>(), 1, 1);
    private LazyOptional<IQuarryData> quarryOptional = LazyOptional.empty();

    public MatterQuarryBlockEntity(BlockPos pos, BlockState state) {
        super(RegistryBlock.MATTER_QUARRY_BLOCK_ENTITY.get(), pos, state);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, MatterQuarryBlockEntity blockEntity) {
        System.out.println(blockEntity.quarryData.getEnergyUse());
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityQuarryData.QUARRY_DATA) {
            return quarryOptional.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        quarryOptional = LazyOptional.of(() -> quarryData);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        quarryOptional.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("quarryData", quarryData.serializeNBT());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        quarryData.deserializeNBT(tag.getCompound("quarryData"));
    }
}
