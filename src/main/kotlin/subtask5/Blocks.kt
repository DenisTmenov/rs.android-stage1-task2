package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        return when (blockB) {
            Int::class -> forNumber(blockA)
            String::class -> forString(blockA)
            LocalDate::class -> forDate(blockA)
            else -> ""
        }
    }

    private fun forNumber(blockA: Array<*>): Int {
        return blockA
            .filterIsInstance<Int>()
            .sumBy {
                it.toString().toInt()
            }
    }

    private fun forString(blockA: Array<*>): String {
        return blockA
            .filterIsInstance<String>()
            .joinToString("")
    }

    private fun forDate(blockA: Array<*>): String {

        return blockA
            .filterIsInstance<LocalDate>()
            .max()
            ?.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) ?: ""
    }
}
