package game;

import elements.Board;
import elements.Player;

public interface Move {
    void check(Player player, Board board);
    void make(Player player, Board board);
}
