package com.example.myapplication.ui.detailedFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.data.BUNDLE_KEY
import com.example.myapplication.data.item.Item
import com.example.myapplication.databinding.FragmentDetailedBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailedFragment : Fragment() {

    lateinit var binding: FragmentDetailedBinding
    private val detailedFragmentViewModel by viewModel<DetailedFragmentViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailedFragmentViewModel.getCurrentItem(arguments?.getSerializable(BUNDLE_KEY) as Item)
        binding.idTextView.text = detailedFragmentViewModel.getId().toString()
        binding.nameTextView.text = detailedFragmentViewModel.getName()
        binding.descriptionTextView.text = detailedFragmentViewModel.getDescription()
        detailedFragmentViewModel.saveId(detailedFragmentViewModel.getId())
    }
}

