package music;

import java.util.ArrayList;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;
import javazoom.jl.player.Player;

public class MusicMain {

	public static void main(String[] args) {
		// View
		Scanner sc = new Scanner(System.in);
		MP3Player mp3 = new MP3Player(); // ������ ���������� ��������� ��ü

		// ���� ����Ʈ�� �� ArrayList ����
//		ArrayList<Music> musicList = new ArrayList<Music>();
//		musicList.add(new Music("��", "Rain", 100, "C://music/Rain - ��.mp3"));
//		musicList.add(new Music("Dalla Dalla", "Itzy", 120, "C://music/Itzy - Dalla Dalla.mp3"));
//		musicList.add(new Music("Solo", "Jennie", 200, "C://music/JENNIE - SOLO.mp3"));

		// index �� �Է¹޾Ƶ� �ɵ�
//		int index = 0; // ���� ��ġ ����

		// ����� ����ϴ� ��ü ����
		MusicPlayer player = new MusicPlayer();

		while (true) {
			System.out.print("1. ��� 2. ���� 3. ������ 4. ������ 5. ���� >> ");
			int menu = sc.nextInt();

			if (menu == 1) {
				// ��� -> ��, Rain, 1�� 40��

				presentSing(player.musicList, player.index);
				// isplaying() -> ���� ��������� �Ǵ��ϴ� �޼ҵ�
				// stop() -> ���� ��� ���� �뷡�� �����ִ� �޼ҵ�
				// ��� �޼ҵ� play(���)
				// mp3.play(musicList.get(index).getPath());
				// Controller �ҷ��ͼ� �����Ű��
				player.play();
			} else if (menu == 2) {
				player.mp3.stop();
				System.out.println("������ �����մϴ�");
			} else if (menu == 3) {
//				if (mp3.isPlaying()) {
//					mp3.stop();
//				}
				// SOLO ���ķ� ������ ������ ����� ���� �����ϴ� ��� ( ������ ��� )
//				if (player.index < player.musicList.size() - 1) {
//					player.index++;
//					mp3.play(player.musicList.get(player.index).getPath());
//				} else {
//					System.out.println("�������� �����ϴ�.");
//					player.index = player.musicList.size() - 1;
//				}
				int cnt = player.nextPlay();
				// index �� 2�� �Ѵ´ٸ� show()�� �����Ű�� �����ּ���
				if (cnt == 0) {
					presentSing(player.musicList, player.index);
				} else {
					System.out.println("����� �뷡�� �����ϴ�.");
				}

			} else if (menu == 4) {
//				if (mp3.isPlaying()) {
//					mp3.stop();
//				}
//				// '��' ���� �������� ������ �������� �����ϴ� ��� ( �� ��� )
//				player.index--;
//				if (player.index < 0) {
//					System.out.println("�������� �����ϴ�.");
//					player.index = 0;
//				} else {
//					presentSing(player.musicList, player.index);
//					mp3.play(player.musicList.get(player.index).getPath());
//				}
				int cnt = player.beforePlay();
				if(cnt == 0) {
					presentSing(player.musicList, player.index);
				} else {
					System.out.println("����� �뷡�� �����ϴ�.");
				}
			} else if (menu == 5) {
				System.out.println("���α׷� ����");
				mp3.stop();
				break;
			} else {
				System.out.println("�ٽ� �Է��ϼ���");
			}

		}

	}

	// ����� ��� < ��� ���� �� ������ ���콺 Refactor -> extract Method >
	public static void presentSing(ArrayList<Music> musicList, int musicNumber/* , MP3Player mp3 */) {
		System.out.print(musicList.get(musicNumber).getMusicName() + ", ");
		System.out.print(musicList.get(musicNumber).getSinger() + ", ");
		if (musicList.get(musicNumber).getPlayTime() % 60 == 0) {
			System.out.println((musicList.get(musicNumber).getPlayTime() / 60) + "�� ");
		} else {
			System.out.println((musicList.get(musicNumber).getPlayTime() / 60) + "�� "
					+ (musicList.get(musicNumber).getPlayTime() % 60) + "��");
		}
		// mp3.play(musicList.get(musicNumber).getPath());
	}
}
