package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {
        val result = mutableListOf(0, 1)

        while (result[0] * result[1] < n) {
            val sum = result[0] + result[1]
            result[0] = result[1]
            result[1] = sum
        }
        if (result[0] * result[1] > n) result.add(0) else result.add(1)
        return result.toIntArray()
    }
}
