package com.rutvik.Teams;

import org.springframework.data.repository.CrudRepository;

import java.util.Map;
import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team, String> {
//    Map<Object, Object> findById(Integer id);
//    Map<Object, Object> findById(int parseInt);
    Optional<Object> findById(Integer id);

    void deleteById(Integer id);
}
