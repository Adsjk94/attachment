import Attachment.*


object WallService {
    private var id = 0
    var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += if (posts.isEmpty()) post.copy(id = 1)
        else post.copy(id = posts.last().id + 1)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, currentPost) in posts.withIndex()) {
            if (currentPost.id == post.id) {
                posts[index] = post.copy(ownerId = currentPost.ownerId, date = currentPost.date)
                return true
            }
        }
        return false
    }


    fun main(post: Post) {
        println(post.text)
        for ((index, att) in post.attachments.withIndex()) {
            when (att) {
                is AttachmentLink -> println("ссылка")
                is AttachmentVideo -> println("видео")
                is AttachmentDoc -> println("документы")
                is AttachmentPhoto -> println("фото")
                is AttachmentAudio -> println("музыка")
            }
        }
        println("copyright ${post.copyright}")
    }
}
