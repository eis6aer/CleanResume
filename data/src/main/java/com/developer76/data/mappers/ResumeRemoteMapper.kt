package com.developer76.data.mappers

import com.developer76.data.model.ResumeRemote
import com.developer76.domain.model.Resume
import javax.inject.Inject

class ResumeRemoteMapper @Inject constructor(): BaseRemoteMapper<ResumeRemote, Resume> {
    override fun transform(input: ResumeRemote): Resume {
        return Resume().apply {
            name = input.name
            lastName = input.lastName
            profile = input.profile
        }
    }
}