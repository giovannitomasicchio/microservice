/*
 * This file is generated by jOOQ.
*/
package it.giovannitomasicchio.microservice.jooq.tables.records;


import it.giovannitomasicchio.microservice.jooq.tables.Comment;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


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
public class CommentRecord extends UpdatableRecordImpl<CommentRecord> implements Record5<BigDecimal, BigDecimal, BigDecimal, Timestamp, String> {

    private static final long serialVersionUID = -636599666;

    /**
     * Setter for <code>public.comment.id</code>.
     */
    public void setId(BigDecimal value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.comment.id</code>.
     */
    public BigDecimal getId() {
        return (BigDecimal) get(0);
    }

    /**
     * Setter for <code>public.comment.author_id</code>.
     */
    public void setAuthorId(BigDecimal value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.comment.author_id</code>.
     */
    public BigDecimal getAuthorId() {
        return (BigDecimal) get(1);
    }

    /**
     * Setter for <code>public.comment.post_id</code>.
     */
    public void setPostId(BigDecimal value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.comment.post_id</code>.
     */
    public BigDecimal getPostId() {
        return (BigDecimal) get(2);
    }

    /**
     * Setter for <code>public.comment.data</code>.
     */
    public void setData(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.comment.data</code>.
     */
    public Timestamp getData() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>public.comment.body</code>.
     */
    public void setBody(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.comment.body</code>.
     */
    public String getBody() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<BigDecimal> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<BigDecimal, BigDecimal, BigDecimal, Timestamp, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<BigDecimal, BigDecimal, BigDecimal, Timestamp, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field1() {
        return Comment.COMMENT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field2() {
        return Comment.COMMENT.AUTHOR_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field3() {
        return Comment.COMMENT.POST_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return Comment.COMMENT.DATA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Comment.COMMENT.BODY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal component2() {
        return getAuthorId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal component3() {
        return getPostId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component4() {
        return getData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getBody();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value2() {
        return getAuthorId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value3() {
        return getPostId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getBody();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CommentRecord value1(BigDecimal value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CommentRecord value2(BigDecimal value) {
        setAuthorId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CommentRecord value3(BigDecimal value) {
        setPostId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CommentRecord value4(Timestamp value) {
        setData(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CommentRecord value5(String value) {
        setBody(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CommentRecord values(BigDecimal value1, BigDecimal value2, BigDecimal value3, Timestamp value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CommentRecord
     */
    public CommentRecord() {
        super(Comment.COMMENT);
    }

    /**
     * Create a detached, initialised CommentRecord
     */
    public CommentRecord(BigDecimal id, BigDecimal authorId, BigDecimal postId, Timestamp data, String body) {
        super(Comment.COMMENT);

        set(0, id);
        set(1, authorId);
        set(2, postId);
        set(3, data);
        set(4, body);
    }
}
