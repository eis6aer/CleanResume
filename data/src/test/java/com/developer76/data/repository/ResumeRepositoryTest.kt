package com.developer76.data.repository

import com.developer76.data.RxSchedulersOverride
import com.developer76.domain.datasource.ResumeLocalDataSource
import com.developer76.domain.datasource.ResumeRemoteDataSource
import com.developer76.domain.model.Resume
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ResumeRepositoryTest {

    lateinit var resumeRepository: ResumeRepositoryImpl

    @Mock
    lateinit var resumeLocalDataSource: ResumeLocalDataSource

    @Mock
    lateinit var resumeRemoteDataSource: ResumeRemoteDataSource

    @get:Rule
    var rxSchedulers = RxSchedulersOverride()

    var resume = Resume("Javier", "Torres", "Android Developer")

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        resumeRepository = ResumeRepositoryImpl(resumeLocalDataSource, resumeRemoteDataSource)
        whenever(resumeRemoteDataSource.getResume()).thenReturn(Single.just(resume))
    }

    @Test
    fun `when getResume is called remoteDataSource#getResume should be called and stored by localDataSource#save`() {
        resumeRepository.getResume()
            .test()
            .dispose()

        verify(resumeRemoteDataSource).getResume()
        verify(resumeLocalDataSource).saveResume(resume)
    }
}