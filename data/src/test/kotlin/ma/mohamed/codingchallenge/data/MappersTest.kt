package ma.mohamed.codingchallenge.data

import ma.mohamed.codingchallenge.data.mappers.RepoMapper
import ma.mohamed.codingchallenge.data.mappers.UserMapper
import ma.mohamed.codingchallenge.domain.common.DomainTestUtils
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MappersTest {

    @Test
    fun testRepoMapperToEntityShouldReturnExpectedResult() {
        val userMapper = mock(UserMapper::class.java)
        val mapper = RepoMapper(userMapper)

        `when`(userMapper.toEntity(DataTestUtils.USER_MODEL)).thenReturn(DomainTestUtils.USER_ENTITY)

        assertEquals(DomainTestUtils.REPO_ENTITY, mapper.toEntity(DataTestUtils.REPO_MODEL))
    }

    @Test
    fun testRepoMapperToModelShouldReturnExpectedResult() {
        val userMapper = mock(UserMapper::class.java)
        val mapper = RepoMapper(userMapper)

        `when`(userMapper.toModel(DomainTestUtils.USER_ENTITY)).thenReturn(DataTestUtils.USER_MODEL)

        assertEquals(DataTestUtils.REPO_MODEL, mapper.toModel(DomainTestUtils.REPO_ENTITY))
    }

    @Test
    fun testUserMapperToEntityShouldReturnExpectedResult() {
        val mapper = UserMapper()

        assertEquals(DomainTestUtils.USER_ENTITY, mapper.toEntity(DataTestUtils.USER_MODEL))
    }

    @Test
    fun testUserMapperToModelShouldReturnExpectedResult() {
        val mapper = UserMapper()

        assertEquals(DataTestUtils.USER_MODEL, mapper.toModel(DomainTestUtils.USER_ENTITY))
    }
}