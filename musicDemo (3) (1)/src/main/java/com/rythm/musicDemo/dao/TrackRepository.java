package com.rythm.musicDemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rythm.musicDemo.entity.Track;

public interface TrackRepository extends JpaRepository<Track, Integer> {
	
	@Query(value="SELECT l.track_id FROM Rythm.likes AS l WHERE l.username= :username", nativeQuery = true)
	public List<Object[]> findLikedTracksOfPlayListByUsername(@Param("username") String username);

}
