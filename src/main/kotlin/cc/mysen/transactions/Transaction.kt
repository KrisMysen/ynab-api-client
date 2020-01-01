package cc.mysen.transactions

data class Transaction(
    val date: String,
    val description: String,
    val amount: Float
) {

    companion object Invalid {
        fun invalid(): Transaction {
            return Transaction("", "", 0F)
        }
    }


}