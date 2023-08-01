package com.rythm.musicDemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rythm.musicDemo.entity.Playlist;
import com.rythm.musicDemo.entity.User;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

	public List<Playlist> findByUser(User user);
	
	@Query(value="SELECT t.id FROM Rythm.track AS t JOIN Rythm.playlist_track AS pt ON pt.track_id = t.id WHERE pt.playlist_id= :playlistId", nativeQuery = true)
	public List<Object[]> findTracksOfPlayList(@Param("playlistId") Integer playlistId);

}
