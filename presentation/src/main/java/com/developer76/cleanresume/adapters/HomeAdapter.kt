package com.developer76.cleanresume.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.developer76.cleanresume.MainActivity
import com.developer76.cleanresume.home.ContactFragment
import com.developer76.cleanresume.home.ProjectsFragment
import com.developer76.cleanresume.home.ResumeFragment

class HomeAdapter(mainActivity: MainActivity) : FragmentPagerAdapter(mainActivity.supportFragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            ResumeFragment.RESUME_PAGE -> {
                ResumeFragment.newInstance()
            }
            ProjectsFragment.PROJECTS_PAGE -> {
                ProjectsFragment.newInstance()
            }
            ContactFragment.CONTACT_PAGE -> {
                ContactFragment.newInstance()
            }
            else -> {
                // Default page in case of unexpected tab click
                ResumeFragment.newInstance()
            }
        }
    }

    override fun getCount(): Int = 3
}