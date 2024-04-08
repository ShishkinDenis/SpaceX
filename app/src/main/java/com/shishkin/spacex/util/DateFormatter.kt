package com.shishkin.spacex.util

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

private const val INPUT_PATTERN = "yyyy-MM-dd'T'HH:mm:ssXXX"
private const val OUTPUT_PATTERN = "dd.MM.yyyy HH:mm:ss"

fun String.toUIDate(): String {
	val formatter = DateTimeFormatter.ofPattern(INPUT_PATTERN)
	val dateTime = ZonedDateTime.parse(this, formatter)
	return dateTime.format(DateTimeFormatter.ofPattern(OUTPUT_PATTERN))
}