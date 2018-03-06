package info.blogbasbas.logintesting.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.infideap.atomic.Atom;
import com.infideap.atomic.FutureCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.blogbasbas.logintesting.R;
import info.blogbasbas.logintesting.db.LoginRequest;
import info.blogbasbas.logintesting.db.ResponseLogin;
import info.blogbasbas.logintesting.db.facade.Facade;
import info.blogbasbas.logintesting.db.facade.ManageLibraryTbl;
import info.blogbasbas.logintesting.db.facade.ManageSubcriptionTbl;
import info.blogbasbas.logintesting.db.facade.ManageUserTbl;
import info.blogbasbas.logintesting.db.model.LibraryTblItem;
import info.blogbasbas.logintesting.db.model.SubscriptionTbl;
import info.blogbasbas.logintesting.db.model.UserTbl;
import info.blogbasbas.logintesting.helper.SessionManager;
import okhttp3.Headers;
import timber.log.Timber;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.etEmail)
    TextInputEditText etEmail;
    @BindView(R.id.inputEmail)
    TextInputLayout inputEmail;
    @BindView(R.id.etPassword)
    TextInputEditText etPassword;
    @BindView(R.id.inputPassword)
    TextInputLayout inputPassword;
    @BindView(R.id.loading)
    ProgressBar loading;
    @BindView(R.id.btnSignin)
    Button btnSignin;

    @BindView(R.id.rootView)
    RelativeLayout rootView;
    ProgressDialog pd;
    Facade facade;

    SessionManager sessionManager;
    private final String protocol = "http://";
    private final String domain = "156.67.216.158/feo/public/v1/login";
    private final String path = protocol.concat(domain);
    String token = "testnotification";
    @BindView(R.id.layoutLogin)
    ConstraintLayout layoutLogin;

    ManageLibraryTbl manageLibraryTbl;
    ManageUserTbl manageUserTbl;
    ManageSubcriptionTbl manageSubcriptionTbl;
    List<LibraryTblItem> libraryTbls;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        sessionManager= new SessionManager(getApplicationContext());
        manageLibraryTbl = Facade.getInstance().getManageLibraryTbl();
        manageUserTbl = Facade.getInstance().getManageUserTbl();
        manageSubcriptionTbl = Facade.getInstance().getManageSubcriptionTbl();

        libraryTbls = new ArrayList<>();
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getdata();
            }
        });
    }


    private void getdata() {
        final LoginRequest loginRequest = new LoginRequest();
        loginRequest.Password = etPassword.getText().toString();
        loginRequest.Username = etEmail.getText().toString();
        loginRequest.Token = token;

//add validasi
        if (etPassword.getText().toString().isEmpty()){
            Snackbar.make(layoutLogin," Pass is empty",Snackbar.LENGTH_LONG).show();

        }
        else if (etEmail.getText().toString().isEmpty()) {
            Snackbar.make(layoutLogin, " Username is empty", Snackbar.LENGTH_LONG).show();
        }
        else {

            Headers.Builder builder = new Headers.Builder();
            builder.add("ApiKey", "v:Dt4p2]$BTRyz^hrS).");
            builder.add("Content-Type", "application/json");


            Atom.with(LoginActivity.this)
                    .load(path)
                    .setHeader(builder.build())
                    .setJsonPojoBody(loginRequest)
                    .as(ResponseLogin.class)
                    .setCallback(new FutureCallback<ResponseLogin>() {
                        @Override
                        public void onCompleted(Exception e, ResponseLogin result) {

                            //ngecek error dan respon
                            Timber.e("ERROR : " + new Gson().toJson(e));
                       //     Timber.e("RESPOSNE : " + new Gson().toJson(result));




                            if (e != null) {
                                Timber.e("error " + e.getMessage());
                                e.printStackTrace();
                            }


                            if (result.getApiStatus() == 201) {

                                List<LibraryTblItem> x = result.apiValue.libraryTbl;
                                UserTbl y = result.apiValue.userTbl;
                                SubscriptionTbl z = result.apiValue.subscriptionTbl;
                                //looping list
                                for (LibraryTblItem lib : x){
                                    Timber.e("hasil 1 "+lib);

                                    manageLibraryTbl.removeAll();
                                    manageUserTbl.removeAll();
                                    manageSubcriptionTbl.removeAll();

                                     manageLibraryTbl.add(x);
                                     manageUserTbl.add(y);
                                     manageSubcriptionTbl.add(z);
                                }


                                sessionManager.createSession(etEmail.getText().toString());
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra("data", new Gson().toJson(result));
                                startActivity(intent);


                                Timber.e("hasil :" + result.getApiMessage());
                                Timber.e("hasil : " + result.getApiStatus());
                                Timber.e("hasil : " + loginRequest.Password);
                                Timber.e("hasil a : " + result.apiValue.libraryTbl);

                            }
                            Snackbar.make(layoutLogin, " Username / Pass is incorrect", Snackbar.LENGTH_LONG).show();


                        }
                    });



        }

    }

    private void saveData (ResponseLogin response){
       /* UserTbl userTbl = (UserTbl) response.getDataUser();
        SubscriptionTbl subscriptionTbl = (SubscriptionTbl) response.getDataSubcription();
        LibraryTbl libraryTbl = (LibraryTbl) response.getDataLibrary();

        List<UserTbl> userTbls = new ArrayList<>();
        List<SubscriptionTbl >subscriptionTbls = new ArrayList<>();
        List<LibraryTbl>libraryTbls = new ArrayList<>();
*/

        /*facade.getManageUserTbl().removeAll();
        facade.getManageLibraryTbl().removeAll();
        facade.getManageSubcriptionTbl().removeAll();

        if (userTbl != null){
            facade.getManageUserTbl().add(userTbl);
        }
        if (subscriptionTbl != null){
            facade.getManageSubcriptionTbl().add(subscriptionTbl);

        }
        if (libraryTbl != null){
            facade.getManageLibraryTbl().add(libraryTbl);
        }

        if (userTbls.size() > 0){
            facade.getManageUserTbl().add((UserTbl) userTbls);
        }

        if (subscriptionTbls.size() > 0){
            facade.getManageSubcriptionTbl().add(subscriptionTbls);
        }
        if (libraryTbls.size() > 0){
            facade.getManageLibraryTbl().add(libraryTbls);
        }

*/
    }

}
