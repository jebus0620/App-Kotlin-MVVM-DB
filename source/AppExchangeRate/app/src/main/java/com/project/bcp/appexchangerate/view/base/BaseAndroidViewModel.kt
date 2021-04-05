package com.project.bcp.appexchangerate.view.base

import android.app.Application
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.project.bcp.appexchangerate.R
import com.project.jebus.appdefreesa.view.listener.OnDialogListener

open class BaseAndroidViewModel(application: Application): AndroidViewModel(application) {

    var alertDialog = MutableLiveData<AlertDialog>()

    open fun customDialogAlert(message: String, context: Context){
        val view = View.inflate(context, R.layout.custom_dialog, null)
        alertDialog.value = MaterialAlertDialogBuilder(context, R.style.AlertDialogTheme)
            .setView(view)
            .create()
        var tviMessage = view.findViewById<TextView>(R.id.tviMessage)
        var tviAccept = view.findViewById<TextView>(R.id.tviAccept)
        var tviCancel = view.findViewById<TextView>(R.id.tviCancel)

        tviMessage.text = message
        tviCancel.visibility = View.GONE

        tviAccept.setOnClickListener {
            alertDialog.value!!.dismiss()
        }

        alertDialog.value!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(alertDialog.value!!.window?.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        alertDialog.value!!.window?.attributes = lp

    }

    open fun customDialogAlertAction(
        message: String,
        context: Context,
        cancelable: Boolean,
        listener: OnDialogListener
    ){
        val view = View.inflate(context, R.layout.custom_dialog, null)
        var tviMessage = view.findViewById<TextView>(R.id.tviMessage)
        var tviAccept = view.findViewById<TextView>(R.id.tviAccept)
        var tviCancel = view.findViewById<TextView>(R.id.tviCancel)
        tviMessage.text = message
        tviCancel.visibility = View.GONE

        alertDialog.value = MaterialAlertDialogBuilder(context, R.style.AlertDialogTheme)
            .setView(view)
            .setCancelable(cancelable)
            .create()

        tviCancel.setOnClickListener{
            alertDialog.value!!.dismiss()
        }

        tviAccept.setOnClickListener{
            listener.onClickAccept(alertDialog.value)
        }

        alertDialog.value!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(alertDialog.value!!.window?.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        alertDialog.value!!.window?.attributes = lp
        /*
        alertDialog.value = MaterialAlertDialogBuilder(context, R.style.AlertDialogTheme)
            .setTitle("Alerta")
            .setMessage(message)
            .setCancelable(cancelable)
            .setPositiveButton("Aceptar", listener)
            .create()
         */
    }

    open fun customDialogAlertActionPositiveAndNegative(
        message: String,
        context: Context,
        cancelable: Boolean,
        listener: OnDialogListener
    ){
        val view = View.inflate(context, R.layout.custom_dialog, null)
        var tviMessage = view.findViewById<TextView>(R.id.tviMessage)
        var tviAccept = view.findViewById<TextView>(R.id.tviAccept)
        var tviCancel = view.findViewById<TextView>(R.id.tviCancel)
        tviMessage.text = message

        alertDialog.value = MaterialAlertDialogBuilder(context, R.style.AlertDialogTheme)
            .setView(view)
            .create()

        tviCancel.setOnClickListener{
            alertDialog.value!!.dismiss()
        }

        tviAccept.setOnClickListener{
            listener.onClickAccept(alertDialog.value)
        }

        alertDialog.value!!.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(alertDialog.value!!.window?.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        alertDialog.value!!.window?.attributes = lp
        /*
        alertDialog.value = MaterialAlertDialogBuilder(context, R.style.AlertDialogTheme)
            .setTitle("Alerta")
            .setMessage(message)
            .setCancelable(cancelable)
            .setPositiveButton("Aceptar", listener)
            .setNegativeButton("Cancelar") { dialog, _ ->  dialog.dismiss()}
            .create()

         */
    }
}