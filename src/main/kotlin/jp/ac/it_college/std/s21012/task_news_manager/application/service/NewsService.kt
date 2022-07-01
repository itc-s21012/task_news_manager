package jp.ac.it_college.std.s21012.task_news_manager.application.service

import jp.ac.it_college.std.s21012.task_news_manager.domain.model.NewsWithCategoryModel
import jp.ac.it_college.std.s21012.task_news_manager.domain.repository.NewsRepository
import jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.record.NewsWithRentalRecord
import org.springframework.stereotype.Service

@Service
class NewsService (
    private val newsRepository: NewsRepository
) {
    fun getList(): List<NewsWithCategoryModel> {
        return newsRepository.findAllWithRental()
    }
    fun getDetail(newsId: Long): NewsWithCategoryModel {
        return newsRepository.findWithRental(newsId) ?: throw java.lang.IllegalArgumentException("存在しないニュースID: $newsId")
    }
}