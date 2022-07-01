package jp.ac.it_college.std.s21012.task_news_manager.domain.repository

import jp.ac.it_college.std.s21012.task_news_manager.infrastructure.database.record.Users


interface UserRepository {
    fun find(email: String) : Users?
}