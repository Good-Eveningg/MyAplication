package com.example.myapplication.ui.firstFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.APP
import com.example.myapplication.data.BUNDLE_KEY
import com.example.myapplication.data.ItemHolder
import com.example.myapplication.data.item.Item
import com.example.myapplication.databinding.FragmentFrirstBinding
import com.example.myapplication.services.myService.MyService


class FirstFragment : Fragment() {

    lateinit var binding: FragmentFrirstBinding
    private val adapter by lazy { Adapter(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFrirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rw : RecyclerView = binding.rw
        rw.adapter = adapter
        adapter.insertList(ItemHolder.items)
    }

    companion object{
        fun onClick(item: Item){
            val bundle = Bundle()
            bundle.putSerializable(BUNDLE_KEY, item)
            APP.navController.navigate(R.id.action_firstFragment_to_detailedFragment, bundle)

        }
    }
}
