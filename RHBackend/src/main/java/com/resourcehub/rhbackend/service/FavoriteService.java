package com.resourcehub.rhbackend.service;

import com.resourcehub.rhbackend.model.Favorite;
import com.resourcehub.rhbackend.model.User;
import com.resourcehub.rhbackend.model.Resource;
import com.resourcehub.rhbackend.repository.FavoriteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public Favorite addFavorite(User user, Resource resource) {
        return favoriteRepository.save(new Favorite(user, resource));
    }

    public List<Favorite> getFavoritesByUser(User user) {
        return favoriteRepository.findByUser(user);
    }
}
