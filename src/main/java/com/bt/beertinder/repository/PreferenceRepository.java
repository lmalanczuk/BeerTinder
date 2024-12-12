package com.bt.beertinder.repository;

import com.bt.beertinder.model.Beer;
import com.bt.beertinder.model.Preference;
import com.bt.beertinder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Long> {
    Optional<Preference> findByUserAndBeer(User user, Beer beer);
    List<Preference> findByUserId(Long userId);
    // Znajdź preferencje użytkownika na podstawie jego ID i statusu "liked"
    List<Preference> findByUserIdAndLiked(Long userId, boolean liked);
}
