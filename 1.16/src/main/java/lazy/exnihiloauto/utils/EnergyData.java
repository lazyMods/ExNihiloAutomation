package lazy.exnihiloauto.utils;

import lombok.ToString;
import lombok.var;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.energy.EnergyStorage;

@ToString
public class EnergyData extends EnergyStorage {

    private boolean canReceive;
    private boolean canExtract;

    public static final String TAG_ENERGY = "Energy";
    public static final String TAG_CAPACITY = "Capacity";
    public static final String TAG_CAN_RECEIVE = "CanReceive";
    public static final String TAG_CAN_EXTRACT = "CanExtract";

    public EnergyData(int capacity) {
        super(capacity);
        this.canReceive = true;
        this.canExtract = true;
    }

    public EnergyData(int capacity, boolean canReceive, boolean canExtract) {
        super(capacity);
        this.canReceive = canReceive;
        this.canExtract = canExtract;
    }

    public boolean canExtractAmount(int amount) {
        return this.energy - amount >= 0;
    }

    public void decreaseEnergy(int amount) {
        if(!this.canExtractAmount(amount)) return;
        this.energy -= amount;
    }

    public void setEnergyStored(int amount) {
        this.energy = amount;
    }

    public void setCapacity(int amount) {
        this.capacity = amount;
    }

    public void setCanReceive(boolean canReceive) {
        this.canReceive = canReceive;
    }

    public void setCanExtract(boolean canExtract) {
        this.canExtract = canExtract;
    }

    @Override
    public boolean canExtract() {
        return this.canExtract;
    }

    @Override
    public boolean canReceive() {
        return this.canReceive;
    }

    public CompoundNBT writeNBT() {
        var nbt = new CompoundNBT();
        nbt.putInt(TAG_ENERGY, this.energy);
        nbt.putInt(TAG_CAPACITY, this.capacity);
        nbt.putBoolean(TAG_CAN_EXTRACT, this.canExtract);
        nbt.putBoolean(TAG_CAN_RECEIVE, this.canReceive);
        return nbt;
    }

    public void readNBT(CompoundNBT nbt) {
        this.setEnergyStored(nbt.getInt(TAG_ENERGY));
        this.setCapacity(nbt.getInt(TAG_CAPACITY));
        this.setCanExtract(nbt.getBoolean(TAG_CAN_EXTRACT));
        this.setCanReceive(nbt.getBoolean(TAG_CAN_RECEIVE));
    }
}
