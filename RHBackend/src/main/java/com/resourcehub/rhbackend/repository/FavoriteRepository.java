package com.resourcehub.rhbackend.repository;

import com.resourcehub.rhbackend.model.Favorite;
import com.resourcehub.rhbackend.model.User;
import com.resourcehub.rhbackend.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    List<Favorite> findByUser(User user);

    Optional<Favorite> findByUserAndResource(User user, Resource resource);
}
