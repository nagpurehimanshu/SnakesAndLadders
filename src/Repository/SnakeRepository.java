package Repository;

import Models.Snake;

import java.util.ArrayList;

public class SnakeRepository {
    ArrayList<Snake> snakesList;

    public SnakeRepository(){
        snakesList = new ArrayList<>();
    }

    public int getTail(int position){
        for(int i=0; i<snakesList.size(); i++){
            if(snakesList.get(i).getHead()==position) return snakesList.get(i).getTail();
        }

        //No snake found at this position
        return -1;
    }

    public void addSnake(int head, int tail){
        snakesList.add(new Snake(head, tail));
    }
}
