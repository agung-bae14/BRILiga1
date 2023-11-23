package com.example.ligasatu

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Club(
    val name: String,
    val since: String,
    val manager: String,
    val coach: String,
    val stadium: String,
    val location: String,
    val description: String,
    val logo: String,
    val photo: String,
): Parcelable
