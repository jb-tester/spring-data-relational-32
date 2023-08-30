package com.example.springdatarelational32.repos;

import com.example.springdatarelational32.model.ChinsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ChinsRepo {


    @Autowired
    private JdbcClient client;

    public List<ChinsEntity> findAll(){
        return client.sql("select * from chins")
                .query((rs, rowNum) -> mapChinsResult(rs))
                .list();
    }

    public List<ChinsEntity> findByName(String name){
        return client.sql("select * from chins where name = :cname")
                .param("cname", name)
                .query((rs, rowNum) -> mapChinsResult(rs))
                .list();
    }


    private ChinsEntity mapChinsResult(final ResultSet rs) throws SQLException {
        ChinsEntity chin = new ChinsEntity();
        chin.setId(rs.getInt("ID"));
        chin.setWeight(rs.getInt("WEIGHT"));
        chin.setName(rs.getString("NAME"));
        chin.setColor(rs.getString("COLOR"));
        chin.setBirthday(rs.getString("BIRTHDAY"));
        chin.setSex(rs.getString("SEX"));
        chin.setForSale(rs.getByte("FOR_SALE"));

        return chin;
    }
}
