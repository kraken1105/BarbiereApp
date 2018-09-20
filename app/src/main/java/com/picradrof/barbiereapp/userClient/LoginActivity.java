package com.picradrof.barbiereapp.userClient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.*;

import com.picradrof.barbiereapp.R;
import com.picradrof.barbiereapp.entity.*;
import com.picradrof.barbiereapp.businessLogic.*;
import com.picradrof.barbiereapp.businessLogic.exception.*;
import com.picradrof.barbiereapp.utility.DBHandler;

public class LoginActivity extends AppCompatActivity {

    private EditText mUsernameView, mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Avvia il gestore del database per l'intera app
        DBHandler db = DBHandler.getInstance(this);

        // CoordinatorBusiness
        final ICliente coordinatore = CoordinatorFacade.getInstance();

        // Nasconde la tastiera, che altrimenti apparirebbe immediatamente
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        // Set up the login form
        mUsernameView = (EditText) findViewById(R.id.username);
        mPasswordView = (EditText) findViewById(R.id.password);

        Button LoginButton = (Button) findViewById(R.id.login_button);
        LoginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mUsernameView.setError(null);
                mPasswordView.setError(null);

                try {
                    IEntityCliente cliente = coordinatore.login(mUsernameView.getText().toString(),
                            mPasswordView.getText().toString());

                    Intent loggedInUserPage = new Intent(LoginActivity.this, LoggedInUserActivity.class);
                    loggedInUserPage.putExtra("clienteLoggato", (Cliente) cliente);
                    startActivity(loggedInUserPage);

                    finish();

                } catch(UsernameTooShortException e) {
                    mUsernameView.setError(e.getMessage());
                    mUsernameView.requestFocus();
                } catch(PasswordTooShortException e) {
                    mPasswordView.setError(e.getMessage());
                    mPasswordView.requestFocus();
                } catch(WrongLoginInfoException e) {
                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                } catch(UserNotEnabledException e) {
                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        Button SignInButton = (Button) findViewById(R.id.sign_in_button);
        SignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInPage = new Intent(LoginActivity.this,SignInActivity.class);
                startActivity(signInPage);
            }
        });
    }
}

