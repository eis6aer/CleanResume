package com.developer76.domain.repository

import com.developer76.domain.model.Contact
import io.reactivex.Completable
import io.reactivex.Single

interface ContactRepository {
    fun saveContactInfo(contactInfo: Contact): Completable
    fun getContactInfo(): Single<Contact>
}