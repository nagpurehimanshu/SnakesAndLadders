package Services;

import Repository.LadderRepository;
import Repository.SnakeRepository;

import java.util.Map;

public class BoardService {
    SnakeRepository snakeRepository;
    LadderRepository ladderRepository;

    public BoardService(){
        snakeRepository = new SnakeRepository();
        ladderRepository = new LadderRepository();
    }

    //-1 for no snake head, else return tail position
    public int checkSnake(int position){
        return snakeRepository.getTail(position);
    }

    //-1 for no ladder tail, else return head position
    public int checkLadder(int position){
        return ladderRepository.getHead(position);
    }

    //Insert Snake
    public void insertSnake(int head, int tail){
        snakeRepository.addSnake(head, tail);
    }

    //Insert Ladder
    public void insertLadder(int tail, int head){
        ladderRepository.addLadder(tail, head);
    }

}
