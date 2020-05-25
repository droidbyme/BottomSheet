package com.droidbyme.bottomsheet

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        btnPersistent.setOnClickListener(this)
        btnModal.setOnClickListener(this)
        btnModalFragment.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val intent: Intent
        when (view.id) {
            R.id.btnPersistent -> {
                intent = Intent(this, PersistentActivity::class.java)
                startActivity(intent)
            }
            R.id.btnModal -> {
                val dialogView = layoutInflater.inflate(R.layout.bottom_sheet_2, null)
                val dialog = BottomSheetDialog(this)
                dialog.setContentView(dialogView)
                dialog.show()
            }
            R.id.btnModalFragment -> {
                val bottomSheetFragment = BottomSheetFragment()
                bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
            }
        }
    }
}