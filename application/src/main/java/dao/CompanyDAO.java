package dao;

import commons.JDBCCredentials;
import entity.Company;

import generated.tables.records.CompanyRecord;
import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static generated.tables.Company.COMPANY;

public class CompanyDAO {
    private @NotNull Connection connection;
    private @NotNull DSLContext context;
    private static final JDBCCredentials CREDS = JDBCCredentials.DEFAULT;

    public CompanyDAO() {
        try {
            connection = DriverManager.getConnection(CREDS.getUrl(), CREDS.getLogin(), CREDS.getPassword());
            context = DSL.using(connection, SQLDialect.POSTGRES);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(@NotNull Company entity) {
        context
                .insertInto(COMPANY, COMPANY.NAME)
                .values(entity.getName())
                .execute();
    }
    public @NotNull Company getByName(@NotNull String name) {
        final CompanyRecord record = context.fetchOne(COMPANY, COMPANY.NAME.eq(name));
        if (record != null) {
            return new Company(
                    record.getName()
            );
        }
        return null;
    }
}
