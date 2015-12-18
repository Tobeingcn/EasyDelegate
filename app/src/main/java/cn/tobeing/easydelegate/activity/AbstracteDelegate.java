package cn.tobeing.easydelegate.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

/**
 * Created by sunzheng on 15/12/18.
 */
public class AbstracteDelegate {

    protected View rootView;

    protected Activity mActivity;

    protected Context mConext;
    /****
     * 构造函数，要求传入相应的Fragment
     */
    public AbstracteDelegate(){

    }
    public void onAttach(Activity activity){
        mConext=activity.getApplication();
        mActivity=activity;
    }
    /**
     * delegate初始化的时候被调用，
     * @param view
     */
    public void onCreate(View view){
        rootView=view;
    }

    /**
     * 返回context,注意这个context不是activity
     * @return
     */
    public Context getConext(){
        return mConext;
    }

    /**
     * 返回当前的activity
     * @return
     */
    public Activity getActivity(){
        return mActivity;
    }
    /**
     * 根据id找到子View
     * **/
    public View findViewById(int id){
        return rootView.findViewById(id);
    }

    public void onResume(){

    }
    public void onStart(){

    }
    public void onPause(){

    }
    public void onStop(){

    }
    public void onDestory(){

    }

    /**
     * 销毁代理类
     */
    public void recyle(){
        mActivity=null;
        mConext=null;
        rootView=null;
    }
}
