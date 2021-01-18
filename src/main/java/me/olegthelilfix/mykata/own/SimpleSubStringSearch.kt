package me.olegthelilfix.mykata.own

fun findFirstSubString(string: String, subString: String): Int? {
    val stringArray = string.toList()
    val substringArray = subString.toList()

    if (stringArray.size < substringArray.size || stringArray.isEmpty() || substringArray.isEmpty()) {
        return null
    }

    var counter = 0
    var startIndex = 0

    var i = 0

    while (i < stringArray.size) {
        if (stringArray[i] == substringArray[counter]) {
            if(counter == 0) {
                startIndex = i
            }

            if ((counter + 1) == substringArray.size) {
                return startIndex
            }
            counter++
            i++
        }
        else {
            if (counter > 0) {
                i = startIndex + 1
            }
            else {
                i++
            }
            counter = 0
            startIndex = 0
        }

        println(i)
    }

    return null
}

fun main() {
    print(findFirstSubString("54321321", "321"))
}