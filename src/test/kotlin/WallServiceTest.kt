import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class WallServiceTest {

    @Test
    fun add() {
        val post = Post()
        val post2 = Post()
        WallService.add(post)
        WallService.add(post2)

        val resultId = WallService.posts[1]

        val result = resultId.id

        assertNotEquals(0, result)
    }

    @Test
    fun updateTrue() {
        val post = Post()
        WallService.add(post)

        val result = WallService.update(post)

        assertTrue(result)
    }

    @Test
    fun updateFalse() {

        assertFalse(WallService.update(Post()))
    }
}