/*
 * This file is generated by jOOQ.
 */
package generated.tables;


import generated.Keys;
import generated.Public;
import generated.tables.records.CompanyRecord;

import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function1;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row1;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Company extends TableImpl<CompanyRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.company</code>
     */
    public static final Company COMPANY = new Company();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CompanyRecord> getRecordType() {
        return CompanyRecord.class;
    }

    /**
     * The column <code>public.company.name</code>.
     */
    public final TableField<CompanyRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR.nullable(false), this, "");

    private Company(Name alias, Table<CompanyRecord> aliased) {
        this(alias, aliased, null);
    }

    private Company(Name alias, Table<CompanyRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.company</code> table reference
     */
    public Company(String alias) {
        this(DSL.name(alias), COMPANY);
    }

    /**
     * Create an aliased <code>public.company</code> table reference
     */
    public Company(Name alias) {
        this(alias, COMPANY);
    }

    /**
     * Create a <code>public.company</code> table reference
     */
    public Company() {
        this(DSL.name("company"), null);
    }

    public <O extends Record> Company(Table<O> child, ForeignKey<O, CompanyRecord> key) {
        super(child, key, COMPANY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<CompanyRecord> getPrimaryKey() {
        return Keys.COMPANY_PK;
    }

    @Override
    public Company as(String alias) {
        return new Company(DSL.name(alias), this);
    }

    @Override
    public Company as(Name alias) {
        return new Company(alias, this);
    }

    @Override
    public Company as(Table<?> alias) {
        return new Company(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Company rename(String name) {
        return new Company(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Company rename(Name name) {
        return new Company(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Company rename(Table<?> name) {
        return new Company(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row1 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row1<String> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function1<? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function1<? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
