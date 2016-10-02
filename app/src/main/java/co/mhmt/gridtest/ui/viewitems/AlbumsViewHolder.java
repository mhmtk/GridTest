package co.mhmt.gridtest.ui.viewitems;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.mhmt.gridtest.R;
import co.mhmt.gridtest.domain.Album;

public class AlbumsViewHolder extends RecyclerView.ViewHolder{


  @BindView(R.id.text_view_title)
  protected TextView titleTextView;

  public AlbumsViewHolder(final View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }

  public void bind(final Album album) {
    titleTextView.setText(album.getTitle());
  }
}
