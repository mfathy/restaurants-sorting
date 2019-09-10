package me.mfathy.task.data.mapper

import konveyor.base.randomBuild
import org.junit.Assert
import org.junit.Test

import me.mfathy.task.data.model.Restaurant
import me.mfathy.task.data.model.Sorting
import me.mfathy.task.data.store.remote.models.RestaurantItem
import me.mfathy.task.data.store.remote.models.SortingValues
import kotlin.test.assertEquals

class RestaurantMapperTest {

    private val sortingMapper = SortingValueMapper()
    private var restaurantMapper = RestaurantMapper(sortingMapper)

    @Test
    @Throws(Exception::class)
    fun testMapFromEntity_MapsData() {
        val entity = randomBuild(Restaurant::class.java)
        val result = restaurantMapper.mapFromEntity(entity)

        assertEqualsData(entity, result)
    }

    @Test
    @Throws(Exception::class)
    fun testMapToEntity_MapsData() {
        val type = randomBuild(RestaurantItem::class.java)
        val result = restaurantMapper.mapToEntity(type)

        assertEqualsData(result, type)
    }

    private fun assertEqualsData(result: Restaurant, type: RestaurantItem) {
        assertEquals(result.name, type.name)
        assertEquals(result.status, type.status)
    }
}
