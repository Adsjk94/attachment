import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class WallServiceTest {
    val theFirstComments = Comments (
        canPost = true
    )
    val theFirstLikes = Likes (
        canLike = true
    )
    val theFirstReposts = Repost ()
    val theFirstViewsObject = Views (
        count = 1
    )
    val theFirstVideo = Video (player = null)
    val theFirstPhoto = Photo (sizes = null)
    val theFirstAttach = arrayOf(theFirstPhoto, theFirstVideo)

    val theFirstPost = Post (
        id = 1,
        comments = theFirstComments,
        likes = theFirstLikes,
        reposts = theFirstReposts,
        viewsObject = theFirstViewsObject,
        postType = PostType.POST,
        attach = theFirstAttach
    )

    @Test
    fun add() {
        val wallservice = WallService()
        var testParam: Boolean = true
        wallservice.add(theFirstPost)
        if (theFirstPost.id == 0) testParam = false
        assertEquals(true, testParam)
    }

    @Test
    fun updateRealID() {
        val wallservice = WallService()
        wallservice.add(theFirstPost)
        assertEquals(true, wallservice.update(theFirstPost))
    }

    @Test
    fun updateNotRealID() {
        val wallservice = WallService()
        val theFirstComments = Comments (
            canPost = true
        )
        val theFirstLikes = Likes (
            canLike = true
        )
        val theFirstReposts = Repost ()
        val theFirstViewsObject = Views (
            count = 1
        )

        val theSecondPost = Post (
            id = 5,
            comments = theFirstComments,
            likes = theFirstLikes,
            reposts = theFirstReposts,
            viewsObject = theFirstViewsObject,
            postType = PostType.POST,
            attach = theFirstAttach
        )
        assertEquals(false, wallservice.update(theSecondPost))
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrowOK() {
        val wallservice = WallService()
        var comment = Comment (postID = 1, attachment = theFirstAttach)
        wallservice.createComment(comment)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrowNotOK() {
        val wallservice = WallService()
        var comment = Comment (postID = 10, attachment = theFirstAttach)
        wallservice.createComment(comment)
    }
}