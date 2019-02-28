package ma.mohamed.codingchallenge.data.mappers

import ma.mohamed.codingchallenge.data.model.PagedResponseModel
import ma.mohamed.codingchallenge.domain.common.Mapper
import ma.mohamed.codingchallenge.domain.entity.PagedResponseEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PagedResponseMapper<T> @Inject constructor() : Mapper<PagedResponseEntity<T>, PagedResponseModel<T>> {
    override fun toEntity(model: PagedResponseModel<T>): PagedResponseEntity<T> = PagedResponseEntity(model.items)
    override fun toModel(entity: PagedResponseEntity<T>): PagedResponseModel<T> = PagedResponseModel(entity.items)
}