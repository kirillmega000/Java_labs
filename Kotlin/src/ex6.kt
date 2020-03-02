fun getYearEra(year: Int): String{
    return when{
       year < 1970 -> "before"
       year == 1970 -> "equals"
       year < 2000 -> "after (XX century)"
       year < 2100 -> "after (XXI century)"
       else -> "distant future"
    }
    //enter your function implementation here
}