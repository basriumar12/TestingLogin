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
import info.blogbasbas.logintesting.db.model.UserTbl;
import info.blogbasbas.logintesting.db.model.UserTblDao;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {


    @BindView(R.id.txtName)
    TextView txtName;
    @BindView(R.id.txtEmail)
    TextView txtEmail;
    @BindView(R.id.txtSchool)
    TextView txtSchool;
    @BindView(R.id.txtClassName)
    TextView txtClassName;
    Unbinder unbinder;

    UserTblDao userTblDao;
     UserTbl userTbl;
     DaoSession daoSession;
    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        unbinder = ButterKnife.bind(this, view);

       daoSession = BaseApplication.getDaoSession();
       userTblDao = daoSession.getUserTblDao();
        List<UserTbl> userTbls = daoSession.getUserTblDao().queryBuilder().list();

        txtName.setText(userTbls.get(0).getName());
        txtClassName.setText(userTbls.get(0).getClassName());
        txtEmail.setText(userTbls.get(0).getEmail());
        txtSchool.setText(userTbls.get(0).getSchool());

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
