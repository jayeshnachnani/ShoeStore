package com.udacity.shoestore

import android.app.Activity
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseMethod
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
//import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_detail.*
import kotlinx.android.synthetic.main.fragment_shoe_detail.view.*
import timber.log.Timber
import kotlin.reflect.KProperty

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private val viewModel: ShoeViewModel by activityViewModels()

    //private val viewModel: ShoeViewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val sdbinding: FragmentShoeDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        sdbinding.shoeViewModel?.shoe = viewModel.shoe
        if (activity != null && isAdded()) {
            sdbinding.setLifecycleOwner(activity)
        }


        sdbinding.btnSave.setOnClickListener {
            if (sdbinding.editShoeName.getText().toString().trim().equals("")) {
                sdbinding.editShoeName.setError("This Field cannot be blank")
            } else if (sdbinding.editShoeSize.getText().toString().trim().equals("")) {
                sdbinding.editShoeSize.setError("This Field cannot be blank")
            } else if (sdbinding.editShoeCompany.getText().toString().trim().equals("")) {
                sdbinding.editShoeCompany.setError("This Field cannot be blank")
            } else if (sdbinding.editShoeDescription.getText().toString().trim().equals("")) {
                sdbinding.editShoeDescription.setError("This Field cannot be blank")
            } else {
                var shoe: Shoe = Shoe(
                    editShoeName.text.toString(),
                    editShoeSize.text.toString().toDouble(),
                    editShoeCompany.text.toString(),
                    editShoeDescription.text.toString()
                )
                /*shoe.name = editShoeName.text.toString()
            shoe.size = editShoeSize.text.toString().toDouble()
            shoe.company = editShoeCompany.text.toString()
            shoe.description = editShoeCompany.text.toString()*/

                viewModel.shoe.name = editShoeName.text.toString()
                viewModel.shoe.size = editShoeSize.text.toString().toDouble()
                viewModel.shoe.company = editShoeCompany.text.toString()
                viewModel.shoe.description = editShoeDescription.text.toString()

                viewModel.addToList(shoe)
                Timber.i("View Model now is :" + viewModel.shoeList.value)
                //Navigation not working
                //Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoesListFragment)
                //this.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoesListFragment())
                this.findNavController().navigateUp()
            }
            //view.findNavController()
        }
        sdbinding.btnCancel.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoesListFragment)
        )

        return sdbinding.root
    }


    /*companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ShoeDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShoeDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}




