package com.tma.musicmanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tma.musicmanager.dao.SongDAO;
import com.tma.musicmanager.model.Song;
import com.tma.musicmanager.service.SongService;
@Service
public class SongServiceImpl implements SongService {

	private SongDAO songDAO;

	public SongDAO getSongDAO() {
		return songDAO;
	}

	public void setSongDAO(SongDAO songDAO) {
		this.songDAO = songDAO;
	}

	public List<Song> getAllSong() {
		return songDAO.getAllSong();
	}

	public Song getSong(Integer songID) {
		return songDAO.getSong(songID);
	}

	public void add(Song song) {
		songDAO.addSong(song);
	}

	public void update(Song song) {
		songDAO.updateSong(song);
	}

	public void remove(int songID) {
		songDAO.removeSong(songID);
	}

	public void removeAll() {
		songDAO.removeAllSong();
	}

}
