package com.linguapro.android.data.content

import com.linguapro.android.CourseContentPack
import com.linguapro.android.LessonStageType

object CoursePackValidator {
    private val supportedLevels = setOf("A1", "A2", "B1", "B2", "C1", "C2")

    fun errors(pack: CourseContentPack): List<String> = buildList {
        if (pack.schemaVersion != 1) add("Desteklenmeyen içerik şeması: ${pack.schemaVersion}")
        if (pack.contentVersion.isBlank()) add("İçerik sürümü boş olamaz.")
        if (pack.units.isEmpty()) add("İçerik paketi en az bir ünite içermeli.")

        val units = pack.units
        if (units.map { it.id }.toSet().size != units.size) add("Ünite kimlikleri benzersiz olmalı.")
        val allLessons = units.flatMap { unit -> unit.lessons.map { unit to it } }
        val lessons = allLessons.map { it.second }
        if (lessons.map { it.id }.toSet().size != lessons.size) add("Ders kimlikleri benzersiz olmalı.")
        if (lessons.any { it.id.isBlank() || it.title.isBlank() || it.canDo.isBlank() }) add("Her dersin kimliği, başlığı ve öğrenme çıktısı olmalı.")
        val vocabIds = lessons.flatMap { it.targetVocabulary }.map { it.id }
        if (vocabIds.toSet().size != vocabIds.size) add("Kelime kimlikleri içerik paketi genelinde benzersiz olmalı.")
        supportedLevels.forEach { level ->
            if (allLessons.count { (unit, _) -> unit.id.substringBefore('-') == level } < 2) add("$level için en az iki tam ders gerekli.")
        }

        allLessons.forEach { (unit, lesson) ->
            val level = unit.id.substringBefore('-')
            if (level !in supportedLevels) add("${unit.id}: CEFR seviyesi geçersiz.")
            if (lesson.targetVocabulary.size !in 8..12) add("${lesson.id}: 8–12 hedef kelime gerekli.")
            if (lesson.targetVocabulary.map { it.id }.toSet().size != lesson.targetVocabulary.size) add("${lesson.id}: kelime kimlikleri benzersiz olmalı.")
            val grammar = lesson.grammarFocus
            if (grammar == null) add("${lesson.id}: dilbilgisi odağı eksik.")
            else if (grammar.checkPromptTr.isBlank() || grammar.correctAnswer.isBlank() || grammar.correctAnswer !in grammar.checkOptions) {
                add("${lesson.id}: dilbilgisi kontrolü ve doğru seçenek gerekli.")
            }
            if (lesson.stages.map { it.type }.toSet() != LessonStageType.entries.toSet()) add("${lesson.id}: altı ders aşamasının her biri tam bir kez bulunmalı.")
            if (lesson.exercises.isEmpty()) add("${lesson.id}: en az bir ölçülebilir alıştırma gerekli.")
            if (lesson.exercises.map { it.id }.toSet().size != lesson.exercises.size) add("${lesson.id}: alıştırma kimlikleri benzersiz olmalı.")
            if (lesson.targetVocabulary.any { it.termEn.isBlank() || it.translationTr.isBlank() || it.exampleEn.isBlank() || it.exampleTr.isBlank() }) {
                add("${lesson.id}: her hedef kelime çeviri ve iki dilli örnek içermeli.")
            }
        }
    }
}
