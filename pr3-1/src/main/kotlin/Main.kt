import kotlin.math.min

fun main(args: Array<String>)
{
    check()
}

fun agoToText (secondCounter : Int) : String
{

    if (secondCounter < 60) {
        return "Был(а) только что"
    }
    else if (secondCounter < 60*60) {
        return theEndOfTheMinutes(secondCounter)
    }
    else if (secondCounter < 24*60*60) {
        return theEndOfTheClock(secondCounter)
    }
    else if(secondCounter < 2*24*60*60) {
        return "Был(а) вчера"
    }
    else if (secondCounter < 3*24*60*60) {
        return "Был(а) позавчера"
    }
    else {
        return "Был(а) давно"
    }
}

fun theEndOfTheMinutes (secondCounter : Int) : String
{
    val minute =  secondCounter / 60

    if (minute % 10 == 1 && minute != 11) // 1 и конец на 1
        return ("Был(а) $minute минуту назад")

    else if (minute % 5 >= 0 && (minute % 10 ==0 || minute % 10 > 4) || (minute in 11..14)) // все числа делящиеся на 5 и ( конец_0(0,10,20) или конецБольше_4(5,16,27,38,49)) исключения 11-14
        return ("Был(а) $minute минут назад")

    else//конец 2.3.4 (икл 12,13,14 но она учтены в пункте выше)
        return ("Был(а) $minute минуты назад")
}
fun theEndOfTheClock (secondCounter: Int) : String
{
    val hour =  secondCounter / 60 /60

    if (hour % 10 == 1 && hour != 11) // 1 и конец на 1
        return ("Был(а) $hour час назад")

    else if (hour % 5 >= 0 && (hour % 10 == 0 || hour % 10 > 4) || (hour in 11..14)) // все числа делящиеся на 5 и ( конец_0(0,10,20) или конецБольше_4(5,16,27,38,49)) исключения 11-14
        return ("Был(а) $hour часов назад")

    else//конец 2.3.4 (икл 12,13,14 но она учтены в пункте выше)
        return ("Был(а) $hour часа назад")
}
fun check() : kotlin.Unit
{
    var secondCounter = 0

    while (secondCounter < 3*24*60*60+1)
    {
        println(agoToText(secondCounter))
        if (secondCounter >= 0 && secondCounter < 60*60) {//меньче часа + минута
            secondCounter+=60
        }
        else if (secondCounter >= 60*60 && secondCounter < 24*60*60){ // меньше суток + час
            secondCounter+=3600
        }
        else if(secondCounter >= 24*60*60 && secondCounter < 2*24*60*60) { // меньше 2 суток(вчера) + сутки
            secondCounter+= (24*60*60)
        }
        else if (secondCounter >= 2*24*60*60 && secondCounter < 3*24*60*60) { // меньше 3 суток
            secondCounter+= (24*60*60)
        }
        else if (secondCounter >= 3*24*60*60 ){ // больше 3 суток
            secondCounter++// (3 * 24 * 60 * 60+1)
        }
    }
}