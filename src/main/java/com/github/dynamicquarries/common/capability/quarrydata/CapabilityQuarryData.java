package com.github.dynamicquarries.common.capability.quarrydata;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class CapabilityQuarryData {

    public static final Capability<IQuarryData> QUARRY_DATA = CapabilityManager.get(new CapabilityToken<>(){});

}
