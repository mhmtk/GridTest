package co.mhmt.gridtest.ui.viewitems;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import co.mhmt.gridtest.events.AlbumViewHolderClicked;
import co.mhmt.gridtest.R;
import co.mhmt.gridtest.domain.Album;

public class AlbumsViewHolder extends BaseViewHolder implements View.OnClickListener{


  @BindView(R.id.text_view_title)
  protected TextView titleTextView;

  private int albumId;

  public AlbumsViewHolder(final View itemView) {
    super(itemView);
  }

  public void bind(final Album album) {
    albumId = album.getId();
    titleTextView.setText(album.getTitle());
  }

  @Override public void onClick(final View v) {
    eventBus.post(new AlbumViewHolderClicked(albumId));
  }
}
