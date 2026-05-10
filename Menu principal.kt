fun exibirQuartos() {
    println("\n--- Status dos Quartos ---")
    quartos.forEachIndexed { index, ocupado ->
        val status = if (ocupado) "Ocupado" else "Livre"
        println("Quarto ${index + 1}: $status")
    }
}

fun validarSenha(): Boolean {
    print("Informe a senha de acesso: ")
    val senha = readln()
    if (senha == "1334") return true
    println("Senha inválida. Tente novamente.")
    return false
}

fun realizarReserva() {
    val dias = lerInt("Quantas diárias? ")
    if (dias == null || dias !in 1..30) {
        println("Período inválido.")
        return
    }
    println("Total: R$${valorDiaria * dias}")
    print("Nome do hóspede: ")
    val hospede = readln()
    if (hospede.isBlank()) {
        println("Nome inválido.")
        return
    }
    var quarto = 0
    while (true) {
        val entrada = lerInt("Quarto (1-20): ")
        if (entrada == null || entrada !in 1..20) { println("Quarto inválido."); continue }
        if (quartos[entrada - 1]) { println("Quarto ocupado."); continue }
        quarto = entrada
        break
    }
    print("Confirmar reserva para $hospede no quarto $quarto? (S/N): ")
    if (readln().equals("S", ignoreCase = true)) {
        quartos[quarto - 1] = true
        println("Reserva confirmada!")
    } else {
        println("Reserva cancelada.")
    }
}

fun inicio() {
    println("Bem-vindo ao $hotelNome")
    print("Seu nome: ")
    nome = readln()
    while (!validarSenha()) {}

    while (continuar) {
        println("\n1. Reserva\n2. Quartos\n3. Hóspedes\n4. Evento\n5. Sair")
        when (lerInt("Opção: ")) {
            1 -> realizarReserva()
            2 -> exibirQuartos()
            3 -> cadastrarHospedes()
            4 -> organizarEvento()
            5 -> { println("Até logo, $nome!"); continuar = false }
            else -> println("Opção inválida.")
        }
    }
}

fun main() {
    inicio()
}