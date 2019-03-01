package ma.mohamed.codingchallenge.di.modules

import dagger.Module
import dagger.Provides
import ma.mohamed.codingchallenge.data.transformer.AsyncSingleTransformer
import ma.mohamed.codingchallenge.domain.repository.RepoRepository
import ma.mohamed.codingchallenge.domain.usecase.GetReposUseCase
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetReposUseCase(repoRepository: RepoRepository): GetReposUseCase {
        return GetReposUseCase(repoRepository, AsyncSingleTransformer())
    }
}