import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val currencyByCountry = getCurrencyByCountry()
    var country1 = input.next()
    val country2 = input.next()
    println(currencyByCountry[country1] == currencyByCountry[country2]
            && currencyByCountry[country1] != null)
}

private fun getCurrencyByCountry(): HashMap<String, Currency> {
    val currencyByCountry = HashMap<String, Currency>()
    currencyByCountry["Germany"] = Currency.Euro
    currencyByCountry["Mali"] = Currency.CfaFranc
    currencyByCountry["Dominica"] = Currency.EasternCaribbeanDollar
    currencyByCountry["Canada"] = Currency.CanadianDollar
    currencyByCountry["Spain"] = Currency.Euro
    currencyByCountry["Australia"] = Currency.AustralianDollar
    currencyByCountry["Brazil"] = Currency.BrazilianReal
    currencyByCountry["Senegal"] = Currency.CfaFranc
    currencyByCountry["France"] = Currency.Euro
    currencyByCountry["Grenada"] = Currency.EasternCaribbeanDollar
    currencyByCountry["Kiribati"] = Currency.AustralianDollar
    return currencyByCountry
}

enum class Currency {
    Euro,
    CfaFranc,
    EasternCaribbeanDollar,
    CanadianDollar,
    AustralianDollar,
    BrazilianReal
}