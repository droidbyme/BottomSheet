package com.droidbyme.bottomsheet;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private android.widget.Button btnPersistent;
    private android.widget.Button btnModal;
    private android.support.v7.widget.Toolbar toolbar;
    private Button btnModalFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        setContentView(R.layout.activity_menu);
        this.btnModalFragment = (Button) findViewById(R.id.btnModalFragment);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Bottom Sheet");
        this.btnModal = (Button) findViewById(R.id.btnModal);
        this.btnPersistent = (Button) findViewById(R.id.btnPersistent);

        btnPersistent.setOnClickListener(this);
        btnModal.setOnClickListener(this);
        btnModalFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnPersistent:
                intent = new Intent(this, PersistentActivity.class);
                startActivity(intent);
                break;

            case R.id.btnModal:
                View dialogView = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
                BottomSheetDialog dialog = new BottomSheetDialog(this);
                dialog.setContentView(dialogView);
                dialog.show();
                break;

            case R.id.btnModalFragment:
                BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
                bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
                break;
        }
    }
}
