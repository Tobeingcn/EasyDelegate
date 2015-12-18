package cn.tobeing.easydelegate.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunzheng on 15/12/19.
 */
public class BroadcastDelegate extends AbstracteDelegate{
    private BroadcastListener mBroadcastListener;
    private MyBroadCastReceiver myBroadCastReceiver;
    public BroadcastDelegate(BroadcastListener listener){
        mBroadcastListener=listener;
    }
    @Override
    public void onCreate(View view) {
        super.onCreate(view);
        if(mBroadcastListener!=null) {
            IntentFilter filter = new IntentFilter();
            List<String> actions = new ArrayList<>();
            mBroadcastListener.setUpAction(actions);
            for (String action : actions) {
                filter.addAction(action);
            }
            myBroadCastReceiver = new MyBroadCastReceiver();
            getActivity().registerReceiver(myBroadCastReceiver, filter);
        }
    }

    @Override
    public void onDestory() {
        super.onDestory();
        if(mBroadcastListener!=null){
            mActivity.unregisterReceiver(myBroadCastReceiver);
        }
    }

    public static interface BroadcastListener {

        public void setUpAction(List<String> actions);

        public void onBroadcast(Context context,Intent intent);
    }
    private class MyBroadCastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if(mBroadcastListener!=null){
                mBroadcastListener.onBroadcast(context, intent);
            }
        }
    }
}
