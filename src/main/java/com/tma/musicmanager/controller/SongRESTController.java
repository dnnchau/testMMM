
package com.tma.musicmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tma.musicmanager.dao.SongDAO;
import com.tma.musicmanager.dao.impl.SongDAOImpl;
import com.tma.musicmanager.model.Song;
import com.tma.musicmanager.service.SongService;

@RestController
@RequestMapping("/song")
public class SongRESTController {
	@Autowired
	private SongService songService;
	
	@RequestMapping("")
	@ResponseBody
	public String welcome() {
		return "Welcome to Rest";
	}

	// @GetMapping(value = "/songs")
	@RequestMapping(value = "/songs", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<Song> getSongs() {
		List<Song> list = songService.getAllSong();
		return list;

		// return (List<Song>) songService.findAll();
	}

	/*
	 * @GetMapping(value = "/songs/{songId}", produces = {
	 * MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }) public
	 * Song getSong(@PathVariable("songId") Integer songId) { return
	 * songService.getSong(songId); }
	 */

	/*
	 * @RequestMapping(value = "/songs/{songID}", method = RequestMethod.GET,
	 * produces = { MediaType.APPLICATION_JSON_VALUE,
	 * MediaType.APPLICATION_XML_VALUE })
	 * 
	 * @ResponseBody public Song getSong(@PathVariable("songID") Integer songID) {
	 * return songService.get(songID);}
	 */

	/*
	 * @PostMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE,
	 * MediaType.APPLICATION_ATOM_XML_VALUE }) public Song addSong(@RequestBody Song
	 * song) { return SongDAOImpl.addSong(song); }
	 * 
	 * public Response add(@RequestBody Song song) { //songService.add(song); return
	 * song; }
	 */

}
