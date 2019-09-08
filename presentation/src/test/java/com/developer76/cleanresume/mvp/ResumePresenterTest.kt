package com.developer76.cleanresume.mvp

import com.developer76.cleanresume.RxSchedulersOverride
import com.developer76.cleanresume.mvp.resume.ResumeContract
import com.developer76.cleanresume.mvp.resume.ResumePresenter
import com.developer76.domain.model.Resume
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.lang.Exception

class ResumePresenterTest {

    @get:Rule
    var rxSchedulers = RxSchedulersOverride()

    @Mock
    lateinit var resumeModel: ResumeContract.Model

    @Mock
    lateinit var resumeView: ResumeContract.View

    lateinit var resumePresenter: ResumePresenter
    var resume = Resume("Javier", "Torres", "Android Developer")

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        resumePresenter = ResumePresenter(resumeModel, resumeView)
    }

    @Test
    fun `when init is called view#initView should be called`() {
        resumePresenter.init()
        verify(resumeView).initView()
    }

    @Test
    fun `when requestResume is called model should return resume and render to view`() {
        whenever(resumeModel.getResume()).thenReturn(Single.just(resume))
        resumePresenter.requestResume()
        verify(resumeView).updateResume(resume)
    }

    @Test
    fun `when requestResume throws and exception not mother of view should be called`() {
        whenever(resumeModel.getResume()).thenReturn(Single.error(Exception("No resume found")))
        resumePresenter.requestResume()
        verifyNoMoreInteractions(resumeView)
    }
}