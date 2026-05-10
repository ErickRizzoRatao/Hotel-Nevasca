fun main() {
    print("Seu nome: ")
    val nome = readln()

    print("Álcool Wayne Oil: R$ "); val alcoolWayne = readln().toDoubleOrNull() ?: return
    print("Gasolina Wayne Oil: R$ "); val gasolinaWayne = readln().toDoubleOrNull() ?: return
    print("Álcool Stark Petrol: R$ "); val alcoolStark = readln().toDoubleOrNull() ?: return
    print("Gasolina Stark Petrol: R$ "); val gasolinaStark = readln().toDoubleOrNull() ?: return

    val (posto, combustivel) = when {
        alcoolWayne <= gasolinaWayne * 0.7 && alcoolWayne * 42 <= alcoolStark * 42 -> "Wayne Oil" to "álcool"
        alcoolStark <= gasolinaStark * 0.7 -> "Stark Petrol" to "álcool"
        gasolinaWayne <= gasolinaStark -> "Wayne Oil" to "gasolina"
        else -> "Stark Petrol" to "gasolina"
    }

    println("$nome, abasteça com $combustivel no $posto.")
}