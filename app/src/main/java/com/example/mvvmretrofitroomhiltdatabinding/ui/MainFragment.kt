package com.example.mvvmretrofitroomhiltdatabinding.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.mvvmretrofitroomhiltdatabinding.R
import com.example.mvvmretrofitroomhiltdatabinding.adapters.UniversityListAdapter
import com.example.mvvmretrofitroomhiltdatabinding.databinding.FragmentMainBinding
import com.example.mvvmretrofitroomhiltdatabinding.modal.University
import com.example.mvvmretrofitroomhiltdatabinding.viemodel.UniversityListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var binding : FragmentMainBinding? = null
    private val _binding get() = binding
    private val mUniversityListViewModel by viewModels<UniversityListViewModel>()
    private lateinit var adapter : UniversityListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
       initMembers()
        initObserver()
        return _binding?.root
    }

    private fun initMembers() {
        adapter = UniversityListAdapter(::onRecyclerListItemClickListner)
    }

    private fun initObserver() {
        binding?.recyclerView?.adapter = adapter
//        mUniversityListViewModel.result.observe(viewLifecycleOwner){ universityList ->
//            adapter.setUniversity(universityList)
//
//        }

        mUniversityListViewModel.getUniversityListDB().observe(viewLifecycleOwner){
            adapter.setUniversity(it)
        }

        mUniversityListViewModel.loading.observe(viewLifecycleOwner){loadingStatus ->
            if(loadingStatus)
                binding?.progressBar?.visibility = View.VISIBLE
            else
                binding?.progressBar?.visibility = View.GONE
        }

        mUniversityListViewModel.errorMessage.observe(viewLifecycleOwner){ errorMessage ->
            Toast.makeText(context, "$errorMessage", Toast.LENGTH_SHORT).show()

        }

        mUniversityListViewModel.navigateToUniversityDetailFragmentLiveData.observe(viewLifecycleOwner){

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun onRecyclerListItemClickListner(university: University){
        Toast.makeText(context, "Hello ${university.name}", Toast.LENGTH_SHORT).show()
    }
}