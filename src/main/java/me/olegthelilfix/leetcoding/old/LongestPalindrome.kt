package me.olegthelilfix.leetcoding.old

//Given a string s, return the longest palindromic substring in s.
fun isPalindrome(s: String): Boolean {
    if (s.isEmpty()) {
        return false
    }

    for (i in 0 .. s.length/2) {
        if(s[i] != s[s.length-i-1]) {
            return false
        }
    }

    return true
}

fun longestPalindrome(s: String): String {
    if (s.length == 1) {
        return s
    }

    if (isPalindrome(s)) {
        return s
    }

    var longest = s[0].toString()

    for (i in 0 until s.length - 1) {
        s.slice(0..10)
        var substring: String = s[i].toString()
        for (j in i + 1 until s.length) {
            substring += s[j]
            if (isPalindrome(substring) && substring.length > longest.length) {
                longest = substring
            }
        }
    }

    return longest
}

fun main() {
//    isPalindrome("abcba")
    var t = System.currentTimeMillis()
    longestPalindrome("busislnescsicxpvvysuqgcudefrfjbwwjcchtgqyajdfwvkypfwshnihjdztgmyuuljxgvhdiwphrweyfkbnjgerkmifbirubhseuhrugwrabnjafnbdfjnufdstjbkuwtnpflffaqmjbhssjlnqftgjiglvvequhapasarlkcvbmkwnkuvwktbgfoaxteprobdwswcdyddyvrehvmxrrjiiidatidlpihkbmmruysmhhsncmfdanafdrfpdtfgkglcqpwrrtvacuicohspkounojuziittugpqjyhhkwfnflozbispehrtrnizowrlzcuollagxwtznjwzcumvedjwokueuqktvvouwnsmpxqvvpuwprezrbobrpnwaccwljchdguubjulyilzvmandjjleitweybqkjttschrjjlebnmponvlktzzcdtuybugggcqffkcffpamauvxfbonjrobgpvlyzveiwemmtdvbjciaytvesnocnjrwodtcokgcuoiicxapmrzpkfphjniuvzjrhbnqndfshoduejyktebgdabidxlkstepuwvtrtgbxaeheylicvhrxddijshcvdadxzsccmainyfpfdhqdanfccqkzlmhsfilvoybqojlvbcixjzqpbngdvesuokbxhkomsiqfyukvspqthlzxdnlwthrgaxhtpjzhrugqbfokrdcyurivmzgtynoqfjbafboselxnfupnpqlryvlcxeksirvufepfwczosrrjpudbwqxwldgjyfjhzlzcojxyqjyxxiqvfhjdwtgoqbyeocffnyxhyyiqspnvrpxmrtcnviukrjvpavervvztoxajriuvxqveqsrttjqepvvahywuzwtmgyrzduxfqspeipimyoxmkadrvrdyefekjxcmsmzmtbugyckcbjsrymszftjyllfmoeoylzeahnrxlxpnlvlvzltwnmldi")
    var t2 = System.currentTimeMillis()

    print(t2-t)
}
