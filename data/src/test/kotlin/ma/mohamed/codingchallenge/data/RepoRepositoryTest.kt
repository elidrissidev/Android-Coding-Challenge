package ma.mohamed.codingchallenge.data

import io.reactivex.Single
import ma.mohamed.codingchallenge.data.api.GitHubService
import ma.mohamed.codingchallenge.data.mappers.RepoMapper
import ma.mohamed.codingchallenge.data.repository.RepoRepositoryImpl
import ma.mohamed.codingchallenge.domain.common.DomainTestUtils
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class RepoRepositoryTest {

    @Mock
    private lateinit var githubService: GitHubService
    @Mock
    private lateinit var repoMapper: RepoMapper

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testGetReposShouldReturnRepos() {
        val repoRepository = RepoRepositoryImpl(githubService, repoMapper)
        val reposModel = DataTestUtils.REPOS_RESPONSE_MODEL
        val reposEntity = DomainTestUtils.REPOS_RESPONSE_ENTITY

        (0..9).forEach { i ->
            `when`(repoMapper.toEntity(reposModel.items[i])).thenReturn(reposEntity.items[i])
        }
        `when`(githubService.getRepos("created:>2019-01-30", 1)).thenReturn(Single.just(reposModel))

        repoRepository.getRepos("created:>2019-01-30", 1)
            .test()
            .assertComplete()
            .assertValue(reposEntity)
    }
}