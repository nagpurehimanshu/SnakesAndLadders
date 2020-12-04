package Repository;

import Models.Ladder;

import java.util.ArrayList;

public class LadderRepository {
    ArrayList<Ladder> laddersList;

    public LadderRepository(){
        laddersList = new ArrayList<>();
    }

    public int getHead(int position){
        for(int i = 0; i< laddersList.size(); i++){
            if(laddersList.get(i).getTail()==position) return laddersList.get(i).getHead();
        }

        //No snake found at this position
        return -1;
    }

    public void addLadder(int tail, int head){
        laddersList.add(new Ladder(tail, head));
    }
}
