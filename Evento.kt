import kotlin.math.ceil

fun organizarEvento() {
    print("Número de convidados: ")
    val convidados = readln().toIntOrNull() ?: return
    if (convidados !in 1..350) { println("Capacidade inválida."); return }

    val auditorio = if (convidados <= 150) "Laranja" else "Colorado"
    println("Auditório: $auditorio")

    print("Dia do evento: ")
    val dia = readln().lowercase()
    val hora = lerInt("Hora do evento: ") ?: return

    val disponivel = when (dia) {
        "segunda", "terça", "quarta", "quinta", "sexta" -> hora in 7..23
        "sábado", "domingo" -> hora in 7..15
        else -> false
    }
    if (!disponivel) { println("Auditório indisponível."); return }

    print("Nome da empresa: ")
    val empresa = readln()
    val duracao = lerInt("Duração (horas): ") ?: return

    val garcons = ceil(convidados / 12.0).toInt() + (duracao / 2)
    val custoGarcons = garcons * 10.50 * duracao
    val custoBuffet = (convidados * 0.2 * 0.80) + (convidados * 0.5 * 0.40) + (ceil(convidados * 7 / 100.0) * 34.0)
    val total = custoGarcons + custoBuffet

    println("\nEmpresa: $empresa | Auditório: $auditorio")
    println("$dia às ${hora}h por ${duracao}h | $garcons garçons")
    println("Total: R$ %.2f".format(total))

    print("Confirmar reserva? (S/N): ")
    if (readln().equals("S", ignoreCase = true)) println("Reserva confirmada para $empresa!")
    else println("Reserva cancelada.")
}