package info.blogbasbas.logintesting.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import info.blogbasbas.logintesting.BaseApplication;
import info.blogbasbas.logintesting.R;
import info.blogbasbas.logintesting.db.model.DaoSession;
import info.blogbasbas.logintesting.db.model.LibraryTblItem;
import info.blogbasbas.logintesting.db.model.LibraryTblItemDao;
import info.blogbasbas.logintesting.ui.adapter.LibraryAdapter;
import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 */
public class LibraryFragment extends Fragment  {


//    @BindView(R.id.rvLibrary)
//    RecyclerView rvLibrary;
    DaoSession daoSession;
    LibraryTblItemDao libraryTblItemDao;
    Unbinder unbinder;
    private Query<LibraryTblItem> libraryTblItemQuery;
    LibraryAdapter libraryAdapter;
    RecyclerView recyclerView;
    List<LibraryTblItem>itemList;
    public LibraryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_library, container, false);
        unbinder = ButterKnife.bind(this, view);
       recyclerView= (RecyclerView)view.findViewById(R.id.rvLibrary);
        daoSession = BaseApplication.getDaoSession();
        libraryTblItemDao = daoSession.getLibraryTblItemDao();
        itemList = new ArrayList<>();


         setupView();

        libraryTblItemQuery = libraryTblItemDao.queryBuilder().orderAsc(LibraryTblItemDao.Properties.Title).build();
        updateData();


        return view;
    }

    private void updateData() {
        List<LibraryTblItem> libraryTblItemList = libraryTblItemQuery.list();
        libraryAdapter.setLibrary(libraryTblItemList);
    }

    private void setupView() {
        libraryAdapter = new LibraryAdapter(clickListener);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(libraryAdapter);

    }
    LibraryAdapter.LibraryClickListener clickListener = new LibraryAdapter.LibraryClickListener() {
        @Override
        public void onClick(int position) {

            LibraryTblItem libraryTblItem = libraryAdapter.getLibraryTblItem(position);
            Long libraryId = libraryTblItem.getLibraryId();
            Timber.e("Klik :"+libraryId);

        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
