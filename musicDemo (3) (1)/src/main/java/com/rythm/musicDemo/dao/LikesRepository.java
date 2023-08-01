package com.rythm.musicDemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rythm.musicDemo.entity.Like;
import com.rythm.musicDemo.entity.LikeId;

public interface LikesRepository extends JpaRepository<Like, LikeId> {
	
	public List<Like> findByIdUsername(String username);
	
	@Modifying
	@Query(value="DELETE FROM rythm.likes as L WHERE L.username=:username AND L.track_id=:trackId", nativeQuery = true)
	public void deleteTrackLike(@Param("trackId") int trackId, @Param("username")  String username); 
	
	@Modifying
	@Query(value="INSERT INTO Rythm.likes (username, track_id) VALUES (:username, :trackId)", nativeQuery = true)
	public void insertTrackLike(@Param("trackId") int trackId, @Param("username")  String username);
	
	@Query(value="SELECT * FROM Rythm.likes L WHERE L.track_id=:trackId AND L.username=:username", nativeQuery = true)
	public Like getLike(@Param("trackId") int trackId, @Param("username")  String username);
}