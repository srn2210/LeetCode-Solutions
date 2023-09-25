func findTheDifference(s string, t string) byte {
    m := [26]int{}
    for i:=0; i<len(s); i++ {
        m[s[i]-'a']++
    }
    for i:=0; i<len(t); i++ {
        m[t[i]-'a']--
    }
    for i:=0; i<26; i++ {
        if m[i] < 0 {
            return byte(i+'a')
        }
    }
    return 'a'
}