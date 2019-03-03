package ma.mohamed.codingchallenge.data.mappers

import ma.mohamed.codingchallenge.data.model.RepoModel
import ma.mohamed.codingchallenge.domain.common.Mapper
import ma.mohamed.codingchallenge.domain.entity.RepoEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class RepoMapper @Inject constructor(private val userMapper: UserMapper) : Mapper<RepoEntity, RepoModel> {

    override fun toEntity(model: RepoModel): RepoEntity = RepoEntity(
        model.id,
        model.name,
        model.description,
        model.url,
        userMapper.toEntity(model.owner),
        model.starsCount,
        model.lang
    )

    override fun toModel(entity: RepoEntity): RepoModel = RepoModel(
        entity.id,
        entity.name,
        entity.description,
        entity.url,
        userMapper.toModel(entity.owner),
        entity.starsCount,
        entity.lang
    )
}