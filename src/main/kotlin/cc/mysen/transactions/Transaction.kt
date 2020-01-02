package cc.mysen.transactions

data class Transaction(
    val date: String,
    val type: String,
    val payee: String,
    val amount: Float
) {
    companion object {
        fun invalid(): Transaction {
            return Transaction("", "", "", 0F)
        }
    }
}