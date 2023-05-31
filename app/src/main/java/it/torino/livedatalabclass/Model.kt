package it.torino.livedatalabclass

class Model {
    private val TAG = this::class.simpleName
    private var currentValue: String = ""
    private var pastValues: MutableList<String> = mutableListOf()

    fun findAnotherValue(): String {
        currentValue = getRandomString((Math.random()*10).toInt())
        return currentValue
    }

    fun getPastValues(): MutableList<String> {
        // to detect a value change, you have to recreate the list If you just add to the existing
        // list the value of the variable does not change
        val newList = mutableListOf<String>()
        for (value in pastValues)
            newList.add(value)
        newList.add(currentValue)
        pastValues = newList
        return pastValues
    }

    private fun getRandomString(length: Int) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }
}