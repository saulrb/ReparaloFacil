package com.facil.reparalo.reparalofacil.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Switch;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;


import com.facil.reparalo.reparalofacil.R;
import com.facil.reparalo.reparalofacil.dagger.MainApplication;
import com.facil.reparalo.reparalofacil.models.AccessTokenModel;
import com.facil.reparalo.reparalofacil.models.AuthenticationModel;
import com.facil.reparalo.reparalofacil.models.CredencialsModel;
import com.facil.reparalo.reparalofacil.network.services.AuthenticationService;
import com.facil.reparalo.reparalofacil.preferences.services.PreferencesService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    View loginProgress;
    AutoCompleteTextView email;
    EditText password;
    Button buttonSingin;
    FloatingActionButton fActionButtonRegister;
    Switch rememberme ;
    static final int REQUEST_CODE_REGISTRAR = 1;
    static final int REQUEST_CODE_RECUPERAR = 2;

    private CompositeDisposable compositeDisposable;

    @Inject
    AuthenticationService authenticationService;

    @Inject
    PreferencesService preferencesService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MainApplication)getApplication())
                .getMainActivityComponent()
                .inject(this);
        mapViewComponents();
    }

    @Override
    protected void onPostResume() {
        getSettingsFromPreferences();
        super.onPostResume();
    }

    private void mapViewComponents(){
        loginProgress = findViewById(R.id.login_progress);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        buttonSingin = findViewById(R.id.buttonSingin);
        fActionButtonRegister = findViewById(R.id.fActionButtonRegister);
        rememberme = findViewById(R.id.swRememberme);
        rememberme.setOnClickListener(this);
        buttonSingin.setOnClickListener(this);
        fActionButtonRegister.setOnClickListener(this);
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSettingsFromPreferences();
    }

    @Override
    public void onClick(View view) {
        switch( view.getId()) {
            case R.id.buttonSingin:
                sessionLogin();
                break;
            case R.id.fActionButtonRegister:
                registerUser();
                break;
            case R.id.swRememberme:
                preferencesService.saveRememberMe(rememberme.isChecked());
                if (!rememberme.isChecked()) preferencesService.clearCredentials();
                break;
        }
    }

    private void sessionLogin(){
        showProgress(true);
        CredencialsModel credencialsModel = new CredencialsModel()
                .setEmail(email.getText().toString())
                .setPassword(password.getText().toString());
        if (rememberme.isChecked()) preferencesService.saveCredentials(credencialsModel);
        AuthenticationModel authModel= new AuthenticationModel()
                .setAuth(credencialsModel);
        compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(authenticationService.getAuthToken(authModel)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError));
    }

    private void registerUser(){
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivityForResult(intent,REQUEST_CODE_REGISTRAR);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_OK){
            Bundle params = data.getExtras();
            if (requestCode == REQUEST_CODE_REGISTRAR) {
                password.setText(params.getString("password"));
                email.setText(params.getString("email"));
            }
        }
    }

    private void handleResponse(AccessTokenModel tokenModel){
        Toast.makeText(this,"Token:" + tokenModel.getJwt() ,Toast.LENGTH_SHORT).show();
        showProgress(false);
    }

    private void handleError(Throwable throwable){
        Toast.makeText(this,"Error in accessing JSON" + throwable.getLocalizedMessage() ,Toast.LENGTH_SHORT).show();
        showProgress(false);
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
            loginProgress.setVisibility(show ? View.VISIBLE : View.GONE);
            loginProgress.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    loginProgress.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            loginProgress.setVisibility(show ? View.VISIBLE : View.GONE);
        }
    }

    private void getSettingsFromPreferences(){
        rememberme.setChecked(preferencesService.getRememberMe());
        if (rememberme.isChecked()) {
            CredencialsModel credencialsModel = preferencesService.getCredentials();
            if (credencialsModel.getEmail() != null && !credencialsModel.getEmail().isEmpty()) {
                email.setText(credencialsModel.getEmail());
                password.setText(credencialsModel.getPassword());
            }
        }
    }
}
