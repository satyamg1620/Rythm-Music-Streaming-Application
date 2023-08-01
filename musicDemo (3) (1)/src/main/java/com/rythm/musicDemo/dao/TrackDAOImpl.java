package com.rythm.musicDemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rythm.musicDemo.entity.Track;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
@Repository
public class TrackDAOImpl implements TrackDAO {

	private EntityManager entityManager;
	public TrackDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public void save(Track theTrack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Track findTrackById(int theId) {
		// TODO Auto-generated method stub
		return entityManager.find(Track.class, theId);
	}
	@Override
	public List<Track> findAll() {
		TypedQuery<Track> theQuery = entityManager.createQuery("from Track", Track.class);

		return theQuery.getResultList();
	}

}
