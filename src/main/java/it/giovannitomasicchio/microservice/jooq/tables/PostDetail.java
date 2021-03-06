/*
 * This file is generated by jOOQ.
*/
package it.giovannitomasicchio.microservice.jooq.tables;


import it.giovannitomasicchio.microservice.jooq.Indexes;
import it.giovannitomasicchio.microservice.jooq.Keys;
import it.giovannitomasicchio.microservice.jooq.Public;
import it.giovannitomasicchio.microservice.jooq.tables.records.PostDetailRecord;

import java.math.BigDecimal;
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
public class PostDetail extends TableImpl<PostDetailRecord> {

    private static final long serialVersionUID = 934185295;

    /**
     * The reference instance of <code>public.post_detail</code>
     */
    public static final PostDetail POST_DETAIL = new PostDetail();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PostDetailRecord> getRecordType() {
        return PostDetailRecord.class;
    }

    /**
     * The column <code>public.post_detail.id</code>.
     */
    public final TableField<PostDetailRecord, BigDecimal> ID = createField("id", org.jooq.impl.SQLDataType.NUMERIC.nullable(false), this, "");

    /**
     * The column <code>public.post_detail.body</code>.
     */
    public final TableField<PostDetailRecord, String> BODY = createField("body", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.post_detail.title</code>.
     */
    public final TableField<PostDetailRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * Create a <code>public.post_detail</code> table reference
     */
    public PostDetail() {
        this(DSL.name("post_detail"), null);
    }

    /**
     * Create an aliased <code>public.post_detail</code> table reference
     */
    public PostDetail(String alias) {
        this(DSL.name(alias), POST_DETAIL);
    }

    /**
     * Create an aliased <code>public.post_detail</code> table reference
     */
    public PostDetail(Name alias) {
        this(alias, POST_DETAIL);
    }

    private PostDetail(Name alias, Table<PostDetailRecord> aliased) {
        this(alias, aliased, null);
    }

    private PostDetail(Name alias, Table<PostDetailRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.POST_DETAIL_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<PostDetailRecord> getPrimaryKey() {
        return Keys.POST_DETAIL_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PostDetailRecord>> getKeys() {
        return Arrays.<UniqueKey<PostDetailRecord>>asList(Keys.POST_DETAIL_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<PostDetailRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PostDetailRecord, ?>>asList(Keys.POST_DETAIL__FKKHUHIXRLGDFH58XKIQELM7DMB);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PostDetail as(String alias) {
        return new PostDetail(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PostDetail as(Name alias) {
        return new PostDetail(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public PostDetail rename(String name) {
        return new PostDetail(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PostDetail rename(Name name) {
        return new PostDetail(name, null);
    }
}
