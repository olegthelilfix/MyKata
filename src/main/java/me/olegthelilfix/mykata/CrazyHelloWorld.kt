package me.olegthelilfix.mykata

fun greet(): String {
    return deepDive("hello world!".toCharArray().map { it.toString() }.toMutableList())
}

private fun deepDive(helloWorld: MutableList<String>): String {
    if (helloWorld.isEmpty()) {
        return ""
    }

    return helloWorld.removeFirst() + deepDive(helloWorld)
}

