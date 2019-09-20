
package com.tma.musicmanager.dao;

import java.util.List;

import com.tma.musicmanager.model.Song;

public interface SongDAO {

	List<Song> getAllSong();

	Song get(Integer songID);

	void addSong(Song song);

	void updateSong(Song song);

	void removeSong(int songID);

	void removeAllSong();
}
