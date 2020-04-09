package subtask2

class TimeConverter {
    private val numberMap: Map<Int, String> = mapOf(
        Pair(1, "one"),
        Pair(2, "two"),
        Pair(3, "three"),
        Pair(4, "four"),
        Pair(5, "five"),
        Pair(6, "six"),
        Pair(7, "seven"),
        Pair(8, "eight"),
        Pair(9, "nine"),
        Pair(10, "tex"),
        Pair(11, "eleven"),
        Pair(12, "twelve"),
        Pair(13, "thirteen"),
        Pair(14, "fourteen"),
        Pair(15, "fifteen"),
        Pair(16, "sixteen"),
        Pair(17, "seventeen"),
        Pair(18, "eighteen"),
        Pair(19, "nineteen"),
        Pair(20, "twenty"),
        Pair(21, "twenty one"),
        Pair(22, "twenty two"),
        Pair(23, "twenty three"),
        Pair(24, "twenty four"),
        Pair(25, "twenty five"),
        Pair(26, "twenty six"),
        Pair(27, "twenty seven"),
        Pair(28, "twenty eight"),
        Pair(29, "twenty nine"),
        Pair(31, "twenty nine"),
        Pair(32, "twenty eight"),
        Pair(33, "twenty seven"),
        Pair(34, "twenty six"),
        Pair(35, "twenty five"),
        Pair(36, "twenty four"),
        Pair(37, "twenty three"),
        Pair(38, "twenty two"),
        Pair(39, "twenty one"),
        Pair(40, "twenty"),
        Pair(41, "nineteen"),
        Pair(42, "eighteen"),
        Pair(43, "seventeen"),
        Pair(44, "sixteen"),
        Pair(45, "fifteen"),
        Pair(46, "fourteen"),
        Pair(47, "thirteen"),
        Pair(48, "twelve"),
        Pair(49, "eleven"),
        Pair(50, "tex"),
        Pair(51, "nine"),
        Pair(52, "eight"),
        Pair(53, "seven"),
        Pair(54, "six"),
        Pair(55, "five"),
        Pair(56, "four"),
        Pair(57, "three"),
        Pair(58, "two"),
        Pair(59, "one")
    )

    fun toTextFormat(hour: String, minute: String): String {

        return when (minute.toInt()) {
            0 -> "${numberMap[hour.toInt()]} ${getPretext(minute)}"
            1, 59 -> "${numberMap[minute.toInt()]} minute ${getPretext(minute)} ${numberMap[hour.toInt()]}"
            in 2..14, in 16..29 -> "${numberMap[minute.toInt()]} minutes ${getPretext(minute)} ${numberMap[hour.toInt()]}"
            in 31..44, in 46..58 -> "${numberMap[minute.toInt()]} minutes ${getPretext(minute)} ${numberMap[hour.toInt() + 1]}"
            15, 30 -> "${getPretext(minute)} ${numberMap[hour.toInt()]}"
             45 -> "${getPretext(minute)} ${numberMap[hour.toInt() + 1]}"
            else -> ""
        }
    }

    private fun getPretext(minute: String): String {
        return when (minute.toInt()) {
            0 -> "o' clock"
            in 1..14, in 16..29 -> "past"
            15 -> "quarter past"
            30 -> "half past"
            in 31..44, in 46..59 -> "to"
            45 -> "quarter to"
            else -> ""
        }
    }

}
