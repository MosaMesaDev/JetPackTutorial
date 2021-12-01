package com.mosamesadev.jetpacktutorial.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mosamesadev.jetpacktutorial.R
import com.mosamesadev.jetpacktutorial.databinding.FragmentAllArticlesBinding
import com.mosamesadev.jetpacktutorial.view.activities.AddUpdateActivity
import com.mosamesadev.jetpacktutorial.viewmodel.AllArticlesViewModel

class AllArticlesFragment : Fragment() {

    private lateinit var allArticlesViewModel: AllArticlesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    private var _binding: FragmentAllArticlesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        allArticlesViewModel =
            ViewModelProvider(this).get(AllArticlesViewModel::class.java)

        _binding = FragmentAllArticlesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        allArticlesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_all_articles, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.action_add_article -> {
                startActivity(Intent(requireActivity(), AddUpdateActivity::class.java))
            return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}