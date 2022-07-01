package jp.ac.it_college.std.s21012.task_news_manager.domain.repository

import jp.ac.it_college.std.s21012.task_news_manager.domain.model.NewsWithCategoryModel
import jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.record.News

interface NewsRepository {
    fun findAllWithRental(): List<NewsWithCategoryModel>
    fun findWithRental(id: Long): NewsWithCategoryModel?

    fun register(news: News)


}