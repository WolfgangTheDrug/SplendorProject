package util;

import elements.Gem;

abstract public class ResourceVector {
    private byte[] amounts;
    private final Gem[] units;

    public ResourceVector(){
        this.amounts = new byte[Gem.values().length];
        this.units = Gem.values();
    }

    public ResourceVector(byte[] amounts) {
        this.amounts = amounts;
        this.units = Gem.values();
    }

    public byte[] getAmounts() {
        return amounts;
    }

    public void setAmounts(byte[] amounts) {
        this.amounts = amounts;
    }

    public Gem[] getUnits() {
        return units;
    }

    public void add(ResourceVector resourceVector) {
        for(int i = 0; i < this.amounts.length; i++) {
            this.amounts[i] += resourceVector.amounts[i];
        }
    }

    public boolean isGreaterOrEqual(ResourceVector resourceVector) {
        for(int i = 0; i < this.amounts.length; i++) {
            if (this.amounts[i] < resourceVector.amounts[i]){
                return false;
            }
        }
        return true;
    }
}
