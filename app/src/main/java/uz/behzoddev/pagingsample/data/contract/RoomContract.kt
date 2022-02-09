package uz.behzoddev.pagingsample.data.contract

object RoomContract {
    object RedditPosts {
        const val TABLE_NAME = "reddit_posts"
        const val POST_KEY = "post_key"
        const val POST_TITLE = "post_title"
        const val POST_SCORE = "post_score"
        const val POST_AUTHOR = "post_author"
        const val POST_COMMENT_COUNT = "post_comment_count"
    }

    object RedditKeys {
        const val TABLE_NAME = "reddit_keys"
        const val KEYS_ID = "keys_id"
        const val KEYS_AFTER = "keys_after"
        const val KEYS_BEFORE = "keys_before"
    }

}