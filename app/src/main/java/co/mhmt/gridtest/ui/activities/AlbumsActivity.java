package co.mhmt.gridtest.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.mhmt.gridtest.R;
import co.mhmt.gridtest.adapters.AlbumsRecyclerViewAdapter;
import co.mhmt.gridtest.domain.Album;

public class AlbumsActivity extends AppCompatActivity {

  @BindView(R.id.recycler_view_albums)
  protected RecyclerView albumsRecyclerView;
  private AlbumsRecyclerViewAdapter albumsAdapter;

  private List<Album> dummyData = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    
    initiateUI();

    dummyData.add(new Album(0,0, "YOLO OR SWA SD ASDJ DJL DJ: LASDJ :DJ D:KSJ JLAD  D:JASD DJ LDJAS :ASJA SADDSDLAS DKASD  JDSAJ ASDJAS DASD ASDJS DJAS DAS DASJ DKASD ASJD ASDJKA SDJSAD KASDJ AKSD ASDKA DS"));
    dummyData.add(new Album(0,0, "aasg dsfdsf asdf asfsdf asdfasda"));

    dummyData.add(new Album(0,0, "YOLO OR SWA SD ASDJ DJL DJ: LASDJ :DJ D:KSJ JLAD  D:JASD DJ LDJAS :ASJA SADDSDLAS DKASD  JDSAJ ASDJAS DASD ASDJS DJAS DAS DASJ DKASD ASJD ASDJKA SDJSAD KASDJ AKSD ASDKA DS\n"
                            + "asdasdasf afdsf asf dsfasd fdsaf asdfasd fas"));
    dummyData.add(new Album(0,0, "aasg dsfdsf asdf asfsdf asdfasda"));
  }

  private void initiateUI() {
    albumsAdapter = new AlbumsRecyclerViewAdapter(dummyData);
    albumsRecyclerView.setHasFixedSize(false);
    albumsRecyclerView.setLayoutManager(new LinearLayoutManager(AlbumsActivity.this));
    albumsRecyclerView.setAdapter(albumsAdapter);

//    albumsRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));
//    albumsRecyclerView.setEmptyView(emptyView);
//    albumsRecyclerView.setFloatingActionButton(fabAddImage);
  }
}
