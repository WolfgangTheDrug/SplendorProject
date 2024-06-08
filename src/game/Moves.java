package game;

import elements.Board;
import elements.Player;

public enum Moves implements Move {
    DRAW_2_COINS {
        @Override
        public void check(Player player, Board board) {

        }

        @Override
        public void make(Player player, Board board) {

        }
    },
    DRAW_3_COINS {
        @Override
        public void check(Player player, Board board) {

        }

        @Override
        public void make(Player player, Board board) {

        }
    },
    BUY_CARD_BOARD {
        @Override
        public void check(Player player, Board board) {

        }

        @Override
        public void make(Player player, Board board) {

        }
    },
    BUY_CARD_HAND {
        @Override
        public void check(Player player, Board board) {

        }

        @Override
        public void make(Player player, Board board) {

        }
    },
    RESERVE_UPCARD {
        @Override
        public void check(Player player, Board board) {

        }

        @Override
        public void make(Player player, Board board) {

        }
    },
    RESERVE_DOWNCARD {
        @Override
        public void check(Player player, Board board) {

        }

        @Override
        public void make(Player player, Board board) {

        }
    };

}
