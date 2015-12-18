package cn.tobeing.easydelegate;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

/**
 * Created by sunzheng on 15/12/18.
 */
public class AbstracteDelegate {

    private View rootView;

    private Activity mActivity;

    private Fragment mFragment;

    private Context mConext;

    public AbstracteDelegate(Activity activity){
        mConext=activity.getApplication();
        mActivity=activity;
    }

    public AbstracteDelegate(Fragment fragment){
        mActivity=fragment.getActivity();
        mConext=mActivity.getApplication();
        mFragment=fragment;
    }
    public void onCreate(View view){
        rootView=view;
    }
    public Context getConext(){
        return mConext;
    }
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
    public void onPause(){

    }

    public void onDestory(){

    }
}
