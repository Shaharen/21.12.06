package music;

import java.util.ArrayList;

import javazoom.jl.player.MP3Player;

public class MusicPlayer {

	// Controller : 실질적인 기능이 수행될 클래스

	ArrayList<Music> musicList = new ArrayList<Music>();
	MP3Player mp3 = new MP3Player();
	int index = 0;

	public MusicPlayer() {
		musicList.add(new Music("깡", "Rain", 100, "C://music/Rain - 깡.mp3"));
		musicList.add(new Music("Dalla Dalla", "Itzy", 120, "C://music/Itzy - Dalla Dalla.mp3"));
		musicList.add(new Music("Solo", "Jennie", 200, "C://music/JENNIE - SOLO.mp3"));
	}

	// 재생기능 빼주기
	public void play() {
		mp3.play(musicList.get(index).getPath());
	}

	// 다음곡을 실행할 기능
	public int nextPlay() {
		int cnt = 0; // 재생할 곡이 있는지 없는지 판별

		if (mp3.isPlaying()) {
			mp3.stop();
		}
		// 선생님 방법
		if (index < musicList.size() - 1) {
			index++;
			mp3.play(musicList.get(index).getPath());
		} else {
			cnt++;
		}
		return cnt;
	}
	// 이전곡을 실행할 기능
	public int beforePlay() {
		int cnt = 0;

		if (mp3.isPlaying()) {
			mp3.stop();
		}
		if (index > 0) {
			index--;
			mp3.play(musicList.get(index).getPath());
		} else {
			cnt++;
		}
		return cnt;
	}
}
