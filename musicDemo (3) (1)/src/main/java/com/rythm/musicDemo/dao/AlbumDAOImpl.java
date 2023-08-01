package com.rythm.musicDemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rythm.musicDemo.entity.Album;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
@Repository
public class AlbumDAOImpl implements AlbumDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public AlbumDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(Album theAlbum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Album findAlbumById(int theId) {
		// TODO Auto-generated method stub
		return entityManager.find(Album.class, theId);
	}

	@Override
	public List<Album> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<Album> theQuery = entityManager.createQuery("from Album", Album.class);

		return theQuery.getResultList();
	}

}
