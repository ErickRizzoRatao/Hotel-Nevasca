fun cadastrarHospedes() {
    val lista = mutableListOf(
        "Gabriel Mendes", "Larissa Duarte", "Felipe Castro",
        "Amanda Correia", "Vinícius Teixeira", "Juliana Pires",
        "Eduardo Monteiro", "Camila Azevedo", "Thiago Ramos",
        "Priscila Moreira", "Leonardo Cunha", "Fernanda Dias",
        "Matheus Cardoso", "Bianca Lopes", "Rodrigo Neves"
    )

    while (true) {
        println("\n1. Cadastrar\n2. Pesquisar\n3. Voltar")
        when (lerInt("Opção: ")) {
            1 -> {
                print("Nome: ")
                val novo = readln()
                if (novo.isBlank()) { println("Nome inválido."); continue }
                lista.add(novo)
                println("$novo cadastrado!")
            }
            2 -> {
                print("Pesquisar: ")
                val busca = readln()
                val resultado = lista.filter { it.contains(busca, ignoreCase = true) }
                if (resultado.isEmpty()) println("Não encontrado.")
                else resultado.forEach { println("- $it") }
            }
            3 -> break
            else -> println("Opção inválida.")
        }
    }
}