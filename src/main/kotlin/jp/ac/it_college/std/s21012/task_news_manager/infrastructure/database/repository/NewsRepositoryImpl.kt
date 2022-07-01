package jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.repository

import jp.ac.it_college.std.s21012.task_news_manager.domain.model.Category
import jp.ac.it_college.std.s21012.task_news_manager.domain.repository.NewsRepository

import jp.ac.it_college.std.s21012.task_news_manager.domain.model.NewsModel
import jp.ac.it_college.std.s21012.task_news_manager.domain.model.NewsWithCategoryModel
import jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.mapper.*
import jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.record.News
import jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.record.NewsWithRentalRecord
import org.springframework.stereotype.Repository

@Suppress
@Repository
class NewsRepositoryImpl(
    private val newsWithCategoryMapper: NewsWithCategoryMapper,
    private val newsMapper: NewsMapper
) : NewsRepository {
    override fun findAllWithRental(): List<NewsWithCategoryModel> {
        return newsWithCategoryMapper.select().map { toModel(it) }
    }

    override fun findWithRental(id: Long): NewsWithCategoryModel? {
        return newsWithCategoryMapper.selectByPrimaryKey(id)?.let { toModel(it) }
    }

    override fun register(news: News) {
        newsMapper.insert(toCategory(news))
    }

    private fun toModel(record: NewsWithRentalRecord): NewsWithCategoryModel {
        val news = NewsModel(
            record.id!!,
            record.title!!,
            record.body!!,
            record.categoryId!!,
            record.userId!!,
            record.createAt!!,
            record.publishAt!!,
        )
        val rental = record.id?.let {
            Category(
                record.id!!,
                record.name!!,
            )
        }
        return NewsWithCategoryModel(news, rental)
    }

    private fun toCategory(model: News): News {
        return News(model.id, model.title, model.categoryId, model.publishAt, model.createAt, model.userId, model.body)
    }
}
