package cn.tobeing.easydelegate.activity;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/**
 * Created by sunzheng on 15/12/19.
 */
public class HandlerDelegate extends AbstracteDelegate{

    private Handler mUIHandler;

    private Handler mWorkHandler;

    private Object mTarget;

    public HandlerDelegate(Object target){
        mTarget=target;
    }
    public Handler getUIHandler() {
        if (mUIHandler == null) {
            checkUIHandler();
        }
        return mUIHandler;
    }
    private synchronized void checkUIHandler(){
        if(mUIHandler ==null){
            mUIHandler =new UIHanlder(Looper.getMainLooper());
        }
    }
    public Handler getWorkHandler() {
        if (mWorkHandler == null) {
            checkWorkHandler();
        }
        return mWorkHandler;
    }
    private synchronized void checkWorkHandler(){
        if(mWorkHandler ==null){
            HandlerThread thread=new HandlerThread(mTarget+"");
            thread.start();
            mWorkHandler =new WorkHanlder(thread.getLooper());
        }
    }
    private class UIHanlder extends Handler{
        public UIHanlder(Looper looper){
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(mTarget==null){
                return;
            }
            if(mTarget instanceof MessageListener&&((MessageListener)mTarget).isAlive()){
                if(mTarget instanceof UIMessageListener){
                    ((UIMessageListener) mTarget).onUIMessage(msg);
                }
            }
        }
    }
    private class WorkHanlder extends Handler{
        public WorkHanlder(Looper looper){
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(mTarget==null){
                return;
            }
            if(mTarget instanceof MessageListener&&((MessageListener)mTarget).isAlive()){
                if(mTarget instanceof WorkMessageListener){
                    ((WorkMessageListener) mTarget).onWorkMessage(msg);
                }
            }
        }
    }
    public static interface MessageListener{
        /**
         * 判断当前的target是否还有效
         * **/
        public boolean isAlive();
    }
    public static interface UIMessageListener extends MessageListener{
        /**
         * UI线程消息触发
         * @param msg
         */
        public void onUIMessage(Message msg);
    }
    public static interface WorkMessageListener extends MessageListener{
        /**
         * 后台线程消息触发
         * @param msg
         */
        public void onWorkMessage(Message msg);
    }
    public static interface  WorkAndUIMessageListener extends WorkMessageListener,UIMessageListener{

    }
}
