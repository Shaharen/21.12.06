package music;

import java.util.ArrayList;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;

public class Music_final {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MP3Player mp3 = new MP3Player();

		MusicPlayer player = new MusicPlayer();

		while (true) {
			System.out.println("1. 재생 2. 정지 3. 다음곡 4. 이전곡 5. 종료 >> ");
			int menu = sc.nextInt();

			if (menu == 1) {
				presentSing(player.musicList, player.index);
				player.play();
			} else if (menu == 2) {
				player.mp3.stop();
				System.out.println("음악을 정지합니다");
			} else if (menu == 3) {
				int cnt = player.nextPlay();
				if (cnt == 0) {
					presentSing(player.musicList, player.index);
				} else {
					System.out.println("재생할 노래가 없습니다.");
				}
			} else if (menu == 4) {
				int cnt = player.beforePlay();
				if (cnt == 0) {
					presentSing(player.musicList, player.index);
				} else {
					System.out.println("재생할 노래가 없습니다.");
				}
			} else if (menu == 5) {
				System.out.println("프로그램 종료");
				mp3.stop();
				break;
			} else {
				System.out.println("다시 입력하세요");
			}

		}

	}

	public static void presentSing(ArrayList<Music> musicList, int musicNumber) {
		System.out.print(musicList.get(musicNumber).getMusicName() + ", ");
		System.out.print(musicList.get(musicNumber).getSinger() + ", ");
		if (musicList.get(musicNumber).getPlayTime() % 60 == 0) {
			System.out.println((musicList.get(musicNumber).getPlayTime() / 60) + "분 ");
		} else {
			System.out.println((musicList.get(musicNumber).getPlayTime() / 60) + "분 "
					+ (musicList.get(musicNumber).getPlayTime() % 60) + "초");
		}
	}

}