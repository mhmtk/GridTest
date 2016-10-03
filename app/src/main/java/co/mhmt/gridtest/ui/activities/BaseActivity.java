package co.mhmt.gridtest.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.greenrobot.eventbus.EventBus;

import co.mhmt.gridtest.Constant;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class BaseActivity extends AppCompatActivity{

  protected Retrofit retrofit;
  protected EventBus eventBus;

  @Override protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    retrofit = new Retrofit.Builder().baseUrl(Constant.NETWORK.BASE_URL)
//                                     .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                                     .addConverterFactory(JacksonConverterFactory.create(new ObjectMapper()))
//                                       .client(client)
                                     .build();

    eventBus = EventBus.getDefault();
  }

  @Override protected void onResume() {
    super.onResume();
    eventBus.register(this);
  }

  @Override protected void onPause() {
    super.onPause();
    eventBus.unregister(this);
  }
}
