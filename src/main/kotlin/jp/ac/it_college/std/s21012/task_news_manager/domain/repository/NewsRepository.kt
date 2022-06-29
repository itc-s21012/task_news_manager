package jp.ac.it_college.std.s21012.task_news_manager.domain.repository

import jp.ac.it_college.std.s21012.task_news_manager.domain.model.NewsWithCategoryModel

interface NewsRepository {
    fun findAllWithRental(): List<NewsWithCategoryModel>
}