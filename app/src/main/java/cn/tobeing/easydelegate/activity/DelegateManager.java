package cn.tobeing.easydelegate.activity;

import android.app.Activity;
import android.app.Fragment;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunzheng on 15/12/19.
 */
public class DelegateManager extends AbstracteDelegate{

    private List<AbstracteDelegate> delegates=new ArrayList<>();

    public DelegateManager() {

    }
    public void addDelegate(AbstracteDelegate delegate){
        if(mActivity!=null){
            delegate.onAttach(mActivity);
            if(rootView!=null){
                delegate.onCreate(rootView);
            }
        }
        delegates.add(delegate);
    }
    public void removeDelegate(AbstracteDelegate delegate){
        delegates.remove(delegate);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        for (AbstracteDelegate delegate:delegates){
            delegate.onAttach(activity);
        }
    }

    @Override
    public void onCreate(View view) {
        super.onCreate(view);
        for (AbstracteDelegate delegate:delegates){
            delegate.onCreate(view);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        for (AbstracteDelegate delegate:delegates){
            delegate.onStart();
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        for (AbstracteDelegate delegate:delegates){
            delegate.onResume();
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        for (AbstracteDelegate delegate:delegates){
            delegate.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        for (AbstracteDelegate delegate:delegates){
            delegate.onStop();
        }
    }

    @Override
    public void onDestory() {
        super.onDestory();
        for (AbstracteDelegate delegate:delegates){
            delegate.onDestory();
        }
    }
}
