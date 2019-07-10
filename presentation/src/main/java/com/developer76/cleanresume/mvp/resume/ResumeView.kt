package com.developer76.cleanresume.mvp.resume

import android.app.Activity
import com.developer76.cleanresume.home.ResumeFragment
import com.developer76.domain.model.Resume
import kotlinx.android.synthetic.main.fragment_resume.*
import javax.inject.Inject

class ResumeView @Inject constructor(
    private val fragment: ResumeFragment
): ResumeContract.View {
    lateinit var activity: Activity

    override fun initView() {
        activity = fragment.activity as Activity
    }

    override fun updateResume(resume: Resume) {
        activity.title_resume_page.text = resume.profile
    }
}