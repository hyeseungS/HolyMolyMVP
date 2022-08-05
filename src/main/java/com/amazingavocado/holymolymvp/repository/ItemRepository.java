package com.amazingavocado.holymolymvp.repository;

import com.amazingavocado.holymolymvp.model.Item;
import com.amazingavocado.holymolymvp.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findById(Long id);

    List<Item> findByShop(Shop shop);
}
