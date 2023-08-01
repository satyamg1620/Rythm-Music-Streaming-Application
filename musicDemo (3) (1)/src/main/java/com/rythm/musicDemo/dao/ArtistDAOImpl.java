package com.rythm.musicDemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rythm.musicDemo.entity.Artist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class ArtistDAOImpl implements ArtistDAO {
	private EntityManager entityManager;

	@Autowired
	public ArtistDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(Artist theArtist) {
		// TODO Auto-generated method stub

	}

	@Override
	public Artist findArtistById(int theId) {
		// TODO Auto-generated method stub
		return entityManager.find(Artist.class, theId);
	}

	@Override
	public List<Artist> findAll() {
		TypedQuery<Artist> theQuery = entityManager.createQuery("from Artist", Artist.class);
		List<Artist> artists = theQuery.getResultList();
		for(Artist artist: artists) {
			System.out.println(artist);
		}
		return artists;
	}

}
