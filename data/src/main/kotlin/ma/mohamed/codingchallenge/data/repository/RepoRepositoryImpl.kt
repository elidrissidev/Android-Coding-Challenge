package ma.mohamed.codingchallenge.data.repository

import io.reactivex.Single
import ma.mohamed.codingchallenge.data.api.GitHubService
import ma.mohamed.codingchallenge.data.mappers.RepoMapper
import ma.mohamed.codingchallenge.domain.entity.PagedResponseEntity
import ma.mohamed.codingchallenge.domain.entity.RepoEntity
import ma.mohamed.codingchallenge.domain.repository.RepoRepository

class RepoRepositoryImpl(
    private val gitHubService: GitHubService,
    private val repoMapper: RepoMapper
) : RepoRepository {

    override fun getRepos(fromDate: String): Single<PagedResponseEntity<RepoEntity>> {
        return gitHubService.getRepos(fromDate).map {
            PagedResponseEntity(it.items.map(repoMapper::toEntity))
        }
    }
}