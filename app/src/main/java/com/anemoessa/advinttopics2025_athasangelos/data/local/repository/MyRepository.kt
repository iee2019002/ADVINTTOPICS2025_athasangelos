import com.anemoessa.advinttopics2025_athasangelos.data.local.database.User
import com.anemoessa.advinttopics2025_athasangelos.data.local.database.UsersDao
import kotlinx.coroutines.flow.Flow

class MyRepository(private val dao: UsersDao) {

    val allItems: Flow<List<User>> = dao.getAllUsers()

    suspend fun insert(item: User) {
        dao.insertUser(item)
    }

    suspend fun delete(item: User) {
        dao.deleteUserById(item)
    }
}
