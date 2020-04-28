package com.developer76.data.datasource

import com.developer76.data.mappers.BaseMapper
import com.developer76.data.model.ResumeCache
import com.developer76.domain.model.Resume
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doNothing
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.spy
import org.mockito.MockitoAnnotations

class ResumeLocalDataSourceTest {

    @Mock
    lateinit var remoteMapper: BaseMapper<ResumeCache, Resume>

    var resume = Resume("Javier", "Torres", "Android Developer")

    lateinit var remoteDataSource: ResumeLocalDataSourceImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        remoteDataSource = spy(ResumeLocalDataSourceImpl(remoteMapper))
        doNothing().whenever(remoteDataSource).save(any())
    }

    @Test
    fun `when SaveResume is invoked, mapper should transform the input`() {
        remoteDataSource.saveResume(resume)
            .test()
            .dispose()
        verify(remoteMapper).transform(resume)
    }
}