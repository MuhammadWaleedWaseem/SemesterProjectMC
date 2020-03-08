package com.example.semesterprojectmc;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface FriendDAO {

    @Query(value = "Select * from Friends")
    public LiveData<List<Friend>> getAllFriends();

    @Query("SELECT * FROM friends WHERE fid = :fid LIMIT 1")
    public  Friend findFriend(int fid);

    @Delete
    public void deleteFriend(Friend friend);

    @Insert(onConflict = REPLACE)
    public long insertNewFriend(Friend friend);

}
