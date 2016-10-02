package co.mhmt.gridtest;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class GridTest extends Application {

  private static GridTest instance;
  private static Retrofit RETROFIT;

  public static GridTest getInstance() {
    return instance;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;

    initializeFresco();
//    initializeTimber();
  }

  @Override
  public void onLowMemory() {
    Fresco.getImagePipeline().clearMemoryCaches();
    super.onLowMemory();
  }

//  private void initializeTimber() {
//    if (BuildConfig.DEBUG || Config.DEBUG_MODE_ENABLED) {
//      Timber.plant(new Timber.DebugTree());
//    } else {
//      Timber.plant(new CrashlyticsTree());
//    }
//  }

  private void initializeFresco() {
    ImagePipelineConfig config =
        OkHttpImagePipelineConfigFactory.newBuilder(getApplicationContext(), new OkHttpClient.Builder().build())
                                        .setDownsampleEnabled(true)
                                        .build();
    Fresco.initialize(getApplicationContext(), config);
//    Fresco.initialize(getApplicationContext());
  }

  static Retrofit retrofit(final ObjectMapper objectMapper) {
    if (RETROFIT == null) {
      RETROFIT = new Retrofit.Builder().baseUrl(Constant.NETWORK.BASE_URL)
//                                       .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                                       .addConverterFactory(JacksonConverterFactory.create(objectMapper))
//                                       .client(client)
                                       .build();
    }
    return RETROFIT;
  }

}

