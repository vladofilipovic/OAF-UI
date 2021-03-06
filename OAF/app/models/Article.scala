package models

import com.oaf.dal.enums.ArticleStatus

case class Article
(
  id: Option[Long],
  name: String,
  description: Option[String],
  price: Double,
  pictureLocation: Option[String],
  weight: Option[Double],
  companyId: Long,
  status: ArticleStatus.Value
)

object Article {

  implicit def convertToModel(articleDbModel: ArticleDBModel) : Article = {
    Article(articleDbModel.id, articleDbModel.name, articleDbModel.description, articleDbModel.price,
      articleDbModel.pictureLocation, articleDbModel.weight, articleDbModel.companyId, articleDbModel.status)
  }

  implicit def convertToDBModel(article: Article) : ArticleDBModel = {
    ArticleDBModel(article.id, article.name, article.description, article.price,
      article.pictureLocation, article.weight, article.companyId, article.status)
  }
}
