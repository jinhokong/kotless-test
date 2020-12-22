resource "aws_dynamodb_table" "ktor_short_url_table" {
  name = "spring-short-url-table"
  billing_mode = "PAY_PER_REQUEST"
  hash_key = "URLHash"

  attribute {
    name = "URLHash"
    type = "S"
  }
}
