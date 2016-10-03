package co.mhmt.gridtest.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.greenrobot.eventbus.EventBus;

import co.mhmt.gridtest.R;
import retrofit2.Retrofit;

public class BaseActivity extends AppCompatActivity{

  protected Retrofit retrofit;
  protected EventBus eventBus;

  @Override protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    eventBus = EventBus.getDefault();
  }

  protected void setToolbar() {
    Toolbar toolbar = (Toolbar) findViewById(R.id.default_toolbar);
    setSupportActionBar(toolbar);
  }

  protected void enableUpNavigation() {
    ActionBar ab = getSupportActionBar();
    if (ab != null) {
      ab.setDisplayHomeAsUpEnabled(true);
    }
  }

  @Override protected void onStart() {
    super.onStart();
    eventBus.register(this);
  }


  @Override protected void onStop() {
    super.onStop();
    eventBus.unregister(this);
  }
}
