package com.droidbyme.bottomsheet

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {

    /** ⚽️ This  method is sufficient if you only need to set contentView and manipulate views */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.bottom_sheet_2, container, false)
        view.findViewById<ImageView>(R.id.imageView).setOnClickListener{
            Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
        }
        return view
    }

    /** 🏵 This method is needed if you want to set callback method which is triggered when the bottom sheet dialog is shown. Then you can watch state changes */
    /** In addition, you can set the layout in onCreateDialog() method, then you can remove the above onCreateView() method.
     *      val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
     *      val view = View.inflate(context, R.layout.fragment_bottomsheet3, null)
     *      dialog.setContentView(view)
     */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        dialog.setOnShowListener(DialogInterface.OnShowListener { dialogInterface ->
            val b = dialogInterface as BottomSheetDialog
            val b2 = b.findViewById<FrameLayout>(R.id.design_bottom_sheet)

            b2?.let{
                val bottomSheetBehavior = BottomSheetBehavior.from<FrameLayout>(it)
                bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback(){
                    override fun onSlide(bottomSheet: View, slideOffset: Float) {
                        Log.d("test123", "onSlide: $slideOffset")
                    }

                    override fun onStateChanged(bottomSheet: View, newState: Int) {
                        Log.d("test123", "onStateChanged: $newState")
                    }

                })
            }
        })
        return dialog
    }

    /** 🪂 It is also possible to set layout using only setupDialog() method */
    /*override fun setupDialog(dialog: Dialog, style: Int) {
        val view = View.inflate(context, R.layout.bottom_sheet_2, null)

        view.findViewById<ImageView>(R.id.imageView).setOnClickListener{
            Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
        }

        dialog.setContentView(view)
    }*/
}