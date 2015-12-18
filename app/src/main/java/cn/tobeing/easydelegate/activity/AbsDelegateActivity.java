package cn.tobeing.easydelegate.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by sunzheng on 15/12/18.
 */
public class AbsDelegateActivity extends Activity{
    DelegateManager delegates=new DelegateManager();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delegates.onAttach(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        delegates.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        delegates.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        delegates.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        delegates.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        delegates.onDestory();
    }
}
