package com.developer76.data.mappers

import com.developer76.data.model.ResumeCache
import com.developer76.domain.model.Resume
import javax.inject.Inject

class ResumeMapper @Inject constructor(): BaseMapper<ResumeCache, Resume> {
    override fun transform(input: ResumeCache): Resume {
        return Resume().apply {
            name = input.name
            lastName = input.lastName
            profile = input.profile
        }
    }

    override fun transform(input: Resume): ResumeCache {
        return ResumeCache().apply {
            name = input.name
            lastName = input.lastName
            profile = input.profile
        }
    }
}