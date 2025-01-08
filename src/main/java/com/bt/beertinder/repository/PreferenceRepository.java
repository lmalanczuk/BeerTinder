package com.bt.beertinder.repository;
import com.bt.beertinder.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Long> {
    List<Preference> findByUserIdAndLiked(Long userId, Boolean liked);
}
