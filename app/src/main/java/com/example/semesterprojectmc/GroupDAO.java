package com.example.semesterprojectmc;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface GroupDAO {

    @Query(value = "Select * from Groups")
    public LiveData<List<Group>> getAllGroups();

    @Query("SELECT * FROM groups WHERE gid = :gId LIMIT 1")
    public  Group findGroup(int gId);

    @Delete
    public void deleteGroup(Group group);

    @Insert(onConflict = REPLACE)
    public long insertNewGroup(Group group);

}
