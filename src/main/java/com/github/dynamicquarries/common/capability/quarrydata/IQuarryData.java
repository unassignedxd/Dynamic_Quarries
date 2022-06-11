package com.github.dynamicquarries.common.capability.quarrydata;

import net.minecraft.core.BlockPos;

import java.util.ArrayList;

public interface IQuarryData {

    int setMiningSpeed(int newSpeed);
    int getMiningSpeed();

    int setEnergyUse(int newUse);
    int getEnergyUse();

    ArrayList<BlockPos> setMiningList(ArrayList<BlockPos> newList);
    ArrayList<BlockPos> getMiningList();
}
