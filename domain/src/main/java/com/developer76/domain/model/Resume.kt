package com.developer76.domain.model

import com.developer76.domain.constants.EMPTY_STRING

data class Resume(var name: String = EMPTY_STRING, var lastName: String = EMPTY_STRING, var profile: String = EMPTY_STRING)