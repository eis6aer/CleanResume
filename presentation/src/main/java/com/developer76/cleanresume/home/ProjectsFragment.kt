package com.developer76.cleanresume.home


import android.app.Activity
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

class ProjectsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_projects, container, false)
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onResume() {
        super.onResume()
    }

    companion object {
        const val PROJECTS_PAGE = 1
        @JvmStatic
        fun newInstance() =
            ProjectsFragment()
    }
}
