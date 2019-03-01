package ma.mohamed.codingchallenge.data.mappers

import ma.mohamed.codingchallenge.data.model.UserModel
import ma.mohamed.codingchallenge.domain.common.Mapper
import ma.mohamed.codingchallenge.domain.entity.UserEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class UserMapper @Inject constructor() : Mapper<UserEntity, UserModel> {
    override fun toEntity(model: UserModel): UserEntity = UserEntity(model.login, model.url, model.avatar)
    override fun toModel(entity: UserEntity): UserModel = UserModel(entity.login, entity.url, entity.avatar)
}