import Models.Ladder;
import Models.Player;
import Models.Snake;
import Services.BoardService;
import Services.GameService;
import Services.PlayerService;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Driver {
    public static void startDriver() {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            int s = Integer.parseInt(sc.nextLine());
            ArrayList<Snake> snakesList = new ArrayList<Snake>();
            for(int i=0; i<s; i++){
                String[] head_tail = sc.nextLine().split(" ");
                snakesList.add(new Snake(Integer.parseInt(head_tail[0]), Integer.parseInt(head_tail[1])));
            }

            int l = Integer.parseInt(sc.nextLine());
            ArrayList<Ladder> laddersList = new ArrayList<Ladder>();
            for(int i=0; i<l; i++){
                String[] tail_head = sc.nextLine().split(" ");
                laddersList.add(new Ladder(Integer.parseInt(tail_head[0]), Integer.parseInt(tail_head[1])));
            }

            int p = Integer.parseInt(sc.nextLine());
            ArrayList<Player> playersList = new ArrayList<>();
            for(int i=0; i<p; i++){
                playersList.add(new Player(sc.nextLine(), 0));
            }

            GameService.startGame(playersList, snakesList, laddersList);
        }
    }
}
