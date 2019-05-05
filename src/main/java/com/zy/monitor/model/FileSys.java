package com.zy.monitor.model;

import org.hyperic.sigar.FileSystemUsage;

public class FileSys {
    private String name;
    private long total;
    private long used;
    private long free;
    private long avail;
    private long write;
    private long read;

    public FileSys(){}

    public FileSys(String name, FileSystemUsage usage){
        this.setName(name);
        this.setFree(usage.getFree());
        this.setTotal(usage.getTotal());
        this.setUsed(usage.getUsed());
        this.setAvail(usage.getAvail());
        this.setRead(usage.getDiskReads());
        this.setWrite(usage.getDiskWrites());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public long getAvail() {
        return avail;
    }

    public void setAvail(long avil) {
        this.avail = avil;
    }

    public long getWrite() {
        return write;
    }

    public void setWrite(long write) {
        this.write = write;
    }

    public long getRead() {
        return read;
    }

    public void setRead(long read) {
        this.read = read;
    }
}
