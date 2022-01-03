package com.example.harajtask.overview

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.harajtask.R
import com.example.harajtask.databinding.FragmentOverviewBinding
import com.example.harajtask.overview.adapter.OverviewListAdapter


class OverviewFragment : Fragment() {

    private lateinit var binding: FragmentOverviewBinding
    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentOverviewBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.productsListRecyclerview.adapter = OverviewListAdapter {
            viewModel.productClicked(it)
        }

        viewModel.navigateToDetailFragment.observe(viewLifecycleOwner, Observer { product ->
            product?.let {
                val action =
                    OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(product)
                NavHostFragment.findNavController(this).navigate(action)
                viewModel.doneNavigation()
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search_menu, menu)
        val menuItem = menu.findItem(R.id.action_search)
        val searchView = menuItem.actionView as SearchView

    }

}