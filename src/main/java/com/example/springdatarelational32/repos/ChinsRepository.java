package com.example.springdatarelational32.repos;

import com.example.springdatarelational32.model.ChinsEntity;
import org.springframework.data.domain.Limit;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChinsRepository extends CrudRepository<ChinsEntity, Integer> {

    List<ChinsEntity> findChinsEntitiesByColorIsLike(String color, Limit limit);

    @Query("select * from chins where color like '%beige%'")
    List<ChinsEntity> someQuery();
}
