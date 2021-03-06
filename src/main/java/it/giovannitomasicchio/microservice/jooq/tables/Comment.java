/*
 * This file is generated by jOOQ.
*/
package it.giovannitomasicchio.microservice.jooq.tables;


import it.giovannitomasicchio.microservice.jooq.Indexes;
import it.giovannitomasicchio.microservice.jooq.Keys;
import it.giovannitomasicchio.microservice.jooq.Public;
import it.giovannitomasicchio.microservice.jooq.tables.records.CommentRecord;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Comment extends TableImpl<CommentRecord> {

    private static final long serialVersionUID = -705394419;

    /**
     * The reference instance of <code>public.comment</code>
     */
    public static final Comment COMMENT = new Comment();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CommentRecord> getRecordType() {
        return CommentRecord.class;
    }

    /**
     * The column <code>public.comment.id</code>.
     */
    public final TableField<CommentRecord, BigDecimal> ID = createField("id", org.jooq.impl.SQLDataType.NUMERIC.nullable(false), this, "");

    /**
     * The column <code>public.comment.body</code>.
     */
    public final TableField<CommentRecord, String> BODY = createField("body", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.comment.data</code>.
     */
    public final TableField<CommentRecord, Timestamp> DATA = createField("data", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>public.comment.author_id</code>.
     */
    public final TableField<CommentRecord, BigDecimal> AUTHOR_ID = createField("author_id", org.jooq.impl.SQLDataType.NUMERIC, this, "");

    /**
     * The column <code>public.comment.post_id</code>.
     */
    public final TableField<CommentRecord, BigDecimal> POST_ID = createField("post_id", org.jooq.impl.SQLDataType.NUMERIC, this, "");

    /**
     * Create a <code>public.comment</code> table reference
     */
    public Comment() {
        this(DSL.name("comment"), null);
    }

    /**
     * Create an aliased <code>public.comment</code> table reference
     */
    public Comment(String alias) {
        this(DSL.name(alias), COMMENT);
    }

    /**
     * Create an aliased <code>public.comment</code> table reference
     */
    public Comment(Name alias) {
        this(alias, COMMENT);
    }

    private Comment(Name alias, Table<CommentRecord> aliased) {
        this(alias, aliased, null);
    }

    private Comment(Name alias, Table<CommentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.COMMENT_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CommentRecord> getPrimaryKey() {
        return Keys.COMMENT_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CommentRecord>> getKeys() {
        return Arrays.<UniqueKey<CommentRecord>>asList(Keys.COMMENT_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<CommentRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CommentRecord, ?>>asList(Keys.COMMENT__FK_COMMENT_AUTHOR, Keys.COMMENT__FK_COMMENT_POST);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Comment as(String alias) {
        return new Comment(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Comment as(Name alias) {
        return new Comment(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Comment rename(String name) {
        return new Comment(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Comment rename(Name name) {
        return new Comment(name, null);
    }
}
