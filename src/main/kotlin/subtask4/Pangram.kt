package subtask4

class Pangram {
    private val vowels = listOf('a', 'e', 'i', 'o', 'u', 'y')

    fun getResult(inputString: String): String {
        return if (isPangram(calculateLetter(inputString))) {
            calculateCountVowelLetterInEachWord(inputString).joinToString(separator = " ")
        } else {
            calculateCountConsonantsLetterInEachWord(inputString).joinToString(separator = " ")
        }
    }

    private fun isPangram(occurrences: Map<Char, Int>): Boolean {
        return occurrences.size == 26
    }

    private fun calculateLetter(inputString: String): Map<Char, Int> {
        val occurrences = inputString
            .toLowerCase()
            .replace("[^a-z]".toRegex(), "")
            .groupingBy { it }
            .eachCount()
        return occurrences
    }

    private fun calculateCountVowelLetterInEachWord(inputString: String): List<String> {
        val words: List<String> = splitStringToWords(inputString)

        val calculateWords: MutableList<String> = mutableListOf()

        words.forEach { word ->
            run {
                var vowelCount = 0

                if (word.contains("[a-zA-Z]".toRegex())) {
                    for (c in word) {
                        if ((c.isLetter() && vowels.contains(c.toLowerCase()))
                        ) {
                            vowelCount++
                        }
                    }
                }
                calculateWords.add("$vowelCount" + vowelsToUpperCase(word))
            }
        }

        return calculateWords.sortedBy { it[0].toInt() }
    }

    private fun calculateCountConsonantsLetterInEachWord(inputString: String): List<String> {
        val words: List<String> = splitStringToWords(inputString)

        val calculateWords: MutableList<String> = mutableListOf()

        words.forEach { word ->
            run {
                var consonantCount = 0
                if (word.contains("[a-zA-Z]".toRegex())) {
                    for (c in word) {
                        if ((c.isLetter() && !vowels.contains(c.toLowerCase()))
                        ) {
                            consonantCount++
                        }
                    }
                }
                calculateWords.add("$consonantCount" + occurrencesToUpperCase(word))
            }
        }

        return calculateWords.sortedBy { it[0].toInt() }
    }

    private fun vowelsToUpperCase(word: String): String {
        var newWord = ""
        for (c in word) {
            newWord += if (c.isLetter() && vowels.contains(c)) {
                c.toUpperCase()
            } else {
                c
            }
        }
        return newWord
    }

    private fun occurrencesToUpperCase(word: String): String {
        var newWord = ""
        for (c in word) {
            newWord += if (c.isLetter() && !vowels.contains(c)) {
                c.toUpperCase()
            } else {
                c
            }
        }
        return newWord
    }

    private fun splitStringToWords(inputString: String): List<String> {
        val words: MutableList<String> = mutableListOf()
        inputString.split(" ").forEach { word ->
            run {
                if (word.isNotBlank()) {
                    words.add(word)
                }
            }
        }
        return words
    }
}
