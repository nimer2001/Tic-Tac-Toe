
# Tic Tac Toe Game
## Overview

This project is an enhanced version of the classic Tic Tac Toe game implemented in Java. Unlike the original 3x3 grid where players connect three cells to win, this game allows you to customize the board size, win criterion, and player types.

## Features

- **Customizable Settings:** Set the board size, win size, and number of rounds via command line arguments.
- **Player Types:** Choose between human and AI players (Genius, Clever, Random).
  - **Genius:** Toughest opponent.
  - **Clever:** Moderately challenging.
  - **Random:** Moves are random.
- **Game Mechanics:** Players take turns to place their marks on the board, aiming to connect the specified number of cells in a row, column, or diagonally to win.
- **Terminal Interface:** The game runs in the terminal with all settings configured via command line arguments.
- **Game Over Conditions:** The game ends when the win condition is met or all cells are filled.

## How to Play

1. Set the game rules via command line arguments: number of games, board size, win size, player one type, and player two type.
2. Players take turns placing their marks on the board.
3. The game provides feedback on the winner and updates the score.
4. The game ends when the specified number of rounds is completed.

## Command Line Arguments

The order of command line arguments is:
1. Number of games
2. Board size
3. Win size
4. Renderer Type(Console,none
5. Type of player one (human, genius, clever, random)
6. Type of player two (human, genius, clever, random)
   
## Getting Started

To play the game, ensure you have Java installed. Run the `Tournament.java` file with the appropriate command line arguments to start the game.

```bash
java Tournament <number_of_games> <board_size> <win_size> <renderer_type> <player_one_type> <player_two_type>
```

## Contributing

Contributions are welcome! Feel free to submit a pull request or open an issue to discuss improvements or features.

---
