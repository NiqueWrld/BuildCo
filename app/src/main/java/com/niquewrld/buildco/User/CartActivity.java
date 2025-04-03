
package com.niquewrld.buildco.User;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.niquewrld.buildco.Adapter.CartAdapter;
import com.niquewrld.buildco.Helper.ManagmentCart;
import com.niquewrld.buildco.databinding.ActivityCartBinding;

public class CartActivity extends BaseActivity {
    ActivityCartBinding binding;
    private ManagmentCart managementCart;
    private double tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        managementCart = new ManagmentCart(this);

        calculatorCart();
        setVariable();
        initCartList();

    }

    private void initCartList() {
        if (managementCart.getListCart().isEmpty()) {
            binding.emptyTxt.setVisibility(View.VISIBLE);
            binding.scrollViewCart.setVisibility(View.GONE);
        } else {
            binding.emptyTxt.setVisibility(View.GONE);
            binding.scrollViewCart.setVisibility(View.VISIBLE);
        }

        binding.cartView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.cartView.setAdapter(new CartAdapter(managementCart.getListCart(), this, () -> calculatorCart()));
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(view -> finish());
    }

    private void calculatorCart() {
        double percentTax = 0.15;
        double delivery = 20;

        tax = Math.round((managementCart.getTotalFee() * percentTax));

        double total = Math.round((managementCart.getTotalFee() + tax + delivery));
        double itemTotal = Math.round(managementCart.getTotalFee() * 100) / 100;

        binding.totalFeeTxt.setText("R" + itemTotal);
        binding.taxTxt.setText("R" + tax);
        binding.deliveryTxt.setText("R" + delivery);
        binding.totalTxt.setText("R" + total);

    }
}