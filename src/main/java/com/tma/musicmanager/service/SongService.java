package com.tma.musicmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tma.musicmanager.model.Song;
@Service
public interface SongService {
	List <Song> getAllSong(); 
	Song getSong(Integer songID);
	void add(Song song);
	void update(Song song);
	void remove(int songID);
	void removeAll();
}
