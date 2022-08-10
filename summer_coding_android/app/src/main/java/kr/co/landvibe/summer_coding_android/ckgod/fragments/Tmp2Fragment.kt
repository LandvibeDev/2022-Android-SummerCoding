package kr.co.landvibe.summer_coding_android.ckgod.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kr.co.landvibe.summer_coding_android.AutoClearedValue
import kr.co.landvibe.summer_coding_android.R
import kr.co.landvibe.summer_coding_android.databinding.FragmentTmp2Binding
import kr.co.landvibe.summer_coding_android.databinding.FragmentTmpBinding

class Tmp2Fragment : Fragment() {
    private var binding by AutoClearedValue<FragmentTmp2Binding>(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTmp2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvTmp.text = "B"
    }
}