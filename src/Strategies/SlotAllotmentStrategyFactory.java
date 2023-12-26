package Strategies;

import model.SlotAllotmentStrategyType;

public class SlotAllotmentStrategyFactory {
    public static SlotAllotmentStrategy getSlotForType(SlotAllotmentStrategyType slotAllotmentStrategyType){
        if(slotAllotmentStrategyType==slotAllotmentStrategyType.RandomSlotAllotmentStrategy){
            return new RandomSlotAllotmentStrategy();
        }
        return null;
    }
}
