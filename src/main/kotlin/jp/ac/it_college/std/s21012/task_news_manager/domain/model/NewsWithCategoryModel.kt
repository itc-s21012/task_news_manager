package jp.ac.it_college.std.s21012.task_news_manager.domain.model

data class NewsWithCategoryModel(
    val news: NewsModel,
    val category: Category?
){
    val isCategory: Boolean
        get() = category != null
}
