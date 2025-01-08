package com.bt.beertinder.repository;
import com.bt.beertinder.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findByUser1IdOrUser2Id(Long user1Id, Long user2Id);
    @Query("SELECT m FROM Match m WHERE m.user1.id = :userId OR m.user2.id = :userId")
    List<Match> findMatchesForUser(Long userId);
}