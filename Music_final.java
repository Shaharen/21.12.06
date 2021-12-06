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
			System.out.println("1. ��� 2. ���� 3. ������ 4. ������ 5. ���� >> ");
			int menu = sc.nextInt();

			if (menu == 1) {
				presentSing(player.musicList, player.index);
				player.play();
			} else if (menu == 2) {
				player.mp3.stop();
				System.out.println("������ �����մϴ�");
			} else if (menu == 3) {
				int cnt = player.nextPlay();
				if (cnt == 0) {
					presentSing(player.musicList, player.index);
				} else {
					System.out.println("����� �뷡�� �����ϴ�.");
				}
			} else if (menu == 4) {
				int cnt = player.beforePlay();
				if (cnt == 0) {
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

	public static void presentSing(ArrayList<Music> musicList, int musicNumber) {
		System.out.print(musicList.get(musicNumber).getMusicName() + ", ");
		System.out.print(musicList.get(musicNumber).getSinger() + ", ");
		if (musicList.get(musicNumber).getPlayTime() % 60 == 0) {
			System.out.println((musicList.get(musicNumber).getPlayTime() / 60) + "�� ");
		} else {
			System.out.println((musicList.get(musicNumber).getPlayTime() / 60) + "�� "
					+ (musicList.get(musicNumber).getPlayTime() % 60) + "��");
		}
	}

}