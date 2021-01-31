package com.udacity.shoestore

import android.databinding.tool.ext.S
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.common.primitives.Ints.indexOf
//import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoes_list.*
import timber.log.Timber

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShoesListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoesListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val viewModel: ShoeViewModel by activityViewModels()


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
        // Inflate the layout for this fragment
        val binding: FragmentShoesListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_list, container, false)
        Timber.i("Created boss!")
        setHasOptionsMenu(true)
        //binding.lifecycleOwner = activity
        /*val txtView: TextView = TextView(this.context)
        txtView.text = "Try Adding me"
        txtView.setTextSize(50.0F)
        binding.listLinearLayout.addView(txtView)
        val txtView2: TextView = TextView(this.context)
        txtView.text = "Try Adding me tooo!!"
        binding.listLinearLayout.addView(txtView2)*/

        viewModel.shoeList.observe(this.viewLifecycleOwner, Observer { newShoeList ->
            run {
                viewModel.shoeList.value?.forEach {
                    var txtShoeName: TextView = TextView(this.context)
                    txtShoeName.text = "Shoe Name: " + it.name.toString()
                    txtShoeName.setTextSize(20.0F)
                    binding.listLinearLayout.addView(txtShoeName)
                    var txtShoeDescription: TextView = TextView(this.context)
                    txtShoeDescription.text = "Shoe Description: " + it.description.toString()
                    txtShoeDescription.setTextSize(20.0F)
                    binding.listLinearLayout.addView(txtShoeDescription)
                    var txtShoeSize: TextView = TextView(this.context)
                    txtShoeSize.text = "Shoe Size: " + it.size.toString()
                    txtShoeSize.setTextSize(20.0F)
                    binding.listLinearLayout.addView(txtShoeSize)
                    var txtShoeCompany: TextView = TextView(this.context)
                    txtShoeCompany.text = "Shoe Company: " + it.company.toString()
                    txtShoeCompany.setTextSize(20.0F)
                    binding.listLinearLayout.addView(txtShoeCompany)
                    var txtSpace: TextView = TextView(this.context)
                    txtSpace.text = " "
                    txtSpace.setTextSize(20.0F)
                    binding.listLinearLayout.addView(txtSpace)


                }
                /*var txtView: TextView = TextView(this.context)
                txtView.text = viewModel.shoeList.value.toString()
                txtView.setTextSize(50.0F)
                binding.listLinearLayout.addView(txtView)*/
            }
        })

        binding.btnAddShoe.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoesListFragment_to_shoeDetailFragment)
        )

        //binding.listLinearLayout
        return binding.root
        //return inflater.inflate(R.layout.fragment_shoes_list, container, false)
    }


    override fun onResume() {
        super.onResume()
        Timber.i("Resumed boss!")
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.nav_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ShoesListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShoesListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}