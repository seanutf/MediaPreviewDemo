package com.seanutf.mediapreviewdemo

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.permissionx.guolindev.PermissionX
import com.seanutf.media.queryprovider.QueryMode
import com.seanutf.media.queryprovider.config.QueryConfig
import com.seanutf.media.queryprovider.data.ImgFormat
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

    private fun createConfig(): QueryConfig {
        val config = QueryConfig()
        with(config) {
            mode = QueryMode.ALL
        }

        return config
    }
}