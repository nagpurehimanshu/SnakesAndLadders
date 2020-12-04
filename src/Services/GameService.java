package Services;

import Models.Ladder;
import Models.Player;
import Models.Snake;

import java.util.ArrayList;
import java.util.Random;

public class GameService {
    static PlayerService playerService;
    static BoardService boardService;

    public static void createGame(ArrayList<Player> playersList, ArrayList<Snake> snakesList, ArrayList<Ladder> laddersList){
        playerService = new PlayerService();
        boardService = new BoardService();

        for(int i=0; i<playersList.size(); i++){
            playerService.addPlayer(playersList.get(i).getName());
        }

        for(int i=0; i<snakesList.size(); i++){
            boardService.insertSnake(snakesList.get(i).getHead(), snakesList.get(i).getTail());
        }

        for(int i=0; i<laddersList.size(); i++){
            boardService.insertLadder(laddersList.get(i).getTail(), snakesList.get(i).getHead());
        }
    }

    public static int generateRandom(){
        Random random = new Random();
        int low = 1;
        int high = 6;
        return (random.nextInt(high-low) + low);
    }

    public static void startGame(ArrayList<Player> playersList, ArrayList<Snake> snakesList, ArrayList<Ladder> laddersList){
        createGame(playersList, snakesList, laddersList);

        ArrayList<Player> playerList = playerService.getPlayersList();

        boolean flag = false;
        while(true){
            for(int i=0; i<playerList.size(); i++){
                int dice = generateRandom();
                String name = playerList.get(i).getName();
                int position = playerService.getPosition(name);
                int new_position = position+dice;

                if(new_position==100){
                    System.out.println(name + " wins the game.");
                    flag = true;
                    break;
                }

                else if(new_position<100){
                    int s = boardService.checkSnake(new_position);
                    int l = boardService.checkLadder(new_position);
                    while(s!=-1 || l!=-1){
                        if(s!=-1){
                            new_position = s;
                            s = boardService.checkSnake(new_position);
                        }else if(l!=-1){
                            new_position = l;
                            l = boardService.checkLadder(new_position);
                        }
                    }

                    playerService.updatePosition(name, new_position);
                    System.out.println(name + " rolled a " + dice + " and moved to position " + new_position);
                }

            }

            if(flag) break;
        }
    }
}
