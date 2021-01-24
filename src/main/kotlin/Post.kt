data class Post(
    var id: Int,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,
    var text: String = "",
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    var friendsOnly: Boolean = false,
    val comments: Comments,
    val copyright: String = "",
    val likes: Likes,
    val reposts: Repost,
    val viewsObject: Views,
    var postType: PostType,
    val signerId: Int = 0,
    var canPin: Boolean = false,
    var canDelete: Boolean = false,
    var canEdit: Boolean = false,
    var isPinned: Boolean = false,
    var markedAsAds: Boolean = false,
    var isFavorite: Boolean = false,
    var postponedId: Int = 0,
    var attach: Array<Unit>

)

