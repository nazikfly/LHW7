package com.geektech.lhw7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.geektech.lhw7.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: CharacterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        loadData()
    }

    private fun loadData() {
        val list = ArrayList<CharacterModel>()
        list.apply {
            add(CharacterModel(R.drawable.image_one, "Rick", "ALive"))
            add(CharacterModel(R.drawable.image_two, "Morty", "Dead"))
            add(CharacterModel(R.drawable.image_third, "Albert", "ALive"))
            add(CharacterModel(R.drawable.image_one, "Jerry", "Dead"))
        }
        adapter = CharacterAdapter(list, this::onClickItem)
        binding.rmView.adapter = adapter
    }

    private fun onClickItem(model: CharacterModel) {
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToSecondFragment(model))
    }

    companion object {
        const val KEY_FOR_VALUE = "key value"
    }
}
