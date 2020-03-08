package com.example.semesterprojectmc;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Groups")
public class Group {

    @PrimaryKey(autoGenerate = true)
    private int gid;


    @ColumnInfo(name = "gname")
    private String gname;


    @ColumnInfo(name = "ownerId")
    private int ownerId;


    public Group(String gname, int ownerId) {
        this.gname = gname;
        this.ownerId = ownerId;
    }

    @NonNull
    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}


