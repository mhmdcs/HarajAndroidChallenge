package com.example.harajtask.detail

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.harajtask.R
import com.example.harajtask.databinding.FragmentDetailBinding
import com.example.harajtask.overview.OverviewViewModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this).get(DetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater)

        val product = DetailFragmentArgs.fromBundle(requireArguments()).selectedProduct
        binding.product = product

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
       //intent.putExtra(Intent.EXTRA_SUBJECT, "mock data")
       //intent.putExtra(Intent.EXTRA_TEXT, "mock data")
        startActivity(Intent.createChooser(intent, "Share"))
        return super.onOptionsItemSelected(item)
    }
}