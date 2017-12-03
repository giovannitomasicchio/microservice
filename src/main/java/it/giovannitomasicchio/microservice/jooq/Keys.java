/*
 * This file is generated by jOOQ.
*/
package it.giovannitomasicchio.microservice.jooq;


import it.giovannitomasicchio.microservice.jooq.tables.Author;
import it.giovannitomasicchio.microservice.jooq.tables.Comment;
import it.giovannitomasicchio.microservice.jooq.tables.Post;
import it.giovannitomasicchio.microservice.jooq.tables.PostDetail;
import it.giovannitomasicchio.microservice.jooq.tables.PostTag;
import it.giovannitomasicchio.microservice.jooq.tables.Tag;
import it.giovannitomasicchio.microservice.jooq.tables.records.AuthorRecord;
import it.giovannitomasicchio.microservice.jooq.tables.records.CommentRecord;
import it.giovannitomasicchio.microservice.jooq.tables.records.PostDetailRecord;
import it.giovannitomasicchio.microservice.jooq.tables.records.PostRecord;
import it.giovannitomasicchio.microservice.jooq.tables.records.PostTagRecord;
import it.giovannitomasicchio.microservice.jooq.tables.records.TagRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AuthorRecord> AUTHOR_PKEY = UniqueKeys0.AUTHOR_PKEY;
    public static final UniqueKey<CommentRecord> COMMENT_PKEY = UniqueKeys0.COMMENT_PKEY;
    public static final UniqueKey<PostRecord> POST_PKEY = UniqueKeys0.POST_PKEY;
    public static final UniqueKey<PostDetailRecord> POST_DETAIL_PKEY = UniqueKeys0.POST_DETAIL_PKEY;
    public static final UniqueKey<PostTagRecord> POST_TAG_PKEY = UniqueKeys0.POST_TAG_PKEY;
    public static final UniqueKey<TagRecord> TAG_PKEY = UniqueKeys0.TAG_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<CommentRecord, AuthorRecord> COMMENT__FK_COMMENT_AUTHOR = ForeignKeys0.COMMENT__FK_COMMENT_AUTHOR;
    public static final ForeignKey<CommentRecord, PostRecord> COMMENT__FK_COMMENT_POST = ForeignKeys0.COMMENT__FK_COMMENT_POST;
    public static final ForeignKey<PostRecord, AuthorRecord> POST__FK_POST_AUTHOR = ForeignKeys0.POST__FK_POST_AUTHOR;
    public static final ForeignKey<PostDetailRecord, PostRecord> POST_DETAIL__FK_POST_DETAIL_POST = ForeignKeys0.POST_DETAIL__FK_POST_DETAIL_POST;
    public static final ForeignKey<PostTagRecord, PostRecord> POST_TAG__FK_POST_TAG_POST = ForeignKeys0.POST_TAG__FK_POST_TAG_POST;
    public static final ForeignKey<PostTagRecord, TagRecord> POST_TAG__FK_POST_TAG_TAG = ForeignKeys0.POST_TAG__FK_POST_TAG_TAG;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<AuthorRecord> AUTHOR_PKEY = createUniqueKey(Author.AUTHOR, "author_pkey", Author.AUTHOR.ID);
        public static final UniqueKey<CommentRecord> COMMENT_PKEY = createUniqueKey(Comment.COMMENT, "comment_pkey", Comment.COMMENT.ID);
        public static final UniqueKey<PostRecord> POST_PKEY = createUniqueKey(Post.POST, "post_pkey", Post.POST.ID);
        public static final UniqueKey<PostDetailRecord> POST_DETAIL_PKEY = createUniqueKey(PostDetail.POST_DETAIL, "post_detail_pkey", PostDetail.POST_DETAIL.ID);
        public static final UniqueKey<PostTagRecord> POST_TAG_PKEY = createUniqueKey(PostTag.POST_TAG, "post_tag_pkey", PostTag.POST_TAG.POST_ID, PostTag.POST_TAG.TAG_ID);
        public static final UniqueKey<TagRecord> TAG_PKEY = createUniqueKey(Tag.TAG, "tag_pkey", Tag.TAG.ID);
    }

    private static class ForeignKeys0 extends AbstractKeys {
        public static final ForeignKey<CommentRecord, AuthorRecord> COMMENT__FK_COMMENT_AUTHOR = createForeignKey(it.giovannitomasicchio.microservice.jooq.Keys.AUTHOR_PKEY, Comment.COMMENT, "comment__fk_comment_author", Comment.COMMENT.AUTHOR_ID);
        public static final ForeignKey<CommentRecord, PostRecord> COMMENT__FK_COMMENT_POST = createForeignKey(it.giovannitomasicchio.microservice.jooq.Keys.POST_PKEY, Comment.COMMENT, "comment__fk_comment_post", Comment.COMMENT.POST_ID);
        public static final ForeignKey<PostRecord, AuthorRecord> POST__FK_POST_AUTHOR = createForeignKey(it.giovannitomasicchio.microservice.jooq.Keys.AUTHOR_PKEY, Post.POST, "post__fk_post_author", Post.POST.AUTHOR_ID);
        public static final ForeignKey<PostDetailRecord, PostRecord> POST_DETAIL__FK_POST_DETAIL_POST = createForeignKey(it.giovannitomasicchio.microservice.jooq.Keys.POST_PKEY, PostDetail.POST_DETAIL, "post_detail__fk_post_detail_post", PostDetail.POST_DETAIL.ID);
        public static final ForeignKey<PostTagRecord, PostRecord> POST_TAG__FK_POST_TAG_POST = createForeignKey(it.giovannitomasicchio.microservice.jooq.Keys.POST_PKEY, PostTag.POST_TAG, "post_tag__fk_post_tag_post", PostTag.POST_TAG.POST_ID);
        public static final ForeignKey<PostTagRecord, TagRecord> POST_TAG__FK_POST_TAG_TAG = createForeignKey(it.giovannitomasicchio.microservice.jooq.Keys.TAG_PKEY, PostTag.POST_TAG, "post_tag__fk_post_tag_tag", PostTag.POST_TAG.TAG_ID);
    }
}
