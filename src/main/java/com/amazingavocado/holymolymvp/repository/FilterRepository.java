package com.amazingavocado.holymolymvp.repository;

import com.amazingavocado.holymolymvp.model.Filter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterRepository extends JpaRepository<Filter, Long> {

}
