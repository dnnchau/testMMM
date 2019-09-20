package com.tma.musicmanager.service;

import java.util.List;

import com.tma.musicmanager.model.Song;

public interface SongService {
	List <Song> getAllSong(); 
	Song get(Integer songID);
	void add(Song song);
	void update(Song song);
	void remove(int songID);
	void removeAll();
}
