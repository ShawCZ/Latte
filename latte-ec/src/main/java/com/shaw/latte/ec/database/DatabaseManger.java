package com.shaw.latte.ec.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * Created by shaw on 2017/9/2.
 */

public class DatabaseManger {

    private DaoSession mDaoSession = null;
    private UserProfileDao mDao = null;

    private DatabaseManger(){
    }

    public DatabaseManger init(Context context){
        initDao(context);
        return this;
    }

    private static final class Holder{
        private static final DatabaseManger INSTANCE = new DatabaseManger();
    }

    public static DatabaseManger getInstance(){
        return Holder.INSTANCE;
    }

    private void initDao(Context context){
        final ReleaseOpenHelper helper = new ReleaseOpenHelper(context,"fast_ec.db");
        final Database db = helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
        mDao = mDaoSession.getUserProfileDao();
    }

    public final UserProfileDao getDao(){
        return mDao;
    }
}
