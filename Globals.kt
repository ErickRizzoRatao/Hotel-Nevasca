var nome = ""
val hotelNome = "Hotel Nevasca"
val valorDiaria = 100.0
val quartos = BooleanArray(20) { false }
var continuar = true

fun lerInt(mensagem: String): Int? {
    print(mensagem)
    return readlnOrNull()?.toIntOrNull()
}