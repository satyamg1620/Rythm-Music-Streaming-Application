package com.rythm.musicDemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rythm.musicDemo.entity.Follower;
import com.rythm.musicDemo.entity.FollowerId;

public interface FollowerRepository extends JpaRepository<Follower, FollowerId> {
	
	public List<Follower> findByIdUsername(String username);
	
//	@Query(value = "SELECT new com.rythm.musicDemo.custom.FollowingsCount(f.FollowerId.artistId, COUNT(f.FollowerId.username)) FROM Follower AS f GROUP BY f.FollowerId.artistId")
//	public List<FollowingsCount> countTotalFollowersByIdArtistId();
	
	@Query(value="SELECT f.artist_id, COUNT(f.username) FROM Rythm.follower AS f GROUP BY f.artist_id", nativeQuery = true)
	public List<Object[]> countTotalFollowersByIdArtistId();
	
//	@Query(value="SELECT f.username, COUNT(f.artist_id) FROM Rythm.follower AS f GROUP BY f.username", nativeQuery = true)
//	public List<Object[]> countTotalFollowingsByIdUsername();
	
	
}
