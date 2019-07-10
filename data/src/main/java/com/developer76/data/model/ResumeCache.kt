package com.developer76.data.model

import com.developer76.domain.constants.EMPTY_STRING
import io.realm.RealmObject

open class ResumeCache(var id : Int = 1,var name: String = EMPTY_STRING, var lastName: String = EMPTY_STRING, var profile: String = EMPTY_STRING) : RealmObject()