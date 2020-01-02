package cc.mysen.ynab

data class Transaction (

    val account_id: String,
    val date: String, // ISO_FORMAT yyyy-MM-dd
    val amount: Int, // milliunits (e.g 1000.00 kr => 1000000 milliunits
    val payee_name: String // maxlength 50

)