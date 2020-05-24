package com.droidbyme.bottomsheet

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.content_main.*

class PersistentActivity : AppCompatActivity() {
    private lateinit var sheetBehavior: BottomSheetBehavior<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "Persistent Bottom Sheet"
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        sheetBehavior = BottomSheetBehavior.from(bottom_sheet)
        btn_bottom_sheet.setOnClickListener(View.OnClickListener {
            if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
                btn_bottom_sheet.setText("Close sheet")
            } else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
                btn_bottom_sheet.setText("Expand sheet")
            }
        })
        sheetBehavior.addBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(view: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        btn_bottom_sheet.setText("Close Sheet")
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        btn_bottom_sheet.setText("Expand Sheet")
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {

                    }
                    BottomSheetBehavior.STATE_SETTLING -> {

                    }
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {

                    }
                }
            }

            override fun onSlide(view: View, v: Float) {}
        })
    }
}