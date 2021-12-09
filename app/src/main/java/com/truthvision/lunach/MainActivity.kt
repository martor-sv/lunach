package com.truthvision.lunach

import android.content.ComponentName
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.LogUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val homeWatcherReceiver = HomeWatcherReceiver()
        registerReceiver(homeWatcherReceiver, IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS))

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        LogUtils.d("$keyCode ===== $event")
        when (keyCode) {
            KeyEvent.KEYCODE_HOME -> {
                LogUtils.d("$keyCode ===== home")
                return true
            }
            KeyEvent.KEYCODE_BACK -> {
                LogUtils.d("$keyCode ===== back")
                return true
            }

        }
        return true
    }

    override fun onResume() {
        super.onResume()

//        val jypkg = "com.corejoyo.commissioner"
//        val jycls = "com.corejoyo.commissioner.module.splash.SplashActivity"
//        val jycomponet = ComponentName(jypkg, jycls)
//        val jyintent = Intent()
//        jyintent.component = jycomponet
//        jyintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        startActivity(jyintent)
//

        val pkg = "com.truthvision.cloudalertappmin"
        val cls = "com.truthvision.cloudalertappmini.MainActivity"
        val componet = ComponentName(pkg, cls)
        val intent = Intent()
        intent.component = componet
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

}