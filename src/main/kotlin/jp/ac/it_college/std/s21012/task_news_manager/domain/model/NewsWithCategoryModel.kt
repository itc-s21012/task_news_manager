package jp.ac.it_college.std.s21012.task_news_manager.domain.model

import java.lang.reflect.Array.get

data class NewsWithCategoryModel(
    val news: NewesWithCategoryModel(
    val category: CategoryModel?
){
    val isCategory: Boolean
    get() = category != null
}

