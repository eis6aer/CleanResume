package com.developer76.cleanresume.home


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.developer76.cleanresume.R
import com.developer76.cleanresume.mvp.resume.ResumeContract
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResumeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ResumeFragment : Fragment() {

    @Inject
    lateinit var presenter: ResumeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resume, container, false)
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        presenter.init()
    }

    override fun onResume() {
        super.onResume()
        presenter.requestResume()
    }

    companion object {

        const val RESUME_PAGE = 0
        @JvmStatic
        fun newInstance() =
            ResumeFragment()
    }
}
