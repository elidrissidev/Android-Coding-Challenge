package ma.mohamed.codingchallenge.domain.repository

import io.reactivex.Single
import ma.mohamed.codingchallenge.domain.entity.PagedResponseEntity
import ma.mohamed.codingchallenge.domain.entity.RepoEntity

interface RepoRepository {
    fun getRepos(): Single<List<PagedResponseEntity<RepoEntity>>>
}