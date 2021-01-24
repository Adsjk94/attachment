data class Comment(
    val id: Int = 200,
    val postID: Int = 1,
    val fromId: Int = 300,
    val date: Int = 0,
    var text: String = "",
    var attachment: Array<Unit>,
    var count: Int = 10,
    var canPost: Boolean = true,
    var groupsCanPost: Boolean = false
)


