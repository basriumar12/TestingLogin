package info.blogbasbas.logintesting.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import info.blogbasbas.logintesting.R;
import info.blogbasbas.logintesting.db.model.LibraryTblItem;
import timber.log.Timber;

/**
 * Created by User on 06/03/2018.
 */

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.MyHolder> {
    private LibraryClickListener clickListener;
    private List<LibraryTblItem> dataset;

    public LibraryAdapter(LibraryClickListener libraryClickListener){
        this.clickListener = libraryClickListener;
        this.dataset = new ArrayList<LibraryTblItem>();
    }
    public interface LibraryClickListener {
        void onClick (int position);
    }
    public void setLibrary (List<LibraryTblItem> libraryTblItems){
        dataset = libraryTblItems;
        notifyDataSetChanged();
    }
    public LibraryTblItem getLibraryTblItem(int position){
        return dataset.get(position);
    }


    @Override
    public LibraryAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_library, parent, false);
        return new MyHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(LibraryAdapter.MyHolder holder, int position) {
        LibraryTblItem libraryTblItem = dataset.get(position);
        Timber.e("recyclerview :"+libraryTblItem.getAuthor());
        Log.d("", "onBindViewHolder: "+libraryTblItem.getAuthor());
        holder.txtAthor.setText(libraryTblItem.getAuthor());
        holder.txtTitle.setText(libraryTblItem.getTitle());
        holder.txtIdLibrary.setText(String.valueOf(libraryTblItem.getLibraryId()));
        holder.txtGenre.setText(libraryTblItem.getGenre());

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
       public TextView txtTitle, txtGenre,txtAthor, txtIdLibrary;
        public MyHolder(View itemView, final LibraryClickListener clickListener) {
            super(itemView);
           txtTitle = (TextView)itemView.findViewById(R.id.txtTitleSubcription);
           txtIdLibrary =(TextView)itemView.findViewById(R.id.txtLibraryId);
           txtGenre =(TextView)itemView.findViewById(R.id.txtGenre);
           txtAthor =(TextView)itemView.findViewById(R.id.txtAuthor);
        }
    }


}
