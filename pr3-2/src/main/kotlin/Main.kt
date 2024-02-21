fun main(args: Array<String>)
{
    moneyTransfer("Мир", 12_000.0, 4667.0)
}

fun moneyTransfer(cardType : String = "VKPay",  amountPreviousTransfersPerMonth : Double, amountTransferBeingMade : Double) : Unit
{
    var transferWithCommission : Double = amountTransferBeingMade

    when (cardType)
    {
        "VkPlay" -> {
            if (amountTransferBeingMade <= 15_000 && amountPreviousTransfersPerMonth <= 40_000)
                println("За перевод через VKPay комисия не взимается. Перевод в размере $amountTransferBeingMade ₽ доставлен.")
            else
                println("Лимит превышен")
        }

        "MasterCard", "Maestro" -> {
            if (amountTransferBeingMade <= 150_000  && amountPreviousTransfersPerMonth <= 600_000)
            {
                if (amountPreviousTransfersPerMonth > 75_000)
                    transferWithCommission = amountTransferBeingMade - amountTransferBeingMade * 0.006 - 20

                println("Вы осуществили перевод черз MasterCard | Maestro. Перевод в размере $transferWithCommission ₽ доставлен.")
            }
            else
                println("Лимит превышен")
        }

        "Visa", "Мир" -> {
            if (amountTransferBeingMade <= 150_000 && amountPreviousTransfersPerMonth <= 600_000)
            {
                transferWithCommission = if (amountTransferBeingMade * 0.0075 >= 35) {amountTransferBeingMade - amountTransferBeingMade * 0.0075} else amountTransferBeingMade - 35
                println("Вы осуществили перевод черз Visa | Мир. Перевод в размере $transferWithCommission ₽ доставлен.")
            }
            else
                println("Лимит превышен")
        }
    }
}