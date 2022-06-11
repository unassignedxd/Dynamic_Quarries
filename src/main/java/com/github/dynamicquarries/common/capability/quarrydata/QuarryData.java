package com.github.dynamicquarries.common.capability.quarrydata;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.util.INBTSerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;

public class QuarryData implements IQuarryData, INBTSerializable<Tag> {

    protected ArrayList<BlockPos> miningList;
    protected int energyUse;
    protected int miningSpeed;

    public QuarryData(@Nonnull ArrayList<BlockPos> miningList, int energyUse, int miningSpeed){
        this.miningList = miningList;
        this.energyUse = energyUse;
        this.miningSpeed = miningSpeed;
    }

    @Override
    public int setMiningSpeed(int newSpeed) {
        this.miningSpeed = newSpeed;
        return this.miningSpeed;
    }

    @Override
    public int getMiningSpeed() {
        return this.miningSpeed;
    }

    @Override
    public int setEnergyUse(int newUse) {
        this.energyUse = newUse;
        return this.energyUse;
    }

    @Override
    public int getEnergyUse() {
        return this.energyUse;
    }

    @Override
    public ArrayList<BlockPos> setMiningList(ArrayList<BlockPos> newList) {
        this.miningList = newList;
        return miningList;
    }

    @Override
    public ArrayList<BlockPos> getMiningList() {
        return this.miningList;
    }

    @Override
    public Tag serializeNBT() {
        CompoundTag ret = new CompoundTag();

        ListTag listTag = new ListTag();
        for(BlockPos pos : this.miningList) {
            listTag.add(NbtUtils.writeBlockPos(pos));
        }

        ret.put("miningList", listTag);

        return ret;
    }

    @Override
    public void deserializeNBT(Tag nbt) {
        ArrayList<BlockPos> tempList = new ArrayList<>();

        if(nbt.getId() == Tag.TAG_COMPOUND) {
            CompoundTag comp = ((CompoundTag) nbt);
            ListTag listTag = comp.getList("miningList", Tag.TAG_COMPOUND);

            for(int i = 0; i < listTag.size(); i++) {
                tempList.add(NbtUtils.readBlockPos(listTag.getCompound(i)));
            }

            setMiningList(tempList);
        }
    }
}
