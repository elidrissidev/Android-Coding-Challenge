package ma.mohamed.codingchallenge.domain

import io.reactivex.Single
import ma.mohamed.codingchallenge.domain.common.SyncSingleTransformer
import ma.mohamed.codingchallenge.domain.repository.RepoRepository
import ma.mohamed.codingchallenge.domain.usecase.GetReposUseCase
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class UseCasesTest {

    @Mock
    private lateinit var repoRepository: RepoRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testGetReposUseCaseShouldReturnRepos() {
        val usecase = GetReposUseCase(repoRepository, SyncSingleTransformer())
        val repos = TestUtils.REPOS_RESPONSE

        `when`(repoRepository.getRepos(anyString(), anyInt())).thenReturn(Single.just(repos))

        usecase.execute(anyString(), anyString())
            .test()
            .assertComplete()
            .assertValue(repos)
    }
}