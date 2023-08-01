package com.rythm.musicDemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rythm.musicDemo.entity.Playlist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
@Repository
public class PlaylistDAOImpl implements PlaylistDAO {

	private EntityManager entityManager;
	@Autowired
	public PlaylistDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public void save(Playlist thePlaylist) {
		// TODO Auto-generated method stub

	}

	@Override
	public Playlist findPlaylistById(int theId) {
		// TODO Auto-generated method stub
		return entityManager.find(Playlist.class, theId);
	}

	@Override
	public List<Playlist> findAll() {
		TypedQuery<Playlist> theQuery = entityManager.createQuery("from Playlist", Playlist.class);

		return theQuery.getResultList();
	}

}
