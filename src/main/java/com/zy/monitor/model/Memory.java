package com.zy.monitor.model;

import org.hyperic.sigar.Mem;

public class Memory {
    private long total;
    private long used;
    private long free;
    private double usedPercent;
    private double freePercent;

    public Memory(){

    }
    public Memory(Mem mem){
        this.setTotal(mem.getTotal());
        this.setUsed(mem.getUsed());
        this.setFree(mem.getFree());
        this.setUsedPercent(mem.getUsedPercent());
        this.setFreePercent(mem.getFreePercent());
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getUsed() {
        return used;
    }

    public void setUsed(long used) {
        this.used = used;
    }

    public long getFree() {
        return free;
    }

    public void setFree(long free) {
        this.free = free;
    }

    public double getUsedPercent() {
        return usedPercent;
    }

    public void setUsedPercent(double usedPercent) {
        this.usedPercent = usedPercent;
    }

    public double getFreePercent() {
        return freePercent;
    }

    public void setFreePercent(double freePercent) {
        this.freePercent = freePercent;
    }
}
