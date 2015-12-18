package cn.tobeing.easydelegate.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sunzheng on 15/12/18.
 */
public class AbsDelegateFragment extends Fragment{
    DelegateManager delegate=new DelegateManager();
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        delegate.onAttach(activity);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        delegate.onCreate(view);
    }
    @Override
    public void onResume() {
        super.onResume();
        delegate.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        delegate.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
        delegate.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        delegate.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        delegate.onDestory();
    }
}
