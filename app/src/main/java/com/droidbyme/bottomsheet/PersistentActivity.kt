package com.droidbyme.bottomsheet

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import kotlinx.android.synthetic.main.activity_persistent.*
import kotlinx.android.synthetic.main.bottom_sheet.*

class PersistentActivity : AppCompatActivity() {
    private lateinit var sheetBehavior: BottomSheetBehavior<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persistent)

        sheetBehavior = BottomSheetBehavior.from(bottom_sheet)
        btn_bottom_sheet.setOnClickListener(View.OnClickListener {
            if (sheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            } else {
                sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        })
        sheetBehavior.addBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(view: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        btn_bottom_sheet.text = "STATE_HIDDEN"
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        btn_bottom_sheet.text = "STATE_EXPANDED"
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        btn_bottom_sheet.text = "STATE_COLLAPSED"
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        btn_bottom_sheet.text = "STATE_DRAGGING"
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                        btn_bottom_sheet.text = "STATE_SETTLING"
                    }
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {
                        btn_bottom_sheet.text = "STATE_HALF_EXPANDED"
                    }
                }
            }

            override fun onSlide(view: View, v: Float) {}
        })
    }
}