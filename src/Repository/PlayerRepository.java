package Repository;

import Models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayerRepository {
    ArrayList<Player> playersList;

    public PlayerRepository() {
        playersList = new ArrayList<>();
    }

    public int findPosition(String name){
        for(int i=0; i<playersList.size(); i++){
            if(playersList.get(i).getName()==name) return playersList.get(i).getPosition();
        }

        //No player found with the given name
        return -1;
    }

    public void insertPlayer(String name, int position){
        playersList.add(new Player(name, position));
    }

    public void updatePosition(String name, int position) {
        for(int i=0; i<playersList.size(); i++){
            if(playersList.get(i).getName()==name){
                playersList.get(i).setPosition(position);
            }
        }
    }

    public int totalPlayers(){
        return playersList.size();
    }

    public ArrayList<Player> getPlayersList(){
        return playersList;
    }
}
