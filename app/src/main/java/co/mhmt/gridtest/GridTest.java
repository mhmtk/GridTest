package co.mhmt.gridtest;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import okhttp3.OkHttpClient;

public class GridTest extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    initializeFresco();
  }

  @Override
  public void onLowMemory() {
    Fresco.getImagePipeline().clearMemoryCaches();
    super.onLowMemory();
  }

  private void initializeFresco() {
    ImagePipelineConfig config =
        OkHttpImagePipelineConfigFactory.newBuilder(getApplicationContext(), new OkHttpClient.Builder().build())
                                        .setDownsampleEnabled(true)
                                        .build();
    Fresco.initialize(getApplicationContext(), config);
  }

}

