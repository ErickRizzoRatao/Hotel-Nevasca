fun main() {
    print("Seu nome: ")
    val nome = readln()
    var menorValor = Double.MAX_VALUE
    var melhorEmpresa = ""

    do {
        print("Empresa: "); val empresa = readln()
        print("Valor por aparelho: R$ "); val valor = readln().toDoubleOrNull() ?: return
        val qtd = lerInt("Quantidade: ") ?: return
        print("Desconto (%): "); val desconto = readln().toDoubleOrNull() ?: return
        val qtdMinima = lerInt("Qtd mínima para desconto: ") ?: return

        var total = valor * qtd
        if (qtd >= qtdMinima) total -= total * (desconto / 100)

        println("$empresa: R$ ${"%.2f".format(total)}")
        if (total < menorValor) { menorValor = total; melhorEmpresa = empresa }

        print("Continuar? (S/N): ")
    } while (readln().uppercase() == "S")

    println("Melhor orçamento: $melhorEmpresa — R$ ${"%.2f".format(menorValor)}")
}