package com.developer76.data.datasource

import com.developer76.data.mappers.BaseMapper
import com.developer76.data.model.ResumeCache
import com.developer76.domain.datasource.ResumeLocalDataSource
import com.developer76.domain.model.Resume
import io.reactivex.Completable
import javax.inject.Inject

class ResumeLocalDataSourceImpl @Inject constructor(
    private val mapper: BaseMapper<ResumeCache, Resume>
): RealmDataSource<ResumeCache>(ResumeCache::class.java), ResumeLocalDataSource {
    override fun saveResume(resume: Resume): Completable {
        return Completable.fromAction {
            save(mapper.transform(resume))
        }
    }
}