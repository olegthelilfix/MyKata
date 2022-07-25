package me.olegthelilfix.leetcoding

fun numUniqueEmails(emails: Array<String>): Int {
    return emails.map { it.normalize() }.toSet().size
}

private fun String.normalize(): String {
    val (local, domain) = split("@")
    val normalizedLocal = local.split("+").first().replace(".", "")
    return "$normalizedLocal@$domain"
}

fun main() {
    println(numUniqueEmails(arrayOf("test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com")))
}
