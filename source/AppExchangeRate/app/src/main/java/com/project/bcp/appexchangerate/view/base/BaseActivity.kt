package com.project.bcp.appexchangerate.view.base

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    open lateinit var activityCurrent: BaseActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityCurrent = this
    }

    protected open fun goToActivity(activity: Class<*>?, bundle: Bundle?, notDestroy: Boolean) {
        val intent = Intent(this, activity)
        if (bundle != null)intent.putExtras(bundle)
        startActivity(intent)
        if (!notDestroy) finish()
    }

    protected open fun goToActivityAnimation(
        activity: Class<*>?,
        bundle: Bundle?,
        notDestroy: Boolean,
        options: ActivityOptions
    ) {
        val intent = Intent(this, activity)
        if (bundle != null)intent.putExtras(bundle)
        startActivity(intent, options.toBundle())
        if (!notDestroy) finish()
    }

    protected open fun goToActivity(activity: Class<*>?) {
        startActivity(Intent(this, activity))
    }

    protected open fun goToActivityForResult(activity: Class<*>?, result: Int) {
        val intent = Intent(this, activity)
        startActivityForResult(intent, result)
    }

    protected open fun goToActivityForResult(activity: Class<*>?, bundle: Bundle?, result: Int) {
        val intent = Intent(this, activity)
        if (bundle != null)intent.putExtras(bundle)
        startActivityForResult(intent, result)
    }

    protected open fun goToActivityCloseSession(activity: Class<*>?) {
        val intent = Intent(this, activity)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }





}