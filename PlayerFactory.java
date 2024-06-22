/**
 * this class represents the player factory
 */
public class PlayerFactory {
    /**
     * a constructor
     */
    public PlayerFactory() {

    }

    /**
     * this function creates a player based on the type
     * @param type a string
     * @return a player/null
     */
    public Player buildPlayer(String type) {
        if (type.equalsIgnoreCase("HUMAN")) {
            return new HumanPlayer();
        }
        if (type.equalsIgnoreCase("whatever")) {
            return new WhateverPlayer();
        }
        if (type.equalsIgnoreCase("clever")){
            return new CleverPlayer();
        }
        if(type.equalsIgnoreCase("genius")){
            return new GeniusPlayer();
        }
        return null;
    }
}
