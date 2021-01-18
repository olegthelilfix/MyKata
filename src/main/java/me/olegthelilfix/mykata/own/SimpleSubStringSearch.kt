package me.olegthelilfix.mykata.own

fun findFirstSubString(string: String, subString: String): Int? {
    if (string.length < subString.length || string.isEmpty() || subString.isEmpty()) {
        return null
    }

    val stringArray = string.toList()
    val substringArray = subString.toList()

    var counter = 0
    var startIndex = 0

    var i = 0

    while (i < stringArray.size) {
        when {
            stringArray[i] == substringArray[counter] -> {
                if (counter == 0) {
                    startIndex = i
                }

                if ((counter + 1) == substringArray.size) {
                    return startIndex
                }
                counter++
                i++
            }
            counter > 0 -> {
                i = startIndex + 1
                counter = 0
            }
            else -> {
                i++
            }
        }
    }

    return null
}