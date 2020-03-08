package com.example.semesterprojectmc;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Friends")
public class Friend {

    @PrimaryKey(autoGenerate = true)
    private int fid;

    @ColumnInfo(name = "uid")
    private int uid;

    @ColumnInfo(name = "fname")
    private String fname;

    @ColumnInfo(name = "gid")
    private int gid;

    @NonNull
    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public Friend(int uid, String fname, int gid) {
        this.uid = uid;
        this.fname = fname;
        this.gid = gid;
    }
}
