package co.mhmt.gridtest.ui.activities;

import android.os.Bundle;
import android.support.v4.os.AsyncTaskCompat;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.mhmt.gridtest.Constant;
import co.mhmt.gridtest.R;
import co.mhmt.gridtest.adapters.BaseRecyclerViewAdapter;
import co.mhmt.gridtest.domain.Photo;
import co.mhmt.gridtest.events.PhotosDownloaded;
import co.mhmt.gridtest.jobs.DownloadPhotosOfAlbum;
import co.mhmt.gridtest.ui.viewitems.PhotosViewHolder;

public class PhotosActivity extends BaseActivity {

  @BindView(R.id.recycler_view_photos)
  protected RecyclerView photosRecyclerView;

  private BaseRecyclerViewAdapter<Photo> photosAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_photos);
    setToolbar();
    enableUpNavigation();
    ButterKnife.bind(this);

    int albumId = getIntent().getIntExtra(Constant.ALBUM_ID, -1);
    if (albumId != -1) {
      AsyncTaskCompat.executeParallel(new DownloadPhotosOfAlbum(), albumId);
    }
    initiateUI();
  }

  private void initiateUI() {
    photosAdapter = new BaseRecyclerViewAdapter<Photo>(new ArrayList<Photo>()) {
      @Override public PhotosViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new PhotosViewHolder(LayoutInflater.from(parent.getContext())
                                                  .inflate(R.layout.item_holder_photo, parent, false));
      }
    };
    photosRecyclerView.setHasFixedSize(true);
    photosRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));

    photosRecyclerView.setAdapter(photosAdapter);
  }

  @SuppressWarnings("UnusedDeclaration")
  @Subscribe (sticky = true)
  public void photosDownloaded(final PhotosDownloaded event) {
    if (event.getPhotos() != null) {
      photosAdapter.update(event.getPhotos());
    }
    eventBus.removeStickyEvent(event);
  }

}
