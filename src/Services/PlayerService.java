package Services;

import Models.Player;
import Repository.PlayerRepository;

import java.util.ArrayList;
import java.util.Map;

public class PlayerService {
    PlayerRepository playerRepository;

    public PlayerService(){
        playerRepository = new PlayerRepository();
    }

    public void addPlayer(String name){
        playerRepository.insertPlayer(name, 0);
    }

    public void updatePosition(String name, int position){
        playerRepository.updatePosition(name, position);
    }

    public int getPosition(String name){
        return playerRepository.findPosition(name);
    }

    public int getPlayersCount(){
        return playerRepository.totalPlayers();
    }

    public ArrayList<Player> getPlayersList(){
        return playerRepository.getPlayersList();
    }
}
