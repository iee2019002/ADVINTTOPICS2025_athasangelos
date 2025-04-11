import com.anemoessa.advinttopics2025_athasangelos.data.local.database.MyDao
import com.anemoessa.advinttopics2025_athasangelos.data.local.database.MyEntity
import kotlinx.coroutines.flow.Flow

class MyRepository(private val dao: MyDao) {

    val allItems: Flow<List<MyEntity>> = dao.getAllEntities()

    suspend fun insert(item: MyEntity) {
        dao.insertEntity(item)
    }

    suspend fun delete(item: MyEntity) {
        dao.deleteEntityById(item)
    }
}
