package ma.mohamed.codingchallenge.domain.usecase

import io.reactivex.Single
import ma.mohamed.codingchallenge.domain.common.SingleTransformer
import ma.mohamed.codingchallenge.domain.entity.PagedResponseEntity
import ma.mohamed.codingchallenge.domain.entity.RepoEntity
import ma.mohamed.codingchallenge.domain.repository.RepoRepository
import ma.mohamed.codingchallenge.domain.usecase.base.SingleUseCase

class GetReposUseCase(
    private val reposRepository: RepoRepository,
    private val transformer: SingleTransformer<PagedResponseEntity<RepoEntity>>
) : SingleUseCase<String, Single<PagedResponseEntity<RepoEntity>>>() {

    override fun execute(vararg params: String): Single<PagedResponseEntity<RepoEntity>> {
        return reposRepository.getRepos(
            params[0], // start date
            params[1].toIntOrNull() ?: 1 // page
        ).compose(transformer)
    }
}