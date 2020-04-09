package subtask1

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        return try {
            val localDate = LocalDate.of(year.toInt(), month.toInt(), day.toInt())
            val russianLocale = Locale("ru", "RU")
            localDate.format(DateTimeFormatter.ofPattern("dd MMMM, EEEE", russianLocale))
        } catch (e: Exception) {
            "Такого дня не существует"
        }
    }
}
