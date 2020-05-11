package com.example.musicscorereader

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Matrix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Size
import android.view.Surface
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.camera.core.CameraX
import androidx.camera.core.Preview
import androidx.camera.core.impl.PreviewConfig
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import org.opencv.android.OpenCVLoader
import java.util.concurrent.Executors

private const val REQUEST_CODE_PERMISSIONS = 10

// This is an array of all the permission specified in the manifest.
private const val IMMERSIVE_FLAG_TIMEOUT = 500L
const val FLAGS_FULLSCREEN =
    View.SYSTEM_UI_FLAG_LOW_PROFILE or
            View.SYSTEM_UI_FLAG_FULLSCREEN or
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

class MainActivity : AppCompatActivity() {

    private lateinit var container: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        container = findViewById(R.id.fragment_container)
        Log.d("verify",(OpenCVLoader.initDebug()).toString());
    }

    override fun onResume() {
        super.onResume()
        // Before setting full screen flags, we must wait a bit to let UI settle; otherwise, we may
        // be trying to set app to immersive mode before it's ready and the flags do not stick
        container.postDelayed({
            container.systemUiVisibility = FLAGS_FULLSCREEN
        }, IMMERSIVE_FLAG_TIMEOUT)
    }
}
