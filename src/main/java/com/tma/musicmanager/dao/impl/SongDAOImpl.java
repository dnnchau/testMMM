
package com.tma.musicmanager.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tma.musicmanager.dao.SongDAO;
import com.tma.musicmanager.hibernate.HibernateUtils;
import com.tma.musicmanager.model.Song;

@Transactional
public class SongDAOImpl implements SongDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	SessionFactory factory = HibernateUtils.getSessionFactory();

	Session session = factory.getCurrentSession();

	@Transactional(Transactional.TxType.SUPPORTS)
	public List<Song> getAllSong() {
		TypedQuery<Song> query = entityManager.createQuery("SELECT s FROM song s", Song.class);
		return query.getResultList();
	}

	@Transactional(Transactional.TxType.SUPPORTS)
	public Song getSong(Integer songID) {
		return entityManager.find(Song.class, songID);
	}

	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public void addSong(Song song) {
		entityManager.persist(song);
		entityManager.flush();
	}

	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public void updateSong(Song song) {
		entityManager.merge(song);
	}

	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public void removeSong(int songID) {
		Song song = getSong(songID);
		entityManager.remove(song);
	}

	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public void removeAllSong() {
		entityManager.createQuery("DELETE FROM Song").executeUpdate();

	}

}
