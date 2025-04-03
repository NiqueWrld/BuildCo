package com.niquewrld.buildco.Main;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.niquewrld.buildco.R;
import com.niquewrld.buildco.User.BaseActivity;
import com.niquewrld.buildco.databinding.ActivityProfileBinding;

public class ProfileActivity extends BaseActivity {

    private ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(view -> finish());
        binding.logoutBtn.setOnClickListener(view -> logout());
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();//to sign out using firebase
        Intent intent=new Intent(getApplicationContext(), WelcomeActivity.class);//now the user will be signed out then we
        startActivity(intent);// move to login activity
        finish();
    }
}