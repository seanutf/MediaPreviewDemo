package com.seanutf.mediapreviewdemo

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.permissionx.guolindev.PermissionX
import com.seanutf.media.queryprovider.QueryMode
import com.seanutf.media.queryprovider.config.QueryConfig
import com.seanutf.media.queryprovider.core.MediaQueryProvider
import com.seanutf.mediapreviewgrid.MediaPreviewGridFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        questPermissions()
    }

    private fun questPermissions() {
        PermissionX.init(this)
            .permissions(Manifest.permission.MANAGE_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
            .request { allGranted, grantedList, deniedList ->
                addFragment()
                //loadMedias()
            }
    }

    private fun addFragment() {
        val trans = supportFragmentManager.beginTransaction()
        var fragment = supportFragmentManager.findFragmentByTag(MediaPreviewGridFragment.TAG) as? MediaPreviewGridFragment
        if (fragment == null) {
            fragment = MediaPreviewGridFragment.newInstance()
        }

        fragment.queryConfig = createConfig()

        trans.add(R.id.container, fragment, MediaPreviewGridFragment.TAG)
        trans.commitAllowingStateLoss()
    }

    private fun loadMedias() {
        Thread {
            val queryConfig = createConfig()
            val provider = MediaQueryProvider()
            provider.setConfig(application, queryConfig)
            val list = provider.loadAlbumMedias(-1, true)
            if (list.isNullOrEmpty()) {
                Log.i("ttt", "tttt")
            } else {
                Log.i("ttt", "tttt12133")
            }
        }.start()


    }

    private fun createConfig(): QueryConfig {
        val config = QueryConfig()
        with(config) {
            mode = QueryMode.ALL
        }

        return config
    }
}