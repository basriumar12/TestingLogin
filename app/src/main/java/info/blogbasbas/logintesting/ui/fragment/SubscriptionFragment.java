package info.blogbasbas.logintesting.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import info.blogbasbas.logintesting.BaseApplication;
import info.blogbasbas.logintesting.R;
import info.blogbasbas.logintesting.db.model.DaoSession;
import info.blogbasbas.logintesting.db.model.SubscriptionTbl;
import info.blogbasbas.logintesting.db.model.SubscriptionTblDao;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubscriptionFragment extends Fragment {


    @BindView(R.id.txtSubcriptionId)
    TextView txtSubcriptionId;
    @BindView(R.id.txtStart)
    TextView txtStart;
    @BindView(R.id.txtEnd)
    TextView txtEnd;
    @BindView(R.id.txtCreatedDate)
    TextView txtCreatedDate;
    Unbinder unbinder;

    DaoSession daoSession;
    SubscriptionTblDao subscriptionTblDao;

    public SubscriptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_subcription, container, false);
        unbinder = ButterKnife.bind(this, view);
        daoSession = BaseApplication.getDaoSession();
        subscriptionTblDao = daoSession.getSubscriptionTblDao();
        List<SubscriptionTbl> subscriptionTbls = daoSession
                                                    .getSubscriptionTblDao()
                                                    .queryBuilder()
                                                    .list();
        long idsubcription = subscriptionTbls.get(0).getSubscriptionId();

        txtSubcriptionId.setText(String.valueOf(idsubcription));
        txtStart.setText(subscriptionTbls.get(0).getSubscriptionStartTimestamp());
        txtEnd.setText(subscriptionTbls.get(0).getSubscriptionEndTimestamp());
        txtCreatedDate.setText(subscriptionTbls.get(0).getCreatedDate());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
