package music;

import java.util.ArrayList;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;
import javazoom.jl.player.Player;

public class MusicMain {

	public static void main(String[] args) {
		// View
		Scanner sc = new Scanner(System.in);
		MP3Player mp3 = new MP3Player(); // 음악을 실질적으로 재생시켜줄 객체

		// 음악 리스트가 될 ArrayList 생성
//		ArrayList<Music> musicList = new ArrayList<Music>();
//		musicList.add(new Music("깡", "Rain", 100, "C://music/Rain - 깡.mp3"));
//		musicList.add(new Music("Dalla Dalla", "Itzy", 120, "C://music/Itzy - Dalla Dalla.mp3"));
//		musicList.add(new Music("Solo", "Jennie", 200, "C://music/JENNIE - SOLO.mp3"));

		// index 도 입력받아도 될듯
//		int index = 0; // 현재 위치 정보

		// 기능을 담당하는 객체 생성
		MusicPlayer player = new MusicPlayer();

		while (true) {
			System.out.print("1. 재생 2. 정지 3. 다음곡 4. 이전곡 5. 종료 >> ");
			int menu = sc.nextInt();

			if (menu == 1) {
				// 재생 -> 깡, Rain, 1분 40초

				presentSing(player.musicList, player.index);
				// isplaying() -> 현재 재생중인지 판단하는 메소드
				// stop() -> 현재 재생 중인 노래를 멈춰주는 메소드
				// 재생 메소드 play(경로)
				// mp3.play(musicList.get(index).getPath());
				// Controller 불러와서 실행시키기
				player.play();
			} else if (menu == 2) {
				player.mp3.stop();
				System.out.println("음악을 정지합니다");
			} else if (menu == 3) {
//				if (mp3.isPlaying()) {
//					mp3.stop();
//				}
				// SOLO 이후로 다음곡 누르면 재생할 곡이 없습니다 출력 ( 선생님 방법 )
//				if (player.index < player.musicList.size() - 1) {
//					player.index++;
//					mp3.play(player.musicList.get(player.index).getPath());
//				} else {
//					System.out.println("다음곡이 없습니다.");
//					player.index = player.musicList.size() - 1;
//				}
				int cnt = player.nextPlay();
				// index 가 2를 넘는다면 show()를 실행시키지 말아주세요
				if (cnt == 0) {
					presentSing(player.musicList, player.index);
				} else {
					System.out.println("재생할 노래가 없습니다.");
				}

			} else if (menu == 4) {
//				if (mp3.isPlaying()) {
//					mp3.stop();
//				}
//				// '깡' 에서 이전곡을 누르면 이전곡이 없습니다 출력 ( 내 방법 )
//				player.index--;
//				if (player.index < 0) {
//					System.out.println("이전곡이 없습니다.");
//					player.index = 0;
//				} else {
//					presentSing(player.musicList, player.index);
//					mp3.play(player.musicList.get(player.index).getPath());
//				}
				int cnt = player.beforePlay();
				if(cnt == 0) {
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

	// 현재곡 출력 < 블록 지정 후 오른쪽 마우스 Refactor -> extract Method >
	public static void presentSing(ArrayList<Music> musicList, int musicNumber/* , MP3Player mp3 */) {
		System.out.print(musicList.get(musicNumber).getMusicName() + ", ");
		System.out.print(musicList.get(musicNumber).getSinger() + ", ");
		if (musicList.get(musicNumber).getPlayTime() % 60 == 0) {
			System.out.println((musicList.get(musicNumber).getPlayTime() / 60) + "분 ");
		} else {
			System.out.println((musicList.get(musicNumber).getPlayTime() / 60) + "분 "
					+ (musicList.get(musicNumber).getPlayTime() % 60) + "초");
		}
		// mp3.play(musicList.get(musicNumber).getPath());
	}
}
