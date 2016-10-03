package co.mhmt.gridtest.ui.viewitems;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import butterknife.BindView;
import co.mhmt.gridtest.R;
import co.mhmt.gridtest.domain.Photo;
import me.relex.photodraweeview.PhotoDraweeView;

public class PhotosViewHolder extends BaseViewHolder<Photo> {

  @BindView(R.id.drawee_photo_thumbnail)
  protected PhotoDraweeView thumbnailDrawee;
  @BindView(R.id.text_view_photo_title)
  protected TextView titleTextView;

  public PhotosViewHolder(final View itemView) {
    super(itemView);
  }

  @Override
  public void bind(final Photo photo) {
    titleTextView.setText(photo.getTitle());
    ImageRequest request = ImageRequestBuilder
                               .newBuilderWithSource(Uri.parse(photo.getThumbnailUrl()))
                               .build();
    DraweeController controller = Fresco.newDraweeControllerBuilder()
                                        .setImageRequest(request)
                                        .setOldController(thumbnailDrawee.getController())
                                        .build();
    thumbnailDrawee.setController(controller);
  }
}
