package com.seanutf.mediapreviewdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.seanutf.mediapreviewdemo.databinding.FragmentMediaPreviewSettingBinding

/**
 * @Author seanutf
 * @Date 2022/2/15 9:51 下午
 * @Desc 对媒体查找器的设置页面
 */
class MediaPreviewSettingFragment : Fragment() {

    private lateinit var vb: FragmentMediaPreviewSettingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        vb = FragmentMediaPreviewSettingBinding.inflate(inflater, container, false)
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}