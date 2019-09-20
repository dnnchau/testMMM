package com.tma.musicmanager.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.tma.musicmanager.hibernate.HibernateUtils;
import com.tma.musicmanager.model.Gerne;
import com.tma.musicmanager.model.Song;

public class QueryTest {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			session.getTransaction().begin();

			String sql = "Select s from " + Song.class.getName() + " s ";
			Query<Song> query = session.createQuery(sql);
			List<Song> song = query.getResultList();
			for (Song songs : song) {
				System.out.println("Song ID: " + songs.getSongId() + " - Song Name: " + songs.getSongName()
						+ " - lyrics: " + songs.getLyrics() + " - Gerne: " + songs.getGerne().getGerneName()
						+ " - Composer: " + songs.getComposer().getComposerName());
			}

			/*
			 * String sql = "Select g from " + Gerne.class.getName() + " g "; Query<Gerne>
			 * query = session.createQuery(sql); List<Gerne> gerne = query.getResultList();
			 * for (Gerne gernes : gerne) System.out.println(gernes.getGerneId() + " - " +
			 * gernes.getGerneName());
			 */

			/*
			 * String sql = "Select c from " + Composer.class.getName() + " c ";
			 * Query<Composer> query = session.createQuery(sql); List<Composer> composer =
			 * query.getResultList(); for (Composer composers : composer)
			 * System.out.println(composers.getComposerID() + " - " +
			 * composers.getComposerName());
			 */

			// String sql = "update Gerne g set g.gerneName='HipHop' where g.gerneID=2";
			// Query<Gerne> query = session.createQuery(sql);
			// Query query = session.createQuery(sql);
			// List<Gerne> gerne = query.getResultList();
			// for (Gerne gernes : gerne)
			// System.out.println(gernes.getGerneId() + " - " + gernes.getGerneName());

			/*
			 * Gerne gerne = session.load(Gerne.class, 2); gerne.setGerneName("Hiphop");
			 * session.update(gerne);
			 */

			/*
			 * Gerne gerne = new Gerne(); gerne.setGerneId(4); gerne.setGerneName("Việt");
			 * gerne.setGerneDesc("Viet"); session.save(gerne);
			 */

			/* Gerne gerne = session.load(Gerne.class, 4); session.delete(gerne); */

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
