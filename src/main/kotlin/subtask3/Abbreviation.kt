package subtask3

class Abbreviation {
    enum class Answer {
        YES, NO
    }

    fun abbreviationFromA(a: String, b: String): String {

        val toCharArray = b.toLowerCase().toCharArray().joinToString(separator = "")
        val pattern: Regex = "[^${toCharArray}]".toRegex();

        return if((a.toLowerCase().replace(pattern,"")) == b.toLowerCase()){
            Answer.YES.toString()
        } else Answer.NO.toString()
    }
}
