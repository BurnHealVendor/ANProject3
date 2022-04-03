package com.example.anproject3.views

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.anproject3.MusicApp
import com.example.anproject3.adapter.ClassicAdapter
import com.example.anproject3.databinding.FragmentClassicBinding
import com.example.anproject3.model.SongItem
import com.example.anproject3.presenters.ClassicPresenterContract
import com.example.anproject3.presenters.ClassicViewContract
import javax.inject.Inject

class ClassicFrag : Fragment(), ClassicViewContract {

    @Inject
    lateinit var presenter: ClassicPresenterContract

    private var _binding: FragmentClassicBinding? = null
    private val binding: FragmentClassicBinding? get() = _binding

    private val classicAdapter by lazy {
        ClassicAdapter(onTrackClicked = {})
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MusicApp.musicComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding?.recView?.apply {
            layoutManager = GridLayoutManager(requireContext(), 3, GridLayoutManager.VERTICAL, false)
            adapter = classicAdapter
        }

        presenter.initializePres(this)

        presenter.checkNetworkConn()

        return binding?.root
    }

    override fun loadingClassic(isLoading: Boolean) {
        binding?.recView?.visibility = View.GONE
        binding?.progBar?.visibility = View.VISIBLE
    }

    override fun classicSuccess(music: List<SongItem>) {
        binding?.progBar?.visibility = View.GONE
        binding?.recView?.visibility = View.VISIBLE
        classicAdapter.updateClassic(music)
    }

    override fun classicError(error: Throwable) {
        binding?.recView?.visibility = View.GONE
        binding?.progBar?.visibility = View.GONE

        AlertDialog.Builder(requireContext())
            .setTitle("AN ERROR HAS OCCURRED")
            .setMessage(error.localizedMessage)
            .setPositiveButton("DISMISS") { dialogInterface, i ->
                dialogInterface.dismiss()
            }
            .create()
            .show()
    }

    companion object {
        fun newInstance() =
            ClassicFrag().apply {
                arguments = Bundle().apply {
                }
            }
    }
}