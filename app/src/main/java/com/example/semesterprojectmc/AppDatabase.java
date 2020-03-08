package com.example.semesterprojectmc;


import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Group.class,Friend.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    @SuppressLint("StaticFieldLeak")
    private static AppDatabase appDatabase;

    public abstract GroupDAO group();
    public abstract FriendDAO friend();

    private Context context;

    public static AppDatabase getInstance(Context context){

        if(appDatabase == null){
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "expensify-database").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
//    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
//        @Override
//        public void migrate(SupportSQLiteDatabase database) {
//            database.execSQL("CREATE TABLE IF NOT EXISTS `Friends` (`fid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `uid` INTEGER NOT NULL, `fname` TEXT, `gid` INTEGER NOT NULL)");
//
//        }
//    };

    public static void destroyInstance() {
        appDatabase = null;
    }
}

