package com.tma.musicmanager.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Song")
public class Song {
	private Integer SongID;
	private String songName;
	private String lyrics;
	private Gerne gerne;
	private Composer composer;

	public Song() {
	}

	@Id
	@Column(name = "songID")
	public Integer getSongId() {
		return SongID;
	}

	public void setSongId(Integer songID) {
		SongID = songID;
	}

	@Column(name = "songName")
	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	@Column(name = "lyrics")
	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	@ManyToOne
	@JoinColumn(name = "gerneID")
	public Gerne getGerne() {
		return gerne;
	}

	public void setGerne(Gerne gerne) {
		this.gerne = gerne;
	}

	@ManyToOne
	@JoinColumn(name = "composerID")
	public Composer getComposer() {
		return composer;
	}

	public void setComposer(Composer composer) {
		this.composer = composer;
	}

	private Set<Singer> singer = new HashSet<Singer>(0);

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "song_singer", joinColumns = { @JoinColumn(name = "songID") }, inverseJoinColumns = {
			@JoinColumn(name = "singerID") })

	public Set<Singer> getSinger() {
		return this.singer;
	}

	public void setSinger(Set<Singer> singer) {
		this.singer = singer;
	}

}
