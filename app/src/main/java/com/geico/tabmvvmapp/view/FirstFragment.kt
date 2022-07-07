package com.geico.tabmvvmapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.geico.tabmvvmapp.R
import com.geico.tabmvvmapp.data.*
import com.geico.tabmvvmapp.databinding.FragmentFirstBinding
import com.geico.tabmvvmapp.model.FirstUsers
import com.geico.tabmvvmapp.repository.FirstFragViewmodelFactory
import com.geico.tabmvvmapp.repository.FirstUserRepository
import com.geico.tabmvvmapp.viewmodel.FirstFragViewmodel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.EntryPoint


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    lateinit var firstFragViewmodel: FirstFragViewmodel


    private val TAG = "FirstFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)

        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dao = UserDatabase.getDatabase(requireContext()).firstUserDao()

        val repository = FirstUserRepository(dao)

        firstFragViewmodel = ViewModelProvider(requireActivity(),
            FirstFragViewmodelFactory(repository)
        ).get(FirstFragViewmodel::class.java)

        binding.submitButton.setOnClickListener { onSubmitData() }

        binding.skipButton.setOnClickListener { onSkipData() }

        firstFragViewmodel.getUserData().observe(requireActivity(), Observer {
            Log.d(TAG, "onViewCreated: "+it.toString())
        })

    }

    private fun onSkipData() {
        Log.d(TAG, "onSkipData: ")
    }

    private fun onSubmitData() {

        val name = binding.nameTv.text.toString()
        val lastName=binding.lastNameTv.text.toString()
        val pass =binding.passwordTv.text.toString()

        if (name.isEmpty()){
            Toast.makeText(requireContext(),"please enter name",Toast.LENGTH_SHORT).show()
        }else if(lastName.isEmpty()){
            Toast.makeText(requireContext(),"please enter lastName",Toast.LENGTH_SHORT).show()
        }else if (pass.isEmpty()){
            Toast.makeText(requireContext(),"please enter pass",Toast.LENGTH_SHORT).show()
        }else{
            alertDialogue("Save Confirm", "Are you sure to save?", FirstUsers(0,name,lastName,pass))
        }

    }

    fun alertDialogue(title:String, supportingText:String, user: FirstUsers){
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(title)
            .setMessage(supportingText)
            .setNeutralButton(resources.getString(R.string.cancel)) { dialog, which ->
                Toast.makeText(requireContext(),"cancel",Toast.LENGTH_SHORT).show()
                binding.nameTv.text?.clear()
                binding.lastNameTv.text?.clear()
                binding.passwordTv.text?.clear()
            }
            .setPositiveButton(resources.getString(R.string.accept)) { dialog, which ->
                firstFragViewmodel.insertUserData(user)
                Toast.makeText(requireContext(),"Successful",Toast.LENGTH_SHORT).show()
                binding.nameTv.text?.clear()
                binding.lastNameTv.text?.clear()
                binding.passwordTv.text?.clear()
            }
            .show()
    }
}