package ma.mohamed.codingchallenge.di.modules

import dagger.Module
import dagger.Provides
import ma.mohamed.codingchallenge.data.api.GitHubService
import ma.mohamed.codingchallenge.data.mappers.RepoMapper
import ma.mohamed.codingchallenge.data.repository.RepoRepositoryImpl
import ma.mohamed.codingchallenge.domain.repository.RepoRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepoRepository(
        gitHubService: GitHubService,
        repoMapper: RepoMapper
    ): RepoRepository = RepoRepositoryImpl(gitHubService, repoMapper)
}