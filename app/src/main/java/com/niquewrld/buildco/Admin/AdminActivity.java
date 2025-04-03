package com.niquewrld.buildco.Admin;

import android.content.Intent;
import android.os.Bundle;

import com.niquewrld.buildco.Main.ProfileActivity;
import com.niquewrld.buildco.User.BaseActivity;
import com.niquewrld.buildco.databinding.ActivityAdminBinding;

public class AdminActivity extends BaseActivity {

    private ActivityAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bottomNavigation();
    }

    private void bottomNavigation() {
        binding.ProfileBtn.setOnClickListener(v -> startActivity(new Intent(AdminActivity.this , ProfileActivity.class)));
    }
}