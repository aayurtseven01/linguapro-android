package com.linguapro.android

/** Hacim genişletme paketlerini seviyeye göre dağıtır. */
object CourseVolume {
    fun units(level: String): List<LearningUnit> = when (level) {
        "A1" -> CourseVolumeA1.units
        "A2" -> CourseVolumeA2.units
        "B1" -> CourseVolumeB1.units
        "B2" -> CourseVolumeB2.units
        "C1" -> CourseVolumeC1.units
        "C2" -> CourseVolumeC2.units
        else -> emptyList()
    }
}
