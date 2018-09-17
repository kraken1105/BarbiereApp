package com.picradrof.barbiereapp.userClient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.picradrof.barbiereapp.R;
import com.picradrof.barbiereapp.businessLogic.CoordinatorFacade;
import com.picradrof.barbiereapp.businessLogic.exception.*;

public class SignInActivity extends AppCompatActivity {

    // UI references.
    private EditText mUsernameView, mPasswordView, mNomeView, mCognomeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // CoordinatorBusiness
        final CoordinatorFacade coordinatore = CoordinatorFacade.getInstance();

        // Set up the login form.
        mUsernameView = (EditText) findViewById(R.id.username);
        mPasswordView = (EditText) findViewById(R.id.password);
        mNomeView = (EditText) findViewById(R.id.nome);
        mCognomeView = (EditText) findViewById(R.id.cognome);

        Button mSignInButton = (Button) findViewById(R.id.registrati_button);
        mSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mUsernameView.setError(null);
                mPasswordView.setError(null);
                mNomeView.setError(null);
                mCognomeView.setError(null);

                try {
                    coordinatore.effettuaRegistrazione(mUsernameView.getText().toString(),
                            mPasswordView.getText().toString(), mNomeView.getText().toString(), mCognomeView.getText().toString());
                    Toast.makeText(SignInActivity.this, "Registrazione effettuata!\nAttendi l'attivazione da parte del barbiere", Toast.LENGTH_LONG).show();
                    finish();

                } catch(UsernameTooShortException e) {
                    mUsernameView.setError(e.getMessage());
                    mUsernameView.requestFocus();
                } catch(PasswordTooShortException e) {
                    mPasswordView.setError(e.getMessage());
                    mPasswordView.requestFocus();
                } catch(AlreadyExistingUsernameException e) {
                    mUsernameView.setError(e.getMessage());
                    mUsernameView.requestFocus();
                } catch(NameNullException e) {
                    mNomeView.setError(e.getMessage());
                    mNomeView.requestFocus();
                } catch(SurnameNullException e) {
                    mCognomeView.setError(e.getMessage());
                    mCognomeView.requestFocus();
                }
            }
        });
    }

}

